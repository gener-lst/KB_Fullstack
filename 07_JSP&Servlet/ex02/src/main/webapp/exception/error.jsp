<%--
  Created by IntelliJ IDEA.
  User: ofin0
  Date: 2024-07-29
  Time: 오후 3:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" %>
<html>
<head>
    <title>exception 실습</title>
</head>
<body>
    <h1>divide.jsp 발생된 예외를 처리하는 페이지</h1>
<%--    발생한 예외를 받아와서 메시지 출력 --%>
<%--    발생된 예외는 : / by zero --%>
    <%
        out.print("발생된 예외는 : " + exception.getMessage());
    %>
</body>
</html>
