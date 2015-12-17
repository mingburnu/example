package com.starbooks.facade;

import java.util.*;
import com.starbooks.model.*;

public class PublisherFacade
{
    private PublisherDAO publisherDAO = null;
    
    public void setPublisherDAO(PublisherDAO publisherDAO)
    {
        this.publisherDAO = publisherDAO;
    }

    private BookDAO bookDAO = null;
    
    public void setBookDAO(BookDAO bookDAO)
    {
        this.bookDAO = bookDAO;
    }

    public PublisherFacade() {}
    
    public int insertPublisher(Publisher publisher)
    {        
        System.out.println("PublisherFacade insertPublisher() is called.");
        return publisherDAO.insert(publisher);
    }

    public Publisher editPublisher(String publisherId)
    {        
        System.out.println("PublisherFacade editPublisher() is called.");
        return publisherDAO.findByPrimaryKey(publisherId);
    }

    public int deletePublisher(String publisherId)
    {        
        System.out.println("PublisherFacade deletePublisher() is called.");
        Iterator<Book> books = bookDAO.findByPubID(publisherId).iterator();
        while (books.hasNext())
        {
            Book book = books.next();
            bookDAO.delete(book.getBookId());
        }
        return publisherDAO.delete(publisherId);            
    }

    public Collection<Publisher> listPublishers()
    {        
        System.out.println("PublisherFacade listPublishers() is called.");
        return publisherDAO.findAll();
    }
    
    public int updatePublisher(Publisher publisher)
    {        
        System.out.println("PublisherFacade updatePublisher() is called.");
        return publisherDAO.update(publisher);
    }
}
