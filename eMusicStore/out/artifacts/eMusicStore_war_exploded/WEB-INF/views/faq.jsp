<%--
  Created by IntelliJ IDEA.
  User: marti
  Date: 8/7/2018
  Time: 6:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>


<div class="container-wrapper">
    <div class="container">
    <div class="page-header">
        <h1>F.A.Q.</h1>
    </div>
    </div>
    <div class="container">
        <div class="col-md-5 col-md-offset-1">
            <h3><strong>HOW CAN I CHANGE MY SHIPPING ADDRESS?</strong></h3>
            <P>You cab choose between the ones registered into to your account. When you are checking out your order,
                the default shipping address will be displayed and you have the option to amend it if you need to.</P>
            <h3><strong>HOW CAN I ACTIVATE MY ACCOUNT?</strong></h3>
            <p>The instructions to activate your account will be sent to your email once you have submitted the registration form.
                If you did not receive this email, your email service provider’s mailing software may be blocking it.
                You can try checking your junk / spam folder or contact us at help@wemusicstore.com</p>
            <h3><strong>HOW CAN I TRACK MY ORDERS?</strong></h3>
            <p>After logging into your account, the status of your checkout history can be found under Order History. </p>
        </div>
        <div class="col-md-5">
            <h3><strong>WHAT ARE THE PAYMENT METHODS AVAILABLE?</strong></h3>
            <p>At the moment, we only accept Credit/Debit cards and Paypal payments.</p>
            <h3><strong>WHERE CAN I CHANGE MY PASSWORD, EMAIL AND PHONE NUMBER?</strong></h3>
            <p>You can view and edit your details on your account page, under the 'My details' option</p>
            <h3><strong>WHEN WILL MY ORDER BE DELIVERED?</strong></h3>
            <p>Customers should expect to receive their orders within five (5) to ten (10) working days upon payment verification.
                If you experience delays in receiving your order, contact us immediately and we will help to confirm the status of your order.</p>
        </div>
        <div class="col-md-30">
        <a href="<c:url value="/"/>" class="btn btn-default pull-left" >Back to HomePage</a>
    </div>
    </div>

</div>
<div class="container">
    <%@include file="/WEB-INF/views/template/footer.jsp" %>
</div>
