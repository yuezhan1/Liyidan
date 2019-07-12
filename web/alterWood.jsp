<%--
  Created by IntelliJ IDEA.
  User: ZYF
  Date: 2019/4/15
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/AlterWood?id=${wood.getId()}" method="post">
    <div>商品名称:<input name="name" value="${wood.getName()}"></div>
    <div>商品价格:<input name="price" value="${wood.getPrice()}"></div>
    <div>商品介绍:<input name="introce" value="${wood.getIntroce()}"></div>
    <div>商品数量:<input name="count" value="${wood.getCount()}"></div>
    <div>商品类型:<input name="type" value="${wood.getType()}"></div>
    <div><input type="submit" value="修改商品"></div>
</form>
</body>
</html>
