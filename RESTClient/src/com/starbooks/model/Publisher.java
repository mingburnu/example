package com.starbooks.model;

import java.io.*;

public class Publisher implements Serializable
{
    static final long serialVersionUID = 2010L;
    
    private String publisherId;
    private String publisherName;

    public Publisher() {}
    
    public Publisher(String publisherId, String publisherName)
    {
        this.publisherId = publisherId;
        this.publisherName = publisherName;
    }
    
    public String getPublisherId()
    {
        return publisherId;
    }

    public void setPublisherId(String publisherId)
    {
        this.publisherId = publisherId;
    }

    public String getPublisherName()
    {
        return publisherName;
    }

    public void setPublisherName(String publisherName)
    {
        this.publisherName = publisherName;
    }
}
