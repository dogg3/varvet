<%-- 
    Document   : boatList
    Created on : Aug 19, 2018, 7:55:16 PM
    Author     : douglaslandvik
--%>

<%@page import="java.util.List"%>
<%@page import="uk.ac.city.douglas.varv.Job.domain.Boat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <jsp:include page="/header.jsp" />
     <div class="fullWidth">
         <h2>Detta är alla båt-tillverkare</h2>
        <%
        List <String> brands = (List<String>) request.getAttribute("brands");
     

            for(String brand: brands){
              out.println("<li><a href=findAllBoatsByBrand.html?brand="+brand+">"+brand+"</a></li>");
            }
        
        %>
      </div>
      <jsp:include page="/footer.jsp" />
</html>
