<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

 
 <c:set var="contextRoot" value="${pageContext.request.contextPath}"/> 
 
<spring:url var="images" value="/resources/images"/>


<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>


<nav class="navbar navbar-default">
	
	<div class="container-fluid">
		<div class="navbar-header">
			<img src="${images}/myntra1.jpg" width="60px" height="50px" /><b>Myntra</b>
		</div>
		
		<ul class="nav navbar-nav">
			<li><a href="${contextRoot}/getProduct/Men Wear"><b>Men</b> </a></li>
			<li><a href="${contextRoot}/getProduct/Women Wear"><b>Women</b> </a></li>
			<li><a href="${contextRoot}/getProduct/kids Wear"> <b>Kids</b></a></li>
			<li><a href="${contextRoot}/getProduct/Home & Living"><b>Home &Living</b> </a></li>

		</ul>
  
    <div class="mx-auto order-0">
		<form class="navbar-form navbar-left" action="">
			<div class="input-group">
				<input type="text" class="form-control" placeholder="Search"
					name="search">
				<div class="input-group-btn">
					<button class="btn btn-default" type="submit">
						<i class="glyphicon glyphicon-search"></i>
					</button>
				</div>
			</div>
		</form>
	</div>

		<ul class="nav navbar-nav navbar-right">
			<li><a href="${contextRoot}/admin/adminHomePage"> <span
					class="glyphicon glyphicon-user" style="color:red"></span>
			</a></li>
			<li><a href="${contextRoot}/addToCart/makePayment" style="color:black"><i class="fa fa-shopping-cart"
					aria-hidden="true"></i></a></li>
			</ul>		

	
    <ul class="nav navbar-nav navbar-right">
    
    <sec:authorize access="isAnonymous()">
	<li >
		<a href="${contextRoot}/register" style="color:red">Sign Up</a>
    </li>
    
	<li >
		<a href="${contextRoot}/login" style="color:black">Login</a>
	</li>
	</sec:authorize>
	</ul>
	<sec:authorize access="isAuthenticated()">
	<li class="dropdown">
		<a href="javascript:void(0)"
			class="btn btn-default dropdown-toggle"
			id="dropdownMenu1"
			data-toggle="dropdown">Welcome : <c:out value="${sessionScope.name}"/>
				<span class="caret"></span>
			</a>
		<li class="divider" role="seperator"></li>
		<li>
			<a href="${contextRoot}/perform-logout">Logout</a>
		</li>
	</sec:authorize>
	
	
  </div>
</nav>



















	
					