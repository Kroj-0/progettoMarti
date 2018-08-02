<%--
  Created by IntelliJ IDEA.
  User: marti
  Date: 7/27/2018
  Time: 12:17 PM
  To change this template use File | Settings | File Templates.
--%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>


<div class="container-wrapper">
    <div class="container">
    <ul class="nav nav-pills">
        <li><a >Basic Info</a></li>
        <li class="active"><a >Shipping</a></li>
        <li><a >Checkout</a></li>
    </ul>
    </div>

    <div class="container">
    <form:form commandName="order" class="form-horizontal">

        <h3>Shipping Address</h3>

        <div class="form-group">
            <label for="street">Street </label><form:input path="cart.customer.shippingAddress.streetName" id="street" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="aptn">Apartment Number </label><form:input path="cart.customer.shippingAddress.aptNumber" id="aptn" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="city">City </label><form:input path="cart.customer.shippingAddress.city" id="city" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="State">State </label><form:input path="cart.customer.shippingAddress.state" id="state" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="cap">CAP </label><form:input path="cart.customer.shippingAddress.cap" id="cap" class="form-Control"/>
        </div>

        <input type="hidden" name="_flowExecutionKey"/>

        <br><br>
        <button class="btn btn-default" name="_eventId_backToCollectCustomerInfo">Back</button>
        <input type="submit" value="Next" class="btn btn-default" name="_eventId_shippingDetailCollected"/>
        <button class="btn btn-default" name="_eventId_cancel">Cancel</button>

    </form:form>
    </div>

<div class="container"
        <%@include file="/WEB-INF/views/template/footer.jsp" %>
</div>