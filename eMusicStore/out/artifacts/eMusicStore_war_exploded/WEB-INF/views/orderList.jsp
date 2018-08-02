<%--
  Created by IntelliJ IDEA.
  User: marti
  Date: 7/29/2018
  Time: 7:59 PM
  To change this template use File | Settings | File Templates.
--%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Order List Page</h1>

            <p class="lead">This is the order list page</p>
        </div>
        <div class="container" style="margin-bottom: 10px">
            <div class="col-md-12">
                <a href="<c:url value="/admin"/>" class="btn btn-default pull-left" >Back to Admin Page</a>
            </div>
        </div>
        <div class="container">
            <table class="table table-striped table-hover">
                <thead>
                <tr class="bg-success">
                    <th>OrderId</th>
                    <th>Product Id</th>
                    <th>Quantity</th>
                    <th>Total</th>
                    <th>Date</th>
                    <th style="width: 300px">Shipping Address</th>
                    <th>Status</th>
                    <th>Details</th>
                </tr>
                </thead>
                <c:forEach items="${orders}" var="customerOrder">
                <tr>
                    <td>${customerOrder.customerOrderId.orderId}</td>
                    <td>${customerOrder.customerOrderId.productId}</td>
                    <td>${customerOrder.quantity}</td>
                    <td>${customerOrder.total}</td>
                    <td>${customerOrder.date}</td>
                    <td >${customerOrder.shippingAddress.streetName}, ${customerOrder.shippingAddress.aptNumber},
                        ${customerOrder.shippingAddress.city}, ${customerOrder.shippingAddress.state}, ${customerOrder.shippingAddress.cap}</td>
                    <td>${customerOrder.status}</td>
                    <td><a href="<c:url value="/admin/orders/viewOrder/${customerOrder.customerOrderId.orderId}/${customerOrder.product.productId}"/>" >
                        <span class="glyphicon glyphicon-info-sign"></span></a></td>
                </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp" %>
