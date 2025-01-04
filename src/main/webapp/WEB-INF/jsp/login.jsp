<html>
<head>
<title>Simple Web Application</title>
</head>
<body>
	<center>
		<h1>Welcome to Digital Prescription</h1>

		<h2>Login To Proceed</h2>
		<font color="red">${errorMessage}</font>
		<form method="post">
			User Name : <input type="text" name="name" /><br>
			<br> Password : <input type="password" name="password" /><br>
			<br> <input type="submit" />
		</form>
		<br>
		<button onclick="window.location.href='/register'">Register</button>
	</center>
</body>
</html>