package com.roamsvie.ws;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PartList
{
    public Map<Integer, String> listWork(File baseFile)
    {
        Map<Integer, String> tempList = new HashMap<Integer, String>();
        String temp1, temp2, tempValue;
        int tempKey;
        baseFile = baseFile.getParentFile();

        File[] fileList = new File[0];
        try
        {
            fileList = getFileList(baseFile.getCanonicalPath());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        //Loop to fill up the map
        for(File file : fileList)
        {
            try //MAKE IT TO FILL UP AN OBJECT AND THEN A MAP, to read prices easier
            {
                Scanner reader = new Scanner(file);

                temp1 = file.getName();
                tempKey = Integer.parseInt(temp1.replaceAll("[^\\d]", ""));

                temp2 = reader.nextLine();
                tempValue = temp2.substring(6);
                tempList.put(tempKey, tempValue);
                reader.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }


        }
        return tempList;
    }

    public boolean listWork(Map<Integer, String> list)
    {
        String value;
        boolean isEmpty;

        //Iterate through map to print out the parts
        if(!list.isEmpty())
        {
            isEmpty = false;
            System.out.println("Your list: ");
            for (Integer key : list.keySet())
            {

                value = list.get(key);

                System.out.println(key + ". " + value);
            }
        }
        else
        {
            isEmpty = true;
            System.out.println("Your list is empty!");
        }
        return isEmpty;
    }


    //FILLS an File array with "Part" file names in them
    public File[] getFileList(String dir)
    {
        File dirF = new File(dir);

        File[] matches = dirF.listFiles(new FilenameFilter()
        {
            @Override
            public boolean accept(File dir, String name)
            {
                return name.startsWith("Part");
            }
        });
        return matches;
    }
}
