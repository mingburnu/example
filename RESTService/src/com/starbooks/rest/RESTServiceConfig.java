package com.starbooks.rest;

import javax.ws.rs.*;

import org.glassfish.jersey.server.*;
@ApplicationPath("services")
public class RESTServiceConfig extends ResourceConfig
{
    public RESTServiceConfig()
    {
        packages("com.starbooks.facade");
    }
}
