<%--
  Created by IntelliJ IDEA.
  User: marti
  Date: 8/6/2018
  Time: 2:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Tracking Information</h1>
        </div>
    </div>
    <div class="container">
        <div clas="col-md-6 col-md-offset-3">
            <div class="row clearfix" style="margin: 30px">
                <c:set var="now" value="${order.tracking.trackingId.status}"/>
                <h4>Delivery progress:</h4>
                <c:if test="${now=='confirmed'}">
                    <div class="progress">
                        <div class="progress-bar  bg-success" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100"></div>
                    </div>
                    <h3>Tracking History</h3>
                        <h4>${trackingHst.get(0).date}</h4>
                        <h4>Order was paid, and payment was confirmed</h4>
                    </div>
                </c:if>
                <c:if test="${now=='prep4shipping'}">
                    <div class="progress">
                        <div class="progress-bar  bg-success" role="progressbar" style="width: 25%" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
                    </div>
                    <h3>Tracking History</h3>
                    <c:if test="${trackingHst.get(1)!=null}">
                    <h4><strong>${trackingHst.get(1).date}</strong>: Tracking#: ${order.tracking.trackingId.trackingId}</h4>
                        <h4>Order is being prepaired for shipping, and will soon be picked up by the courier</h4><br>
                    </c:if>
                        <h4>${trackingHst.get(0).date}</h4>
                        <h4>Order was paid, and payment was confirmed</h4>
                    </div>
                </c:if>
                <c:if test="${now=='shipped'}">
                    <div class="progress">
                        <div class="progress-bar  bg-success" role="progressbar" style="width: 50%" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
                    </div>
                    <h3>Tracking History</h3>
                    <c:if test="${trackingHst.get(2)!=null}">
                        <h4><strong>${trackingHst.get(2).date}</strong>: Tracking#: ${order.tracking.trackingId.trackingId}</h4>
                        <h4>Order has been picked up by the courier</h4><br>
                    </c:if>
                    <c:if test="${trackingHst.get(1)!=null}">
                        <h4><strong>${trackingHst.get(1).date}</strong></h4>
                        <h4>Order is being prepaired for shipping, and will soon be picked up by the courier</h4><br>
                    </c:if>
                        <h4>${trackingHst.get(0).date}</h4>
                        <h4>Order was paid, and payment was confirmed</h4>
                    </div>
                </c:if>
                <c:if test="${now=='transit'}">
                    <div class="progress">
                        <div class="progress-bar bg-success" role="progressbar" style="width: 75%" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100"></div>
                    </div>
                    <h3>Tracking History</h3>
                    <c:if test="${trackingHst.get(3)!= null}">
                        <h4><strong>${trackingHst.get(3).date}</strong>: Tracking#: ${order.tracking.trackingId.trackingId}</h4>
                        <h4>Package is in transit, see courier website for more accurate updates</h4><br>
                    </c:if>
                    <c:if test="${trackingHst.get(2)!= null}">
                        <h4><strong>${trackingHst.get(2).date}</strong></h4>
                        <h4>Order has been picked up by the courier</h4><br>
                    </c:if>
                    <c:if test="${trackingHst.get(1)!= null}">
                        <h4><strong>${trackingHst.get(1).date}</strong></h4>
                        <h4>Order is being prepaired for shipping, and will soon be picked up by the courier</h4><br>
                    </c:if>
                        <h4>${trackingHst.get(0).date}</h4>
                        <h4>Order was paid, and payment was confirmed</h4>
                    </div>
                </c:if>
                <c:if test="${now=='received'}">
                    <div class="progress">
                        <div class="progress-bar bg-success" role="progressbar" style="width: 100%" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100"></div>
                    </div>
                    <h3>Tracking History</h3>
                    <c:if test="${trackingHst.get(4)!=null}">
                        <h4><strong>${trackingHst.get(4).date}</strong></h4>
                        <h4>Package has been delivered!</h4><br>
                    </c:if>
                    <c:if test="${trackingHst.get(3)!=null}">
                        <h4><strong>${trackingHst.get(3).date}</strong></h4>
                        <h4>Package is in transit, see courier website for more accurate updates</h4><br>
                    </c:if>
                    <c:if test="${trackingHst.get(2)!=null}">
                        <h4><strong>${trackingHst.get(2).date}</strong></h4>
                        <h4>Order has been picked up by the courier</h4><br>
                    </c:if>
                    <c:if test="${trackingHst.get(1)!=null}">
                        <h4><strong>${trackingHst.get(1).date}</strong></h4>
                        <h4>Order is being prepaired for shipping, and will soon be picked up by the courier</h4><br>
                    </c:if>
                        <h4>${trackingHst.get(0).date}</h4>
                        <h4>Order was paid, and payment was confirmed</h4>
                    </div>
                </c:if>

            </div>
        </div>
    </div>
</div>


<div>
    <%@include file="/WEB-INF/views/template/footer.jsp" %></div>