package com.roamsvie.ws;

public class Part
{
    private String name, link;
    private double price;

    public Part(String name, String link, double price)
    {
        this.name = name;
        this.link = link;
        this.price = price;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getLink()
    {
        return link;
    }

    public void setLink(String link)
    {
        this.link = link;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }
}
