package com.java.testdriven.chapter08.newalexandria;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.java.testdriven.chapter08.newalexandria.Book;
import com.java.testdriven.chapter08.newalexandria.Books;
import com.java.testdriven.chapter08.newalexandria.States;

public class BooksTest {

    @Test
    public void should_search_for_any_past_state() {
        Book book1 = new Book("title", "author", States.AVAILABLE.getValue());
        book1.censor();

        Books books = new Books();
        books.add(book1);

        assertThat(books.filterByState(String.valueOf(States.AVAILABLE.getValue())).isEmpty(), is(false));
    }

}