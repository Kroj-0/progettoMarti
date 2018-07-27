<%--
  Created by IntelliJ IDEA.
  User: marti
  Date: 7/26/2018
  Time: 4:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Register Customer</h1>

            <p class="lead">Please fill in your information below:</p>
        </div>

        <h3>Basic Info</h3>
        <form:form action="${pageContext.request.contextPath}/register" method="post"
                   commandName="customer">
        <div class="form-group">
            <label for="name">Name</label> <form:errors path="customerName" cssStyle="color: #ff0000;" />
            <form:input path="customerName" id="name" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="surname">Surname</label> <form:errors path="customerSurname" cssStyle="color: #ff0000;" />
            <form:input path="customerSurname" id="surname" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="email">Email</label> <form:errors path="customerEmail" cssStyle="color: #ff0000;" />
            <span style="color: red">  ${emailMsg}</span><form:input path="customerEmail" id="email" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="phone">Phone</label>
            <form:input path="customerPhone" id="phone" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="username">Username</label> <form:errors path="username" cssStyle="color: #ff0000;" />
            <span style="color: red">  ${usernameMsg}</span><form:input path="username" id="username" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="password">Password</label> <form:errors path="password" cssStyle="color: #ff0000;" />
            <form:password minlength="8" placeholder="min. 8 char." path="password" id="password" class="form-Control"/>
        </div>

        <h3>Billing Address</h3>

        <div class="form-group">
            <label for="street">Street </label><form:input path="billingAddress.streetName" id="street" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="aptn">Apartment Number </label><form:input path="billingAddress.aptNumber" id="aptn" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="city">City </label><form:input path="billingAddress.city" id="city" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="State">State </label><form:input path="billingAddress.state" id="state" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="cap">CAP </label><form:input path="billingAddress.cap" id="cap" class="form-Control"/>
        </div>

        <h3>Shipping Address</h3>

        <div class="form-group">
            <label for="street">Street </label><form:input path="shippingAddress.streetName" id="street" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="aptn">Apartment Number </label><form:input path="shippingAddress.aptNumber" id="aptn" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="city">City </label><form:input path="shippingAddress.city" id="city" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="State">State </label><form:input path="shippingAddress.state" id="state" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="cap">CAP </label><form:input path="shippingAddress.cap" id="cap" class="form-Control"/>
        </div>

        <br><br>
        <input type="submit" value="submit" class="btn btn-default">
        <a href="<c:url value="/" />" class="btn btn-default">Cancel</a>
        </form:form>


        <%@include file="/WEB-INF/views/template/footer.jsp" %>
