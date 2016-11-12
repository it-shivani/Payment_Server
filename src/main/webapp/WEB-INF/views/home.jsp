<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Test Page!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<div>user register</div>
<form action="users/" method="post">
	firstName<input type="text" name="firstName" /><br>
	lastName<input type="text" name="lastName" /><br>
	email<input type="text" name="email" /><br>
	phone<input type="text" name="phone" /><br>
	password<input type="text" name="password" /><br>
	submit<input type="submit" value="submit" /><br>
</form>
<hr>

<div>user modify</div>
<form action="users/update/" method="post">
	userId <input type="text" name="userId" /><br>
	firstName<input type="text" name="firstName" /><br>
	lastName<input type="text" name="lastName" /><br>
	email<input type="text" name="email" /><br>
	phone<input type="text" name="phone" /><br>
	password<input type="text" name="password" /><br>
	submit<input type="submit" value="submit" /><br>
</form>
<hr>

<div>user modify</div>
<form action="users/search/" method="get">
	firstName<input type="text" name="firstName" /><br>
	submit<input type="submit" value="submit" /><br>
</form>
<hr>

<div>Login</div>
<form action="login/" method="post">
	email   <input type="text" name="email" /><br>
	password <input type="text" name="password" /><br>
	submit<input type="submit" value="submit" /><br>
</form>
<hr>

<!-- <div>user delete friend</div>
<form action="users/friends/" method="delete">
	userId <input type="text" name="userId" /><br>
	friendId<input type="text" name="friendId" /><br>
	submit<input type="submit" value="submit" /><br>
</form> -->

<div>user transfer money to someone</div>
<form action="transfer/toUser/" method="post">
	user1  <input type="text" name="user1" /><br>
	user2 <input type="text" name="user2" /><br>
	amount <input type="text" name="amount" /><br>
	submit<input type="submit" value="submit" /><br>
</form>
<hr>

<div>Transfer money to user bank account</div>
<form action="transfer/toBank/" method="post">
	userId  <input type="text" name="userId" /><br>
	bankAccountId <input type="text" name="bankAccountId" /><br>
	amount <input type="text" name="amount" /><br>
	submit<input type="submit" value="submit" /><br>
</form>
<hr>

<div>Transfer money to user bank account</div>
<form action="transfer/fromBank/" method="post">
	userId  <input type="text" name="userId" /><br>
	bankAccountId <input type="text" name="bankAccountId" /><br>
	amount <input type="text" name="amount" /><br>
	submit<input type="submit" value="submit" /><br>
</form>
<hr>

<div>add a new user bank account</div>
<form action="userBankAccount/" method="post">
	userId  <input type="text" name="userId" /><br>
	accountNumber  <input type="text" name="accountNumber" /><br>
	bankName <input type="text" name="bankName" /><br>
	swiftCode <input type="text" name="swiftCode" /><br>
	country <input type="text" name="country" /><br>
	submit<input type="submit" value="submit" /><br>
</form>
<hr>
</body>
</html>
