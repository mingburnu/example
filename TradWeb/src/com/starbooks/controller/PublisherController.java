package com.starbooks.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.starbooks.facade.*;
import com.starbooks.model.*;

public class PublisherController extends javax.servlet.http.HttpServlet
{
    private static final long serialVersionUID = 2010L;
    
    private PublisherFacade publisherFacade = null;
    
    public void setPublisherFacade(PublisherFacade publisherFacade)
    {
        this.publisherFacade = publisherFacade;
    }
    
    public void init() throws ServletException
    {
        publisherFacade = new PublisherFacade();
        publisherFacade.setBookDAO(new BookJDBCDAO());
        publisherFacade.setPublisherDAO(new PublisherJDBCDAO()); 
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
        Publisher publisher = null;
        String publisherId = request.getParameter("publisherId");
        if (publisherId != null && publisherId.length() != 0)
            publisher = publisherFacade.editPublisher(publisherId);
        else
            publisher = new Publisher("", "");
        request.setAttribute("publisher", publisher);
     }

    public void insert(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException
    {
        String publisherId = request.getParameter("publisherId");
        String publisherName = request.getParameter("publisherName");
        Publisher publisher = new Publisher(publisherId, publisherName);
        publisherFacade.insertPublisher(publisher);
        request.setAttribute("publisherList", publisherFacade.listPublishers());
    }
    
    public void delete(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException
    {
        String publisherId = request.getParameter("publisherId");
        publisherFacade.deletePublisher(publisherId);
        request.setAttribute("publisherList", publisherFacade.listPublishers());
    }

    public void list(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException
    {               
        request.setAttribute("publisherList", publisherFacade.listPublishers());        
    }
    
    public void update(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException
    {
        String publisherId = request.getParameter("publisherId");
        String publisherName = request.getParameter("publisherName");
        Publisher publisher = new Publisher(publisherId, publisherName);
        publisherFacade.updatePublisher(publisher);
        request.setAttribute("publisherList", publisherFacade.listPublishers());
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
            viewName = "publisher.jsp";
        }
        else if (operation.equals("insert")) 
        {
            insert(request, response);
            viewName = "publishers.jsp";
        }        
        else if (operation.equals("delete")) 
        {
            delete(request, response);
            viewName = "publishers.jsp";
        }
        else if (operation.equals("list"))
        {
            list(request, response);
            viewName = "publishers.jsp";                        
        }                
        else if (operation.equals("update")) 
        {
            update(request, response);
            viewName = "publishers.jsp";
        }

        RequestDispatcher view = request.getRequestDispatcher(viewName);
        view.forward(request, response);
    }
}