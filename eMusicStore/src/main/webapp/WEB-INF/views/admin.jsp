<%--
  Created by IntelliJ IDEA.
  User: marti
  Date: 1/7/2018
  Time: 7:09 PM
  To change this template use File | Settings | File Templates.
--%>

<%@include file="/WEB-INF/views/template/header.jsp"%>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Administrator page</h1>

            <p class="lead">This is the administrator page!</p>
        </div>
        <div class="container">
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <h2 class="lead">
                    Welcome: ${pageContext.request.userPrincipal.name} | <a href="<c:url
                    value="/j_spring_security_logout" />">Logout</a>
                </h2>
            </c:if>
            </div>
        <div class="container">
            <ul class="list-group">
                <li class="list-group-item clearfix">

                    <a href="<c:url value="/admin/productInventory" />" />
                        <div class="row">
                            <div class="container">
                                <h3>
                                    Product Inventory
                                </h3>
                                <p>Here you can view, check and modify the product inventory!</p>
                            </div>
                        </div>
                    </a>
                </li>
                <li class="list-group-item clearfix">
                    <a href="<c:url value="/admin/users" />"/>
                        <div class="row">
                            <div class="container">
                                <h3>
                                    Customer Management
                                </h3>
                                <p>Here you can view and manage customers/users!</p>
                            </div>
                        </div>
                    </a>
                </li>
                <li class="list-group-item clearfix">
                    <a href="<c:url value="/admin/orders" />">
                        <div class="row">
                            <div class="container">
                                <h3>
                                    Orders Management
                                </h3>
                                <p>Here you can view and manage all the orders!</p>
                                <p>* If a user contacted you for a problem in his order, you can retrieve his order directly from Customer Management</p>
                            </div>
                        </div>
                    </a>
                </li>
            </ul>
        </div>
        <%@include file="/WEB-INF/views/template/footer.jsp" %>

