<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: marti
  Date: 7/26/2018
  Time: 5:11 PM
  To change this template use File | Settings | File Templates.
--%>

<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="container-wrapper">
    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Customer Registered Successfully</h1>

                </div>
            </div>
        </section>

        <section class="container" >
            <p>
                <a href="<spring:url value="/product/productList"/>" class="btn btn-default">Continue Shopping</a>
            </p>
        </section>

    </div>
</div>


<script src="<c:url value="/resources/js/cartcontroller.js"/>"/>
<%@include file="/WEB-INF/views/template/footer.jsp" %>


