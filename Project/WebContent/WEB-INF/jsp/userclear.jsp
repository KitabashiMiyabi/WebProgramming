<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ユーザ削除確認</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
	<body>
		<div class="container">
			<div align=right>
				${user.name}
		 		<a href="a.shtml">ログアウト</a>
			</div>
			<br>
			<DIV align="center"><h1>ユーザ削除確認</h1><br></DIV>
			<br>
			ログインID：${user.loginId}<br>
			を本当に削除してよろしいでしょうか。<br>
			<br>

			<form class="form-signin" action="UserList" method="get">
				<input type="submit" value="　キャンセル　">
			</form>
			<form class="form-signin" action="Userclear" method="post">
				<input type="submit" value="　　OK　　">
			</form>
		</DIV>
	</body>
</html>