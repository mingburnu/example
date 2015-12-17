package com.starbooks.model;

import java.util.*;
import javax.ws.rs.client.*;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.*;

public class PublisherRESTDAO implements PublisherDAO
{
    private Client client = ClientBuilder.newClient();
    private WebTarget target = client
            .target("http://localhost:8080/RESTService/services/publishers");
    private Builder builder = null;

    @Override
    public int insert(Publisher publisher)
    {
        builder = target.request(MediaType.APPLICATION_JSON);
        return builder.post(
                Entity.entity(publisher, MediaType.APPLICATION_JSON),
                Integer.class);
    }

    @Override
    public int delete(String publisherId)
    {
        builder = target.path(publisherId).request(MediaType.APPLICATION_JSON);
        return builder.delete(Integer.class);
    }

    @Override
    public Publisher findByPrimaryKey(String publisherId)
    {
        builder = target.path(publisherId).request(MediaType.APPLICATION_JSON);
        return builder.get(Publisher.class);
    }

    @Override
    public int update(Publisher publisher)
    {
        builder = target.request(MediaType.APPLICATION_JSON);
        return builder.put(
                Entity.entity(publisher, MediaType.APPLICATION_JSON),
                Integer.class);
    }

    @Override
    public Collection<Publisher> findAll()
    {
        builder = target.request(MediaType.APPLICATION_JSON);
        return builder.get(new GenericType<List<Publisher>>()
        {
        });
    }
}
