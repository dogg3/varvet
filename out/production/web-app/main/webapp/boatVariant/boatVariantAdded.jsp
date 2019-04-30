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
       
       <div class="alert alert-success" role="alert">
 Båten är tillagd
</div>
     
     
     <%
         } //success-end

         //Error
       if(request.getParameter("errorMessage")!=null){
        String errorMessage = request.getParameter("errorMessage");
            out.print("<div class='alert alert-danger'>"+errorMessage +"</div>");
 
         } //Error-end
  
       
       %>

</html>
