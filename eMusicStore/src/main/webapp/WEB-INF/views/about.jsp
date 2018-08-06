<%--
  Created by IntelliJ IDEA.
  User: marti
  Date: 8/5/2018
  Time: 4:47 PM
  To change this template use File | Settings | File Templates.
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

--%>

<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>About Us</h1>

            <p>We are a humble team, passionate about helping our customers to get the best
                experience on instruments, accessory and music in all its forms.</p>
            <p>We are determined to provide the best products and services</p>
        </div>

        <div class="container">
            <img class="clearfix" src="<c:url value="/resources/images/showroom.jpg"/> "alt="showroom" style="margin-left: 5px">
        </div>
    </div>


<div class="container" style="margin-top: 20px">
    <%@include file="/WEB-INF/views/template/footer.jsp" %>
</div>
</div>



