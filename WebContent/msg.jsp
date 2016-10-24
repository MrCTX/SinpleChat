<%@page import="java.util.ArrayList"%>
<%@page import="com.panda.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>聊天信息界面</title>
</head>
<body>
<%
response.setHeader("refresh", "10");
%>
<table width="80%" border="0" align="center">
<tr>
<td width="70%">消息</td>
<td width="30%">当前在线</td>
</tr>
<tr bgcolor="pink">
<td>
<%
ArrayList<String> message = (ArrayList<String>)application.getAttribute("message");
for(int i = message.size() - 1 ; i >= 0 ; i--) {
	out.println(message.get(i)+"<br>");
}
%>
</td>
<td valign="top">
<%
ArrayList<User> users = (ArrayList<User>)application.getAttribute("users");
for(int i = users.size() - 1 ; i >= 0 ; i--) {
	User user = users.get(i);
	out.println("("+user.getAccount()+")"+user.getCname()+"<br>");
}
%>
</td>
</tr>
</table>
</body>
</html>