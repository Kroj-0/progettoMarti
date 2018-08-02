<%--
  Created by IntelliJ IDEA.
  User: marti
  Date: 8/1/2018
  Time: 2:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Order List Page</h1>

            <p class="lead">This your order history page</p>
        </div>
        <div class="container" style="margin-bottom: 10px">
            <div class="col-md-12">
                <a href="<c:url value="/customer"/>" class="btn btn-default pull-left" >Back to My Account</a>
            </div>
        </div>
        <div class="container" ng-app="cartApp">
            <div class="col-md-10" style="margin-left: 100px;margin-right: 100px">
                <div class="row">
                    <div class="fill-parent">
                        <ul class="list-group">
                        <c:forEach items="${orders}" var="customerOrder">
                            <c:set var="cancelled" value="cancelled"/>
                            <c:set var="received" value="received"/>
                            <c:if test="${customerOrder.status==cancelled}">
                                <span style="color: red; font-size: x-large">Order was cancelled, please contact support</span>
                            </c:if>
                            <li class="list-group-item clearfix" style="background-color: gainsboro">
                                <div class="col-md-3 ">
                                    <strong>Ordered:</strong><br>
                                    <p>${customerOrder.date}</p>
                                </div>
                                <div class="col-md-5">
                                    <strong>Sent to:</strong><br>
                                    <p>${customerOrder.customer.customerName} ${customerOrder.customer.customerSurname}</p>
                                    <p>${customerOrder.customer.shippingAddress.streetName}, ${customerOrder.customer.shippingAddress.city}, ${customerOrder.customer.shippingAddress.cap}</p>
                                </div>
                                <div class="col-md-2 ">
                                    <strong>Order id:</strong><br>
                                    <p style="text-align: right">${customerOrder.customerOrderId.orderId}</p>
                                </div>
                                <div class="col-md-2">
                                    <strong>Order status:</strong><br>
                                    <p style="color: red;text-align: right">${customerOrder.status}</p>
                                </div>
                            </li>
                        <li class="list-group-item clearfix">
                            <div class="row">
                                    <div class="col-md-8">
                                        <div class="row">
                                            <div class="col-md-4" id="img-container">
                                                <img src="<c:url value="/resources/images/${customerOrder.customerOrderId.productId}.png"/> " style="width:150px; height: 150px;"/>
                                            </div>
                                            <div class="col-md-8 col-md-offset-1">
                                                <a href="<c:url value="/product/viewProduct/${customerOrder.customerOrderId.productId}"/> " >
                                                    ${customerOrder.product.productName}, ${customerOrder.product.productManufacturer}
                                                </a>
                                                <br><br>
                                                Unit Price : ${customerOrder.unitPrice}<br>
                                                Quantity: ${customerOrder.quantity}<br>
                                                Total: ${customerOrder.total}
                                            </div>
                                        </div>
                                    </div>
                                <div class="col-md-4"  >
                                    <c:choose>
                                        <c:when test="${customerOrder.status==cancelled || customerOrder.status==received}">
                                            <div class="row">
                                                <a href="<c:url value="/customer"/>" class="btn btn-default " style="margin-top:37px;width: 200px" >Contact support</a>
                                            </div>
                                            <div class="row" ng-controller="cartCtrl">
                                                <a class="btn btn-warning"
                                                   style="margin:0 auto;width: 200px" ng-click="addToCart('${customerOrder.customerOrderId.productId}')"  >Buy Again</a>
                                            </div>
                                        </c:when>
                                        <c:otherwise><div class="row">
                                            <a href="<c:url value="/customer"/>" class="btn btn-default  " style="margin-top:23px;width: 200px"  >Track your shipment</a>
                                        </div>

                                            <div class="row" >
                                                <a href="<c:url value="/customer"/>" class="btn btn-default " style="margin:0 auto;width: 200px" >Contact support</a>
                                            </div>
                                            <div class="row" ng-controller="cartCtrl">
                                                <a class="btn btn-warning "
                                                   style="margin:0 auto;width: 200px" ng-click="addToCart('${customerOrder.customerOrderId.productId}')"  >Buy Again</a>
                                            </div></c:otherwise>

                                    </c:choose>
                                </div>
                            </div>
                        </li>
                        <div class="row clearfix" style="margin: 10px">

                        </div>
                        </c:forEach>
                        </ul>
                        </div>
                    </div>
                </div>
        </div>
        <div>
        <%@include file="/WEB-INF/views/template/footer.jsp" %>
    </div>
    </div>

</div>

<script src="<c:url value="/resources/js/cartcontroller.js"/>"></script>