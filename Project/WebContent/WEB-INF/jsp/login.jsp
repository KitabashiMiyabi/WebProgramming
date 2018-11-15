<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
	<body>
		<DIV align="center"><h1>ログイン画面</h1><br>
			<form class="form-signin" action="Login" method="post">
				<br>
				ログインID &emsp;<input type="text" id="id" name="loginid"><br>
				<br>
				パスワード  &emsp;<input type="text" name="password"><br>
				<br>
				<br>
				<input type="submit" value="ログイン">
			</form>
		</DIV>
	</body>
</html>