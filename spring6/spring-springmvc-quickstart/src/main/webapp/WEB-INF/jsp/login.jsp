<%--
  Created by IntelliJ IDEA.
  User: wataxi
  Date: 2023/9/28
  Time: 12:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>${pageContext.request.contextPath}</h1>

<h2 style="color: red">${errMsg}</h2>

<form method="post" action="${pageContext.request.contextPath}/login">
    <input type="text" name="username">
    <input type="password" name="password">
    <input type="submit" name="登录"/>
</form>


</body>
</html>
