<%-- 
    Document   : boatList
    Created on : Aug 19, 2018, 7:55:16 PM
    Author     : douglaslandvik
--%>

<%@page import="java.util.List"%>
<%@page import="uk.ac.city.douglas.varv.Boat.domain.Boat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <jsp:include page="/header.jsp" />
    
        <%
        List <Boat> boats = (List<Boat>) request.getAttribute("boats");
        String brand =  (String)request.getAttribute("brand");
        out.print("<h2 class='mellanRubrik'>Detta är alla modeller för tillverkaren: "+brand+"</h2>");
            for(Boat boat: boats){
              out.println("<li><a class='linkRubrikStor' href=findBoatById.html?id="+boat.getBoatId()+"> "+boat.getModel()+"</a></li>");
            }
        
        %>
      <jsp:include page="/footer.jsp" />
</html>
