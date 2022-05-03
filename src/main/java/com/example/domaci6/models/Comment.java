package com.example.domaci6.models;

public class Comment {
    private String name;
    private String comment;
    private int postId;

    public Comment(String name, String comment, int postId) {
        this.name = name;
        this.comment = comment;
        this.postId = postId;
    }

    public String getName() {
        return name;
    }

    public String getComment() {
        return comment;
    }

    public int getPostId() {
        return postId;
    }
}
