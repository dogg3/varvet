<%-- 
    Document   : addEngine
    Created on : Jan 1, 2018, 3:52:54 AM
    Author     : douglaslandvik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <jsp:include page="/header.jsp" />
     <h1>Lägg till motor</h1>

        <form action="/varv/engineAdd.html" method="POST">
                  
            <label>Märke:<input type="text" name="brand" /></label><br />
            <label>Modell:<input type="text" name="model" /></label><br />
            <label>Årgång:<input type="text" name="year" /></label><br />
            <label>Hästkrafter<input type="text" name="horsePower" /></label><br />
            <label>Utombordare/inombordare:<input type="text" name="type" /></label><br />
            <label>Cylinder: <input type="text" name="cylinder" /></label><br />
            <label>Bränsle: <input type="text" name="gas"/></label><br />
  
            <input type="submit" value="Lägg till båt" />
        </form>
      <jsp:include page="/footer.jsp" />
</html>
