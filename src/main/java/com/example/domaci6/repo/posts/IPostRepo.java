package com.example.domaci6.repo.posts;

import com.example.domaci6.models.Post;

import java.util.List;

public interface IPostRepo {
    public List<Post> getPosts();
    public Post findPostById(int id);
    public void addPost(Post post);
}
