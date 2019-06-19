<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Login Page</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.0/examples/sign-in/">

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/css/signin.css"/>" rel="stylesheet">
</head>

<body class="text-center">

<spring:form class="form-signin" action="/register" modelAttribute="user" method="post">
    <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>

    <label for="firstName" class="sr-only">First Name</label>
    <spring:input path="firstName" type="text" id="firstName" class="form-control" placeholder="First Name" autofocus="true"/>
    <label for="lastName" class="sr-only">Last Name</label>
    <spring:input path="lastName" type="text" id="lastName" class="form-control" placeholder="Last Name"/>
    <label for="inputEmail" class="sr-only">Email address</label>
    <spring:input path="email" type="email" id="inputEmail" class="form-control" placeholder="Email address"/>
    <label for="inputPassword" class="sr-only">Password</label>
    <spring:input path="password" type="password" id="inputPassword" class="form-control" placeholder="Password" />
    <label for="repeatedPassword" class="sr-only">Repeat Password</label>
    <spring:input path="repeatedPassword" type="password" id="repeatedPassword" class="form-control" placeholder="Repeat Password" />

    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
</spring:form>
</body>
</html>

