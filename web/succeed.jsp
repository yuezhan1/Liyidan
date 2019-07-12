<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ZYF
  Date: 2019/4/4
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="javax.servlet.ServletContext" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
       <c:choose >
           <c:when test="${cookie.username.name=='username'}">
               <h1>欢迎${cookie.username.value}</h1>
           </c:when>
           <c:otherwise>
               <h1>欢迎${sessionScope.username}</h1>
           </c:otherwise>
       </c:choose>
       <%--<c:if test="${cookie.username.name=='username'}">--%>
           <%--<h1>欢迎${cookie.username.value}</h1>--%>
       <%--</c:if>--%>
       <%--<c:if test="!${cookie.username.name=='username'}">--%>
           <%--<h1>欢迎${sessionScope.username}</h1>--%>
       <%--</c:if>--%>
      <%--<c:redirect url="/count"></c:redirect>--%>
      <h1>该页面的访问次数:${applicationScope.count}</h1>
      <%--<c:forEach  var="username" items="<%= request.getCookies() %>">--%>
          <%--<c:if test="${username.getName() =='username'}">--%>
              <%--${username.getDomain()}--%>
              <%--<c:out value="有效域${username.getDomain()}"></c:out>--%>
              <%--<c:out value="有效路径${username.getPath()}"></c:out>--%>
          <%--</c:if>--%>
      <%--</c:forEach>--%>
      <ul>
          <li><a href="">首页</a></li>
          <li><a href="private.jsp">个人中心</a></li>
          <li><a href="/SelectWood?type=mall">购物商城</a></li>
      </ul>
</body>
</html>
