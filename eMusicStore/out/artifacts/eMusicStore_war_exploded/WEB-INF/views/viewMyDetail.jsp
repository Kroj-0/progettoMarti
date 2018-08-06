<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: marti
  Date: 7/31/2018
  Time: 12:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="container" style="margin-top: 80px" >
    <div class="container">
        <div class="container">
            <div class="col-md-30">
                <a href="<c:url value="/customer"/>" class="btn btn-default pull-left" >Back to My Account</a>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-md-6" style="margin-left: 255px;margin-right: 255px">

                    <div class="text-center">
                        <h1>Your Access Details</h1>
                    </div>
                    <div class="row">
                        <div class="fill-parent">
                            <ul class="list-group">
                                <li class="list-group-item clearfix">
                                    Name:<br><br>
                                    <h6><strong>${user.customerName}</strong></h6><br>
                                    Surname: <br><br>
                                    <h6><strong>${user.customerSurname}</strong></h6>
                                    <a href="<c:url value="/customer/myDetails/editName"/> " ><span class="pull-right"><span class="btn btn-default"
                                            >Modify</span></span></a>
                                </li>
                                <li class="list-group-item clearfix">
                                    <strong>Email:</strong><br>
                                    <p>${user.customerEmail}</p><br>
                                    <strong>Phone:</strong> <br>
                                    <p>${user.customerPhone}</p><br>
                                    <a href="<c:url value="/customer/myDetails/editPhone&Email"/> " ><span class="pull-right"><span class="btn btn-default"
                                             >Modify</span></span></a>

                                </li>
                                <li class="list-group-item clearfix">
                                    Password: <br><br>
                                    <p>**************</p>
                                    <a href="<c:url value="/customer/myDetails/editPassword"/> " ><span class="pull-right"><span class="btn btn-default"
                                             >Modify</span></span></a>
                                </li>
                            </ul>

                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div>
            <%@include file="/WEB-INF/views/template/footer.jsp" %>
        </div>
    </div>

</div>


