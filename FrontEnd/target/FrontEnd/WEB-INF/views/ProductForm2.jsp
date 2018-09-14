<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
		
<spring:url  var="images" value="/resources/images"/>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="./shared/navbar.jsp"></jsp:include>
 
 
 <div class="container">
<div class="rows">
<br>
<h2>

 <c:choose>
  	<c:when test="${productObj eq null}">
  			Add Product <i class="fa fa-cubes" aria-hidden="true"></i>

  	</c:when>
  	<c:otherwise>
  		Update Product <i class="fa fa-cubes" aria-hidden="true"></i>

  	</c:otherwise>
  </c:choose>
 



</h2>
<hr>
<br>
 <form action="${contextRoot}/addUpdateproduct" method="post" enctype="multipart/form-data">
  
  <div class="form-group">
  	<input type="hidden" name="pId" value="${productObj.productId}">
  	
    <label for="name">Product Name:</label>
    <input type="text" class="form-control" name="productName" value="${productObj.productName}">
  </div>
  
   <div class="form-group">
    <label for="Descrption">Product Description:</label>
    <input type="text" class="form-control" name="productDescrption" value="${productObj.productDescrption}">
  </div>
  
   <div class="form-group">
    <label for="Price">Product Price:</label>
    <input type="text" class="form-control" name="productPrice" value="${productObj.productPrice}">
  </div>
   <div class="form-group">
    <label for="Quantity">Product Quantity:</label>
    <input type="text" class="form-control" name="productQuantity" value="${productObj.productQuantity}">
  </div>
  <div class="row">
     <div class="col-md-4">
     <label for="category">CATEGORY</label></div>
     <div class="col-md-4">
     <select name="category" class="form-control">
     <option value="none">------------Select Category----------------------</option>
     <c:forEach items="${categoryList}" var="categoryObj">
      <option value="${categoryObj.categoryId}">${categoryObj.categoryName }</option>
      </c:forEach>
      </select>
    </div>
    </div>
    
      <div class="row">
     <div class="col-md-4">
     <label for="supplier">SUPPLIER</label></div>
     <div class="col-md-4">
     <select name="supplier" class="form-control">
     <option value="none">------------Select Supplier----------------------</option>
     <c:forEach items="${supplierList}" var="supplierObj">
      <option value="${supplierObj.supplierId}">${supplierObj.supplierName}</option>
      </c:forEach>
      </select>
    </div>
    </div>
  
  <div class="form-group">
  	<label for="pimage">Upload New Image</label>
  	<input type="file" class="form-control" id="file" placeholder="Upload Product Image" name="file">
  	</div>
  
   <c:choose>
  	<c:when test="${productObj eq null}">
  			<input type="submit" class="btn btn-danger" value=" Add product">
  	</c:when>
  	<c:otherwise>
  		<input type="submit" class="btn btn-danger" value="Update Product">
  	</c:otherwise>
  </c:choose>
  </form>
</div>
</div>
<br>
<br>
<jsp:include page="./shared/footer.jsp"></jsp:include>
</body>
</html>