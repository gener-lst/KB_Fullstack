<%--
  Created by IntelliJ IDEA.
  User: ofin0
  Date: 2024-07-31
  Time: 오전 9:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    // 자바 언어를 쓰기 위한 스크립트릿 언어
    int age = 10; // 지역 변수
    request.setAttribute("age", 40); // request scope
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- 스크립트릿 언어 --%>
<%-- 지역 변수를 가져온다 --%>
변수 age : <%= age%> <br>
EL age: ${age}
<%-- 작은 범위부터 타고 올라가면서 해당 값을 찾는다--%>
<%-- page < request < session < application --%>
<%-- EL(Expression Language) --%>
<%-- EL 에서는 null 일 경우 출력 x --%>
</body>
</html>
