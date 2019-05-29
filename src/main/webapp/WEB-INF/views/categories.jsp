<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: oleksandrkh
  Date: 2019-05-29
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Categories</title>
</head>
<body>

    <c:forEach var="c" items="${categories}">
        <h3>Category name <c:out value="${c.name}"/></h3>
        <h4>Category description <c:out value="${c.description}"/></h4>
    </c:forEach>

</body>
</html>
