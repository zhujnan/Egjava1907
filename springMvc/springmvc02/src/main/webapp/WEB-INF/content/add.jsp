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
  <！--
        作用1：自动绑定来自model中的一个属性值到当前form对应的实体对象，默认是command属性。
                这样就可以在form表单体力方便的使用该对象的属性。
        作用2：支持我们在提交表单的时候使用除get和post之外的其他地方进行提交，
                包括Delete和put等。

        在实现get、post请求之外的请求方法时，使用post方法进行请求，这个隐藏域默认是_method.
        实际的请求方式还是post，Sring提供了一个过滤器HiddenHttpMethodFilter,通过该过滤器
       可以把post方式传递过来的表示实际请求方式的参数转换为真正的http请求方法。
  -->
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
