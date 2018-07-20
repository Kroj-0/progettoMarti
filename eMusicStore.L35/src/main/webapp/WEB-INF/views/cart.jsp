<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: marti
  Date: 7/17/2018
  Time: 7:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="container-wrapper">
    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Cart</h1>
                    <p>All the selected products</p>
                </div>
            </div>
        </section>

        <section class="container">
            <div>
                <a class="btn btn-danger pull-left"><span class="glyphicon-remove-sign"></span>Clear cart</a>
            </div>

            <table class="table table-hover">
                <tr>
                    <th>Product</th>
                    <th>Unit Price</th>
                    <th>Quantity</th>
                    <th>Total</th>
                    <th>Action</th>
                </tr>
                <tr>
                    <td>productname</td>
                    <td>productprice</td>
                    <td>productquant</td>
                    <td>producttot</td>
                    <td>act</td>
                </tr>
                <tr>
                    <th></th>
                    <th></th>
                    <th>Total</th>
                    <th>retrieveTotal</th>
                    <th></th>
                </tr>
            </table>
            <a href="<spring:url value="/productList"/>">Continue Shopping</a>
        </section>
    </div>
</div>



<%@include file="/WEB-INF/views/template/footer.jsp" %>

