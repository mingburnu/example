package com.starbooks.model;

import java.sql.*;

public class DatabaseUtils
{
    private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/starbooks";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "passw0rd";

    static
    {
        try
        {
            Class.forName(DRIVER_CLASS);
        }
        catch (ClassNotFoundException ex)
        {
            throw new RuntimeException(ex);
        }
    }

    public final static Connection getConnection() throws RuntimeException
    {
        try
        {
            return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        }
        catch (Exception ex)
        {
            throw new RuntimeException(ex);
        }        
    }

    public final static void closeResultSet(ResultSet rs) throws RuntimeException
    {
        if (rs != null)
        {
            try
            {
                // isClose() is weird for Apache Commons DBCP.
                rs.close();
            }
            catch (Exception ex)
            {
                throw new RuntimeException(ex);
            }
            finally
            {
                rs = null;
            }
        }
    }

    public final static void closeStatement(Statement stmt) throws RuntimeException
    {
        if (stmt != null)
        {
            try
            {
                // isClose() is weird for Apache Commons DBCP.
                stmt.close();
            }
            catch (Exception ex)
            {
                throw new RuntimeException(ex);
            }
            finally
            {
                stmt = null;
            }
        }
    }        
    
    public final static void closeConnection(Connection conn) throws RuntimeException
    {
        if (conn != null)
        {
            try
            {
                if (!conn.isClosed()) conn.close();
            }
            catch (Exception ex)
            {
                throw new RuntimeException(ex);
            }
            finally
            {
                conn = null;
            }
        }
    }    
}
