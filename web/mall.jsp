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
        <c:choose >
            <c:when test="${cookie.username.name=='username'}">
                <h1>欢迎${cookie.username.value}<h1>欢迎${sessionScope.username}<a href="/selectCart    ">查看购物车</a></h1></h1>
            </c:when>
            <c:when test="${sessionScope.username!=null}">
                <h1>欢迎${sessionScope.username}<a href="/selectCart">查看购物车</a></h1>
            </c:when>
            <c:otherwise>
                <a href="/temporaryCart.jsp">查看购物车</a>
            </c:otherwise>
        </c:choose>
    <table border="1">
        <tr>
            <td>商品编号</td>
            <td>商品名称</td>
            <td>商品价格</td>
            <td>商品介绍</td>
            <td>商品类型</td>
            <td>商品数量</td>
            <td>购买数量</td>
            <td>商品操作</td>
        </tr>
        <c:forEach var="wood" items="${list}">
            <tr>
                <form action="IntoCart" method="post">
                    <td><input type="text" value="${wood.getId()}" name="id" readonly></td>
                    <td><input type="text" value="${wood.getName()}" name="name" readonly></td>
                    <td><input type="text" value="${wood.getPrice()}" name="price" readonly></td>
                    <td><input type="text" value="${wood.getIntroce()}" name="introce" readonly></td>
                    <td><input type="text" value="${wood.getType()}" name="type" readonly></td>
                    <td><input type="text" value="${wood.getCount()}" name="count" readonly></td>
                    <td><input type="number" value="1" name="buyCount" max="${wood.getCount()}" min="1"></td>
                        <%--<td><a href="/IntoCart?id=${wood.getId()}&name=${wood.getName()}&price=${wood.getPrice()}&introce=${wood.getIntroce()}&count=${wood.getCount()}&type=${wood.getType()}">加入购物车</a></td>--%>
                    <td><input type="submit" value="加入购物车"></td>
                </form>
            </tr>
        </c:forEach>
    </table>


</div>
</body>
</html>
