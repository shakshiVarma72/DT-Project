
<jsp:include page="./shared/navbar.jsp"></jsp:include>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<div class="container">
	<h2>${msg }</h2>
	<br />
	<hr>
	<h1 align="center">Supplier List</h1>

	<div class="table-responsive">
		<table class="table">
			<thead>
				<tr>
					<th>Supplier Name</th>
					<th> Supplier Address</th>
					<th>Operations</th>
				</tr>
			</thead>
			</tbody>
			<c:forEach items="${supplierList}" var="supplierObj">
				<tr>
					<td>${supplierObj.supplierName}</td>
					<td>${supplierObj.supplierAddress}</td>


					<td><a
						href="${contextRoot}/deleteSupplier/${supplierObj.supplierId}">
							<span class="glyphicon glyphicon-trash"></span>
					</a></td>
					<td>
				</tr>
			</c:forEach>

		</table>
	</div>
</div>
<div style="margin-top: 20%;">

	<jsp:include page="./shared/footer.jsp"></jsp:include>
</div>
</body>
</html>

