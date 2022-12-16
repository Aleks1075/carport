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
        <div class="row">
        <div class="center">
            <br>
            <div class="col-md center" align="center">
            <h3>Ordre status: ${requestScope.status}</h3>
            </div>
            <table class="table">
                <thead>
                <tr>
            <th>Valgte bredde</th>
            <th>Valgte længde</th>
            <th>Samlet pris</th>
                </tr>
                </thead>
            <tr>
            <td>${requestScope.width}</td>
            <td>${requestScope.length}</td>
            <br>
            <td>${requestScope.price},-</td>
            </tr>
            </table>
            <br>

            <c:if test="${!requestScope.status.equals('Godkendt') && sessionScope.user.role.equals('Customer')}">
                <div class="col-md center" align="center">
                <h4>Når din ordre bliver godkendt af Fog, får du adgang til styklisten på denne side.</h4>
                </div>
            </c:if>
        </div>
        </div>
            <c:if test="${requestScope.status.equals('Godkendt')}">
                <div class="col-md center" align="center">
                    <br>
                    <h1 class="center">Stykliste</h1>
                    <br>
                    <div class="center">
                        <h3>Træ & Tagplader</h3>
                        <table class="table">
                            <thead>
                            <tr>
                                <th>Navn</th>
                                <th>Antal</th>
                                <th>Længde</th>
                                <th>Enhed</th>
                                <th>Beskrivelse</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="bom" items="${requestScope.bom}">
                                <c:if test="${bom.length > 0}">
                                    <tr>
                                        <td>${bom.description}</td>
                                        <td>${bom.quantity}</td>
                                        <td>${bom.length}</td>
                                        <td>${bom.unit}</td>
                                        <td>${bom.definition}</td>
                                    </tr>
                                </c:if>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <br>
                    <div class="center">
                        <h3>Beslag & Skruer</h3>
                        <table class="table">
                            <thead>
                            <tr>
                                <th>Navn</th>
                                <th>Antal</th>
                                <th>Enhed</th>
                                <th>Beskrivelse</th>
                            </tr>
                            </thead>
                            <tbody>

                            <c:forEach var="bom" items="${requestScope.bom}">
                            <c:if test="${bom.length < 1}">
                            <tr>
                                <td>${bom.description}</td>
                                <td>${bom.quantity}</td>
                                <td>${bom.unit}</td>
                                <td>${bom.definition}</td>
                            </tr>
                            </c:if>
                            </c:forEach>
                        </table>
                    </div>
                </div>
            </c:if>
            </div>
            <br>
            <div class="col-md center" align="center">
                <c:if test="${sessionScope.user.role.equals('Customer')}">
                    <a href="customerorders" class="btn btn-primary">Tilbage til ordrer</a>
                </c:if>
                <c:if test="${sessionScope.user.role.equals('Admin')}">
                    <a href="adminorders" class="btn btn-primary">Tilbage til ordrer</a>
                </c:if>
            </div>
            <br>
            <div class="center" align="center">
                <h3>Tegning</h3>
                <a href="svg" name="order_id" value="${requestScope.order.order_id}" class="btn btn-success">Se tegning</a>
            </div>
        </form>
    </jsp:body>

</t:customer>