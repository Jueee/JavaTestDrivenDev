package com.java.testdriven.chapter08.alexandria;

import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

public class MyApplication extends ResourceConfig {

    public MyApplication() {
        register(RequestContextFilter.class);
        register(new BooksEndpoint());
        register(JacksonJaxbJsonProvider.class);
        register(CustomExceptionMapper.class);
    }
    
}
