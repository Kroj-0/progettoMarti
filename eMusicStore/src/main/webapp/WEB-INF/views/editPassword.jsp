<%--
  Created by IntelliJ IDEA.
  User: marti
  Date: 8/1/2018
  Time: 12:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: marti
  Date: 8/1/2018
  Time: 10:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<script>
    var check = function() {
        if (document.getElementById('password').value ==
            document.getElementById('pwd_confirm').value) {
            document.getElementById('message').style.color = 'green';
            document.getElementById('message').innerHTML = 'matching';
        } else {
            document.getElementById('message').style.color = 'red';
            document.getElementById('message').innerHTML = 'not matching';
        }
    }
</script>

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
                <div>${error}</div>


                <form:form action="${pageContext.request.contextPath}/customer/myDetails/editPassword" method="post"
                           commandName="customer">
                    <form:hidden path="customerId" value="${customer.customerId}" />
                    <div class="form-group">
                        <label for="surname">New Password</label><form:errors path="password" cssStyle="color: #ff0000;" /><br>
                        <form:password minlength="8" placeholder="min. 8 char." path="users.password" id="password" class="form-Control" onkeyup="check()"/>
                        <form:hidden path="username" id="username"  value="${customer.username}" />

                        <label for="name">Confirm Password</label><form:errors path="password" cssStyle="color: #ff0000;" /><br>
                        <input type="password" name="password" minlength="8" placeholder="min. 8 char." path="password" id="pwd_confirm"
                                       class="form-Control" onkeyup="check()"/><span id='message'></span>
                        <form:hidden path="customerName" id="name"  value="${customer.customerName}"/><br>

                        <form:hidden path="customerSurname" id="surname"  value="${customer.customerSurname}"/><br>

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


            </div>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp" %>