<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<input id="dark" onclick="dark();" type="radio" name="mode"><label for="dark">다크모드</label>
<input id="white" onclick="light();" type="radio" name="mode"><label for="white">라이트모드</label>
    <script>
 function dark(){
     document.body.style.backgroundColor = '#1e1f21';
    document.body.style.color = 'white';
 }
 function light(){
     document.body.style.backgroundColor = 'white';
     document.body.style.color = '#1e1f21';
     document.body.style.hr.color = '#1e1f21';
 }</script>
</body>
</html>