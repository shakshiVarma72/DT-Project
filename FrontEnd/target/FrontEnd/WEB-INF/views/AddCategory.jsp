<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
		
				     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		     <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
		
		<spring:url  var="images" value="/resources/images"/>
		<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
		
		<div class="container">
		<h2>List Of Category</h2>
		<hr>
		<div class="thumbnail">
		<div class="tabl e-responsive">
		<table class="table table-hover">
		    <thead>
		      <tr>
		      	<th>Category name</th>
		        <th colspan="2">Action</th>
		      </tr>
		    </thead>
		    <tbody>
		    
		    
		     <c:forEach items="${categoryList}" var="categoryObj">
		    <tr>
		    <td>${categoryObj.categoryName}</td>
			<td>
				<a href="${contextRoot}/deleteCategory/${categoryObj.categoryId}">
          		<span class="glyphicon glyphicon-trash"></span></a>
          	</td>
          	<td>
				<a href="${contextRoot}/fetchCategory/${categoryObj.categoryId}">
          		<span class="glyphicon glyphicon-edit"></span></a>
          	</td>
			</tr>
		</c:forEach>
		</tbody>
		</table>
		</div>
		</div>
	    </div>
		
		
		</body>
		</html>