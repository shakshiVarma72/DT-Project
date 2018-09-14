 
 <jsp:include page="./shared/navbar.jsp"></jsp:include>
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
  
  <spring:url var="images" value="/resources/images"/>
  <c:set var="contextRoot" value="${pageContext.request.contextPath }"/>
   
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 

<div class="container">
<h2 style="color:red">${msg }</h2>
<h2>List Of Product</h2>
<hr>
<div class="thumbnail">
<div class="table-responsive">
<table class="table table-hover">
<thead>
<tr>
<th>Images </th>
<th> Product Name </th>
<th> Product Description </th>
<th> Product Price </th>
<th>Product quantity</th>
<th  colspan="2"> Action </th>
</tr>
</thead>
<tbody>
</tbody>

<c:forEach items="${ProductList}" var="productObj">
<tr>
<td><img src="${images}/${productObj.imgname }"class="img-responsive img Thumbnail"style="width:100px;height:100px"/></td> 
<td>${productObj.productId} </td>
<td>${productObj.productName}</td>
<td>${productObj.productDesc} </td>
<td>${productObj.price}<td>
<td>${productObj.quantity}</td>
<td>
<a href="${contextRoot}/deleteProduct/${productObj.productId}">
<span class="glyphicon glyphicon-trash"></span></a>
</td>
<td>
<a href="${contextRoot}/fetchProduct/${productObj.productId}">
<span class="glyphicon glyphicon-trash"></span></a>

</td>
</tr>
</c:forEach>
</div>
</div>
</div>
</table>
</body>
</html>