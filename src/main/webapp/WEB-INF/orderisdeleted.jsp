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

        <div class="col-md center" align="center">
        <h1>Ordren er nu slettet fra systemet</h1>
            <c:if test="${sessionScope.user.role.equals('Admin')}">
                <a href="redirectadmin" class="btn btn-primary">Tilbage til forsiden</a>
            </c:if>
        </div>

    </jsp:body>

</t:admin>

