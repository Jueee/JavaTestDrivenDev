package com.java.testdriven.chapter08.newalexandria;

import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

/**
 * 	复制启动器 MyApplication 的代码：
 *	
 *	@author hzweiyongqiang
 */
public class TestMyApplication extends ResourceConfig{

	/**
	 * 	让我们能够注入任何 BooksEndpoint 。
	 * 	@param booksEndpoint
	 */
    public TestMyApplication(BooksEndpoint booksEndpoint) {
        register(RequestContextFilter.class);
        register(booksEndpoint);
        register(JacksonJaxbJsonProvider.class);
        register(CustomExceptionMapper.class);
    }
    
    public TestMyApplication() {
    	this(new BooksEndpoint(new BooksRepository()));
    }
}
