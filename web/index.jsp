<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 6/6/18
  Time: 1:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.1/css/bulma.min.css">
    <title>Beer Database</title>
</head>
<body>
    <div class="content">
        <h1>Modify Database</h1>
        <ul>
            <li><a href="/addtransaction">Add Transaction</a></li>
            <li><a href="/addcustomer">Add Customer</a></li>
        </ul>

        <h1>Query Database</h1>
        <ul>
            <li><a href="/getbeers">See All Available Beers</a></li>
            <li><a href="/abcustomers">View Anheuser-Busch Customers</a></li>
            <li><a href="/georgebeers">List Types of Beer Ordered by George</a></li>
        </ul>
    </div>
</body>
</html>
