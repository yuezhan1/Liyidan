<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.Wood" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ZYF
  Date: 2019/4/15
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>
            <%--<c:out value="${wood.getName()}"></c:out>--%>
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
                <c:forEach var="wood" items="${list}">
                    <tr>
                        <td>${wood.getId()}</td>
                        <td>${wood.getName()}</td>
                        <td>${wood.getPrice()}</td>
                        <td>${wood.getIntroce()}</td>
                        <td>${wood.getCount()}</td>
                        <td>${wood.getType()}</td>
                        <td><a href="/SelectWood?id=${wood.getId()}">修改商品</a>  <a href="/DeleteWood?id=${wood.getId()}">删除商品</a></td>
                    </tr>
                </c:forEach>
            </table>



    </div>
</body>
</html>
