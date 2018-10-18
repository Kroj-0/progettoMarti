<%--
  Created by IntelliJ IDEA.
  User: marti
  Date: 7/28/2018
  Time: 11:43 AM
  To change this template use File | Settings | File Templates.
--%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Customer Detail</h1>

            <p class="lead">Here is the detail information of the customer!</p>
        </div>
        <div class="container">
            <div class="col-md-30">
                <a href="<c:url value="/admin/users"/>" class="btn btn-default pull-left" >Back to Users list</a>
            </div>
        </div>
        <div class="container" >
            <div class="col-md-5">
                <h3>Customer Basic Information</h3>
                <form:form action="${pageContext.request.contextPath}/admin/users/editCustomer" method="post"
                           commandName="customer">
                    <form:hidden path="customerId" value="${customer.customerId}" />
                    <div class="form-group">
                        <label for="username">Username</label>
                            <form:input path="username" id="username" class="form-Control" value="${customer.username}" readonly="true"/>
                            <form:hidden path="password" value="${customer.password}" /><br>
                        <label for="name">Name</label>
                            <form:input path="customerName" id="name" class="form-Control" value="${customer.customerName}" readonly="true"/><br>
                        <label for="surname">Surname</label>
                            <form:input path="customerSurname" id="surname" class="form-Control" value="${customer.customerSurname}" readonly="true"/><br>
                        <label for="email">Email</label>
                            <form:input path="customerEmail" id="email" class="form-Control" value="${customer.customerEmail}" readonly="true"/><br>
                        <label for="phone">Phone</label>
                            <form:input path="customerPhone" id="phone" class="form-Control" value="${customer.customerPhone}" readonly="true"/><br>
                        <form:hidden path="shippingAddress.shippingAddressId" value="${customer.shippingAddress.shippingAddressId}" />
                        <form:hidden path="billingAddress.billingAddressId" value="${customer.billingAddress.billingAddressId}" />
                        <form:hidden path="cart.cartId" value="${customer.cart.cartId}" />
                        <form:hidden path="users.userId" value="${customer.users.userId}" />

                    </div>
                    <div class="form-group">
                        <label for="status">Status</label>
                        <label class="checkbox-inline"><form:radiobutton path="users.enabled" id="status"
                                                                     value="1" />Enabled</label>
                        <label class="checkbox-inline"><form:radiobutton path="users.enabled" id="status"
                                                                     value="0" />Disabled</label>
                    </div>
                    <input type="submit" value="Confirm status changes?" class="btn btn-default">
                </form:form>
                <br>
            </div>
            <div class="col-md-2"></div>
            <div class="col-md-5">
                <h3>Customer Billing Information</h3>
                <br><br><br>
                <h4>Street:     ${customer.shippingAddress.streetName}</h4>
                <p></p><br>
                <h4>Apt.Number:     ${customer.shippingAddress.aptNumber}</h4>
                <p></p><br>
                <h4>City:   ${customer.shippingAddress.city}</h4>
                <p></p><br>
                <h4>State:  ${customer.shippingAddress.state}</h4>
                <p></p><br>
                <h4>Cap:    ${customer.shippingAddress.cap}</h4>
                <p></p><br>
            </div>
            <div class="col-md-30">
                <%--qui voglio mettere una tabella con gli ordini di questo cliente. Potrei mettere un link sull'id ordine per mandare ad una pagina di
                modifica, nel caso decidessi di implementare uno dei punti opzionali. Questa pagina sarebbe in comune con quella di gestione ordini,
                proveniente da una terza sezione della pagina admin, "Order Management", dove voglio che compaiano tutti gli ordini--%>
                <table class="table table-striped table-hover">
                    <thead>
                    <tr class="bg-success">
                        <th>OrderId</th>
                        <th>Product Id</th>
                        <th>Date</th>
                        <th>Total</th>
                        <th style="width: 300px">Shipping Address</th>
                        <th>Status</th>
                        <th>Details</th>
                    </tr>
                    </thead>

                        <c:forEach items="${orders}" var="customerOrders">
                            <tr>
                                <td>${customerOrders.customerOrderId.orderId}</td>
                                <td>${customerOrders.product.productId}</td>
                                <td>${customerOrders.date}</td>
                                <td>${customerOrders.total} USD</td>
                                <td>${customerOrders.shippingAddress.streetName}, ${customerOrders.shippingAddress.city},
                                        ${customerOrders.shippingAddress.state}</td>
                                <td>${customerOrders.tracking.trackingId.status}</td>
                                <td><a href="<c:url value="/admin/orders/viewOrder/${customerOrders.customerOrderId.orderId}/${customerOrders.product.productId}" />"
                                ><span class="glyphicon glyphicon-info-sign"></span></a></td>
                            </tr>
                        </c:forEach>

                </table>
            </div>
        </div>



<%@include file="/WEB-INF/views/template/footer.jsp" %>
