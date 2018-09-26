<%-- 
    Document   : addBoatVariant
    Created on : Jan 1, 2018, 3:52:54 AM
    Author     : douglaslandvik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>


     <%
         //Om allt går som det ska
       if(request.getParameter("boatVariant")!=null){
        String boat = request.getParameter("boatVariant");
       
       %>
       
       <h3>Båten är tillagd</h3>
     
     
     <%
         } //success-end

         //Error
       if(request.getParameter("errorMessage")!=null){
        String errorMessage = request.getParameter("errorMessage");
            out.print("<p>"+errorMessage +"</p>");
 
         } //Error-end
  
       
       %>
       

</html>
