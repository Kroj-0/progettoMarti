<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<script>
    //once loaded...
    $(document).ready(function(){

        //select table class inside document, to apply dataTables functions
        var table= $('.table').DataTable({
            "searching": false,
            "info": false
        });

    });
</script>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Product Inventory Page</h1>

            <p class="lead">This is the product inventory page!</p>
        </div>
        <div class="container" style="margin-bottom: 10px">
            <div class="col-md-30">
                <a href="<c:url value="/admin"/>" class="btn btn-default pull-left" >Back to Admin Page</a>
            </div>
        </div>
        <div class="container">
        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th style="width: 100px">Photo Thumb</th>
                <th style="width: 40%">Product Name</th>
                <th>Category</th>
                <th>Condition</th>
                <th >Price</th>
                <th></th>
            </tr>
            </thead>
            <c:forEach items="${products}" var="product">
                <tr>
                    <td><img src="<c:url value="/resources/images/${product.productId}.png" /> " alt="image"
                             style="width:100%; height: 100px"/></td>
                    <td>${product.productName}</td>
                    <td>${product.productCategory}</td>
                    <td>${product.productCondition}</td>
                    <td>${product.productPrice} USD</td>
                    <td><a href="<spring:url value="/product/viewProduct/${product.productId}" />"
                    ><span class="glyphicon glyphicon-info-sign"></span></a>
                        <a href="<spring:url value="/admin/product/deleteProduct/${product.productId}" />"
                        ><span class="glyphicon glyphicon-remove"></span></a>
                        <a href="<spring:url value="/admin/product/editProduct/${product.productId}" />"
                        ><span class="glyphicon glyphicon-pencil"></span></a>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <a href="<spring:url value="/admin/product/addProduct" />" class="btn btn-primary">Add Product</a>
    </div>
        <%@include file="/WEB-INF/views/template/footer.jsp" %>
