<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
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
<meta charset="UTF-8">
</head>

<body>
<h2><a href="<c:url value='/board/list'/>">게시글 목록</a></h2>
		
	<c:if test="${articles.size() <= 0 }">
		<p>게시물이 존재하지 않습니다.</p>
	</c:if>
	<a style="float:left" href="<c:url value='/board/write' />">게시글 작성하기</a>
	<c:if test="${articles.size() > 0 }">

		
		<form style="float:right" action="<c:url value='/board/searchList'/> ">
			<input name="keyword" placeholder="작성자 이름을 입력하세요"> 
			<input type="submit" value="검색">
		</form>
		<br>
		<table>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>비고</th>
			</tr>
			<c:forEach var="article" items="${articles}">
				<tr>
					<td>${article.boardNo}</td>
					<td><a
						href="<c:url value='/board/content?boardNo=${article.boardNo}'/> ">${article.title}</a>
					</td>
					<td>${article.writer}</td>
					<td><a
						href="<c:url value='/board/delete?boardNo=${article.boardNo}'/>"
						onclick="return confirm('정말 삭제하시겠습니까?')">[삭제]</a></td>
				</tr>
			</c:forEach>
		</table>

		
	</c:if>
	
</body>
</html>