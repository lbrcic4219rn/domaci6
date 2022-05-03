package com.example.domaci6.servlets;

import com.example.domaci6.models.Post;
import com.example.domaci6.repo.posts.IPostRepo;
import com.example.domaci6.repo.posts.PostRepo;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "NewPostServlet", value = "/new-post")
public class NewPostServlet extends HttpServlet {
    private PostRepo postRepo;

    @Override
    public void init() throws ServletException {
        postRepo = new PostRepo();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/new-post.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String author = req.getParameter("author");
        String title = req.getParameter("title");
        String content = req.getParameter("content");

        if(!author.isEmpty() && !title.isEmpty() && !content.isEmpty()){
            postRepo.addPost(new Post(postRepo.id, author, title, content));
        }

        resp.sendRedirect(getServletContext().getContextPath() + "/posts");
    }

    public void destroy() {
    }
}