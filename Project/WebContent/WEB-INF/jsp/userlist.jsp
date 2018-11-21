<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>




<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ一覧</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
</head>
<body>
	<p style="background-color: #ffcc99;">
		<div align=right>
			${userInfo.name}
			<a href="Logout" class="navbar-link logout-link">ログアウト</a>
		</div>
	<br>
	<DIV align="center">
		<h1>ユーザ一覧</h1>
		<br>
	</DIV>

	<div class="container">

		<div align=right>
			<a href="SignUp">新規登録</a>
		</div>
		<br>

		<form method="post" action="UserList" class="form-horizontal">
			<div class="form-group">
				<div class="row">
					<label for="code" class="control-label col-sm-2">ログインID</label> <input
						type="text" name="loginid"
						class="form-control col-sm-2" />
				</div>
			</div>
			<div class="form-group">
				<div class="row">
					<label for="name" class="control-label col-sm-2">ユーザ名 </label> <input
						type="text" name="name"
						class="form-control col-sm-2" style="width: 171px;">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">生年月日</label>
				<input type="date" name="date-start"> ～ <input type="date" name="date-start">
			</div>

			<div class="text-right">
				<button type="submit" value="検索" class="btn btn-primary form-submit"
					style="width: 120px; height: 34px;">検索</button>
			</div>
		</form>
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">ログインID</th>
					<th scope="col">ユーザ名</th>
					<th scope="col">生年月日</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${userList}" >
                   <tr>
                     <th>${user.loginId}</th>
                     <td>${user.name}</td>
                     <td>${user.birthDate}</td>
                     <!-- TODO 未実装；ログインボタンの表示制御を行う -->
                     <td>
                       <a class="btn btn-primary" href="UserLeference?id=${user.id}">詳細</a>
                       <a class="btn btn-success" href="UserUpdate?id=${user.id}">更新</a>
                       <a class="btn btn-danger" href ="Userclear?id=${user.id}">削除</a>
                     </td>
                   </tr>
                 </c:forEach>
			</tbody>
		</table>
	</div>


</body>
</html>