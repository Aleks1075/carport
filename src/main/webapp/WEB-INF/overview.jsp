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
        <div class="center" align="center">


            <h1>Din ordre er registreret.</h1>

            <br>

            <h3>Din valgte Bredde: ${sessionScope.width}</h3>
            <h3>Din valgte Længde: ${sessionScope.length}</h3>

            <br>

            <h2>Pris i alt:</h2>
            <h3>${sessionScope.price},-</h3>
        </div>
        <br>
        <div class="col-md center" align="center">
            <h4>Når din ordre bliver godkendt af Fog, får du adgang til styklisten på denne side.</h4>
        </div>
        <br>
        <div class="center" align="center">
            <h3>Tegning</h3>
            <a href="svg" class="btn btn-success">Se tegning</a>
        </div>
    </jsp:body>

</t:customer>