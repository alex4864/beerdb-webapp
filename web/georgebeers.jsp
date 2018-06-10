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
    <title>Beers Purchased By George</title>
</head>
<section class="hero">
    <div class="hero-body">
        <h1 class="title">Beers Purchased By George</h1>
        <h2 class="subtitle">Names, types, sizes, and prices of beers costing more than 2 Euro bought by George</h2>
    </div>
</section>
<body>
    <table class="table">
        <thead>
            <tr>
                <th>Name</th>
                <th>Type</th>
                <th>Size</th>
                <th>Price</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${beers}" var="beer">
            <tr>
                <td>${beer.name}</td>
                <td>${beer.type}</td>
                <td>${beer.size}</td>
                <td>${beer.price}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</body>
</html>
