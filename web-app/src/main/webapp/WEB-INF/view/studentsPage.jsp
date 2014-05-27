<%--
  Created by IntelliJ IDEA.
  User: Elena
  Date: 5/27/2014
  Time: 8:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Students</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="<c:url value="../../resources/css/bootstrap.min.css"/>" rel="stylesheet"/>
    <script src="<c:url value="../../resources/js/jquery.js"/>"></script>
    <script src="<c:url value="../../resources/js/bootstrap.min.js"/>"></script>
</head>
<body>
<table class="table table-striped">
    <tr>
        <th>First name</th>
        <th>Last name</th>
        <th>Group</th>
        <th>Date</th>
    </tr>
    <c:forEach items="${studentsList}" var="students">
        <tr>
            <td>${students.firstName}</td>
            <td>${students.lastName}</td>
            <td>${students.group}</td>
            <td>${students.date}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
