package com.epam.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Book {
    //ISBN10
    private long id;
    private String title;
    private String author;
    private String description;
    private BigDecimal cost;
    private Date publicationDate;
    private String publisher;
    private String category;

    public Book() {
    }

    public Book(long id, String title, String author, String description, BigDecimal cost, Date publicationDate, String publisher, String category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.description = description;
        this.cost = cost;
        this.publicationDate = publicationDate;
        this.publisher = publisher;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
