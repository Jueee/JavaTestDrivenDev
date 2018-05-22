package com.java.testdriven.chapter08.newalexandria;

import static org.hamcrest.CoreMatchers.is;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

/**
 * 	以编程方式启动服务器
 *	使用Grizzly（https://grizzly.java.net/），它让我们能够使用来自Jersey ResourceConfig 的配置以启动服务器
 *
 *	为进行测试，我们使用了一个名为RestAssured的库（https://github.com/rest-assured/rest-assured），它让我们能够更轻松地测试REST和JSON。
 *
 *	@author hzweiyongqiang
 */
public class BooksEndpointTest {
	
	public static final URI FULL_PATH = URI.create("http://127.0.0.1:8080/JavaTestDrivenDev");

	private HttpServer server;
	
	public static final String AUTHOR_BOOK_1 = "Viktor Farcic and Alex Garcia";
	public static final String TITLE_BOOK_1 = "TDD in Java";
	private final Map<String, String> TDD_IN_JAVA;
	
	public BooksEndpointTest() {
		TDD_IN_JAVA = getBookProperties(TITLE_BOOK_1, AUTHOR_BOOK_1);
		RestAssured.baseURI = FULL_PATH.toString();
	}
    
    private Matcher<Integer> hasStatus(int status){
    	return is(status);
    }
	
	@Before
	public void before() throws IOException {
		ResourceConfig resourceConfig = new MyApplication();
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
    
    private Map<String, Object> withId(int id){
    	Map<String, Object> properties = new HashMap<>();
    	properties.put("id", id);
    	return properties;
    }
    
    private void checkBookSetDetails(Response book2, int id, Matcher<Integer> status) {
    	book2.prettyPrint();
    	book2.then()
    		 .body("empty", is(false))
    		 .body("result[0].author", is(AUTHOR_BOOK_1))
    		 .body("result[0].title", is(TITLE_BOOK_1))
    		 .body("result[0].id", is(id))
    		 .body("result[0].status", status);
    }
    
    private void checkBookDetails(Response book2, int id, Matcher<Integer> status) {
    	book2.prettyPrint();
    	book2.then()
    		 .body("author", is(AUTHOR_BOOK_1))
    		 .body("title", is(TITLE_BOOK_1))
    		 .body("id", is(id))
    		 .body("status", status);
    }
	
	private void assertBooksSize(Response response, Matcher<String> matcher) {
		response.then().body(matcher);
	}
	
	private Response addBook(Map<String, ?> bookProperties) {
		return RestAssured.given()
						  .log().path()
						  .contentType(ContentType.URLENC)
						  .parameters(bookProperties)
						  .post("books");
	} 
	
	private Response getBook(Map<String, ?> bookProperties) {
		return RestAssured.given()
						  .log().path()
						  .contentType(ContentType.URLENC)
						  .accept(ContentType.JSON)
						  .parameters(bookProperties)
						  .get("books");
	}
	
	private Response censorBook(Map<String, Object> properties) {
		return RestAssured.given()
						  .log().path()
						  .contentType(ContentType.URLENC)
						  .post("books/{id}/censor",properties.get("id"));
	}
	
	private void checkThatBook(Map<String, Object> properties, Matcher<Integer> status) {
		final Response book2 = getBook(properties);
		checkBookSetDetails(book2, (Integer)properties.get("id"), status);
	}

	/**
	 * 	这个服务器仅在很短的时间内（测试运行时）可用
	 * 	因此如果你需要手动访问，请在需要暂停执行时调用下面的方法
	 *	@throws IOException
	 */
	public void pauseTheServer() {
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// (1) 添加新书
	@Test
	public void add_one_book() {
		final Response books1 = addBook(TDD_IN_JAVA);
		assertBooksSize(books1, is("1"));
	}
	
	@Test
	public void add_a_second_book() {
		addBook(TDD_IN_JAVA);
		
		final Response books2 = addBook(TDD_IN_JAVA);
		assertBooksSize(books2, is("2"));
	}
	
	@Test
	public void get_book_details_by_id() {
		addBook(TDD_IN_JAVA);
		
		final Response book2 = getBook(withId(0));
		checkBookSetDetails(book2, 0, hasStatus(1));
	}
	
	@Test
	public void get_several_books_in_a_row() {
		addBook(TDD_IN_JAVA);
		addBook(TDD_IN_JAVA);
		addBook(TDD_IN_JAVA);
		addBook(TDD_IN_JAVA);
		
		checkThatBook(withId(0), hasStatus(1));
		checkThatBook(withId(1), hasStatus(1));
		checkThatBook(withId(2), hasStatus(1));
		checkThatBook(withId(3), hasStatus(1));
	}
	
	@Test
	public void censor_a_book() {
		addBook(TDD_IN_JAVA);
		
		final Response response = censorBook(withId(0));
		checkBookDetails(response, 0, hasStatus(4));
	}
	
	@Test
	public void cannot_retrieve_a_censored_book() {
		addBook(TDD_IN_JAVA);
		
		censorBook(withId(0));
		
		final Response book = getBook(withId(0));
		book.prettyPrint();
		book.then().body("empty", is(true));
	}
}
