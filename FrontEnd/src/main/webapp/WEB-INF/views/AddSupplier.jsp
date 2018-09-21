
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<spring:url var="images" value="/resources/images" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<div class="container">
	<h1>Add Supplier</h1>
	<hr />

	<form:form action="submitSupplier" method="post" modelAttribute="supplierObj">
		<div class="row">
			<div class="col-sm-4"></div>
			<label for="SupplierName">Supplier Name </label>
		</div>
		<div class="col-sm-4">
			<form:input type="text" class="form-control" id="supplier id"
				path="supplierName"/>
		</div>
		<div class="row">
			<div class="col-sm-4"></div>
			<label for="SupplierAddress">Supplier Address </label>
		</div>
		<div class="col-sm-4">
			<form:input type="text" class="form-control" id="supplier id"
				path="supplierAddress"/>
		</div>
		<br />

		<button type="submit" class="btn-btn-primary">Submit</button>

	</form:form>

	<div style="margin-top: 20%;">

		<jsp:include page="./shared/footer.jsp"></jsp:include>
	</div>