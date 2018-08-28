<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: marti
  Date: 8/1/2018
  Time: 10:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>


<div class="container-wrapper">
    <div class="container">
        <div class="container">
            <div class="col-md-30">
                <a href="<c:url value="/customer/myDetails"/>" class="btn btn-default pull-left" >Back to Detail list</a>
            </div>
        </div>
        <div class="container" >
            <div class="col-md-5">
                <h3>Your Info</h3>
                <form:form action="${pageContext.request.contextPath}/customer/myDetails/editName" method="post"
                           commandName="customer">
                    <form:hidden path="customerId" value="${customer.customerId}" />
                    <div class="form-group">
                        <form:hidden path="username" id="username"  value="${customer.username}" />
                        <form:hidden path="password" value="${customer.password}" /><br>
                        <label for="name">Name</label>
                        <form:input path="customerName" id="name" class="form-Control" value="${customer.customerName}"/><br>
                        <label for="surname">Surname</label>
                        <form:input path="customerSurname" id="surname" class="form-Control" value="${customer.customerSurname}"/><br>

                        <form:hidden path="customerEmail" id="email"  value="${customer.customerEmail}" /><br>

                        <form:hidden path="customerPhone" id="phone" value="${customer.customerPhone}" /><br>
                        <form:hidden path="shippingAddress.shippingAddressId" value="${customer.shippingAddress.shippingAddressId}" />
                        <form:hidden path="billingAddress.billingAddressId" value="${customer.billingAddress.billingAddressId}" />
                        <form:hidden path="cart.cartId" value="${customer.cart.cartId}" />
                        <form:hidden path="users.userId" value="${customer.users.userId}" />
                        <form:hidden path="users.enabled" value="${customer.users.enabled}" />
                    </div>
                    <input type="submit" value="Confirm status changes?" class="btn btn-default">
                </form:form>
                <br>
            </div>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp" %>