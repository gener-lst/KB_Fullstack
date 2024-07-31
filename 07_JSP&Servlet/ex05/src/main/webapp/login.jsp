<%--
  Created by IntelliJ IDEA.
  User: ofin0
  Date: 2024-07-31
  Time: 오전 9:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<%@ include file="navbar.jsp"%>--%>
<%-- 필요할 경우 템플릿처럼 사용 가능 --%>
    <h1>EL 실습</h1>
<%-- request scope에서 해당 데이터를 찾아온다 --%>
    사용자 아이디: ${userid}<br>
    사용자 비밀번호: ${passwd}<br>

    ${login.name}/${login.passwd}
</body>
</html>
