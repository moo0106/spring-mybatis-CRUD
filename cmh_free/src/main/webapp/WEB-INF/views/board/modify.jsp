<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cmh_게시판</title>
<style>
table {
	width: 100%;
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
	<h2>${article.boardNo }번 게시물 내용 수정</h2>
	<form method="post">
		<input type="hidden" name="boardNo" value="${article.boardNo }">
		<table>
			<tr><td># 제목: <input name="title" value="${article.title }"></td></tr>
			<tr><td># 작성자: <input name="writer" value="${article.writer }"></td></tr>
			<tr><td># 내용:	<textarea rows="5" name="content">${article.content }</textarea></td></tr>
		</table>
		<input style="float:right" type="submit" value="수정">
	</form>
</body>
</html>