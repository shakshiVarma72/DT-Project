<!--  <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<body>
<jsp:include page="./shared/navbar.jsp"></jsp:include>
<div class="container">
<form  method="post">
<div class="form-group">
<label for="email">Email:</label>
<input type="email" class="form-control" id="email" palceholder="Enter Email" name="UserName">
</div>
<div class="form-group">
<label for="email">Password:</label>
<input type="password" class="form-control" id="password" palceholder="Enter password" name="password">
</div>
<button type="submit"  class="btn-btn-danger">Login</button>
<input type="hidden" name="${_csrf.parameterName}"
value="${_csrf.token }"/>
</form>
</div>
</body>
</html>-->
