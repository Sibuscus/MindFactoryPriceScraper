package com.roamsvie.ws;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class RemovePart
{
    public boolean removePart(Map<Integer, String> list, String baseFile)
    {
        int choice, fileNum, mapKey;
        String fileString, path;
        boolean isEmpty;

        PartList pl = new PartList();
        File[] fileList = new File[0];
        Scanner input = new Scanner(System.in);

        isEmpty = pl.listWork(list);
        if(isEmpty || baseFile == null)
        {
            return false;
        }
        System.out.println("Enter the part's number you'd like to remove:");
        choice = input.nextInt();
        //-------File work
        fileList = pl.getFileList(baseFile);

        //Iterate through map and find the key
        for(Integer key : list.keySet())
        {
            if(key == choice)
            {
                mapKey = choice;
                list.remove(mapKey);
                break;
            }
        }

        //Iterate through "Part" files and find the part number
        for(File file : fileList)
        {
            fileString = file.getName();
            fileString = fileString.replaceAll("[^\\d]", "");
            fileNum = Integer.parseInt(fileString);
            if(fileNum == choice)
            {
                try
                {
                    path = file.getCanonicalPath();
                    File filePath = new File(path);
                    filePath.delete();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
                break;
            }
        }
        return true;
    }

}
