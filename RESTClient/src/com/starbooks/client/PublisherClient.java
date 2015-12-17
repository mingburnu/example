package com.starbooks.client;

import java.util.*;

import javax.ws.rs.client.*;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.*;

import com.starbooks.model.*;

public class PublisherClient
{
    public static void main(String[] args)
    {
        //        Client client = ClientBuilder.newClient();
        //        WebTarget target = client.target("http://localhost:8080/RESTService")
        //                .path("services").path("publishers").path("OA");
        //        Builder builder = target.request(MediaType.APPLICATION_XML);
        //        Publisher publisher = builder.get(Publisher.class);
        //        System.out.println(publisher.getPublisherId());
        //        System.out.println(publisher.getPublisherName());
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/RESTService")
                .path("services").path("publishers");
        Builder builder = target.request(MediaType.APPLICATION_JSON);
        List<Publisher> publisherList = builder
                .get(new GenericType<List<Publisher>>()
                {
                });
        Iterator<Publisher> publishers = publisherList.iterator();
        while (publishers.hasNext())
        {
            System.out.println("===========");
            Publisher publisher = publishers.next();
            System.out.println(publisher.getPublisherId());
            System.out.println(publisher.getPublisherName());
        }
    }
}
