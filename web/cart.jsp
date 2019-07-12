<%--
  Created by IntelliJ IDEA.
  User: ZYF
  Date: 2019/4/25
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <td>商品编号</td>
        <td>商品名称</td>
        <td>商品价格</td>
        <td>商品介绍</td>
        <td>商品数量</td>
        <td>商品类型</td>
        <td>商品操作</td>
    </tr>
    <c:forEach var="cart" items="${cartList}">
        <tr>
            <td>${cart.getId()}</td>
            <td>${cart.getName()}</td>
            <td>${cart.getPrice()}</td>
            <td>${cart.getIntroce()}</td>
            <td>${cart.getBuyCount()}</td>
            <td>${cart.getType()}</td>
            <td><a href="/index.jsp">购买</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
