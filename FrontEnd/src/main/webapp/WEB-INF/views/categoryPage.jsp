<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
<jsp:include page="./shared/navbar.jsp"></jsp:include>

 

<div class="container">
<div class="rows">
<div class="col-md-6">
<div class="thumbnail" align="center">
<div><a href="${contextRoot}/admin/getaddcategory"><h5>Add Category</h5></a></div>
</div>
</div>
</div>


<div class="col-md-6">
<div class="thumbnail" align="center">
<div><a href="getviewcategory"><h5>View All Category</h5></div>
</div>

</div>





</div>
</div>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>


<jsp:include page="./shared/footer.jsp"></jsp:include>


</body>
</html>
