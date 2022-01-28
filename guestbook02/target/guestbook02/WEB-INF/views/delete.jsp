<%@page import="com.poscoict.guestbook.vo.GuestbookVo"%>
<%@page import="com.poscoict.guestbook.dao.GuestbookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Long no = Long.parseLong(request.getParameter("no"));
String password = request.getParameter("password");

GuestbookDao dao = new GuestbookDao();
GuestbookVo vo = new GuestbookVo();

vo.setNo(no);
vo.setPassword(password);
dao.delete(vo);
response.sendRedirect(request.getContextPath());

%>
</body>
</html>