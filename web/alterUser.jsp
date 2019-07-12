<%--
  Created by IntelliJ IDEA.
  User: ZYF
  Date: 2019/4/16
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
    <style>
        .tab{
            display: inline-block;
            width:80px;
        }
    </style>
</head>
<body>
<c:set var="jishu" value="${user.getJishu()}"></c:set>
<form action="/alterUser?user=${user.getUsername()}" method="post">
    <div><span class="tab">用户名:</span><input name="username" value="${user.getUsername()}" disabled></div>
    <div><span class="tab">密码:</span><input name="password" value="${user.getPassword()}" type="password"></div>
    <div><span class="tab">学校名:</span><input name="schoolName" value="${user.getSchoolName()}"></div>
    <div><span class="tab">专业:</span><input name="zhuanye" value="${user.getZhuanye()}"></div>
    <div><span class="tab">掌握技术:</span><input name="jishu" value="${fn:join(jishu,',')}"></div>
    <div><input type="submit" value="修改用户信息"></div>
</form>
</body>
</html>
