package com.starbooks.model;

import java.util.*;

public interface PublisherDAO
{
    public abstract int insert(Publisher publisher);
    public abstract int delete(String publisherId);
    public abstract Publisher findByPrimaryKey(String publisherId);
    public abstract int update(Publisher publisher);
    public abstract Collection<Publisher> findAll();
}