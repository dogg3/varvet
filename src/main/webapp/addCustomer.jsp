<%-- 
    Document   : addCustomer
    Created on : Aug 20, 2018, 2:30:55 AM
    Author     : douglaslandvik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="/header.jsp" />
     <h1>Lägg till ny kund</h1>

        <form action="addCustomer.html" method="POST">
            <label>Förnamn: <input type="text" name="firstName" /></label><br />
            <label>Efternamn: <input type="text" name="lastName" /></label><br />
            <label>Person-nr: <input type="text" name="personNr" /></label><br />
            <label>Adress <input type="text" name="adress" /></label><br />
            <label>Telefon-nr: <input type="text" name="phoneNumber" /></label><br />
            <label>Email: <input type="text" name="email" /></label><br />
            
  
            <input type="submit" value="Lägg till båt" />
        </form>
      <jsp:include page="/footer.jsp" />
</html>
