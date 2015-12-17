package com.starbooks.facade;

import java.util.*;
import com.blogspot.monstersupreme.dataaccess.*;
import com.starbooks.model.*;

public class BookFacade
{
    private UserTransactionFactory txFactory = null;
    
    public void setUserTransactionFactory(UserTransactionFactory txFactory)
    {
        this.txFactory = txFactory;
    }
    
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
        
        XUserTransaction tx = txFactory.getUserTransaction();
        
        try
        {            
            tx.begin();
            Book book = bookDAO.findByPrimaryKey(bookId);
            tx.commit();
            if (book != null) available = true;
        }
        catch (Exception e)
        {
            tx.rollback();
        }
        
        return available; 
    }
    
    public int insertBook(Book book)
    {
        System.out.println("BookFacade insertBook() is called.");
                
        int updateCount = 0;
        
        XUserTransaction tx = txFactory.getUserTransaction();
                
        try
        {            
            tx.begin();
            bookDAO.save(book);
            tx.commit();
        }
        catch (Exception e)
        {
            tx.rollback();
        }

        return updateCount;
    }

    public int deleteBook(int bookId)
    {
        System.out.println("BookFacade deleteBook() is called.");
        
        int updateCount = 0;
        
        XUserTransaction tx = txFactory.getUserTransaction();
        
        try
        {            
            tx.begin();
            updateCount = bookDAO.delete(bookId);
            tx.commit();                        
        }
        catch (Exception e)
        {
            tx.rollback();
        }

        return updateCount; 
    }

    public List<Book> listBooks()
    {
        System.out.println("BookFacade listBooks() is called.");
        
        List<Book> bookList = null;

        XUserTransaction tx = txFactory.getUserTransaction();
        
        try
        {            
            tx.begin();
            bookList = bookDAO.findAll();
            tx.commit();            
        }
        catch (Exception e)
        {
            tx.rollback();
        }

        return bookList; 
    }

    public Book editBook(int bookId)
    {
        System.out.println("BookFacade editBook() is called.");
        
        Book book = null;

        XUserTransaction tx = txFactory.getUserTransaction();
        
        try
        {            
            tx.begin();
            book = bookDAO.findByPrimaryKey(bookId);
            tx.commit();            
        }
        catch (Exception e)
        {
            tx.rollback();
        }
        
        return book; 
    }
    
    public int updateBook(Book book)
    {
        System.out.println("BookFacade updateBook() is called.");
        
        int updateCount = 0;
        
        XUserTransaction tx = txFactory.getUserTransaction();
        
        try
        {            
            tx.begin();
            updateCount = bookDAO.update(book);
            tx.commit();                        
        }
        catch (Exception e)
        {
            tx.rollback();
        }
        
        return updateCount; 
    }
}
