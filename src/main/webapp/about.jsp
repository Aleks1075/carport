<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pagetemplate>
    <jsp:attribute name="header">

    </jsp:attribute>


    <jsp:body>

        <div class="backgroundcontainer">
            <div class="p-3 mb-2 bg-light text-dark">
                <div class="Titel" style="margin-left: auto; margin-right: auto; text-align: center;">
                    <h2>Om Fog</h2>
                    <div class="info" style="font-size: 20px; font-weight: lighter">
                        <br>
                        <p> I Fog får du kvalificeret rådgivning til den bedste løsning.
                            Vi hjælper dig med at få overblik og komme i mål med dit kommende carport.</p>
                        <br>
                        <p> Beskyt din bil under en flot carport. I Fog er vi specialister i byg-selv carporte. Bestil
                            din carport i standardmål online - vi leverer i hele Danmark. </p>
                        <br>
                        <p> En carport kan beskrives som et delvist lukket tag, som enten er fritstående eller
                            bygget som en del af huset. For de fleste mennesker, og især dem der elsker biler, er det
                            uundværligt. Med en carport kan du slappe helt af.</p>
                        <br>
                        <p>Det beskytter din bil mod regn og slud. Det er derfor praktisk at lade bilen stå i læ under
                            en overdækning. Du behøver ikke at skrabe ruderne fri for is om vinteren, vade i vandpytter
                            om efteråret eller sætte dig ind i en skoldende varm bil om sommeren.</p>
                        <br>
                        <p>Den er også hurtigere at bygge end en garage. Du kan derfor hurtigt og nemt opstille den og
                            dermed beskytte din bil efter kort tid. Det er en gevinst for huset, som får det til at
                            fremstå fuldendt. Alt andet vil være synd.</p>
                        <br>
                        <p>En flot carport øger husets værdi, og det bliver vigtigt, hvis du en dag skal sælge din
                            bolig. Så gå på jagt og lad dig inspirere af vores store udvalg.</p>
                    </div>
                </div>
            </div>
        </div>
        <div class="text-center">
        <h2>Vores team</h2>
        </div>

        <div class="card-group">
            <div class="card">
                <img src="${pageContext.request.contextPath}/images/chef.png" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">Direktør</h5>
                    <p class="card-text">Martin Fog</p>
                    <p class="card-text"><small class="text-muted">martinfog@fog.dk</small></p>
                </div>
            </div>
            <div class="card">
                <img src="${pageContext.request.contextPath}/images/salgchef.png" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">Salgschef</h5>
                    <p class="card-text">John Doe</p>
                    <p class="card-text"><small class="text-muted">johndoe@fog.dk</small></p>
                </div>
            </div>
            <div class="card">
                <img src="${pageContext.request.contextPath}/images/logistikchef.png" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">Logistikchef</h5>
                    <p class="card-text">Jane Doe</p>
                    <p class="card-text"><small class="text-muted">janedoe@fog.dk</small></p>
                </div>
            </div>
        </div>

    </jsp:body>

</t:pagetemplate>