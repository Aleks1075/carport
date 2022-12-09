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

        <form action="deletematerial" method="post">
        <h2 class="text-center">Oversigt over alle materialer</h2>

        <h3 class="mt-3">Træ & tagplader</h3>
        <table class="table table-striped">
            <thead>
            <th>ID</th>
            <th>Beskrivelse</th>
            <th>Type</th>
            <th>Enhed</th>
            <th>Pris per enhed</th>
            <th></th>
            </thead>

            <c:forEach var="wood" items="${requestScope.woodList}">
                <tr>
                    <td>${wood.materialId}</td>
                    <td>${wood.description}</td>
                    <td>${wood.type}</td>
                    <td>${wood.unit}</td>
                    <td>${wood.unit_price}</td>
                    <td>
                        <button class="btn btn-danger btn-sm" type="submit" name="material_id"
                                value="${wood.materialId}">
                            Fjern
                        </button>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <br>

        <h3 class="mt-3">Beslag & skruer</h3>
        <table class="table table-striped">
            <thead>
            <th>ID</th>
            <th>Beskrivelse</th>
            <th>Type</th>
            <th>Enhed</th>
            <th>Pris per enhed</th>
            <th></th>
            </thead>

            <c:forEach var="accessory" items="${requestScope.accessoryList}">
                <tr>
                    <td>${accessory.materialId}</td>
                    <td>${accessory.description}</td>
                    <td>${accessory.type}</td>
                    <td>${accessory.unit}</td>
                    <td>${accessory.unit_price}</td>
<%--                    <td> <button formaction="deleteitem" name="materialId" value="${material.materialId}" class="btn btn-danger">Fjern</button></td>--%>
                    <td>
                        <button class="btn btn-danger btn-sm" type="submit" name="material_id"
                                value="${accessory.materialId}">
                            Fjern
                        </button>
                    </td>
                </tr>
            </c:forEach>
        </table>
        </form>

        <form action="addmaterial" method="post">
        <div class="row">

            <div class="col-md">
                <div class="form-group">
                    <label for="description">Beskrivelse:</label>
                    <input class="form-control" type="text" id="description" name="description">
                </div>
            </div>

            <div class="col-md">
                <div class="form-group">
                    <label for="type">Type:</label>
                    <input class="form-control" type="text" id="type" name="type">
                </div>
            </div>

            <div class="col-md">
                <div class="form-group">
                    <label for="unit">Enhed:</label>
                    <input class="form-control" type="text" id="unit" name="unit">
                </div>
            </div>

            <div class="col-md">
                <div class="form-group">
                    <label for="unit_price">Pris:</label>
                    <input class="form-control" type="text" id="unit_price" name="unit_price">
                </div>
            </div>

            <div class="col-md">
                <br>
                <button style="width:100%;" type="submit" class="btn btn-secondary" name="addMaterial"
                        value="update">Tilføj
                </button>
            </div>
        </div>
        </form>
        <br>
        <form action="updatematerialprice" method="post">
        <div class="row">
            <div class="col-md">
                <div class="form-group">
                    <label for="material_id">ID:</label>
                    <input class="form-control" type="text" id="material_id" name="material_id">
                </div>
            </div>

            <div class="col-md">
                <div class="form-group">
                    <label for="price">Pris:</label>
                    <input class="form-control" type="text" id="price" name="price">
                </div>
            </div>

            <div class="col-md">
                <br>
                <button style="width:100%;" type="submit" class="btn btn-secondary" name="update"
                        value="update">Opdater
                </button>
            </div>
        </div>
        </form>

    </jsp:body>

</t:admin>

