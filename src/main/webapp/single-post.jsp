<%--
  Created by IntelliJ IDEA.
  User: sbg
  Date: 3.5.22.
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
        <%@include file="styles.jsp"%>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <c:choose>
                <c:when test="${notFound}">
                    <h1>No such post was found</h1>
                </c:when>
                <c:otherwise>
                <div class="col">
                    <h1><c:out value="${post.title}"/></h1>
                    <h6><fmt:formatDate pattern="dd.MM.yyyy" value="${post.postDate}"/></h6>
                    <h6 class="text-muted"><c:out value="${post.author}"/></h6>
                    <div class="text-wrap w-100"><c:out value="${post.content}"/></div>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <h3>Comments</h3>
                    <c:if test="${comments.size() == 0}">
                        <h4>No comments</h4>
                    </c:if>
                    <c:forEach var="comment" items="${comments}">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title"><c:out value="${comment.name}"/></h4>
                                <p class="card-text"><c:out value="${comment.comment}"/></p>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <h3>New comment</h3>
                    <form method="post">
                        <div class="form-group">
                            <label for="author">Author</label>
                            <input type="text" required class="form-control" id="author" name="author">
                        </div>
                        <div class="form-group">
                            <label for="comment">Comment</label>
                            <textarea class="form-control" rows="4" required id="comment" name="comment"></textarea>
                        </div>
                        <button type="submit" class="btn btn-primary btn-lg">Comment</button>
                    </form>
                </div>
                </c:otherwise>
                </c:choose>

            </div>
        </div>
    </body>
</html>
