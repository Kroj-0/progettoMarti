<%--
  Created by IntelliJ IDEA.
  User: marti
  Date: 7/27/2018
  Time: 3:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Customer Management Page</h1>

            <p class="lead">This is the customer management page</p>
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">

                <th>Username</th>
                <th>Name</th>
                <th>Surname</th>
                <th>Email</th>
                <th>Phone number</th>
                <th>Enabled</th>
                <th></th>

                <th></th>
            </tr>
            </thead>
            <c:forEach items="${customerList}" var="customer">
                <tr>
                    <td>${customer.username}</td>
                    <td>${customer.customerName}</td>
                    <td>${customer.customerSurname}</td>
                    <td>${customer.customerEmail}</td>
                    <td>${customer.customerPhone}</td>
                    <td>${customer.enabled}</td>
                    <td><a href="<spring:url value="/product/viewProduct/${product.productId}" />"
                    ><span class="glyphicon glyphicon-info-sign"></span></a></td>
                </tr>
            </c:forEach>
        </table>

        <%@include file="/WEB-INF/views/template/footer.jsp" %>
