<%--
  Created by IntelliJ IDEA.
  User: ofin0
  Date: 2024-08-01
  Time: 오전 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Todo 목록 보기</h1>
    <div>
<%--        ${todoList}--%>
        <table>
            <c:forEach var="todo" items="${todoList}">
                <tr>
                    <td>${todo}</td>
                </tr>
            </c:forEach>
        </table>

        <a href="view">상세보기</a>
    </div>
    <div>
        <a href="create">새 Todo</a>
    </div>
</body>
</html>
