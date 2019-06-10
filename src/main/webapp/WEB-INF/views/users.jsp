<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: oleksandrkh
  Date: 2019-06-10
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>

    <h2>All Users:</h2>

    <c:forEach var="u" items="${users}">
        <h4>First name: <c:out value="${u.firstName}"/></h4>
        <h4>Last name: <c:out value="${u.lastName}"/></h4>
        <h4>Roles:</h4>
        <c:forEach var="r" items="${u.roles}">
            <h5>Role name: ${r.name}</h5>
        </c:forEach>
        <hr style="margin-bottom: 10px"/>
    </c:forEach>

</body>
</html>
