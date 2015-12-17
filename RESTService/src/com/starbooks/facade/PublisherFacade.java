package com.starbooks.facade;

import java.util.*;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import org.glassfish.jersey.server.*;
import com.blogspot.monstersupreme.dataaccess.*;
import com.starbooks.helper.*;
import com.starbooks.model.*;

@Path("/publishers")
public class PublisherFacade
{
    private UserTransactionFactory txFactory = null;
    
    public void setUserTransactionFactory(UserTransactionFactory txFactory)
    {
        this.txFactory = txFactory;
    }
    
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

    public PublisherFacade() 
    {
        ConnectionFactory connFactory = Helper.getConnectionFactory();
        UserTransactionFactory txFactory = Helper.getUserTransactionFactory();
        
        bookDAO = new BookDAO(connFactory);
        publisherDAO = new PublisherDAO(connFactory);
        
        this.setUserTransactionFactory(txFactory);
        this.setBookDAO(bookDAO);
        this.setPublisherDAO(publisherDAO); 
    }
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public int insertPublisher(Publisher publisher)
    {        
        System.out.println("PublisherFacade insertPublisher() is called.");
        
        int updateCount = 0;
        
        XUserTransaction tx = txFactory.getUserTransaction();      
       
        try
        {            
            tx.begin();
            updateCount = publisherDAO.save(publisher);
            tx.commit();                        
        }
        catch (Exception e)
        {
            tx.rollback();
        }
        
        return updateCount; 
    }

    @GET
    @Path("/{publisherId}")
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Publisher editPublisher(@PathParam("publisherId") String publisherId)
    {        
        System.out.println("PublisherFacade editPublisher() is called.");
        
        Publisher publisher = null; 
        
        XUserTransaction tx = txFactory.getUserTransaction();      
        
        try
        {            
            tx.begin();
            publisher = publisherDAO.findByPrimaryKey(publisherId);
            tx.commit();                        
        }
        catch (Exception e)
        {
            tx.rollback();
        }
        
        return publisher; 
    }

    @DELETE
    @Path("/{publisherId}")
    public int deletePublisher(@PathParam("publisherId") String publisherId)
    {        
        System.out.println("PublisherFacade deletePublisher() is called.");
        
        int updateCount = 0;
        
        XUserTransaction tx = txFactory.getUserTransaction();      
        
        try
        {            
            tx.begin();
            Iterator<Book> books = bookDAO.findByPubID(publisherId).iterator();
            while (books.hasNext())
            {
                Book book = books.next();
                bookDAO.delete(book.getBookId());
            }
            updateCount = publisherDAO.delete(publisherId);            
            tx.commit();                        
        }
        catch (Exception e)
        {
            tx.rollback();
        }
        
        return updateCount; 
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Publisher> listPublishers()
    {        
        System.out.println("PublisherFacade listPublishers() is called.");
        
        List<Publisher> publishers = null;

        XUserTransaction tx = txFactory.getUserTransaction();      
        
        try
        {            
            tx.begin();
            publishers = publisherDAO.findAll();
            tx.commit();            
        }
        catch (Exception e)
        {
            tx.rollback();
        }
        
        return publishers; 
    }
    
    @PUT
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public int updatePublisher(Publisher publisher)
    {        
        System.out.println("PublisherFacade updatePublisher() is called.");
        
        int updateCount = 0;
        
        XUserTransaction tx = txFactory.getUserTransaction();      
        
        try
        {            
            tx.begin();
            updateCount = publisherDAO.update(publisher);
            tx.commit();                        
        }
        catch (Exception e)
        {
            tx.rollback();
        }
        
        return updateCount; 
    }
}
