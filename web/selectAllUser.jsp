<%--
  Created by IntelliJ IDEA.
  User: ZYF
  Date: 2019/4/16
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <%--<c:out value="${wood.getName()}"></c:out>--%>
    <table border="1">
        <tr>
            <td>用户名</td>
            <td>学校名</td>
            <td>专业</td>
            <td>掌握技术</td>
            <td>操作</td>
        </tr>
        <c:forEach var="list" items="${list}">
            <c:set var="jishu" value="${list.getJishu()}"></c:set>
            <tr>
                <td>${list.getUsername()}</td>
                <td>${list.getSchoolName()}</td>
                <td>${list.getZhuanye()}</td>
                <td>${fn:join(jishu,',')}</td>
                <td><a href="/alterUser?username=${list.getUsername()}">修改用户信息</a></td>
            </tr>
        </c:forEach>
    </table>


</div>
</body>
</html>
