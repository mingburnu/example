package com.starbooks.model;

import java.io.*;
import java.sql.*;

public class Book implements Serializable
{
    static final long serialVersionUID = 2009L;
    
    private int bookId;
    private String isbn, title, pubId;
    private Date releaseDate;
    private double listPrice;
    private byte[] coverImage;

    public Book()
    {
        this.bookId = 0;
        this.isbn = "";
        this.title = "";
        this.pubId = "";
        this.releaseDate = null;
        this.listPrice = 0;
        this.coverImage = null;
    }
    
    public Book(String isbn, String title, String pubId, Date releaseDate,
        double listPrice, byte[] coverImage)
    {
        this.isbn = isbn;
        this.title = title;
        this.pubId = pubId;
        this.releaseDate = releaseDate;
        this.listPrice = listPrice;
        this.coverImage = coverImage;
    }
    
    public int getBookId()
    {
        return bookId;
    }

    public void setBookId(int bookId)
    {
        this.bookId = bookId;
    }

    public byte[] getCoverImage()
    {
        return coverImage;
    }

    public void setCoverImage(byte[] coverImage)
    {
        this.coverImage = coverImage;
    }

    public String getIsbn()
    {
        return isbn;
    }

    public void setIsbn(String isbn)
    {
        this.isbn = isbn;
    }

    public double getListPrice()
    {
        return listPrice;
    }

    public void setListPrice(double listPrice)
    {
        this.listPrice = listPrice;
    }

    public String getPubId()
    {
        return pubId;
    }

    public void setPubId(String pubId)
    {
        this.pubId = pubId;
    }

    public Date getReleaseDate()
    {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate)
    {
        this.releaseDate = releaseDate;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;        
    }
}
