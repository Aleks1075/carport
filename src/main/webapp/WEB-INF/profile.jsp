<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:customer>
    <jsp:attribute name="header">

    </jsp:attribute>

    <jsp:attribute name="footer">

    </jsp:attribute>

    <jsp:body>

        <h2 class="text-center">Oversigt over dine oplysninger</h2>

        <table class="table table-striped">
            <thead>
            <th>Brugernavn</th>
            <th>Email</th>
            <th>Adgangskode</th>
            <th>Adresse</th>
            <th>Postnummer</th>
            <th>Tlf. nummer</th>
            </thead>

                <tr>
                    <td>${sessionScope.user.username}</td>
                    <td>${sessionScope.user.email}</td>
                    <td>${sessionScope.user.password}</td>
                    <td>${sessionScope.user.address}</td>
                    <td>${sessionScope.user.postcode}</td>
                    <td>${sessionScope.user.phoneNumber}</td>
                </tr>
        </table>

        <form action="updateprofile" method="post">
        <div class="row">

            <div class="col-md">
                <div class="form-group">
                    <label for="username">Brugernavn:</label>
                    <input class="form-control" type="text" id="username" name="username">
                </div>
            </div>

            <div class="col-md">
                <div class="form-group">
                    <label for="email">Email:</label>
                    <input class="form-control" type="text" id="email" name="email">
                </div>
            </div>

            <div class="col-md">
                <div class="form-group">
                    <label for="address">Adresse:</label>
                    <input class="form-control" type="text" id="address" name="address">
                </div>
            </div>

            <div class="col-md">
                <div class="form-group">
                    <label for="postcode">Postnummer:</label>
                    <input class="form-control" type="text" id="postcode" name="postcode">
                </div>
            </div>

            <div class="col-md">
                <div class="form-group">
                    <label for="phone_number">Tlf. nummer:</label>
                    <input class="form-control" type="text" id="phone_number" name="phone_number">
                </div>
            </div>

            <div class="col-md">
                <br>
                <button style="width:100%;" type="submit" class="btn btn-secondary" name="update"
                        value="update">Opdater bruger
                </button>
            </div>
        </div>
        </form>
        <br>
        <form action="profile" method="post">
        <div class="row">
            <div class="col-md">
                <div class="form-group">
                    <label for="password">Nyt kodeord:</label>
                    <input class="form-control" type="text" id="password" name="password">
                </div>
            </div>

            <div class="col-md">
                <div class="form-group">
                    <label for="password1">Gentag nyt kodeord:</label>
                    <input class="form-control" type="text" id="password1" name="password1">
                </div>
            </div>

            <div class="col-md">
                <br>
                <button style="width:100%;" type="submit" class="btn btn-secondary" name="update"
                        value="update">Opdater kodeord
                </button>
            </div>
        </div>
        </form>
    </jsp:body>

</t:customer>