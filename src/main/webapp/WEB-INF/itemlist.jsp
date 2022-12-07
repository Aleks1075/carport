<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">

    </jsp:attribute>

    <jsp:attribute name="footer">

    </jsp:attribute>

    <jsp:body>

        <h2 class="text-center">Oversigt over alle materialer</h2>

        <table class="table table-striped">
            <thead>
            <th>ID</th>
            <th>Description</th>
            <th>Type</th>
            <th>Unit</th>
            <th>Unit price</th>
            </thead>

            <c:forEach var="material" items="${requestScope.materialList}">
                <tr>
                    <td>${material.materialId}</td>
                    <td>${material.description}</td>
                    <td>${material.type}</td>
                    <td>${material.unit}</td>
                    <td>${material.unit_price}</td>
                    <td> <button formaction="deleteitem" name="materialId" value="${material.materialId}" class="btn btn-danger">Fjern</button></td>
                </tr>
            </c:forEach>
        </table>

    </jsp:body>

</t:pagetemplate>

