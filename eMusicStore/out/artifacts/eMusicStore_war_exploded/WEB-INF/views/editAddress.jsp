<%--
  Created by IntelliJ IDEA.
  User: marti
  Date: 8/2/2018
  Time: 7:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Register Customer</h1>

            <p class="lead">Please fill in your information below:</p>
        </div>
        <form:form action="${pageContext.request.contextPath}/customer/myAddresses/editAddress" method="post"
                   commandName="sadr">
            <h3>Shipping Address</h3>

            <div class="form-group">
                <label for="street">Street </label><form:input path="streetName" id="street" class="form-Control" value="${sadr.streetName}"/>
            </div>
            <div class="form-group">
                <label for="aptn">Apartment Number </label><form:input path="aptNumber" id="aptn" class="form-Control" value="${sadr.aptNumber}"/>
            </div>
            <div class="form-group">
                <label for="city">City </label><form:input path="city" id="city" class="form-Control" value="${sadr.city}"/>
            </div>
            <div class="form-group">
                <label for="State">State </label><form:input path="state" id="state" class="form-Control" value="${sadr.state}"/>
            </div>
            <div class="form-group">
                <label for="cap">CAP </label><form:input path="cap" id="cap" class="form-Control" value="${sadr.cap}"/>
            </div>
            <form:hidden path="shippingAddressId" value="${sadr.shippingAddressId}"/>
            <c:out value="${sadr.customer.customerId}"/>
            <br><br>
            <input type="submit" value="Submit" class="btn btn-default">
            <a href="<c:url value="/customer/myAddresses" />" class="btn btn-default">Cancel</a>
        </form:form>
        <div>
            <%@include file="/WEB-INF/views/template/footer.jsp" %>
        </div>
    </div>

</div>
