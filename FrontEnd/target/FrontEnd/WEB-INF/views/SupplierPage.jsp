<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<jsp:include page="./shared/navbar.jsp"></jsp:include>



<div class="container">
	<div class="rows">
		<div class="col-md-6">
			<div class="thumbnail" align="center">
				<div>
					<a href="${contextRoot}/admin/getaddsupplier"><h5>Add
							Supplier</h5></a>
				</div>
			</div>
		</div>
	</div>


	<div class="col-md-6">
		<div class="thumbnail" align="center">
			<div>
				<a href="${contextRoot}/admin/getviewSupplier"><h5>View All
						Supplier</h5></a>
			</div>
		</div>

	</div>





</div>


<div style="margin-top: 20%;">

	<jsp:include page="./shared/footer.jsp"></jsp:include>
</div>


