<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marti
  Date: 8/2/2018
  Time: 5:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Your Addresses </h1>
        </div>
        <div class="row" style="margin-bottom: 20px;border: 2px green">
            <c:if test="${msg != null}">
            <div class="col-md-1" style="height: 55px">
                <div class="glyphicon glyphicon-ok" style="font-size: 50px"></div>
            </div>
            <div class="col-md-6 " style="height: 55px; text-align: middle">
                <h4>${msg}</h4>
            </div>
            </c:if>
        </div>

        <div class="container" style="margin-bottom: 10px">
            <div class="col-md-12">
                <a href="<c:url value="/customer"/>" class="btn btn-default pull-left" >Back to My Account</a>
            </div>
        </div>
        <div class="container">
            <div class="fill-parent">
                <div class="col-md-4">
                    <div class="row" style="margin-top: 20px">
                        <h3>Billing Information</h3>
                    </div>
                    <br><br><br>
                    <h4>Street:${user.shippingAddress.streetName}</h4>
                    <p></p><br>
                    <h4>Apt.Number:${user.shippingAddress.aptNumber}</h4>
                    <p></p><br>
                    <h4>City:${user.shippingAddress.city}</h4>
                    <p></p><br>
                    <h4>State:${user.shippingAddress.state}</h4>
                    <p></p><br>
                    <h4>Cap:${user.shippingAddress.cap}</h4>
                    <p></p><br>
                </div>
                <div class="col-md-2">
                </div>
                <li class="col-md-6" >
                    <div class="row">
                        <h3>Shipping Addresses</h3>
                    </div>
                    <ul class="list-group">
                        <c:forEach items="${addresses}" var="adr">
                        <c:choose>
                            <c:when test="${adr.shippingAddressId!=user.shippingAddress.shippingAddressId}">
                            <li class="list-group-item clearfix" style="border-radius: 10px; margin-top: 10px">
                                <strong>${user.customerName} ${user.customerSurname}</strong>
                                <p>${adr.streetName}</p>
                                <p>${adr.city}, ${adr.state} ${adr.cap}</p>
                                <div class="row">
                                    <ul class="list-inline pull-right" style="margin-right: 10px">
                                        <li class="list-inline"><a href="<c:url value="/customer/myAddresses/editAddress/${adr.shippingAddressId}"/> "style="color: inherit"> Modify</a></li>
                                        <li class="list-inline"><strong>|</strong></li>
                                        <li class="list-inline"><a href="<c:url value="/customer/myAddresses/deleteAddress/${adr.shippingAddressId}"/> "style="color: inherit">Delete</a></li>
                                        <li class="list-inline"><strong>|</strong></li>
                                        <li class="list-inline"><a href="<c:url value="/customer/myAddresses/principalAddress/${adr.shippingAddressId}"/> "style="color: inherit">Set as principal</a></li>
                                    </ul>
                                </div>
                            </li>
                            </c:when>
                            <c:otherwise>

                            <li class="list-group-item on clearfix" style="border-radius: 10px">
                                <div class="row clearfix" style="margin-left: auto">
                                    <h4>Default address</h4>
                                </div>
                                <strong>${user.customerName} ${user.customerSurname}</strong>
                                <p>${adr.streetName}</p>
                                <p>${adr.city}, ${adr.state} ${adr.cap}</p>
                                <div class="row">
                                    <ul class="list-inline pull-right" style="margin-right: 10px">
                                        <li class="list-inline"><a href="<c:url value="/customer/myAddresses/editAddress/${adr.shippingAddressId}"/> " style="color: inherit"> Modify</a></li>
                                        <li class="list-inline"><strong>|</strong></li>
                                        <li class="list-inline"><a href="<c:url value="/customer/myAddresses/deleteAddress/${adr.shippingAddressId}"/> " style="color: inherit">Delete</a></li>
                                    </ul>
                                </div>
                            </li>
                            </c:otherwise>
                        </c:choose>
                        </c:forEach>
                            <a href="<c:url value="/customer/myAddresses/addAddress"/> " style="text-decoration: none;color:inherit">
                        <li class="list-group-item clearfix" style="border: 3px dashed gray;text-align: center; font-size: 100px; border-radius: 25px;margin-top: 10px" >
                            <div class="row" >
                                <div class="glyphicon glyphicon-plus" style="margin-bottom: 7px"></div>
                            </div>
                        </li>
                            </a>
                </div>
            </div>
        </div>
        <div class="container">
            <%@include file="/WEB-INF/views/template/footer.jsp" %>
        </div>
    </div>

</div>
