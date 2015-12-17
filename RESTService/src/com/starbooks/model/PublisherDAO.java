package com.starbooks.model;

import java.sql.*;
import java.util.*;
import com.blogspot.monstersupreme.dataaccess.*;

public class PublisherDAO 
{        
    private final static String SAVE_PUBLISHER =
        "insert into publisher values(?, ?)";
    private final static String DELETE_PUBLISHER =
        "delete from publisher where publisherId = ?";
    private final static String FIND_PUBLISHERID =
        "select * from publisher where publisherId = ?";
    private final static String FIND_PUBLISHERNAME =
        "select * from publisher where publisherName = ?";
    private final static String FIND_ALL =
        "SELECT * FROM publisher";
    private final static String UPDATE_PUBLISHER =
        "update publisher set publisherName = ? where publisherId = ?";

    private ConnectionFactory connFactory = null;
    
    public void setConnectionFactory(ConnectionFactory connFactory)
    {
        this.connFactory = connFactory;
    }

    public PublisherDAO()
    {
    }

    public PublisherDAO(ConnectionFactory connFactory)
    {
        this.setConnectionFactory(connFactory);
    }
    
    public int save(Publisher publisher) throws Exception
    {
        int updateCount = 0;
                          
        PreparedStatement stmt = null;
        
        try
        {            
            stmt = connFactory.getConnection().prepareStatement(SAVE_PUBLISHER);
            stmt.setString(1, publisher.getPublisherId());
            stmt.setString(2, publisher.getPublisherName());
            updateCount = stmt.executeUpdate();
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            throw ex;
        }
        finally
        {
            DatabaseUtils.closeStatement(stmt);
        }

        return updateCount;
    }

    public int delete(String publisherId) throws Exception
    {
        int updateCount = 0;
        
        PreparedStatement stmt = null;

        try
        {
            stmt = connFactory.getConnection().prepareStatement(DELETE_PUBLISHER);
            
            if (publisherId.equals("OA"))
                throw new SQLException("O'Reilly is undeletable!");

            stmt.setString(1, publisherId);
            updateCount = stmt.executeUpdate();
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            throw ex;
        }
        finally
        {
            DatabaseUtils.closeStatement(stmt);
        }
        
        return updateCount;
    }

    public List<Publisher> findAll() throws Exception
    {
        List<Publisher> publishers = new ArrayList<Publisher>();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try
        {
            stmt = connFactory.getConnection().prepareStatement(FIND_ALL);            
            rs = stmt.executeQuery();
            while (rs.next())
            {
                Publisher publisher = new Publisher();                
                publisher.setPublisherId(rs.getString("publisherId"));
                publisher.setPublisherName(rs.getString("publisherName"));
                publishers.add(publisher);
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            throw ex;
        }
        finally
        {
            DatabaseUtils.closeResultSet(rs);
            DatabaseUtils.closeStatement(stmt);
        }
        
        return publishers;
    }

    public Publisher findByPrimaryKey(String publisherId) throws Exception
    {
        Publisher publisher = new Publisher();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try
        {
            stmt = connFactory.getConnection().prepareStatement(FIND_PUBLISHERID);
            stmt.setString(1, publisherId);
            rs = stmt.executeQuery();
            if (rs.next())
            {
                publisher.setPublisherId(rs.getString("publisherId"));
                publisher.setPublisherName(rs.getString("publisherName"));
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            throw ex;
        }
        finally
        {
            DatabaseUtils.closeResultSet(rs);
            DatabaseUtils.closeStatement(stmt);
        }
        
        return publisher;
    }

    public Publisher findByPublisherName(String publisherName) throws Exception
    {
        Publisher publisher = new Publisher();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try
        {
            stmt = connFactory.getConnection().prepareStatement(FIND_PUBLISHERNAME);
            stmt.setString(1, publisherName);
            rs = stmt.executeQuery();
            if (rs.next())
            {
                publisher.setPublisherId(rs.getString("publisherId"));
                publisher.setPublisherName(rs.getString("publisherName"));
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            throw ex;
        }
        finally
        {
            DatabaseUtils.closeResultSet(rs);
            DatabaseUtils.closeStatement(stmt);
        }
        
        return publisher;
    }
    
    public int update(Publisher publisher) throws Exception
    {
        int updateCount = 0;
        
        PreparedStatement stmt = null;

        try
        {
            stmt = connFactory.getConnection().prepareStatement(UPDATE_PUBLISHER);
            stmt.setString(1, publisher.getPublisherName());
            stmt.setString(2, publisher.getPublisherId());
            updateCount = stmt.executeUpdate();
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            throw ex;
        }
        finally
        {
            DatabaseUtils.closeStatement(stmt);
        }
        
        return updateCount;
    }
}
