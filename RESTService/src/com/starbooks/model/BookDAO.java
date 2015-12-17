package com.starbooks.model;

import java.sql.*;
import java.util.*;
import com.blogspot.monstersupreme.dataaccess.*;

public class BookDAO
{
    private final static String SAVE_BOOK =
        "insert into book(isbn, title, pubId, releaseDate, listPrice, coverImage) " +
        "values(?, ?, ?, ?, ?, ?)";
    private final static String DELETE_BOOK =
        "delete from book where bookId = ?";
    private final static String FIND_BOOKID =
        "select * from book where bookId = ?";
    private final static String FIND_ALL =
        "select * from book";
    private final static String UPDATE_BOOK =
        "update book set isbn = ?, title = ?, pubId = ?, releaseDate = ?, " +
        "listPrice = ?, coverImage = ? where bookId = ?";
    private final static String FIND_PUBID =
        "select * from book where pubId = ?";
    
    private ConnectionFactory connFactory = null;
    
    public void setConnectionFactory(ConnectionFactory connFactory)
    {
        this.connFactory = connFactory;
    }

    public BookDAO(ConnectionFactory connFactory)
    {
        this.setConnectionFactory(connFactory);
    }

    public int save(Book book) throws Exception
    {
        int updateCount = 0;
        
        PreparedStatement stmt = null;
        
        try
        {            
            stmt = connFactory.getConnection().prepareStatement(SAVE_BOOK);
            stmt.setString(1, book.getIsbn());
            stmt.setString(2, book.getTitle());
            stmt.setString(3, book.getPubId());
            stmt.setDate(4, book.getReleaseDate());
            stmt.setDouble(5, book.getListPrice());
            stmt.setBytes(6, book.getCoverImage());
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

    public int delete(int bookID) throws Exception
    {
        int updateCount = 0;
        
        PreparedStatement stmt = null;
        
        try
        {            
            stmt = connFactory.getConnection().prepareStatement(DELETE_BOOK);
            stmt.setInt(1, bookID);
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

    public List<Book> findAll() throws Exception
    {
        List<Book> bookList = new ArrayList<Book>();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try
        {
            stmt = connFactory.getConnection().prepareStatement(FIND_ALL);            
            rs = stmt.executeQuery();
            while (rs.next())
            {
                Book book = new Book();          
                book.setBookId(rs.getInt("bookId"));
                book.setIsbn(rs.getString("isbn"));
                book.setTitle(rs.getString("title"));                
                book.setPubId(rs.getString("pubId"));
                book.setReleaseDate(rs.getDate("releaseDate"));
                book.setListPrice(rs.getDouble("listPrice"));
                book.setCoverImage(rs.getBytes("coverImage"));
                bookList.add(book);
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
        
        return bookList;
    }

    public Book findByPrimaryKey(int bookId) throws Exception
    {
        Book book = new Book();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try
        {
            stmt = connFactory.getConnection().prepareStatement(FIND_BOOKID);
            stmt.setInt(1, bookId);
            rs = stmt.executeQuery();
            if (rs.next())
            {         
                book.setBookId(rs.getInt("bookId"));
                book.setIsbn(rs.getString("isbn"));
                book.setTitle(rs.getString("title"));                
                book.setPubId(rs.getString("pubId"));
                book.setReleaseDate(rs.getDate("releaseDate"));
                book.setListPrice(rs.getDouble("listPrice"));
                book.setCoverImage(rs.getBytes("coverImage"));
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
        
        return book;
    }

    public int update(Book book) throws Exception
    {
        int updateCount = 0;
        
        PreparedStatement stmt = null;
        
        try
        {            
            stmt = connFactory.getConnection().prepareStatement(UPDATE_BOOK);
            stmt.setString(1, book.getIsbn());
            stmt.setString(2, book.getTitle());
            stmt.setString(3, book.getPubId());
            stmt.setDate(4, book.getReleaseDate());
            stmt.setDouble(5, book.getListPrice());
            stmt.setBytes(6, book.getCoverImage());
            stmt.setInt(7, book.getBookId());
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
    
    public List<Book> findByPubID(String pubID) throws Exception
    {
        List<Book> bookList = new ArrayList<Book>();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try
        {
            stmt = connFactory.getConnection().prepareStatement(FIND_PUBID);   
            stmt.setString(1, pubID);
            rs = stmt.executeQuery();
            while (rs.next())
            {
                Book book = new Book();          
                book.setBookId(rs.getInt("bookId"));
                book.setIsbn(rs.getString("isbn"));
                book.setTitle(rs.getString("title"));                
                book.setPubId(rs.getString("pubId"));
                book.setReleaseDate(rs.getDate("releaseDate"));
                book.setListPrice(rs.getDouble("listPrice"));
                book.setCoverImage(rs.getBytes("coverImage"));
                bookList.add(book);
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
        
        return bookList;
    }    
}
