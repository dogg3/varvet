<%-- 
    Document   : boatVariantList
    Created on : Aug 19, 2018, 7:55:16 PM
    Author     : douglaslandvik
--%>

<%@page import="java.util.List"%>
<%@page import="uk.ac.city.douglas.varv.Job.domain.BoatVariant"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <jsp:include page="/header.jsp" />
     <h1>Detta är alla båtar som vi har nu</h1>
        <%
        List <BoatVariant> boatVariants = (List<BoatVariant>) request.getAttribute("boatVariants");
            for(BoatVariant boatVariant: boatVariants){
              out.println("<li>"+boatVariant+"</li>");
            }
        
        %>
      <jsp:include page="/footer.jsp" />
</html>
