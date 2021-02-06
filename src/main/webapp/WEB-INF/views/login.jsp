<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form action="login" method="post">
			<div>
				<label>User Name</label> <input type="text" name="username">
			</div>
			<div>
				<label>Password</label> <input type="password" name="password">
			</div>
			<div>
				<input type="submit" value="Login">
			</div>
			<input type="hidden" name="${_csrf.parameterName }"
				value="${_csrf.token }">
		</form>
	</div>
</body>
</html>