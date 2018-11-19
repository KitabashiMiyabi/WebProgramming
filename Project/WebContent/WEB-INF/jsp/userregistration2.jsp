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
			<a href="a.shtml">ログアウト</a>
		</div>
		<br>
		<DIV align="center"><h1>ユーザ情報詳細参照</h1><br></DIV>
		<br>
		<br>
		<br>
		<div class="container">
			ログインID　　　　　${userInfo.loginId}<br>
			<br>
			ユーザ名　　　　　　${userInfo.name}<br>
			<br>
			生年月日　　　　　　${userInfo.birthDate}<br>
			<br>
			登録日時　　　　　　${userInfo.now}<br>
			<br>
			更新日時　　　　　　${userInfo.now}<br>
			<br>
			<a href="UserList">戻る</a>
	    </div>
	</body>
</html>