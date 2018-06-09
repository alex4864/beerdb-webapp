<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 6/6/18
  Time: 1:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.1/css/bulma.min.css">
    <title>All Beers</title>
</head>
<section class="hero">
    <div class="hero-body">
        <h1 class="title">All Beers</h1>
        <h2 class="subtitle">View all beers we currently offer</h2>
    </div>
</section>
<body>
    <table class="table">
        <thead>
            <tr>
                <th>Name</th>
                <th>Size (L)</th>
                <th>Percentage</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${beers}" var="beer">
            <tr>
                <td>${beer.name}</td>
                <td>${beer.size}</td>
                <td>${beer.percentage}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</body>
</html>
