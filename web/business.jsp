<%--
  Created by IntelliJ IDEA.
  User: ZYF
  Date: 2019/4/15
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .business{
            text-decoration: none;

        }
    </style>
</head>
<body>
<div>
    <%--商家页面，可以增加，删除，修改，查看商品--%>
    <ul class="business">
        <li><a href="#">主页</a></li>
        <li><a href="/addWood.jsp">添加商品</a></li>
        <li><a href="/SelectWood">查看商品</a></li>
        <li><a href="/selectAllUser">用户管理</a></li>
    </ul>
</div>
</body>
</html>
