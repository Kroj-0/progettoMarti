<%--
  Created by IntelliJ IDEA.
  User: marti
  Date: 8/3/2018
  Time: 10:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="/WEB-INF/views/template/header.jsp"%>


<div class="container-wrapper">
    <div class="container">
        <div class="jumbotron">
            <h1>Product Categories</h1>

            <p class="lead">Explore categories and products!</p>
        </div>

        <div class="container">
            <div class="row">
            <ul class="list-group">
                <a href="<c:url value="/product/cat?category=instrument" />" >
                <li class="list-group-item clearfix" style="width: 97.45%; height: 200px; padding: 0px">
                    <img src="<c:url value="/resources/images/instrument_header.jpg"/> " style="width: 100%; height: 100%; opacity: 0.7"/>
                </li>
                </a>
                    <div class="col-md-4 col-md-offset-1" style="width: 300px">
                        <li class="list-group-item clearfix" style="width: 300px; height: 200px; padding: 0px">
                            <a href="<c:url value="/product/subcat?subcategory=guitar&bass" />" >
                            <div class="row">
                                <div class="container" style="width: 300px; height: 150px;padding: 0px">
                                    <img src="<c:url value="/resources/images/guitar_header.jpg"/> " style="width: 100%; height: 100%; opacity: 0.7"/>
                                </div>
                                <div class="container" style="width: 300px; height:50px;padding: 0px">
                                    <h4 style="text-align: center">Guitar&Bass</h4>
                                </div>
                            </div>
                            </a>
                        </li>
                        <li class="list-group-item clearfix" style="width: 300px; height: 200px;padding: 0px">
                            <a href="<c:url value="/product/subcat?subcategory=drums" />">
                            <div class="row">
                                <div class="container" style="width: 300px; height: 150px;padding: 0px">
                                    <img src="<c:url value="/resources/images/drum_header.jpeg"/> " style="width: 100%; height: 100%; opacity: 0.7"/>
                                </div>
                                <div class="container" style="width: 300px; height:50px;padding: 0px">
                                    <h4 style="text-align: center">Drums</h4>
                                </div>
                            </div>
                            </a>
                        </li>
                    </div>
                <div class="col-md-4" style="width: 300px">
                    <li class="list-group-item clearfix" style="width: 300px; height: 200px;padding: 0px">

                        <a href="<c:url value="/product/subcat?subcategory=keyboards&pianos" />" >
                        <div class="row">
                            <div class="container" style="width: 300px; height: 150px;padding: 0px">
                                <img src="<c:url value="/resources/images/keyboards_header.jpg"/> " style="width: 100%; height: 100%; opacity: 0.7"/>
                            </div>
                            <div class="container" style="width: 300px; height:50px;padding: 0px">
                                <h4 style="text-align: center">Keyboards&Pianos</h4>
                            </div>
                        </div>
                        </a>
                    </li>
                    <li class="list-group-item clearfix" style="width: 300px; height: 200px;padding: 0px">

                        <a href="<c:url value="/product/subcat?subcategory=strings" />" >
                        <div class="row">
                            <div class="container" style="width: 300px; height: 150px;padding: 0px">
                                <img src="<c:url value="/resources/images/strings_header.jpg"/> " style="width: 100%; height: 100%; opacity: 0.7"/>
                            </div>
                            <div class="container" style="width: 300px; height:50px;padding: 0px">
                                <h4 style="text-align: center">Strings</h4>
                            </div>
                        </div>
                        </a>
                    </li>
                </div>
                <div class="col-md-4" style="width: 300px">
                    <li class="list-group-item clearfix" style="width: 300px; height: 200px;padding: 0px">

                        <a href="<c:url value="/product/subcat?subcategory=winds" />" >
                        <div class="row">
                            <div class="container" style="width: 300px; height: 150px;padding: 0px">
                                <img src="<c:url value="/resources/images/winds_header.jpeg"/> " style="width: 100%; height: 100%; opacity: 0.7"/>
                            </div>
                            <div class="container" style="width: 300px; height:50px;padding: 0px">
                                <h4 style="text-align: center">Winds</h4>
                            </div>
                        </div>
                        </a>
                    </li>
                    <li class="list-group-item clearfix" style="width: 300px; height: 200px;padding: 0px">

                        <a href="<c:url value="/product/subcat?subcategory=djsets" />" >
                        <div class="row">
                            <div class="container" style="width: 300px; height: 150px;padding: 0px">
                                <img src="<c:url value="/resources/images/djset_header.jpeg"/> " style="width: 100%; height: 100%; opacity: 0.7"/>
                            </div>
                            <div class="container" style="width: 300px; height:50px;padding: 0px">
                                <h4 style="text-align: center">Dj Sets</h4>
                            </div>
                        </div>
                        </a>
                    </li>
                </div>
            </ul>
            </div>
            <div class="row">
                <ul class="list-group">
                    <a href="<c:url value="/product/cat?category=accessory" />" >
                    <li class="list-group-item clearfix" style="width: 97.45%; height: 200px; padding: 0px">
                        <img src="<c:url value="/resources/images/accessory_header.jpg"/> " style="width: 100%; height: 100%; opacity: 0.7"/>
                    </li>
                    </a>
                    <div class="col-md-4 col-md-offset-1" style="width: 300px">
                        <li class="list-group-item clearfix" style="width: 300px; height: 200px; padding: 0px">
                            <a href="<c:url value="/product/subcat?subcategory=cables" />" >
                                <div class="row">
                                    <div class="container" style="width: 300px; height: 150px;padding: 0px">
                                        <img src="<c:url value="/resources/images/cables_header.gif"/> " style="width: 100%; height: 100%; opacity: 0.7"/>
                                    </div>
                                    <div class="container" style="width: 300px; height:50px;padding: 0px">
                                        <h4 style="text-align: center">Cables</h4>
                                    </div>
                            </div>
                            </a>
                        </li>
                        <li class="list-group-item clearfix" style="width: 300px; height: 200px; padding: 0px">
                            <a href="<c:url value="/product/subcat?subcategory=headphones" />" >
                                <div class="row">
                                    <div class="container" style="width: 300px; height: 150px;padding: 0px">
                                        <img src="<c:url value="/resources/images/headphones_header.jpg"/> " style="width: 100%; height: 100%; opacity: 0.7"/>
                                    </div>
                                    <div class="container" style="width: 300px; height:50px;padding: 0px">
                                        <h4 style="text-align: center">Headphones</h4>
                                    </div>
                                </div>
                            </a>
                        </li>
                    </div>
                    <div class="col-md-4" style="width: 300px">
                        <li class="list-group-item clearfix" style="width: 300px; height: 200px; padding: 0px">

                            <a href="<c:url value="/product/subcat?subcategory=amplifiers" />" >
                                <div class="row">
                                    <div class="container" style="width: 300px; height: 150px;padding: 0px">
                                        <img src="<c:url value="/resources/images/amplifiers_header.jpg"/> " style="width: 100%; height: 100%; opacity: 0.7"/>
                                    </div>
                                    <div class="container" style="width: 300px; height:50px;padding: 0px">
                                        <h4 style="text-align: center">Amplifiers</h4>
                                    </div>
                            </div>
                            </a>
                        </li>
                        <li class="list-group-item clearfix" style="width: 300px; height: 200px; padding: 0px">

                            <a href="<c:url value="/product/subcat?subcategory=picks&capos" />" >
                                <div class="row">
                                    <div class="container" style="width: 300px; height: 150px;padding: 0px">
                                        <img src="<c:url value="/resources/images/picks_header.jpg"/> " style="width: 100%; height: 100%; opacity: 0.7"/>
                                    </div>
                                    <div class="container" style="width: 300px; height:50px;padding: 0px">
                                        <h4 style="text-align: center">Picks&Capos</h4>
                                    </div>
                            </div>
                            </a>
                        </li>
                    </div>
                    <div class="col-md-4" style="width: 300px">
                        <li class="list-group-item clearfix" style="width: 300px; height: 200px; padding: 0px">

                            <a href="<c:url value="/product/subcat?subcategory=instrument_strings" />" >
                                <div class="row">
                                    <div class="container" style="width: 300px; height: 150px;padding: 0px">
                                        <img src="<c:url value="/resources/images/instr_strings_header.jpg"/> " style="width: 100%; height: 100%; opacity: 0.7"/>
                                    </div>
                                    <div class="container" style="width: 300px; height:50px;padding: 0px">
                                        <h4 style="text-align: center">Instrument Strings</h4>
                                    </div>
                            </div>
                            </a>
                        </li>
                        <li class="list-group-item clearfix" style="width: 300px; height: 200px; padding: 0px">

                            <a href="<c:url value="/product/subcat?subcategory=misc" />" >
                                <div class="row">
                                    <div class="container" style="width: 300px; height: 150px;padding: 0px">
                                        <img src="<c:url value="/resources/images/miscellaneous_header.jpg"/> " style="width: 100%; height: 100%; opacity: 0.7"/>
                                    </div>
                                    <div class="container" style="width: 300px; height:50px;padding: 0px">
                                        <h4 style="text-align: center">Miscellaneous</h4>
                                    </div>
                            </div>
                            </a>
                        </li>
                    </div>
                </ul>
            </div>
            <a href="<c:url value="/product/cat?category=records" />" >
            <div class="row" style=>
                <li class="list-group-item clearfix" style="width: 97.45%; height: 200px; padding: 0px">
                    <img src="<c:url value="/resources/images/records_header.jpeg"/> " style="width: 100%; height: 100%; opacity: 0.7"/>
                </li>
            </div></a>
        </div>
    </div>
    <div class="container" style="margin-top: 50px">
        <%@include file="/WEB-INF/views/template/footer.jsp" %>
    </div>
</div>



