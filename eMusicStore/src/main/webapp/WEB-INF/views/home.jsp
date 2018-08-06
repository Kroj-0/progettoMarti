<%@include file="/WEB-INF/views/template/header.jsp" %>



<!-- Carousel
================================================== -->
<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner" role="listbox">
        <div class="item active">
            <img class="first-slide home-image"
                 src="<c:url value="/resources/images/vet1.jpg" />"
                 alt="First slide">

            <div class="container">
                <div class="carousel-caption">
                    <h1>Welcome to WestEnd Music Store</h1>

                    <p>Here you can browse and buy Instruments, Records and music related Accessories. Order Now for
                        Your Amazing New Kit!</p>

                </div>
            </div>
        </div>
        <div class="item">
            <img class="second-slide home-image"
                 src="<c:url value="/resources/images/vet2.jpg" />"
                 alt="Second slide">

            <div class="container">
                <div class="carousel-caption">


                </div>
            </div>
        </div>

        <div class="item">
            <a href="<c:url value="/product/promo"/>">
            <img class="third-slide home-image"
                 src="<c:url value="/resources/images/vet3.jpg" />"
                 alt="Third slide">
            </a>
            <div class="container">
                <div class="carousel-caption">

                </div>
            </div>
        </div>

    </div>
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>
<!-- /.carousel -->


<!-- Marketing messaging and featurettes
================================================== -->
<!-- Wrap the rest of the page in another container to center all the content. -->

<div class="container marketing">

    <!-- Three columns of text below the carousel -->
    <div class="row">
        <div class="col-lg-4">
            <img class="img-circle" src="<c:url value="/resources/images/shipping.jpg" />" alt="Generic placeholder image" width="140" height="140">
            <h2>Shipping</h2>
            <p>Fast worldwide shipping.</p>
            <%--<p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>--%>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
            <img class="img-circle" src="<c:url value="/resources/images/visa.png" />" alt="Generic placeholder image" width="140" height="140">
            <h2>Payment</h2>
            <p>We support the most popular payment methods.</p>
            <%--<p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>--%>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
            <img class="img-circle" src="<c:url value="/resources/images/faq.png" />" alt="Generic placeholder image" width="140" height="140">
            <h2>FAQ</h2>
            <p>All the help you need.</p>
            <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
        </div><!-- /.col-lg-4 -->
    </div><!-- /.row -->

    <%@include file="/WEB-INF/views/template/footer.jsp" %>

