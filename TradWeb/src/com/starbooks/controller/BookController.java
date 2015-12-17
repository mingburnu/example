package com.starbooks.controller;

import java.io.*;
import java.text.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.starbooks.facade.*;
import com.starbooks.model.*;

public class BookController extends javax.servlet.http.HttpServlet
{
    static final long serialVersionUID = 2010L;
    
    private BookFacade bookFacade = null;
    
    public void setBookFacade(BookFacade bookFacade)
    {
        this.bookFacade = bookFacade;
    }
    
    public void init() throws ServletException
    {
        bookFacade = new BookFacade();
        bookFacade.setBookDAO(new BookJDBCDAO()); 
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException
    {
        processRequest(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException
    {
        processRequest(request, response);
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException
    {
        Book book = null;
        String sBookId = request.getParameter("bookId");
        if (sBookId != null && sBookId.length() != 0)
        {
            int bookId = Integer.parseInt(sBookId);
            book = bookFacade.editBook(bookId);
        }
        else
        {
            book = new Book();
        }
        request.setAttribute("book", book);       
     }

    public void insert(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException
    {
        String isbn = request.getParameter("isbn");
        String title = request.getParameter("title");
        String pubId = request.getParameter("pubId");
        java.sql.Date releaseDate = null;
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date utilDate = sdf.parse(request.getParameter("releaseDate"));
            releaseDate = new java.sql.Date(utilDate.getTime());
        }
        catch (Exception ex)
        {
            releaseDate = new java.sql.Date(System.currentTimeMillis());
            System.out.println(ex.getMessage());
        }
        double listPrice = 
            Double.parseDouble(request.getParameter("listPrice"));
        byte[] coverImage = new byte[1];
        Book book = new Book(isbn, title, pubId, releaseDate, listPrice, coverImage);
        bookFacade.insertBook(book);
        request.setAttribute("bookList", bookFacade.listBooks());        
    }
    
    public void delete(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException
    {
        int bookId = Integer.parseInt(request.getParameter("bookId"));
        bookFacade.deleteBook(bookId);
        request.setAttribute("bookList", bookFacade.listBooks());        
    }

    public void list(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException
    {   
        request.setAttribute("bookList", bookFacade.listBooks());        
    }

    public void update(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException
    {
        int bookID = Integer.parseInt(request.getParameter("bookId"));
        Book book = bookFacade.editBook(bookID);
        book.setIsbn(request.getParameter("isbn"));
        book.setTitle(request.getParameter("title"));
        book.setPubId(request.getParameter("pubId"));
        java.sql.Date releaseDate = null;
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date utilDate = sdf.parse(request.getParameter("releaseDate"));
            releaseDate = new java.sql.Date(utilDate.getTime());
            book.setReleaseDate(releaseDate);
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        book.setListPrice(
            Double.parseDouble(request.getParameter("listPrice")));
        bookFacade.updateBook(book);
        request.setAttribute("bookList", bookFacade.listBooks());        
    }

    public void processRequest(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException
    {
        request.setCharacterEncoding("UTF-8");
        String operation = request.getParameter("operation");
        
        String viewName = null;

        if (operation.equals("edit"))
        {
            edit(request, response);
            viewName = "book.jsp";            
        }
        else if (operation.equals("insert"))
        {
            insert(request, response);
            viewName = "books.jsp";
        }
        else if (operation.equals("delete"))
        {
            delete(request, response);
            viewName = "books.jsp";
        }
        else if (operation.equals("list"))
        {
            list(request, response);
            viewName = "books.jsp";
        }               
        else if (operation.equals("update"))
        {
            update(request, response);
            viewName = "books.jsp";
        }               

        RequestDispatcher view = request.getRequestDispatcher(viewName);
        view.forward(request, response);
    }
}