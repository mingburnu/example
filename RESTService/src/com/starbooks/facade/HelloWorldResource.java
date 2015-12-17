package com.starbooks.facade;

import javax.ws.rs.*;

@Path("/helloworld")
public class HelloWorldResource
{
    @GET
    @Produces("text/plain")
    public String getWelcomeMessage()
    {
        return "Hello, World!";
    }

    @GET
    @Path("/{name}")
    @Produces("text/plain")
    public String getWelcomeMessage(@PathParam("name") String name)
    {
        return "Hello, " + name + "!";
    }
    
    @GET
    @Path("/{name}")
    @Produces("text/html")
    public String getHTMLWelcomeMessage(){
        return "<h1>Hello, World!</h1>";
    }
}