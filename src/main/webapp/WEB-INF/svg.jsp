<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:customer>
    <jsp:attribute name="header">
         Svg
    </jsp:attribute>

    <jsp:attribute name="footer">
        Svg
    </jsp:attribute>

    <jsp:body>

        <h3>Din tegning</h3>

        ${requestScope.svg}

    </jsp:body>

</t:customer>