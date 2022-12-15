<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:admin>
    <jsp:attribute name="header">

    </jsp:attribute>

    <jsp:attribute name="footer">

    </jsp:attribute>

    <jsp:body>

        <form action="adminorders" method="post">
            <div class="row">

                <h1 class="center">Alle ordrer</h1>

                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">Kundenavn</th>
                        <th scope="col">Ordre ID</th>
                        <th scope="col">Dato og tid</th>
                        <th scope="col">Pris</th>
                        <th scope="col">Bestilling</th>
                        <th scope="col">Status</th>
                        <th scope="col">Opdater Status</th>
                        <th scope="col">Fjern</th>
                    </tr>
                    </thead>
                    <c:forEach var="order" items="${requestScope.orderlist}">
                        <tr>
                            <td>${order.username}</td>
                            <td>${order.order_id}</td>
                            <td>${order.order_date}</td>
                            <td>${order.price}</td>
                            <td>
                            <a href="customerorderscontent?order_id=${order.order_id}" class="btn btn-primary">Se bestilling</a>
                            </td>
                            <td>${order.order_status}</td>
                            <form action="updatestatus" method="post">
                            <td>
                                <c:if test="${!order.order_status.equals('Godkendt')}">
                                    <button type="submit" class="btn btn-success" name="order_id" value="${order.order_id}">Bekræft</button>
                                </c:if>
                                <c:if test="${order.order_status.equals('Godkendt')}">
                                        Bekræftet
                                </c:if>
                            </td>
                            </form>
                            <form action="deleteorder" method="post">
                            <td>
                                <button type="submit" class="btn btn-danger" name="order_id" value="${order.order_id}">Fjern</button>
                            </td>
                            </form>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </form>

    </jsp:body>

</t:admin>