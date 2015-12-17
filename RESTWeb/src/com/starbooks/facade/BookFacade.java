package com.starbooks.facade;

import java.util.*;
import com.starbooks.model.*;

public class BookFacade
{
    private BookDAO bookDAO = null;
    
    public void setBookDAO(BookDAO bookDAO)
    {
        this.bookDAO = bookDAO;
    }
    
    public BookFacade() {}
        
    public boolean isBookAvailable(int bookId)
    {        
        System.out.println("BookFacade isBookAvailable() is called.");
        boolean available = false;
        Book book = bookDAO.findByPrimaryKey(bookId);
        if (book != null) available = true;
        return available; 
    }
    
    public int insertBook(Book book)
    {
        System.out.println("BookFacade insertBook() is called.");
        return bookDAO.insert(book);
    }

    public int deleteBook(int bookId)
    {
        System.out.println("BookFacade deleteBook() is called.");
        return bookDAO.delete(bookId);
    }

    public Collection<Book> listBooks()
    {
        System.out.println("BookFacade listBooks() is called.");
        return bookDAO.findAll();
    }

    public Book editBook(int bookId)
    {
        System.out.println("BookFacade editBook() is called.");
        return bookDAO.findByPrimaryKey(bookId);
    }
    
    public int updateBook(Book book)
    {
        System.out.println("BookFacade updateBook() is called.");
        return bookDAO.update(book);
    }
}
