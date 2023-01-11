<%--
  Created by IntelliJ IDEA.
  User: presmelito
  Date: 11/01/2023
  Time: 7:10 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/res/bootstrap/css/bootstrap.css">
</head>
<body>

<c:if test="${NOTIFICATION != null}">
<div class="alert alert-success">
    ${NOTIFICATION}
</div>
</c:if>


