
None selected

Skip to content
Using Gmail with screen readers
Click here to enable desktop notifications for Gmail.   Learn more  Hide
Conversations
amarjeet.singh1998@hotmail.com
amarjeet.singh1998@hotmail.com
1.12 GB (7%) of 15 GB used
Manage
Terms · Privacy · Program Policies
Last account activity: 0 minutes ago
Details

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="./shared/navbar.jsp"></jsp:include>
		
				     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		     <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
		
		<spring:url  var="images" value="/resources/images"/>
		<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
		
		<div class="container">
		<h2>List Of Category</h2>
		<hr>
		<div class="thumbnail">
		<div class="table-responsive">
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
		
		<jsp:include page="./shared/footer.jsp"></jsp:include>
		
		</body>
		</html>

viewcategory.txt
Displaying viewcategory.txt.