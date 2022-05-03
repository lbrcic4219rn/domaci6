package com.example.domaci6.models;

import java.util.Date;

public class Post {

    private int id;
    private String author;
    private String title;
    private String content;
    private Date postDate;

    public Post(int id, String author, String title, String content) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.content = content;
        this.postDate = new Date();
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Date getPostDate() {
        return postDate;
    }


}
