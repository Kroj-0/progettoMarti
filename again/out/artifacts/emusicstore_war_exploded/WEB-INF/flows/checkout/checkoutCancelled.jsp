<%--
  Created by IntelliJ IDEA.
  User: marti
  Date: 7/27/2018
  Time: 12:46 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="container-wrapper">
    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1 class="alert alert-danger">Checkout cancelled!</h1>
                    <P>Your checkout process was cancelled. You can continue shopping</P>
                </div>
            </div>
        </section>

        <section class="container" >
            <p>
                <a href="<spring:url value="/product/productList"/>" class="btn btn-default">Products</a>
            </p>
        </section>

    </div>
</div>



<%@include file="/WEB-INF/views/template/footer.jsp" %>


