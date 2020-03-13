package com.roamsvie.ws;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;


public class Main
{

    public static void main(String[] args)
    {
        Menu.printFMsg();

        //My path:      D:\Development\GitHub\WebScraper\parts.txt


        /*
        String url = "https://www.mindfactory.de/product_info.php/500GB-Samsung-970-Evo-Plus-M-2-2280-PCIe-3-0-x4-NVMe-1-3-3D-NAND-TLC--M_1292721.html";
        String title = null;
        String rawPrice, tempPrice;
        double price;

        try
        {
            final Document page = Jsoup.connect(url).get();
            title = page.title();
            System.out.println("Part: " +title);
            for(Element row : page.select("span.specialPriceText"))
            {
                rawPrice = row.text();
                System.out.println("Raw price: " +rawPrice);

                tempPrice = rawPrice.replace(",", ".").replaceAll("[^\\d.]", "");
                System.out.println("Formatted price: [" +tempPrice +"]");

                price = Double.parseDouble(tempPrice);
                System.out.println("DOUBLE price: [" +price +"]");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        */



    }
}
