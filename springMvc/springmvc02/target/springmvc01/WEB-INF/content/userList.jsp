<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'userList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-1.4.3.js"></script>
  	<script type="text/javascript">
  		$(function(){
  				$(".delete").click(
  					function(){
  						var href=$(this).attr("href");
  						$("form").attr("action",href).submit();
  						return false;
  					}
  				);
  			})
  	
  	</script>
  </head>
  
  <body>
  	<form action=" " method="POST">
  		<input type="hidden" name="_method"
  		 value="DELETE"/>
  	</form>
  		<table>
  			<tr>
  				<td>id</td>
  				<td>username</td>
  				<td>password</td>
  				<td>操作</td>
  			</tr>
  			<c:forEach var="user" items="${userList }">
  				<tr>
				<td>${user.id }</td>
  				<td>${user.loginname }</td>
  				<td>${user.password }</td>
  				<td>
  					<a class="delete" href="del/${user.id }">删除</a>
  					<a  href="add/${user.id }">修改</a>
  				</td>
  				</tr>
  			</c:forEach>
  		</table>
  			<div><a href="add">添加</a></div>
  </body>
</html>
