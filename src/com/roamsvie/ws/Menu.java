package com.roamsvie.ws;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static java.lang.System.exit;

public class Menu
{
    public static String baseFile;
    //Intro
    public static void printFMsg()
    {
        System.out.println("-----------------------------------------------------------");
        System.out.println("Hello and welcome to Sibuscus's MindFactory.de price tracker.");
        System.out.println("Read the README.md file for more information.");
        System.out.println("Press Enter to continue...");
        System.out.println("-----------------------------------------------------------");
        try
        {
            System.in.read();
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
        System.out.flush();
        FilePath();
    }

    private static void FilePath()
    {
        String path, baseFileDirString = null;
        Integer choice;

        Scanner s = new Scanner(System.in);
        Map<Integer, String> list;

        AddPart ap = new AddPart();
        RemovePart rp = new RemovePart();

        PartList pl = new PartList();


        System.out.println("Example: D:\\Development\\GitHub\\WebScraper\\parts.txt");
        System.out.print("Specify the base PARTS's file path:");

        path = s.nextLine();

        while (!isPathValid(path))
        {
            System.out.println("Specify a correct file path:");
            path = s.nextLine();
            if(path.equals("0"))
            {
                exit(1);
            }
        }
        baseFile = path;
        list = pl.listWork(new File(baseFile));

        File baseFileDir = new File(baseFile);
        baseFileDir = baseFileDir.getParentFile();
        try
        {
            baseFileDirString = baseFileDir.getCanonicalPath();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


        do
        {
            System.out.println("-----------------------------------------------------------");
            System.out.println("All changes are saved automatically after each chosen action");
            System.out.println("1. Your parts list.");
            System.out.println("2. Add a part.");
            System.out.println("3. Remove a part.");
            System.out.println("4. Check prices for all.");
            System.out.println("5. Set time interval. Default interval: " +" hours.");
            System.out.println("6. Exit" );
            System.out.println("-----------------------------------------------------------");
            System.out.println("Choice:");
            choice = s.nextInt();

            switch (choice)
            {
                case 1:
                    pl.listWork(list);
                    break;
                case 2:
                    ap.addPart(list);
                    break;
                case 3:
                    rp.removePart(list, baseFileDirString);
                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        while (choice != 6);


    }

    private static boolean isPathValid(String Path)
    {
        try
        {
            File f = new File(Path);
            if (!f.isDirectory())
            {
                f = f.getParentFile();
            }

            if (f.exists())
            {
                System.out.println("That file exists, you may proceed.");
                System.out.println("If you've provided the wrong file, the program won't work.");
            }
            //Paths.get(Path); //Always returns true...
        }
        catch (SecurityException | NullPointerException e)
        {
            System.out.println("You've specified an invalid file path or do not have access to it. Enter 0 (Zero) to quit");
            return false;
        }
        return true;
    }

    public Part linkChecker(String url)
    {
        double price = 0;
        String title = null;
        String query = "div.pprice";

        try
        {
            final Document page = Jsoup.connect(url).get();
            title = page.title();

            price = queryChecker(page, query);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return new Part(title, url, price);
    }

    private double queryChecker(Document page, String query)
    {
        String rawPrice, tempPrice;
        double price = 0;

        for(Element row : page.select(query))
        {
            rawPrice = row.text();

            rawPrice = filter(rawPrice);

            tempPrice = rawPrice.replace(",", ".").replaceAll("[^\\d.]", "");

            price = Double.parseDouble(tempPrice);
            if(price > 0)
            {
                break;
            }
        }
        return price;
    }
    private String filter(String rawPrice)
    {
        String[] array = rawPrice.split(" ");
        return array[2];
    }
}
