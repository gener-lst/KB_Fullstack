<%--
  Created by IntelliJ IDEA.
  User: ofin0
  Date: 2024-07-29
  Time: 오전 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page import ="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>현재 날짜 출력 실습</h1>
<%-- html 코드 내에 자바 코드를 넣어주는걸 스크립트릿이라고 한다 --%>
    <%
        Date d = new Date();

        int sum = 0;
        for(int i = 0; i < 10; i++) {
            sum += i;
        }
        Date d2 = null;
    %>
    현재 날짜 : <%= d %>
    1~10의 합 : <%= sum %>
    <%= d2 %>
</body>
</html>
