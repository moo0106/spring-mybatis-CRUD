<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cmh_게시판</title>
<style>
table {
	width: 100%;
	align: center;
	border-top: 1px solid #444444;
	border-collapse: collapse;
}

th, td {
	border-bottom: 1px solid #444444;
	padding: 10px;
}
</style>
</head>
<body>
	<h2>게시글 등록</h2>
	
	<form action="<c:url value='/board/write'/>" method="post">
		<table>
			<tr>
				<th>제목</th>
				<td><input name="title"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input name="writer"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="3" name="content"></textarea></td>
			</tr>
		</table>
		<a href="<c:url value='/board/list'/>">[목록]</a>
		<input style="float:right" type="submit" value="제출"> 
	</form>

</body>
</html>