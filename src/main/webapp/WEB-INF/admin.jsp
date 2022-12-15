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
        <h1>Velkommen til din profil ${sessionScope.user.username}</h1>
        </div><br>
        <div class="col-md center" align="center">
        <img src="${pageContext.request.contextPath}/images/fog.jpeg" class="img-fluid"/>
        </div>


    </jsp:body>

</t:admin>