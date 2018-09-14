<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">

  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>



<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#"><img src="${images}/myntra.jpg" width="40px" height="25px"></a> 
    </div>
    <ul class="nav navbar-nav">
      <li><a href="#"><b>Myntra</b> </a></li>
      <li class="active"><a href="#">Home</a></li>

     <li><a href="#">Men </a></li>
      <li><a href="#">Women </a></li>
      <li><a href="#"> Kids</a></li>
      <li><a href="#" >Home&Living </a></li>
     
    </ul>
	
	<form class="navbar-form navbar-left" action="">
      <div class="input-group">
        <input type="text" class="form-control" placeholder="Search" name="search">
        <div class="input-group-btn">
          <button class="btn btn-default" type="submit">
            <i class="glyphicon glyphicon-search"></i>
          </button>
        </div>
      </div>
    </form>
	
    <ul class="nav navbar-nav navbar-right">
	<li><a href="adminHomePage">
          <span class="glyphicon glyphicon-user"></span>
        </a></li>
	<li><a href="#"><i class="fa fa-shopping-cart" aria-hidden="true"></i></a></li>
	
	<li><a href="#"><span class="glyphicon glyphicon"></span>LOGIN</a>
	</ul>
	
  </div>
</nav>
