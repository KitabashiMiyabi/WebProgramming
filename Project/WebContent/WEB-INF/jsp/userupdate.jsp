<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

</head>
	<body>
		<p style="background-color:#ffcc99;">
		<div align=right>
		ユーザー名さん
		<a href="a.shtml">ログアウト</a>
		</div>
		</p><br>
		<DIV align="center"><h1>ユーザ情報更新</h1><br></DIV>
		<br>
		<div class="container">
		ログインID　　　　　　　　　　
		id0001<br>
		<br>
		パスワード　　　　　　　　　　
		<input type="text" password="password"><br>
		<br>
		パスワード（確認用）　　　　　
		<input type="text" password2="password2"><br>
		<br>
		ユーザ名　　　　　　　　　　　
		<input type="text" value="田中太郎" ><br>
		<br>
		生年月日　　　　　　　　　　　
		<input type="text" value="1989/04/26" ><br>
		<br>
		<br>
		<DIV align="center">
		<input type="submit" value="　更新　">
		</DIV><br>
		<br>
		<a href="a.shtml">戻る</a>
		</div>
	</body>
</html>