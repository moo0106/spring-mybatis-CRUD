<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<h2>${article.boardNo}번 게시물 내용</h2>

	<table>
		<tr> <td># 글 번호: ${article.boardNo }</td> </tr>
		<tr> <td># 작성자: ${article.writer }</td> </tr>
		<tr> <td># 제목: ${article.title }</td> </tr>
		<tr> <td># 내용: <textarea rows="3" readonly>${article.content }</textarea></td> </tr>
	</table>
	
	<a href="<c:url value='/board/list' /> ">글 목록보기</a>
	<a href="<c:url value='/board/modify?boardNo=${article.boardNo }' /> ">글 수정하기</a>
</body>
</html>
