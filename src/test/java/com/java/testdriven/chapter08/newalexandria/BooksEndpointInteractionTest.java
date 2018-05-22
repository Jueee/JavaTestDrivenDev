package com.java.testdriven.chapter08.newalexandria;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class BooksEndpointInteractionTest {

	public static final URI FULL_PATH = URI.create("http://127.0.0.1:8080/JavaTestDrivenDev");

	private HttpServer server;
	
	public static final String AUTHOR_BOOK_1 = "Viktor Farcic and Alex Garcia";
	public static final String TITLE_BOOK_1 = "TDD in Java";
	private final Map<String, String> TDD_IN_JAVA;
	private BooksRepository booksRepository;
	
	public BooksEndpointInteractionTest() {
		TDD_IN_JAVA = getBookProperties(TITLE_BOOK_1, AUTHOR_BOOK_1);
		RestAssured.baseURI = FULL_PATH.toString();
	}
	
	@Before
	public void before() throws IOException {
		booksRepository = mock(BooksRepository.class);
		BooksEndpoint booksEndpoint = new BooksEndpoint(booksRepository);
		ResourceConfig resourceConfig = new MyApplication(booksEndpoint);
		server = GrizzlyHttpServerFactory.createHttpServer(FULL_PATH, resourceConfig);
		server.start();
	}
	
	@After
	public void after() {
		server.shutdownNow();
	}

    private Map<String, String> getBookProperties(String title, String author) {
        Map<String, String> bookProperties = new HashMap<>();
        bookProperties.put("title", title);
        bookProperties.put("author", author);
        return bookProperties;
    }
	
	private Response addBook(Map<String, String> bookProperties) {
		return RestAssured.given()
						  .log().path()
						  .contentType(ContentType.URLENC)
						  .parameters(bookProperties)
						  .post("books");
	} 
	
	@Test
	public void add_one_book() {
		addBook(TDD_IN_JAVA);
		verify(booksRepository).add(new Book(TITLE_BOOK_1, AUTHOR_BOOK_1, 1));
	}
}

