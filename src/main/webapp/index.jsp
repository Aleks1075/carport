<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<t:pagetemplate>
    <jsp:attribute name="header">
    </jsp:attribute>

    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>

        <div class="backgroundcontainer">
            <div class="p-3 mb-2 bg-light text-dark">
                <div class="Titel" style="margin-left: auto; margin-right: auto; text-align: center;">
                    <h2>Velkommen til FOG</h2>
                    <div class="info" style="font-size: 20px; font-weight: lighter">
                        <br>
                        <p> Her hos FOG laver vi din drømme carport til en god pris!</p>
                        <p>Med et særligt program kan vi hurtigt beregne pris og udskrive en skitsetegning på en carport,
                        der tilpasses dine ønsker og behov. </p>
                    </div>
                </div>
            </div>
        </div>

        <c:if test="${sessionScope.user == null}">
            <div class="backgroundcontainer">
                <div class="Titel" style="margin-left: auto; margin-right: auto; text-align: center;">
                    <div class="info" style="font-size: 20px; font-weight: lighter">
                        <br>
                        <p> Du skal være logget ind for at kunne bestille.</p>
                        <p> Du kan logge ind her: <a href="login.jsp">Log ind</a></p>
                    </div>
                </div>
            </div>
        </c:if>
        <div id="carouselExampleSlidesOnly" class="carousel slide" data-bs-ride="carousel">
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="${pageContext.request.contextPath}/images/billede1.png" class="d-block mx-auto" alt="...">
                </div>
                <div class="carousel-item">
                    <img src="${pageContext.request.contextPath}/images/billede2.png" class="d-block mx-auto" alt="...">
                </div>
                <div class="carousel-item">
                    <img src="${pageContext.request.contextPath}/images/billede3.png" class="d-block mx-auto" alt="...">
                </div>
            </div>
        </div>

    </jsp:body>
</t:pagetemplate>
