<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600' rel='stylesheet' type='text/css'>
<link href="//netdna.bootstrapcdn.com/font-awesome/3.1.1/css/font-awesome.css" rel="stylesheet">


<title>Login</title>

<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/login-register.css">

<script>
	function validate() {
		var id = document.myform.txt_id;
		var password = document.myform.txt_password;

		if (id.value == null || id.value == "") {
			window.alert("Please enter Id ?");
			id.style.background = '#f08080';
			id.focus();
			return false;
		}
		if (password.value == null || password.value == "") {
			window.alert("please enter password ?");
			password.style.background = '#f08080';
			password.focus();
			return false;
		}
	}
</script>

</head>

<body>



	<div class="testbox">
  <h1>Login</h1>

  <form action="loginprocess.jsp" method="post">
      <hr>
    <div class="accounttype">
      <input type="radio" value="admin" id="radioOne" name="account" checked/>
      <label for="radioOne" class="radio" chec>Admin</label>
      <input type="radio" value="user" id="radioTwo" name="account" />
      <label for="radioTwo" class="radio">User</label>
    </div>
  <hr>
  <p style="color: red">
						<%
						if (request.getAttribute("errorMsg") != null) {
							out.println(request.getAttribute("errorMsg"));
						}
						%>
	</p><br>
  <label id="icon" for="name"><i class="icon-envelope "></i></label>
  <input type="text" name="txt_id" placeholder="ID" required/>

  <label id="icon" for="name"><i class="icon-shield"></i></label>
  <input type="password" name="txt_password"  placeholder="Password" required/>
   <p>You Don't have an account. <a href="register.jsp">Register here</a>.</p>
   <!-- a href="#" class="button" name="btn_login">Login</a-->
   <input type="submit" name="btn_login" value="Login" class="button log-btn">
  </form>
</div>

</body>

</html>
