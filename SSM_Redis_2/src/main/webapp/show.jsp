<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="add.jsp">新增</a>
	<table>
		<tr>
			<td>ID</td>
			<td>姓名</td>
			<td>密码</td>
			<td>收入</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${list}" var="i">
			<tr>
				<td>${i.id }</td>
				<td>${i.name }</td>
				<td>${i.password }</td>
				<td>${i.qian }</td>
				<td>
					<a href="selectByID?id=${ i.id}">✎</a>
					<a href="delete?id=${ i.id}">X</a>
				</td>
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>