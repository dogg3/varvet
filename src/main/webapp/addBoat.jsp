<%-- 
    Document   : addBoat
    Created on : Jan 1, 2018, 3:52:54 AM
    Author     : douglaslandvik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <jsp:include page="/header.jsp" />
     <h1>Lägg till båt</h1>

        <form action="boatAdd.html" method="POST">
            <label>Märke:<input type="text" name="brand" /></label><br />
            <label>Modell:<input type="text" name="model" /></label><br />
            <label>Längd:<input type="text" name="length" /></label><br />
            <label>Bredd<input type="text" name="width" /></label><br />
  
            <input type="submit" value="Lägg till båt" />
        </form>
      <jsp:include page="/footer.jsp" />
</html>
