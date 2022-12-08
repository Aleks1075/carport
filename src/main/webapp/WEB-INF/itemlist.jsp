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

        <h2 class="text-center">Oversigt over alle materialer</h2>

        <h3 class="mt-3">Træ & tagplader</h3>
        <table class="table table-striped">
            <thead>
            <th>ID</th>
            <th>Beskrivelse</th>
            <th>Type</th>
            <th>Enhed</th>
            <th>Pris per enhed</th>
            <th></th>
            </thead>

            <c:forEach var="wood" items="${requestScope.woodList}">
                <tr>
                    <td>${wood.materialId}</td>
                    <td>${wood.description}</td>
                    <td>${wood.type}</td>
                    <td>${wood.unit}</td>
                    <td>${wood.unit_price}</td>
                    <td> <button formaction="deleteitem" name="materialId" value="${material.materialId}" class="btn btn-danger">Fjern</button></td>
                </tr>
            </c:forEach>
        </table>

        <br>

        <h3 class="mt-3">Beslag & skruer</h3>
        <table class="table table-striped">
            <thead>
            <th>ID</th>
            <th>Beskrivelse</th>
            <th>Type</th>
            <th>Enhed</th>
            <th>Pris per enhed</th>
            <th></th>
            </thead>

            <c:forEach var="accessory" items="${requestScope.accessoryList}">
                <tr>
                    <td>${accessory.materialId}</td>
                    <td>${accessory.description}</td>
                    <td>${accessory.type}</td>
                    <td>${accessory.unit}</td>
                    <td>${accessory.unit_price}</td>
                    <td> <button formaction="deleteitem" name="materialId" value="${material.materialId}" class="btn btn-danger">Fjern</button></td>
                </tr>
            </c:forEach>
        </table>

    </jsp:body>

</t:admin>

