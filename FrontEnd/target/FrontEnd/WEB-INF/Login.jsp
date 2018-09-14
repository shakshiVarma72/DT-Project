<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<body>
<div class="container">
<form action="login" method="post">
<div class="form-group">
<label for="email">Email:</label>
<input type="email" class="form-control" id="email" palceholder="Enter Email" name="email">
</div>
<div class="form-group">
<label for="email">Password:</label>
<input type="password" class="form-control" id="password" palceholder="Enter password" name="pwd">
</div>
<div class="checkbox">
<label>
<input type="checkbox" name="remember"> Remember me</label></div>
<button type="submit" class="btn-btn-danger"></button>
</form>
</div>
</body>
</html>