package com.roamsvie.ws;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class AddPart
{
    public static int fileNum = 0;
    public static int fileLimit = 20;

    public void addPart()
    {
        String url;

        Menu m = new Menu();
        Part p;

        //Send PART object to be filled with data
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a link:");
        url = s.nextLine();
        p = m.linkChecker(url);

        //Testing purposes
        System.out.println("Name: " +p.getName()); //Check if name == Parts list name to not allow doubles of parts to be entered
        System.out.println("Link: " +p.getLink());
        System.out.println("Price: " +p.getPrice());

        //Create a new range of files
        File dir = new File(Menu.baseFile);//D:\Development\GitHub\WebScraper\parts.txt
        dir = dir.getParentFile(); //D:\Development\GitHub\WebScraper

        String fileName = "Part" + fileNum;
        File part = new File(dir, fileName+".txt");

        do
        {
            if (!part.exists())
            {
                createFile(part);
                break;
            }
            else
            {
                fileNum++;
                fileName = "Part" + fileNum;
                part.renameTo(new File(dir, fileName+".txt"));
            }
        }while (fileNum <= fileLimit);
    }

    public void createFile(File part)
    {
        try
        {
            part.createNewFile();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }


}
