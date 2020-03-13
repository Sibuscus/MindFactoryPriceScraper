package com.roamsvie.ws;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PartList
{
    public void addToList(int fileNum, Part Part)
    {
        Map<Integer, String> list = new HashMap<Integer, String>();
        list.put(fileNum, Part.getName());
        System.out.println("Map entry: " +list.get(fileNum));
    }

    public void getList(File baseFile)
    {
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

        for(File file : fileList)
        {
            System.out.println(file.getName());
        }


    }

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
