package com.example.domaci6.repo.comments;

import com.example.domaci6.models.Comment;

import java.util.List;

public interface ICommentRepo {
    public List<Comment> getCommentsByPostId(int id);
    public void addComment(Comment comment);
}
