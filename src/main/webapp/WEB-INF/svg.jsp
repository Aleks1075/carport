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
        <div class="text-center">
        <h1>Din tegning</h1>
        </div>
        <br>
        <h3>Set oppefra:</h3>
        ${requestScope.svg}
        <br>
        <h3>Set fra siden:</h3>
        ${requestScope.svgside}


        <div class="col-md center" align="center">
            <c:if test="${sessionScope.user.role.equals('Customer')}">
                <a href="customerorders" class="btn btn-primary">Tilbage til ordrer</a>
            </c:if>
            <c:if test="${sessionScope.user.role.equals('Admin')}">
                <a href="adminorders" class="btn btn-primary">Tilbage til ordrer</a>
            </c:if>
        </div>

    </jsp:body>

</t:admin>