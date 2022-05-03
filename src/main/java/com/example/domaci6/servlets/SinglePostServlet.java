package com.example.domaci6.servlets;

import com.example.domaci6.models.Comment;
import com.example.domaci6.models.Post;
import com.example.domaci6.repo.comments.CommentRepo;
import com.example.domaci6.repo.comments.ICommentRepo;
import com.example.domaci6.repo.posts.IPostRepo;
import com.example.domaci6.repo.posts.PostRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "SingePostServlet", value = {"/posts/*"})
public class SinglePostServlet extends HttpServlet {

    private ICommentRepo commentRepo;
    private IPostRepo postRepo;

    @Override
    public void init() throws ServletException {
        commentRepo = new CommentRepo();
        postRepo = new PostRepo();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getPathInfo().substring(1));
        Post post = postRepo.findPostById(id);
        if (post == null) req.setAttribute("notFound", true);
        List<Comment> commentsForPost = commentRepo.getCommentsByPostId(id);
        req.setAttribute("post", post);
        req.setAttribute("comments", commentsForPost);

        req.getRequestDispatcher("/single-post.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String author = req.getParameter("author");
        String comment = req.getParameter("comment");
        int id = Integer.parseInt(req.getPathInfo().substring(1));
        if (!author.isEmpty() && !comment.isEmpty()) {
            commentRepo.addComment(new Comment(author, comment, id));
        }

        resp.sendRedirect("/posts/"+id);
    }

}
