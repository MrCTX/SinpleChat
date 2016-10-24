<%@page import="java.util.Date"%>
<%@page import="org.eclipse.jdt.internal.compiler.ast.IfStatement"%>
<%@page import="java.util.ArrayList" import="com.panda.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录界面</title>
</head>
<body>

*****欢迎来到登录界面****
<form action="LoginServlet" method="post">
账号名:<input type="text" name="account" ><br>
密码: <input type="password" name="password">
<input type="submit" value="登录">
</form>
</body>
<%
//初始化application中的属性，其中users属性是User对象的集合，message属性是聊天信息的集合
 ArrayList<User> users = (ArrayList<User>)application.getAttribute("users");
if (users == null) {
	users = new ArrayList<User>();
	application.setAttribute("users", users);
}

ArrayList<String>  message = (ArrayList<String>)application.getAttribute("message");
if (message == null) {
	message = new ArrayList<String>();
	application.setAttribute("message", message);
} 
%>
</html>