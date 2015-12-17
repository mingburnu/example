package com.starbooks.model;

import java.util.*;

public interface BookDAO
{
    public abstract int insert(Book book);
    public abstract int delete(int bookId);
    public abstract Book findByPrimaryKey(int bookId);
    public abstract int update(Book book);
    public abstract List<Book> findAll();
    public abstract List<Book> findByPubID(String pubId);
}