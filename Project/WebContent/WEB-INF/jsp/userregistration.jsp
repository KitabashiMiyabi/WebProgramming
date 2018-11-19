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
			${userInfo.name}
				<form class="form-signin" action="Login" method="get">
					<a href="a.shtml">ログアウト</a>
				</form>
			</div>
		<br>
		<DIV align="center"><h1>ユーザ新規登録</h1><br></DIV>
		<br>
		<div class="container">
			<form class="form-signin" action="SignUp" method="post">
				ログインID　　　
				<input type="text" name="id"><br>
				<br>
				パスワード　　　
				<input type="text" name="password"><br>
				<br>
				パスワード（確認用）　　　
				<input type="text" name="password2"><br>
				<br>
				ユーザ名　　　
				<input type="text" name="name"><br>
				<br>
				生年月日　　　
				<input type="date" name="birthday"><br>
				<br>
				<br>
				<DIV align="center">
			 		<input type="submit" value="　登録　">
				</DIV>
			</form>
			<br>
			<br>
			<form class="form-signin" action="UserList" method="get">
				<a href="a.shtml">戻る</a>
			</form>
		</div>
	</body>
</html>