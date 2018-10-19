<%--
  Created by IntelliJ IDEA.
  User: marti
  Date: 10/18/2018
  Time: 4:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Submit your ticket to support</h1>
            <p>We'll get back to you in 24h/48h!</p>
        </div>
    </div>
    <div class="container">
        <form:form action="${pageContext.request.contextPath}/customer/myOrders/support" method="post" id="support"
                 commandName="mail" enctype="multipart/form-data">
            <form:hidden path="from" id="from" class="form-Control" value="${order.customer.customerEmail}"/>
            <form:hidden path="subject" id="subject" class="form-Control" value="${mail.subject}"/>
            <div class="col-sm-offset-2">
                <div class="form-group" style="width: 800px;height: 400px">
                    <label for="description">Describe your issue:</label>
                    <form:textarea id="description" path="text" class="form-Control" rows="20" cols="30"/>
                    <input type="submit" value="submit" class="btn btn-default pull-right">
                </div>
            </div>
        </form:form>
        </div>
    </div>
</div>
<div class="container">
    <%@include file="/WEB-INF/views/template/footer.jsp" %>
</div>
<%--<script>--%>
    <%--var form=document.getElementById("support");--%>
    <%--form.addEventListener("submit",function () {--%>
        <%--var text=document.getElementById("description").value;--%>
        <%--var info=document.getElementById("info").value;--%>
        <%--info=text+info;--%>
    <%--},true);--%>
<%--</script>--%>
