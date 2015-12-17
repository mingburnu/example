package com.starbooks.helper;

import com.blogspot.monstersupreme.dataaccess.*;

public class Helper
{
    private static ConnectionFactory connFactory = null;
    private static UserTransactionFactory txFactory = null;
    
    static
    {
        connFactory = new ConnectionFactory();
        connFactory.setDataSource("java:comp/env/jdbc/StarBooksDS");
   
        txFactory = new UserTransactionFactory();
        txFactory.setConnectionFactory(connFactory);
    }
    
    public static ConnectionFactory getConnectionFactory()
    {
        return connFactory;
    }

    public static UserTransactionFactory getUserTransactionFactory()
    {
        return txFactory;
    }
}
