<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: oleksandrkh
  Date: 2019-06-03
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Category</title>
</head>
<body>
    <h2>Add new Category</h2>

    <spring:form modelAttribute="category" action="/edit-category" method="post">
        <spring:input path="id" hidden="true"/>
        <label for="name">Name</label>
        <spring:input path="name" id="name"/>
        <label for="description">Description</label>
        <spring:input path="description" id="description"/>
        <button type="submit">Submit</button>
    </spring:form>

    <h3>Products:</h3>

    <table style="width:50%">
        <tr>
            <th>Name</th>
            <th>Description</th>
            <th>Price</th>
        </tr>
        <c:forEach var="p" items="${category.products}">
            <tr>
                <td>${p.name}</td>
                <td>${p.description}</td>
                <td>${p.price}</td>
            </tr>
        </c:forEach>

    </table>

</body>
</html>
