package com.starbooks.model;

import java.sql.*;
import java.util.*;

public class PublisherJDBCDAO implements PublisherDAO
{
    final static String INSERT = "insert into publisher values (?, ?)";
    final static String DELETE = "delete from publisher where publisherId = ?";
    final static String FIND = "select * from publisher where publisherId = ?";
    final static String UPDATE = 
        "update publisher set publisherName = ? where publisherId = ?";
    final static String FIND_ALL = "select * from publisher";
    
    @Override
    public int insert(Publisher publisher)
    {
        int updateCount = 0;
        
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try
        {
            conn = DatabaseUtils.getConnection();                      
            stmt = conn.prepareStatement(INSERT);           
            stmt.setString(1, publisher.getPublisherId());
            stmt.setString(2, publisher.getPublisherName());            
            updateCount = stmt.executeUpdate();                 
            stmt.close();
            conn.close();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }    
        finally
        {
            DatabaseUtils.closeStatement(stmt);
            DatabaseUtils.closeConnection(conn);
        }

        return updateCount;        
    }
    
    @Override
    public int delete(String publisherId)
    {
        int updateCount = 0;
        
        Connection conn = null;
        PreparedStatement stmt = null;

        try
        {
            conn = DatabaseUtils.getConnection();                      
            stmt = conn.prepareStatement(DELETE);
            stmt.setString(1, publisherId);
            updateCount = stmt.executeUpdate();                 
            stmt.close();
            conn.close();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }    
        finally
        {
            DatabaseUtils.closeStatement(stmt);
            DatabaseUtils.closeConnection(conn);
        }

        return updateCount;                
    }
    
    @Override
    public Publisher findByPrimaryKey(String publisherId)
    {
        Publisher publisher = new Publisher();
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try
        {
            conn = DatabaseUtils.getConnection();                      
            stmt = conn.prepareStatement(FIND);
            stmt.setString(1, publisherId);
            rs = stmt.executeQuery();
            
            if (rs.next())
            {
                publisher.setPublisherId(rs.getString("publisherId"));
                publisher.setPublisherName(rs.getString("publisherName"));
            }
         
            rs.close();
            stmt.close();
            conn.close();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }    
        finally
        {
            DatabaseUtils.closeResultSet(rs);
            DatabaseUtils.closeStatement(stmt);
            DatabaseUtils.closeConnection(conn);
        }

        return publisher;                
    }
    
    @Override
    public int update(Publisher publisher)
    {
        int updateCount = 0;
        
        Connection conn = null;
        PreparedStatement stmt = null;

        try
        {
            conn = DatabaseUtils.getConnection();                      
            stmt = conn.prepareStatement(UPDATE);
            stmt.setString(1, publisher.getPublisherName());
            stmt.setString(2, publisher.getPublisherId());
            updateCount = stmt.executeUpdate();                 
            stmt.close();
            conn.close();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }    
        finally
        {
            DatabaseUtils.closeStatement(stmt);
            DatabaseUtils.closeConnection(conn);
        }

        return updateCount;                
    }
    
    @Override
    public Collection<Publisher> findAll()
    {
        List<Publisher> publisherList = new ArrayList<Publisher>();        

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try
        {
            conn = DatabaseUtils.getConnection();                      
            stmt = conn.prepareStatement(FIND_ALL);
            rs = stmt.executeQuery();     
            while (rs.next())
            {
                Publisher publisher = new Publisher();
                publisher.setPublisherId(rs.getString("publisherId"));
                publisher.setPublisherName(rs.getString("publisherName"));
                publisherList.add(publisher);
            }
            
            rs.close();
            stmt.close();
            conn.close();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }    
        finally
        {
            DatabaseUtils.closeResultSet(rs);
            DatabaseUtils.closeStatement(stmt);
            DatabaseUtils.closeConnection(conn);            
        }

        return publisherList;
    }    
}
