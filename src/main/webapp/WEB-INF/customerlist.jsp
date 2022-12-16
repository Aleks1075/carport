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

        <form action="deletecustomer" method="post">
        <h2 class="text-center">Oversigt over alle kunder</h2>

        <table class="table table-striped">
            <thead>
            <th>Brugernavn</th>
            <th>Email</th>
            <th>Adresse</th>
            <th>Postnummer</th>
            <th>Tlf. nummer</th>
            <th></th>
            </thead>

            <c:forEach var="customer" items="${sessionScope.customerList}">
                <tr>
                    <td>${customer.username}</td>
                    <td>${customer.email}</td>
                    <td>${customer.address}</td>
                    <td>${customer.postcode}</td>
                    <td>${customer.phoneNumber}</td>
                    <form action="deletecustomer" method="post">
                    <td>
                    <button type="submit" class="btn btn-danger" name="username" value="${customer.username}">Slet</button>
                    </td>
                    </form>
                </tr>
            </c:forEach>
        </table>
        </form>
    </jsp:body>

</t:admin>

