<%--
  Created by IntelliJ IDEA.
  User: marti
  Date: 7/30/2018
  Time: 9:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <c:if test="${pageContext.request.userPrincipal.name != null}">
            <h1>My Account</h1>

            <p class="lead">Welcome: ${pageContext.request.userPrincipal.name} | <a href="<c:url
                    value="/j_spring_security_logout" />">Logout</a></p>
            </c:if>
        </div>

        <div class="container">
            <ul class="list-group">
                <li class="list-group-item clearfix">

                <a href="<c:url value="/customer/myOrders" />"
                   onclick="setCookie('user','${pageContext.request.userPrincipal.name}',1,'/')">
                <div class="row">
                    <div class="container">
                    <h3>
                       Your Orders
                    </h3>
                    <p>Here you can view your order history!</p>
                    </div>
                </div>
                </a>
                </li>
                <li class="list-group-item clearfix">
                <a href="<c:url value="/customer/myDetails" />"
                   onclick="setCookie('user','${pageContext.request.userPrincipal.name}',1,'/')">
                <div class="row">
                <div class="container">
                    <h3>
                        Your Details
                    </h3>
                    <p>Here you can view your account details!</p>
                </div>
                </div>
                </a>
                </li>
                <li class="list-group-item clearfix">
                <a href="<c:url value="/customer/myAddresses" />"

                   onclick="setCookie('user','${pageContext.request.userPrincipal.name}',1,'/')">
                <div class="row">
                    <div class="container">
                    <h3>
                        Your Addresses
                    </h3>
                    <p>Here you can view your billing and shipping addresses, and set favorites!</p>
                    </div>
                </div>
                </a>
                </li>
            </ul>
            </div>


        </div>
    <div class="container">
        <%@include file="/WEB-INF/views/template/footer.jsp" %>
    </div>
</div>
<script src="<c:url value="/resources/js/cookies.js"/> "></script>