<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="form1">
		<p>
			<label for="username">Username</label> <input type="text"
				id="username" name="username" /> 
		</p>
		<p>
			<label for="password">Password</label> <input type="password"
				id="password" name="password" />
		</p>
		<input type="button" onclick="login();" value="로그인" />
	</form>

	<script type="text/javascript">
		function login() {
			form1.method = "POST";
			form1.action = "/j_spring_security_check";
			form1.submit();
		}
	</script>
</body>
</html>