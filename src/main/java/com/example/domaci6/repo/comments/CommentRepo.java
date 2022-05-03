package com.example.domaci6.repo.comments;

import com.example.domaci6.models.Comment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CommentRepo implements ICommentRepo {

    private static final List<Comment> comments = new CopyOnWriteArrayList<>();

    @Override
    public List<Comment> getCommentsByPostId(int id) {
        List <Comment> result = new ArrayList<>();
        comments.iterator().forEachRemaining(c -> {
            if(c.getPostId() == id) result.add(c);
        });
        return result;
    }

    @Override
    public void addComment(Comment comment) {
        comments.add(comment);
    }
}
