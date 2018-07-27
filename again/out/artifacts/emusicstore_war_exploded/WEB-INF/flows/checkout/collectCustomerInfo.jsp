<%--
  Created by IntelliJ IDEA.
  User: marti
  Date: 7/27/2018
  Time: 12:12 PM
  To change this template use File | Settings | File Templates.
--%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Customer</h1>

            <p class="lead">Customer Details:</p>
        </div>

        <h3>Basic Info</h3>
        <form:form commandName="order" class="form-horizontal">
        <div class="form-group">
            <label for="name">Name</label> <form:errors path="cart.customer.customerName" cssStyle="color: #ff0000;" />
            <form:input path="cart.customer.customerName" id="name" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="surname">Surname</label> <form:errors path="cart.customer.customerSurname" cssStyle="color: #ff0000;" />
            <form:input path="cart.customer.customerSurname" id="surname" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="email">Email</label> <form:errors path="cart.customer.customerEmail" cssStyle="color: #ff0000;" />
            <form:input path="cart.customer.customerEmail" id="email" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="phone">Phone</label> <form:errors path="cart.customer.customerPhone" cssStyle="color: #ff0000;" />
            <form:input path="cart.customer.customerPhone" id="phone" class="form-Control"/>
        </div>

        <h3>Billing Address</h3>

        <div class="form-group">
            <label for="street">Street </label><form:input path="cart.customer.billingAddress.streetName" id="street" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="aptn">Apartment Number </label><form:input path="cart.customer.billingAddress.aptNumber" id="aptn" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="city">City </label><form:input path="cart.customer.billingAddress.city" id="city" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="State">State </label><form:input path="cart.customer.billingAddress.state" id="state" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="cap">CAP </label><form:input path="cart.customer.billingAddress.cap" id="cap" class="form-Control"/>
        </div>

        <input type="hidden" name="_flowExecutionKey"/>

        <br><br>
        <input type="submit" value="Next" class="btn btn-default" name="_eventId_customerInfoCollected"/>
        <button class="btn btn-default" name="_eventId_cancel">Cancel</button>
        </form:form>


        <%@include file="/WEB-INF/views/template/footer.jsp" %>
