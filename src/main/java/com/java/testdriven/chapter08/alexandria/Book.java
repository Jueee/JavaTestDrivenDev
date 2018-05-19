package com.java.testdriven.chapter08.alexandria;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Book {

    private final String title;
    private final String author;
    private int status;
    private int id;


    public Book(String title, String author, int status) {
        this.title = title;
        this.author = author;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public int getStatus() {
        return status;
    }

    public String getAuthor() {
        return author;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void rent() {
        status = States.RENTED;
    }

    public void returnBook() {
        status = States.AVAILABLE;
    }

    public void censor() {
        status = States.CENSORED;
    }

    public void uncensor() {
        status = States.AVAILABLE;
    }

    public void prepare() {
        status = States.AVAILABLE;
    }
}
