<%@page import="com.poscoict.emaillist.dao.EmaillistDao"%>
<%@page import="com.poscoict.emaillist.vo.EmaillistVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
//post라 request도 엔코딩 해줘야 함
	request.setCharacterEncoding("utf-8");
	String firstName = request.getParameter("fn");
	String lastName = request.getParameter("ln");
	String email = request.getParameter("email");
	
	EmaillistVo vo = new EmaillistVo();
	vo.setFirstName(firstName);
	vo.setLastName(lastName);
	vo.setEmail(email);
	
	new EmaillistDao().insert(vo);

	response.sendRedirect("/emaillist01");
%>
