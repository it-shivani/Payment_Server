<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<form action="user/" method="post">
	<input type="text" name="firstName" />
	<input type="text" name="lastName" />
	<input type="text" name="email" />
	<input type="text" name="phone" />
	<input type="text" name="password" />
	<input type="submit" value="submit" />
</form>
</body>
</html>
