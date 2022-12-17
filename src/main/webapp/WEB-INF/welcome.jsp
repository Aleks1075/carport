<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:customer>
    <jsp:attribute name="header">
         Byg din carport
    </jsp:attribute>

    <jsp:attribute name="footer">
        Logged in area
    </jsp:attribute>

    <jsp:body>

        <form action="createorder" method="post">
            <div class="row helvetica">
                <div class="form-group">
                    <label for="width" class="bold left">Carport bredde</label>
            <select class="form-select" name="width" id="width">
                <option value="240">240 cm</option>
                <option value="270">270 cm</option>
                <option value="300">300 cm</option>
                <option value="330">330 cm</option>
                <option value="360">360 cm</option>
                <option value="390">390 cm</option>
                <option value="420">420 cm</option>
                <option value="450">450 cm</option>
                <option value="480">480 cm</option>
                <option value="510">510 cm</option>
                <option value="540">540 cm</option>
                <option value="570">570 cm</option>
                <option value="600">600 cm</option>
                <option value="630">630 cm</option>
                <option value="660">660 cm</option>
                <option value="690">690 cm</option>
                <option value="720">720 cm</option>
                <option value="750">750 cm</option>
            </select>
                </div>
            </div>
            <br>
            <div class="row helvetica">
                <div class="form-group">
                    <label for="length" class="bold left">Carport længde</label>
                    <select class="form-select" name="length" id="length">
                        <option value="240">240 cm</option>
                        <option value="270">270 cm</option>
                        <option value="300">300 cm</option>
                        <option value="330">330 cm</option>
                        <option value="360">360 cm</option>
                        <option value="390">390 cm</option>
                        <option value="420">420 cm</option>
                        <option value="450">450 cm</option>
                        <option value="480">480 cm</option>
                        <option value="510">510 cm</option>
                        <option value="540">540 cm</option>
                        <option value="570">570 cm</option>
                        <option value="600">600 cm</option>
                        <option value="630">630 cm</option>
                        <option value="660">660 cm</option>
                        <option value="690">690 cm</option>
                        <option value="720">720 cm</option>
                        <option value="750">750 cm</option>
                        <option value="780">780 cm</option>
                    </select>
                </div>
            </div>
            <br>
            <div class="row helvetica">
                <div class="col-md"></div>
                <div class="col-md text-center">
                    <button type="submit" name="create" class="btn btn-primary">Send forespørgsel</button>
                </div>
                <div class="col-md"></div>
            </div>
        </form>



<%--        <p>You should be logged in now</p>--%>

<%--        <c:if test="${sessionScope.user != null}">--%>
<%--            <p>Hello ${sessionScope.user.username}</p>--%>
<%--            <p>You are logged in with the role of "${sessionScope.user.role}".</p>--%>
<%--        </c:if>--%>

<%--        <c:if test="${sessionScope.user == null}">--%>
<%--            <p>You are not logged in yet. You can do it here: <a--%>
<%--                    href="../login.jsp">Login</a></p>--%>
<%--        </c:if>--%>

<%--        <br>--%>

<%--        <h1 class="mb-5 text-center">Shopping side</h1>--%>

<%--        <form class="text-center" action="addtocart" method="post">--%>
<%--            <select name="top">--%>
<%--                <c:forEach var="topItem" items="${sessionScope.topList}">--%>
<%--                    <option value="${topItem.id}">${topItem.name} (${topItem.price} kr)</option>--%>
<%--                </c:forEach>--%>
<%--            </select>--%>
<%--            <select name="bottom">--%>
<%--                <c:forEach var="bottomItem" items="${sessionScope.bottomList}">--%>
<%--                    <option value="${bottomItem.id}">${bottomItem.name} (${bottomItem.price} kr)</option>--%>
<%--                </c:forEach>--%>
<%--            </select>--%>
<%--            <select name="quantity">--%>
<%--                <option value="1">1</option>--%>
<%--                <option value="2">2</option>--%>
<%--                <option value="3">3</option>--%>
<%--                <option value="4">4</option>--%>
<%--            </select>--%>
<%--            <button class="btn btn-primary" name="addToCart">Add to cart</button>--%>
<%--        </form>--%>

<%--        <form method="post">--%>
<%--            <h3 class="mt-3">Indhold i kurv:</h3>--%>
<%--            <table class="table table-striped">--%>
<%--                <thead>--%>
<%--                <th>Carport bredde:</th>--%>
<%--                <th>Carport længde:</th>--%>
<%--                <th></th>--%>
<%--                <th></th>--%>
<%--                <th></th>--%>
<%--                </thead>--%>

<%--                <c:forEach var="item" items="${sessionScope.bomCart.bomList}">--%>
<%--                    <tr>--%>
<%--                        <td>${item.top.id}</td>--%>
<%--                        <td>${item.top.name}</td>--%>
<%--                        <td> <button formaction="deleteitem" name="top_id" value="${item.top.id}" class="btn btn-danger">Fjern</button></td>--%>
<%--                        <td> <button formaction="removeitem" name="top_id" value="${item.top.id}" class="btn btn-success">-</button></td>--%>
<%--                        <td> <button formaction="additem" name="top_id" value="${item.top.id}" class="btn btn-success">+</button></td>--%>
<%--                    </tr>--%>
<%--                </c:forEach>--%>
<%--            </table>--%>
<%--        </form>--%>

<%--        <h3 class="mt-3">Samlet pris: ${sessionScope.bomCart.totalPrice} kr,-</h3>--%>

<%--        <p class="mt-4"><a class="btn btn-primary" href="order">Send forespørgsel</a></p>--%>

    </jsp:body>

</t:customer>