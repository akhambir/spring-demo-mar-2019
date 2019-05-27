<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: oleksandrkh
  Date: 2019-05-27
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add User</title>
</head>
<body>
    <spring:form modelAttribute="user" action="/add-user" method="post">
        <label for="name">Name</label>
        <spring:input path="name" id="name"/>
        <label for="email">Email</label>
        <spring:input path="email" id="email"/>
        <button type="submit">Submit</button>
    </spring:form>
</body>
</html>
