<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

 <c:set var="contextRoot" value="${pageContext.request.contextPath}"/> 

<spring:url var="images" value="/resources/images"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<head>
  <title>OnlineShopping</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>


<!-- navbar -->
<!-- jsp include will include the contents at runtime...will not copy like include directive -->
 <jsp:include page="./shared/navbar.jsp"></jsp:include>

 
 
<div class="container">
<div id="myCarousel" class="carousel slide" data-ride="carousel">
       <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <div class="carousel-inner">
      <div class="item active">
        <img src="${images}/slider12.jpg" alt="Flat 50% off" style="width:50px;">
      </div>

      <div class="item">
        <img src="${images}/slider12.jpg"  style="width:100% ;">
      </div>
    
      <div class="item">
        <img src="${images}/slider12.jpg  style="width:100% ;">
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>
</div>

<div class="container">
<div class="rows">
<div class="col-md-12">

<div class="col-md-3">
<div class="thumbnail" align="center">
<img src="${images}/budhha.jpg">
<h5>Table Lamp</h5>
<p align="left">Rs.1500 (50%off)</p>
<p align="right"><a><i class="fa fa-heart" aria-hidden="true"></a></i></p>
</div>
</div>

<div class="col-md-3">
<div class="thumbnail" align="center">
<img src="${images}/clock.jpg">
<h5>Wall Clock</h5>
<p align="left">Rs.2000 (20%off)</p>
<p align="right"><a><i class="fa fa-heart" aria-hidden="true"></a></i></p>
</div>
</div>

<div class="col-md-3">
<div class="thumbnail" align="center">
<img src="${images}/paris.jpg">
<h5>Wall clock</h5>
<p align="left">Rs.2500 (15%off)</p>
<p align="right"><a><i class="fa fa-heart" aria-hidden="true"></a></i></p>
</div>
</div>

<div class="col-md-3">
<div class="thumbnail" align="center">
<img src="${images }/Cush.jpg">
<h5>Cushun Covers</h5>
<p align="left">Rs.980 (50%off)</p>
<p align="right"><a><i class="fa fa-heart" aria-hidden="true"></a></i></p>
</div>
</div>
 </br>

<div class="col-md-3">
<div class="thumbnail" align="center">
<img src="${images}/blazer.jpg">
<h5>Men Blazer</h5>
<p align="left">Rs.2500 (15%off)</p>
<p align="right"><a><i class="fa fa-heart" aria-hidden="true"></a></i></p>
</div>
</div>

<div class="col-md-3">
<div class="thumbnail" align="center">
<img src="${images}/cutekid2.jpg">
<h5>Girl Dress</h5>
<p align="left">Rs.2500 (15%off)</p>
<p align="right"><a><i class="fa fa-heart" aria-hidden="true"></a></i></p>
</div>
</div>


<div class="col-md-3">
<div class="thumbnail" align="center">
<img src="${images }/packs.jpg">
<h5>Boy T-shirts</h5>
<p align="left">Rs.2500 (15%off)</p>
<p align="right"><a><i class="fa fa-heart" aria-hidden="true"></a></i></p>
</div>
</div>

<div class="col-md-3">
<div class="thumbnail" align="center">
<img src="${images}/cutekid.jpg">
<h5>kids dresses</h5>
<p align="left">Rs.2500 (15%off)</p>
<p align="right"><a><i class="fa fa-heart" aria-hidden="true"></a></i></p>
</div>
</div>
</br>

<div class="col-md-3">
<div class="thumbnail" align="center">
<img src="${images }/saree.jpg">
<h5>Saree</h5>
<p align="left">Rs.2500 (15%off)</p>
<p align="right"><a><i class="fa fa-heart" aria-hidden="true"></a></i></p>
</div>
</div>

<div class="col-md-3">
<div class="thumbnail" align="center">
<img src="${images }/dress2.jpg">
<h5>JumpSuit</h5>
<p align="left">Rs.2500 (15%off)</p>
<p align="right"><a><i class="fa fa-heart" aria-hidden="true"></a></i></p>
</div>
</div>

<div class="col-md-3">
<div class="thumbnail" align="center">
<img src="${images }/dungaree.jpg">
<h5>Dungaree</h5>
<p align="left">Rs.2500 (15%off)</p>
<p align="right"><a><i class="fa fa-heart" aria-hidden="true"></a></i></p>
</div>
</div>

<div class="col-md-3">
<div class="thumbnail" align="center">
<img src="${images}/kurti.jpg">
<h5>Kurti</h5>
<p align="left">Rs.2500 (15%off)</p>
<p align="right"><a><i class="fa fa-heart" aria-hidden="true"></a></i></p>
</div>
</div>
</div>
</div>
</div>
<jsp:include page="./shared/footer.jsp"></jsp:include>

</body>



</head>
<body>

</body>
</html>