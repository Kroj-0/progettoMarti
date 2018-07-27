<%--
  Created by IntelliJ IDEA.
  User: marti
  Date: 7/27/2018
  Time: 12:21 PM
  To change this template use File | Settings | File Templates.
--%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>
<jsp:useBean id="now" class="java.util.Date"/>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Order</h1>

            <p class="lead">Order Confirmation:</p>
        </div>
        <div class="container">
            <div class="row">
                <form:form commandName="order" class="form-horizontal">
                    <div class="well col-xs-10 col-sm-10 col-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3">
          
                        <div class="text-center">
                            <h1>Receipt</h1>
                        </div>
                        <div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <address>
                                    <strong>Shipping Address</strong>
                                    ${order.cart.customer.shippingAddress.streetName}
                                    <br>
                                    ${order.cart.customer.shippingAddress.aptNumber}
                                    <br>
                                    ${order.cart.customer.shippingAddress.city},${order.cart.customer.shippingAddress.state},
                                    ${order.cart.customer.shippingAddress.cap}
                                </address>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <address>
                                    <strong>Billing Address</strong>
                                        ${order.cart.customer.billingAddress.streetName}
                                    <br>
                                        ${order.cart.customer.billingAddress.aptNumber}
                                    <br>
                                        ${order.cart.customer.billingAddress.city},${order.cart.customer.billingAddress.state},
                                        ${order.cart.customer.billingAddress.cap}
                                </address>
                            </div>
                        </div>
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <p>Shipping Date: <fmt:formatDate type="date" value="${now}"/></p>
                        </div>

                        <div class="row">
                            <table class="table table-hover">
                                <thead>
                                <tr>
                                    <th>Product</th>
                                    <th>#</th>
                                    <th class="text-center">Price</th>
                                    <th class="text-center">Total</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="cartItem" items="${order.cart.cartItems}">
                                    <tr>
                                        <td class="col-md-9"><em>${cartItem.product.productName}</em></td>
                                        <td class="col-md-2 text-center"><em>${cartItem.quantity}</em></td>
                                        <td class="col-md-2 text-center"><em>${cartItem.product.productPrice}</em></td>
                                        <td class="col-md-2 text-center"><em>${cartItem.total}</em></td>
                                    </tr>
                                </c:forEach>
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td class="text-right">
                                        <h4><strong>Total is:</strong></h4>
                                    </td>
                                    <td class="text-center text-danger">
                                        <h4><strong>${order.cart.total}</strong></h4>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    <br><br>
                    <button class="btn btn-default" name="_eventId_backToCollectShippingDetail">Back</button>
                    <input type="submit" value="Submit Order" class="btn btn-default" name="_eventId_orderConfirmed"/>
                    <button class="btn btn-default" name="_eventId_cancel">Cancel</button>
                    </div>
                </form:form>
            </div>
        </div>

        <%@include file="/WEB-INF/views/template/footer.jsp" %>
