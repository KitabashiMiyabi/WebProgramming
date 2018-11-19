<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ログイン画面</title>
	<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

</head>
	<body>
		<DIV align="center"><h1>ログイン画面</h1><br>

			<c:if test="${errMsg != null}" >
			    <div class="alert alert-danger" role="alert">
				  ${errMsg}
				</div>
			</c:if>

			<form class="form-signin" action="Login" method="post">
				<br>
				ログインID &emsp;<input type="text" name="loginid"><br>
				<br>
				パスワード  &emsp;<input type="text" name="password"><br>
				<br>
				<br>
				<input type="submit" value="ログイン">
			</form>
		</DIV>
	</body>
</html>