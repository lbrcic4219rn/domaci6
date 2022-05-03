<%--
  Created by IntelliJ IDEA.
  User: sbg
  Date: 3.5.22.
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <head>
        <title>Title</title>
        <%@include file="styles.jsp"%>
    </head>
    <body>
        <div class="container">
            <h1 class="text-center my-5">New Post</h1>
            <form method="post">
                <div class="form-group">
                    <label for="author">Author</label>
                    <input type="text" id="author" name="author" class="form-control" required>
                </div>
                <div class="form-group">
                    <label for="title">Title</label>
                    <input type="text" id="title" name="title" class="form-control" required>
                </div>
                <div class="form-group">
                    <label for="content">Content</label>
                    <textarea class="form-control" name="content" id="content" rows="4" required></textarea>
                </div>
                <button type="submit" class="btn btn-primary btn-lg">Save Post</button>
            </form>
        </div>
    </body>
</html>
