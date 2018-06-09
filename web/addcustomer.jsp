<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 6/9/18
  Time: 10:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.1/css/bulma.min.css">
    <title>Add Customer</title>
</head>
<body>
    <section class="hero">
        <div class="hero-body">
            <h1 class="title">Add Customer</h1>
        </div>
    </section>

    <form action="/addcustomer" method="post">
        <div class="field">
            <label class="label">Name</label>
            <div class="control">
                <input type="text" name="name">
            </div>
        </div>

        <div class="field">
            <label class="label">Address</label>
            <div class="control">
                <input type="text" name="address">
            </div>
        </div>

        <div class="field">
            <div class="control">
                <input type="submit">
            </div>
        </div>
    </form>
</body>
</html>
