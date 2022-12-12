<%@tag description="Overall Page template" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>

<!DOCTYPE html>
<html lang="da">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><jsp:invoke fragment="header"/></title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<header>
    <nav class="navbar navbar-expand-lg navbar-light" style="background-color: #193f76;">
        <div class="container">
            <a class="navbar-brand" href="index.jsp">
                <img src="${pageContext.request.contextPath}/images/logo.png" width="100px;" class="img-fluid"/>
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
                    aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse justify-content-end" id="navbarNavAltMarkup">
                <div class="navbar-nav">
                    <a class="nav-link disabled" style="color: white" href="#">${sessionScope.user.email}</a>
                    <a class="nav-item nav-link" style="color: white" href="${pageContext.request.contextPath}/adminorders">Ordrer</a>
                    <a class="nav-item nav-link" style="color: white" href="${pageContext.request.contextPath}/itemlist">Materialer</a>
                    <a class="nav-item nav-link" style="color: white" href="${pageContext.request.contextPath}/customerlist">Kunder</a>
                    <a class="nav-item nav-link" style="color: white" href="${pageContext.request.contextPath}/createadmin.jsp">Opret ny admin</a>
                    <c:if test="${sessionScope.user == null }">
                        <a class="nav-item nav-link" style="color: white" href="${pageContext.request.contextPath}/login.jsp">Log ind</a>
                    </c:if>
                    <c:if test="${sessionScope.user != null }">
                        <a class="nav-item nav-link" style="color: white" href="${pageContext.request.contextPath}/logout">Log ud</a>
                    </c:if>
                </div>
            </div>
        </div>
    </nav>
</header>

<div id="body" class="container mt-4" style="min-height: 400px;">
    <h1><jsp:invoke fragment="header"/></h1>
    <jsp:doBody/>
</div>

<!-- Footer -->
<footer class="text-center text-black" style="background-color: rgba(128, 128, 128, 5%); margin: 25px 50px;">
    <div class="container" style="padding: 20px 0px;">
    <hr/>
    <div class="row mt-4">
        <div class="col">
            <a href="mailto: fog@carport.dk">Send os en email</a><br/>
            <a href="tel: 93601903">Ring til os</a>
        </div>
        <div class="col">
            <p>Johannes Fog A/S<br>
                Firskovvej 20 <br>
                2800 Lyngby</p>
        </div>
        <div class="col">
            <p>CVR-nr. 16314439</p>
        </div>
    </div>

</div>

</div>
</footer>

<!-- Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>

</body>
</html>