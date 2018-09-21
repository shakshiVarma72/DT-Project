<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<spring:url var="images" value="/resources/images" />

<body>
	<jsp:include page="./shared/navbar.jsp"></jsp:include>
	<div class="container">
			<div class="row">

				<div class="col-md-offset-3 col-md-6">
					<div class="alert alert-danger">${message} ... Please Login</div>
				</div>
			</div>
			<br>
		</div>
	<br>

	<jsp:include page="./shared/footer.jsp"></jsp:include>