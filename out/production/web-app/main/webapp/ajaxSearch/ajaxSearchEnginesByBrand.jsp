<%-- 
    Document   : ajaxSearchEngineByBrands
    Created on : Aug 19, 2018, 7:55:16 PM
    Author     : douglaslandvik
--%>

<%@page import="uk.ac.city.douglas.varv.domain.Engine"%>
<%@page import="java.util.List"%>
<%@page import="uk.ac.city.douglas.varv.domain.Boat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>

   
    
        <%
        List <Engine> engines = (List<Engine>) request.getAttribute("engines");

      
         out.print("<table><tbody>");
            for(Engine engine: engines){
   
                out.println("<tr id='"+engine.getEngineId()+"' onclick='getEngineId(this.id)'>");
                out.println("<th> "+engine.getBrand()+"</th>");
                out.println("<th> "+engine.getModel()+"</th>");
                out.println("<th> "+engine.getHorsePower()+"</th>");
               
                
               
           
             out.println("</tr>");
            }
        out.print("</tbody><table>");
        
  %>
</html>
