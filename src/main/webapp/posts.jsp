<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
    <html>
    <head>
        <title>JSP - Hello World</title>
        <%@ include file="styles.jsp"%>
    </head>

    <body>
    <div class="container">
        <h1 class="text-center my-5">Public Blog</h1>
        <c:if test="${posts.size() == 0}">
            <h2 class="mb-5">No Posts at this time create a first one?</h2>
        </c:if>
        <c:forEach var="post" items="${posts}">
            <a href="/posts/${post.id}">
                <div class="card">
                    <div class="card-body">
                        <h5 class="d-inline-block card-title"><c:out value="${post.title}"/></h5>
                        <p class="d-inline-block float-right margin-top">
                            <small class="text-muted"><fmt:formatDate pattern="dd.MM.yyyy" value="${post.postDate}"/>
                            </small>
                        </p>
                        <c:if test="${post.content.length() > 301}">

                        </c:if>
                        <c:choose>
                            <c:when test="${post.content.length() > 250}">
                                <p class="card-text"><c:out value="${post.content.substring(0, 250)}"/>...</p>
                            </c:when>
                            <c:otherwise>
                                <p class="card-text"><c:out value="${post.content}"/></p>
                            </c:otherwise>
                        </c:choose>

                    </div>
                </div>
            </a>
        </c:forEach>

        <div class="my-5 text-center">
            <form action="/new-post" method="get">
                <button type="submit" class="btn btn-primary btn-lg">New Post</button>
            </form>
        </div>

        </div>
    </body>
</html>