package com.example.domaci6.repo.posts;

import com.example.domaci6.models.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class PostRepo implements IPostRepo {

    private static final ConcurrentHashMap<Integer, Post> posts = new ConcurrentHashMap();
    public static int id = 1;

    @Override
    public List<Post> getPosts() {
        return new ArrayList<>(posts.values());
    }

    @Override
    public Post findPostById(int id) {
        return posts.get(id);
    }

    @Override
    public void addPost(Post post) {
        posts.put(id, post);
        id++;
    }

    public static int getId() {
        return id;
    }
}
