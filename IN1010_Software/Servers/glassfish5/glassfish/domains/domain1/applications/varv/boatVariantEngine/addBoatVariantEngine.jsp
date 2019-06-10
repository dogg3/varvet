<%-- 
    Document   : addBoatVariantEngine
    Created on : Oct 1, 2018, 3:36:31 PM
    Author     : douglaslandvik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
  <form action="/varv/boatVariantEngine/boatVariantEngineAdd.html" method="POST">

      <label>engineId <input type="text" name="engineId" /></label><br />
      <label>customerId <input type="text" name="customerId" /></label><br />
      <label>boatId <input type="text" name="boatId" /></label><br />
  
            <input type="submit" value="Lägg till båt" />
  </form>
