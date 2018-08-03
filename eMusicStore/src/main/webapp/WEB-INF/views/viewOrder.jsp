<%--
  Created by IntelliJ IDEA.
  User: marti
  Date: 7/29/2018
  Time: 5:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
            <h1>Order Detail</h1>

            <p class="lead">Here is the detail information of the order!</p>
        </div>
        <div class="row row-eq-height">
            <div class="col-md-4 ">
                <h4>Username</h4>
                <h5>${order.customer.username}</h5>
                <h4>OrderId</h4>
                <h5>${order.customerOrderId.orderId}</h5>
                <h4>ProductId</h4>
                <h5>${order.customerOrderId.productId}</h5>
                <h4>Quantity</h4>
                <h5>${order.quantity}</h5>
                <h4>Total</h4>
                <h5>${order.total}</h5>
                <h4>Date</h4>
                <h5>${order.date}</h5>
                <h4>Shipping Address</h4>
                <h5>${order.shippingAddress.streetName}, ${order.shippingAddress.aptNumber},
                    ${order.shippingAddress.city}, ${order.shippingAddress.state}, ${order.shippingAddress.cap}</h5>
                <h4>Status</h4>
                <h5>${order.status}</h5>
            </div>
            <c:if test="${linkedOrders.get(0)!=null}">
            <div class="col-md-8 text-center">
                <div class="row">
                    <h4>It appears that this order is part of a multi-product order. Here are the linked orders</h4><br><br>
                    <table class="table table-striped table-hover">
                        <thead>
                        <tr class="bg-success">

                            <th>OrderId</th>
                            <th>ProductId</th>
                            <th>Quantity</th>
                            <th >Total</th>
                            <th>Status</th>
                            <th>Details</th>

                        </tr>
                        </thead>
                        <c:forEach items="${linkedOrders}" var="linkedOrders">
                            <tr>
                                <td>${linkedOrders.customerOrderId.orderId}</td>
                                <td>${linkedOrders.customerOrderId.productId}</td>
                                <td>${linkedOrders.quantity}</td>
                                <td>${linkedOrders.total}</td>
                                <td>${order.status}</td>
                                <td><a href="<c:url value="/admin/orders/viewOrder/${linkedOrders.customerOrderId.orderId}/${linkedOrders.product.productId}"/>" >
                                    <span class="glyphicon glyphicon-info-sign"></span></a></td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
                <div class="row">
                    <h4>Here you can update the order status</h4>
                    <form:form action="${pageContext.request.contextPath}/admin/orders/orderDetail/editStatus"
                               method="post" commandName="order">
                        <form:hidden path="customerOrderId.orderId" value="${order.customerOrderId.orderId}" />
                        <form:hidden path="customerOrderId.productId" value="${order.customerOrderId.productId}" />

                        <fmt:formatDate value="${order.date}" type="date" var="orderDate" pattern="yyyy-MM-dd"/>
                        <form:hidden path="date" value="${orderDate}" />

                        <form:hidden path="quantity" value="${order.quantity}" />
                        <form:hidden path="total" value="${order.total}" />
                        <form:hidden path="unitPrice" value="${order.unitPrice}" />
                        <form:hidden path="billingAddress.billingAddressId" value="${order.billingAddress.billingAddressId}" />
                        <form:hidden path="shippingAddress.shippingAddressId" value="${order.shippingAddress.shippingAddressId}" />
                        <form:hidden path="cart.cartId" value="${order.cart.cartId}" />
                        <form:hidden path="customer.customerId" value="${order.customer.customerId}" />
                        <label for="st">Update order status         </label>
                        <c:set var="state" value="${order.status}"></c:set>
                        <c:set var="denied" value="cancelled"></c:set>
                        <c:if test="${state.equals(denied)}">
                            <form:select path="status" id="st" >
                                <form:option value="Attuale: ${order.status}"/>
                            </form:select>
                        </c:if>
                        <c:if test="${!state.equals(denied)}">
                            <form:select path="status" id="st" >
                                <form:option value="Attuale: ${order.status}"/>
                                <form:options items="${status}"/>
                            </form:select>
                        </c:if>
                        <input type="submit" value="Confirm status changes?" class="btn btn-default">
                    </form:form>
                </div>
                <div class="row">
                <c:if test="${!state.equals(denied)}">
                    <h4>Here you can choose to delete the order</h4>
                    <p style="color: red">*Important note: this action can't be reversed, but you will still be able to see the order</p>
                    <a href="<c:url value="/admin/orders/deleteOrder/${order.customerOrderId.orderId}/${order.customerOrderId.productId}" />">
                        <span class="glyphicon glyphicon-remove"></span></a>
                </c:if>
                </div>
            </div>
            </c:if>

        <c:if test="${linkedOrders.get(0)==null}">
        <div class="col-md-8">
            <div class="row">
                <h4>Here you can update the order status</h4>
                <form:form action="${pageContext.request.contextPath}/admin/orders/orderDetail/editStatus"
                method="post" commandName="order">
                    <form:hidden path="customerOrderId.orderId" value="${order.customerOrderId.orderId}" />
                    <form:hidden path="customerOrderId.productId" value="${order.customerOrderId.productId}" />

                    <fmt:formatDate value="${order.date}" type="date" var="orderDate" pattern="yyyy-MM-dd"/>
                    <form:hidden path="date" value="${orderDate}" />

                    <form:hidden path="quantity" value="${order.quantity}" />
                    <form:hidden path="total" value="${order.total}" />
                    <form:hidden path="unitPrice" value="${order.unitPrice}" />
                    <form:hidden path="billingAddress.billingAddressId" value="${order.billingAddress.billingAddressId}" />
                    <form:hidden path="shippingAddress.shippingAddressId" value="${order.shippingAddress.shippingAddressId}" />
                    <form:hidden path="cart.cartId" value="${order.cart.cartId}" />
                    <form:hidden path="customer.customerId" value="${order.customer.customerId}" />
                    <label for="st">Update order status         </label>
                    <c:set var="state" value="${order.status}"></c:set>
                    <c:set var="denied" value="cancelled"></c:set>
                    <c:if test="${state.equals(denied)}">
                        <form:select path="status" id="st" >
                            <form:option value="Attuale: ${order.status}"/>
                        </form:select>
                    </c:if>
                    <c:if test="${!state.equals(denied)}">
                        <form:select path="status" id="st" >
                            <form:option value="Attuale: ${order.status}"/>
                            <form:options items="${status}"/>
                        </form:select>
                    </c:if>
                    <input type="submit" value="Confirm status changes?" class="btn btn-default">
                </form:form>
            </div>
            <div class="row">
            <c:if test="${!state.equals(denied)}">
                <h4>Here you can choose to delete the order</h4>
                <p style="color: red">*Important note: this action can't be reversed, but you will still be able to see the order</p>
                <a href="<c:url value="/admin/orders/deleteOrder/${order.customerOrderId.orderId}/${order.customerOrderId.productId}" />">
                    <span class="glyphicon glyphicon-remove"></span></a>
            </c:if>
            </div>
        </div>
        </c:if>
        </div>
        <div class="container">
            <div class="col-md-30">
                <a href="<c:url value="/admin/orders"/>" class="btn btn-default pull-right" >Back to OrderList</a>
            </div>
        </div>



    </div>
</div>


<%@include file="/WEB-INF/views/template/footer.jsp" %>
