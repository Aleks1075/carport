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

        <h2 class="text-center">Oversigt over dine oplysninger</h2>

        <table class="table table-striped">
            <thead>
            <th>Brugernavn</th>
            <th>Email</th>
            <th>Adgangskode</th>
            <th>Adresse</th>
            <th>Postnummer</th>
            <th>Tlf. nummer</th>
            </thead>

                <tr>
                    <td>${sessionScope.user.username}</td>
                    <td>${sessionScope.user.email}</td>
                    <td>${sessionScope.user.password}</td>
                    <td>${sessionScope.user.address}</td>
                    <td>${sessionScope.user.postcode}</td>
                    <td>${sessionScope.user.phoneNumber}</td>
                    <td><a href="editCustomer.jsp">Rediger</a></td>
                </tr>
        </table>

    </jsp:body>

</t:customer>