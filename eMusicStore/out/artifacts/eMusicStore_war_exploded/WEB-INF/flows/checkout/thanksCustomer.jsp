<%--
  Created by IntelliJ IDEA.
  User: marti
  Date: 7/27/2018
  Time: 12:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="container-wrapper">
    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Thanks for your order!</h1>
                    <P>Click below to confirm you order, and you'll recieve confirmation email in aprox. 2 minutes.
                        Your order will be shipped in two business days. Follow your order progress in "My orders" section of your account</P>
                </div>
            </div>
        </section>

        <section class="container" >
            <p>
                <a href="<spring:url value="/checkout-ended"/>" class="btn btn-default">OK, Confirm</a>
            </p>
        </section>

    </div>
</div>



<%@include file="/WEB-INF/views/template/footer.jsp" %>


