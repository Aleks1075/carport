<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<t:admin>
    <jsp:attribute name="header">
         Opret admin bruger
    </jsp:attribute>

    <jsp:body>

        <form action="createadmin" method="post">
            <table>
                <tr>
                    <td><label class="col-sm-1 col-form-label" for="username">Brugernavn: </label></td>
                    <td><input class="form-control" type="text" id="username" name="username"
                               placeholder="Indtast din brugernavn"/></td>
                </tr>
                <tr>
                    <td><label class="col-sm-1 col-form-label" for="email">Email: </label></td>
                    <td><input class="form-control" type="text" id="email" name="email"
                               placeholder="Indtast din email"/></td>
                </tr>
                <tr>
                    <td><label class="col-sm-1 col-form-label" for="address">Adresse: </label></td>
                    <td><input class="form-control" type="text" id="address" name="address"
                               placeholder="Indtast din adresse"/></td>
                </tr>
                <tr>
                    <td><label class="col-sm-1 col-form-label" for="postcode">Postnummer: </label></td>
                    <td><input class="form-control" type="postcode" id="postcode" name="postcode"
                               placeholder="Indtast din postnummer"/></td>
                </tr>
                <tr>
                    <td><label class="col-sm-1 col-form-label" for="phoneNumber">Tlf. nummer: </label></td>
                    <td><input class="form-control" type="phoneNumber" id="phoneNumber" name="phoneNumber"
                               placeholder="Indtast din tlf nummer"/></td>
                </tr>
                <tr>
                    <td><label class="col-sm-1 col-form-label" for="password">Adgangskode: </label></td>
                    <td><input class="form-control" type="password" id="password" name="password"
                               placeholder="Indtast kodeord"/></td>
                </tr>
                <tr>
                    <td><label class="col-sm-1 col-form-label" for="password1">Gentag adgangskode: </label></td>
                    <td><input class="form-control" type="password" id="password1" name="password1"
                               placeholder="Gentag kodeord"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><button class="btn btn-primary" type="submit" value="Login">Opret</button></td>
                </tr>
            </table>
        </form>

    </jsp:body>

</t:admin>