<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>JSTL(forEach Tag) test</h4>
	<c:set var="count" value="${fn:length(list)}"></c:set>
	<!-- page context 범위 3이라는 객체 -->
	<!--<c:set var="count" value="${3}" />>
	<!-- status:상태용변수 1부터 시작 -->
	<c:forEach items="${list}" var="vo" varStatus="status">
		[${count-status.index }][${status.index }: ${status.count }][${vo.no}: ${vo.name }]<br>		
	</c:forEach>
</body>
</html>