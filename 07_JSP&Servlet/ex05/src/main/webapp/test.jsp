<%--
  Created by IntelliJ IDEA.
  User: ofin0
  Date: 2024-07-31
  Time: 오전 9:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    int age = 10;
    request.setAttribute("age", 40);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
변수 age : <%= age%> <br>
EL age: ${age}
<%-- EL 에서는 null 일 경우 출력 x --%>
</body>
</html>
