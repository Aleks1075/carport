<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:admin>
    <jsp:attribute name="header">
         Svg
    </jsp:attribute>

    <jsp:attribute name="footer">
        Svg
    </jsp:attribute>

    <jsp:body>

        <h1>Din tegning</h1>
        <br>
        <h3>Set oppefra:</h3>
        ${requestScope.svg}
        <h3>Set fra siden:</h3>
        ${requestScope.svgside}

        <div class="col-md center" align="center">
        <a href="index.jsp" class="btn btn-primary">Tilbage til forsiden</a>
        </div>

    </jsp:body>

</t:admin>