<%@ page language="java" contentType="text/html; charset=UTF-8" import="com.panda.vo.User"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>聊天界面</title>
</head>
<body>
欢迎${sessionScope.user.cname }聊天<br>
<form action="ChatServlet" method="post">
请输入聊天信息<input type="text" name="message" size="40">
<input type="submit" value="发送信息">
</form>
<a href="loginOutServlet">退出登录</a>
<hr>
<iframe src="msg.jsp" width="100%" height="80%" frameborder="0"></iframe>
</body>
</html>