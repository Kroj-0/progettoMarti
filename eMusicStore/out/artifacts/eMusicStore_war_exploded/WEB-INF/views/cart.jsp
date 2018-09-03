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

        <section class="container" ng-controller="cartCtrl" ng-app="cartApp">
            <div  ng-init="initCartId('${cart.cartId}')" >
            <div>
                <a class="btn btn-danger pull-left" ng-click="clearCart()"><span class="glyphicon-remove-sign"></span>Clear cart</a>
                <a href="<c:url value="/order/${cart.cartId}"/>" class="btn btn-success pull-right"><span
                        class="glyphicon glyphicon-shopping-cart">Checkout</span></a>
            </div>

            <table class="table table-hover">
                <tr>
                    <th style="width: 40%">Product</th>
                    <th>Unit Price</th>
                    <th>Quantity</th>
                    <th></th>
                    <th>Total</th>
                    <th>Action</th>
                </tr>
                <tr ng-repeat="item in cart.cartItems" ng-init="initQuantity('${item.quantity}')">
                    <td>{{item.product.productName}}</td>
                    <td>{{item.product.productPrice}}</td>
                    <td>{{item.quantity}}</td>
                    <td>
                        <a class="button" ng-click="increaseQuantity(item.quantity, item.product.productId)">
                            <span class="glyphicon glyphicon-plus-sign"></span></a>
                        <a class="button" ng-click="decreaseQuantity(item.quantity, item.product.productId)">
                            <span class="glyphicon glyphicon-minus-sign"></span></a>
                    </td>
                    <td>{{item.total}}</td>
                    <td><a hfer="#" class="label label-danger" ng-click="removeFromCart(item.product.productId)">
                        <span class="glyphicon glyphicon-remove"></span>Remove</a></td>
                </tr>
                <tr>
                    <th></th>
                    <th></th>
                    <th></th>
                    <th>Total</th>
                    <th>{{calGrandTotal()}}</th>
                    <th></th>
                </tr>
            </table>
            <a href="<spring:url value="/product/productList"/>" class="btn btn-default">Continue Shopping</a>
            </div>
        </section>

    </div>
</div>


<script src="<c:url value="/resources/js/cartcontroller.js"/>"/>
<%@include file="/WEB-INF/views/template/footer.jsp" %>

