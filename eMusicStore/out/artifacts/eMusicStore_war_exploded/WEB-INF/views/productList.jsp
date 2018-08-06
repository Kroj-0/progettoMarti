<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>

<script>
    window.onload=function() {
        var query = window.location.search.substring(1);
        console.log(query);
        var params =query.split('=');
        console.log(params);
        var params2=params[1].split('&');
        console.log((params2));
        // Get a reference to the first element in the form
        var formElement = document.forms['theForm'].elements[0];
        formElement.value = params2[0];
        // Give it a name
        formElement.name = params[0];
        var select=document.getElementById(params[2]);
        select.selected=true;
    }
</script>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Products</h1>
            <p class="lead">Checkout all the awesome products available now!</p>
        </div>
        <div class="row" style="margin-bottom: 20px">

            <div class="col-md-2 pull-left">
                <a href="<c:url value="/product/categories"/> " class="btn btn-default">Back to categories</a>
            </div>

            <div class="col-md-3 col-md-offset-7" style="width: 200px">
            <form action="<c:url value="${uri}" /> " method="get" name="theForm" style="width: 200px">
                <input type="hidden"  />
                <select name="order" onchange="this.form.submit()" style="width: 200px">
                    <option>---Order---</option>
                    <option value="productPrice_asc" id="productPrice_asc">Price asc</option>
                    <option value="productPrice_desc" id="productPrice_desc">Price desc</option>
                    <option value="productName_asc" id="productName_asc">Name asc</option>
                    <option value="productName_desc" id="productName_desc">Name desc</option>
                </select>
            </form>
            </div>
        </div>
       <div class="container" style="margin-left: 40px;margin-top: 10px ">
           <div class="row">
            <c:forEach items="${products}" var="product">
                <c:set var="inactive" value="inactive"/>
                <c:if test="${product.productStatus!=inactive}">

                    <a href="<spring:url value="/product/viewProduct/${product.productId}" />">
                    <div class="col-md-3" style="height: 350px; width: 265px; margin-bottom: 10px;border: 5px black">
                        <div class="clearfix" style="height: 260px">
                            <img src="<c:url value="/resources/images/${product.productId}.png" /> " alt="image"
                                            style="width:100%; height: 100%"/>
                        </div>
                        <div class="row" style="height: 50px; margin-top: 10px">
                            <div class="col-md-8">
                                ${product.productName}<br>
                                ${product.productManufacturer}
                            </div>
                            <div class="col-md-4" style="text-align: right">
                                <h5 style="margin-top: 5px">$ ${product.productPrice}</h5>
                            </div>
                        </div>
                        <div class="row" style="height: 20px; margin-bottom: 10px">
                            <p style="color: forestgreen; text-align: right;margin-right: 15px">${product.unitInStock} pieces available!</p>
                        </div>
                    </div>
                    </a>
                </c:if>

            </c:forEach>
               <c:if test="${empty products}">
                   <h3>It appears that the searched products are not available...</h3>
               </c:if>
       </div>
       </div>
        <div style="margin-top: 30px">
        <%@include file="/WEB-INF/views/template/footer.jsp" %>
        </div>
    </div>
</div>
