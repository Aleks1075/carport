<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:customer>
    <jsp:attribute name="header">

    </jsp:attribute>

    <jsp:attribute name="footer">

    </jsp:attribute>

    <jsp:body>
        <form method="post">
            <div class="Titel" style="margin-left: auto; margin-right: auto; text-align: center;">
            <h2>Ordreoversigt</h2>
                <table class="table table-striped">
                <thead>
                <tr>
                    <th>Ordre ID</th>
                    <th>Dato og tid</th>
                    <th>Pris</th>
                    <th>Status</th>
                    <th>Bestilling</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="order" items="${requestScope.order}">
                    <tr>
                        <td>${order.order_id}</td>
                        <td>${order.order_date}</td>
                        <td>${order.price}</td>
                        <td>${order.order_status}</td>
                        <c:if test="${sessionScope.user.role.equals('Customer') && order.order_status.equals('Godkendt')}">
                            <td><a href="customerorderscontent?order_id=${order.order_id}"class="btn btn-success">Betal og gennemfør ordren</a></td>
                        </c:if>
                        <c:if test="${sessionScope.user.role.equals('Customer') && order.order_status.equals('Afventer')}">
                            <td><a href="customerorderscontent?order_id=${order.order_id}"class="btn btn-primary">Afventer godkendelse</a></td>
                        </c:if>
                        <c:if test="${sessionScope.user.role.equals('Admin') && order.order_status.equals('Afventer')}">
                        <td><a href="customerorderscontent?order_id=${order.order_id}" class="btn btn-primary">Se bestilling</a></td>
                        </c:if>
                        <c:if test="${sessionScope.user.role.equals('Admin') && order.order_status.equals('Godkendt')}">
                            <td><a href="customerorderscontent?order_id=${order.order_id}" class="btn btn-success">Se bestilling</a></td>
                        </c:if>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            </div>
        </form>

    </jsp:body>

</t:customer>