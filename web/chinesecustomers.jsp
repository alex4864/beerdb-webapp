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
    <title>Chinese Customers</title>
</head>
<section class="hero">
    <div class="hero-body">
        <h1 class="title">Chinese Customers in 2014</h1>
        <h2 class="subtitle">The names of all customers who have purchased beers in 2014 made by Chinese suppliers</h2>
    </div>
</section>
<body>
    <table class="table">
        <thead>
            <tr>
                <th>Name</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${customers}" var="customer">
            <tr>
                <td>${customer}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</body>
</html>
