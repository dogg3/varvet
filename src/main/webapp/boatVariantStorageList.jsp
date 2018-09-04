<%-- 
    Document   : boatVariantStorageList
    Created on : Aug 19, 2018, 7:55:16 PM
    Author     : douglaslandvik
--%>

<%@page import="uk.ac.city.douglas.varv.domain.BoatVariantStorage"%>
<%@page import="java.util.List"%>
<%@page import="uk.ac.city.douglas.varv.domain.BoatVariant"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <jsp:include page="/header.jsp" />
     <h1>Vinterplats</h1>
        <%
        List <BoatVariantStorage> boatVariantStorages = (List<BoatVariantStorage>) request.getAttribute("boatVariantStorages");
            for(BoatVariantStorage boatVariantStorage: boatVariantStorages){
              out.println("<li>"+boatVariantStorage+"</li>");
            }
        
        %>
      <jsp:include page="/footer.jsp" />
</html>
