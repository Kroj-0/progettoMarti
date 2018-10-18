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

        <div class="container" style="width: 900px">
            <ul class="list-group">
                <a href="<c:url value="/customer/myOrders" />">
                <li class="list-group-item clearfix">
                    <div class="col-md-4" style="margin-top: 60px">
                        <div class="container">
                        <h3>
                            Your Orders
                        </h3>
                        <p>Here you can view your order history!</p>
                        </div>
                    </div>
                    <div class="col-md-8">
                        <img src="<c:url value="/resources/images/orders.jpg"/> " style="width: 100%; height: 40%; opacity: 0.7"/>
                    </div>
                </li>
                </a>
                <a href="<c:url value="/customer/myDetails" />">
                <li class="list-group-item clearfix">
                    <div class="col-md-4" style="margin-top: 60px">
                        <div class="container">
                            <h3>
                                Your Details
                            </h3>
                            <p>Here you can view your account details!</p>
                        </div>
                    </div>
                    <div class="col-md-8">
                        <img src="<c:url value="/resources/images/account.png"/> " style="width: 100%; height: 40%; opacity: 0.7"/>
                    </div>
                </li>
                </a>
                <a href="<c:url value="/customer/myAddresses" />">
                <li class="list-group-item clearfix">
                    <div class="col-md-4" style="margin-top: 40px">
                        <div class="container">
                        <h3>
                            Your Addresses
                        </h3>
                            <p>Here you can view your billing and</p>
                            <p>shipping addresses, and set favorites!</p>
                        </div>
                    </div>
                    <div class="col-md-8">
                        <img src="<c:url value="/resources/images/address.jpg"/> " style="width: 100%; height: 40%; opacity: 0.7"/>
                    </div>
                </li>
                </a>
            </ul>
            </div>


        </div>
    <div class="container">
        <%@include file="/WEB-INF/views/template/footer.jsp" %>
    </div>
</div>
<script src="<c:url value="/resources/js/cookies.js"/> "></script>