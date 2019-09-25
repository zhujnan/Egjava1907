<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="js/calendar.js"></script>
  </head>
  
  <body>
  		<form:form action="add" method="post" modelAttribute="u">
	<c:if test="${u.id == null }">
  		id:<form:input path="id"/> </br>
  	</c:if>
  	<c:if test="${u.id != null }">
  		<form:hidden path="id"/>
				<input type="hidden" name="_method" value="PUT"/>
	</c:if>-

				用户名:<form:input path="loginname"/> </br>
				密码:<form:input path="password"/> </br>

				<input type="submit" value="提交"/>
  		</form:form>
  </body>
</html>
