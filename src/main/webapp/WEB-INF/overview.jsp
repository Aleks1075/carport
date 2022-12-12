<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:customer>
    <jsp:attribute name="header">
         Byg din carport
    </jsp:attribute>

    <jsp:attribute name="footer">
        Logged in area
    </jsp:attribute>

    <jsp:body>

        <div class="row">

        </div>
        <div class="center">


            <h1>Din ordre er registreret.</h1>

            <br>

            <h3>Din valgte Bredde: ${sessionScope.width}</h3>
            <h3>Din valgte Længde: ${sessionScope.length}</h3>

            <br>

            <h2>Pris i alt:</h2>
            <h3>${sessionScope.price},-</h3>
        </div>
        <br>

<%--        <a href="svg">Se tegning</a>--%>

        <h4>Se tegning</h4>
        <h5>${sessionScope.svg}</h5>


    </jsp:body>

</t:customer>