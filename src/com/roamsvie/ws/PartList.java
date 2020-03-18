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
            try
            {
                Scanner reader = new Scanner(file);

                temp1 = file.getName();
                tempKey = Integer.parseInt(temp1.replaceAll("[^\\d]", ""));

                temp2 = reader.nextLine();
                tempValue = temp2.substring(6);
                tempList.put(tempKey, tempValue);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }


        }
        return tempList;
    }

    public void listWork(Map<Integer, String> list)
    {
        String value;

        //Iterate through map to print out the parts
        if(!list.isEmpty())
        {
            System.out.println("Your list: ");
            for (Integer key : list.keySet())
            {

                value = list.get(key);

                System.out.println(key + ". " + value);
            }
        }
        else
        {
            System.out.println("Your list is empty!");
        }
    }


    //FILLS an File array with "Part" file names in them
    private File[] getFileList(String dir)
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
