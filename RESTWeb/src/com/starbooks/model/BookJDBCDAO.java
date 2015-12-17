package com.starbooks.model;

import java.sql.*;
import java.util.*;

public class BookJDBCDAO implements BookDAO
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
    
    @Override
    public int insert(Book book)
    {
        int updateCount = 0;
        
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try
        {       
            conn = DatabaseUtils.getConnection();
            stmt = conn.prepareStatement(SAVE_BOOK);
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
        }
        finally
        {
            DatabaseUtils.closeStatement(stmt);
        }

        return updateCount;
    }

    @Override
    public int delete(int bookID)
    {
        int updateCount = 0;
        
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try
        {            
            conn = DatabaseUtils.getConnection(); 
            stmt = conn.prepareStatement(DELETE_BOOK);
            stmt.setInt(1, bookID);
            updateCount = stmt.executeUpdate();
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        finally
        {        
            DatabaseUtils.closeStatement(stmt);
        }

        return updateCount;
    }

    @Override
    public List<Book> findAll()
    {
        List<Book> bookList = new ArrayList<Book>();
        
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
        }
        finally
        {
            DatabaseUtils.closeResultSet(rs);
            DatabaseUtils.closeStatement(stmt);            
        }
        
        return bookList;
    }

    @Override
    public Book findByPrimaryKey(int bookId)
    {
        Book book = new Book();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try
        {
            Connection conn = null;
            conn = DatabaseUtils.getConnection();    
            stmt = conn.prepareStatement(FIND_BOOKID);
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
        }
        finally
        {
            DatabaseUtils.closeResultSet(rs);
            DatabaseUtils.closeStatement(stmt);
        }
        
        return book;
    }

    @Override
    public int update(Book book)
    {
        int updateCount = 0;
        
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try
        {           
            conn = DatabaseUtils.getConnection();     
            stmt = conn.prepareStatement(UPDATE_BOOK);
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
        }
        finally
        {
            DatabaseUtils.closeStatement(stmt);
        }

        return updateCount;
    }
    
    @Override
    public List<Book> findByPubID(String pubID)
    {
        List<Book> bookList = new ArrayList<Book>();
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try
        {
            conn = DatabaseUtils.getConnection();     
            stmt = conn.prepareStatement(FIND_PUBID);   
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
        }
        finally
        {
            DatabaseUtils.closeResultSet(rs);
            DatabaseUtils.closeStatement(stmt);            
        }
        
        return bookList;
    }    
}
