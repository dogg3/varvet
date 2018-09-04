<%-- 
    Document   : addBoatVariant
    Created on : Jan 1, 2018, 3:52:54 AM
    Author     : douglaslandvik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <jsp:include page="/header.jsp" />
     <h1>Lägg till kundbåt</h1>

        <form action="boatVariantAdd.html" method="POST">
            <label>kund-id: <input type="text" name="customerId" /></label><br />
            <label>Båt-märke:<input type="text" name="boatBrand" /></label><br />
            <label>Båt-modell<input type="text" name="boatModel" /></label><br />
            <label>Årgång<input type="text" name="year" /></label><br />
             <label>Motor-märke<input type="text" name="engineBrand" /></label><br />
             <label>Motor-modell<input type="text" name="engineModel" /></label><br /><br>
             <label>Beskrivning<br><input style="width:200px;height:100px;" type="text" name="description" /></label><br />
            
             <br>
            <input type="submit" value="Lägg till båt" />
        </form>
      <jsp:include page="/footer.jsp" />
</html>
