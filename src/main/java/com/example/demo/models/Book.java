package com.example.demo.models;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq")
    @SequenceGenerator(name = "book_seq", schema = "public", sequenceName = "book_seq", allocationSize = 1)
    private Integer bId;

    private String bName;
    private String bAuthor;

    public Book() {
    }

    public Book(String bName, String bAuthor) {
        this.bName = bName;
        this.bAuthor = bAuthor;
    }

    public Integer getbId() {
        return bId;
    }

    public void setbId(Integer bId) {
        this.bId = bId;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public String getbAuthor() {
        return bAuthor;
    }

    public void setbAuthor(String bAuthor) {
        this.bAuthor = bAuthor;
    }
}
