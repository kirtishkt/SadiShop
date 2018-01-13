<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" type="text/css"
	href="login.css">
<script type="text/javascript">
var user = document.getElementById("user").value;
var pass = ducument.getElementById("pass").value;
	
	if(user == "admin" && pass=="admin")
		{
			window.location="mainpage.jsp";
		}else{
			window.location="index.jsp";
		}

</script>
</head>
<body>

<h2>Login Form</h2>

<form action="mainpage.jsp" method="post">
  <div  style="width:200px; margin:0 auto">
    <img src="avatar.png" alt="Avatar" class=".avatar" align="middle" >
  </div>

  <div class="container">
    <label><b>Username</b></label>
    <input id="user" type="text" placeholder="Enter Username" name="uname" required>

    <label><b>Password</b></label>
    <input id="pass" type="password" placeholder="Enter Password" name="psw" required>
        
    <button type="submit" onclick="function()">Login</button>
    <input type="checkbox" checked="checked"> Remember me
  </div>
</form>

</body>
</html>
