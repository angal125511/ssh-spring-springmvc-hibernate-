<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/22
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>query</title>
</head>
<body>
<table>
    <%-- 表头 --%>
    <tr>
        <th>ID</th>
        <th>用户名</th>
        <th>密码</th>
        <th>操作</th>
    </tr>
    <%--数据--%>
        <c:forEach items="${list}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.password}</td>
                <td><a href="/user/delete/${user.id}">删除</a></td>
                <td><a href="/user/findById/${user.id}">修改</a></td>
            </tr>
        </c:forEach>
</table>
<%-- 分页页码  --%>
<div>
    <c:forEach begin="1" end="${page}" var="i">
        <a href="/user/queryPage?pageIndex=${i}">
                ${i}
        </a>
    </c:forEach>
</div>
<tr>
    <a href="/user/toadd">添加</a>
</tr>
</body>
</html>