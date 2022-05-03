package com.example.domaci6.servlets;


import com.example.domaci6.repo.posts.IPostRepo;
import com.example.domaci6.repo.posts.PostRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PostsServlet", value = {"/", "/posts"})
public class PostsServlet extends HttpServlet {

    private IPostRepo postRepo;

    @Override
    public void init() throws ServletException {
        this.postRepo = new PostRepo();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("posts", this.postRepo.getPosts());
        req.getRequestDispatcher("/posts.jsp").forward(req, resp);
    }
}
