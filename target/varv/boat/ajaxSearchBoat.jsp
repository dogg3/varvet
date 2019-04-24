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

   
    
        <%
        List <Boat> boats = (List<Boat>) request.getAttribute("boats");
        String brand =  (String)request.getAttribute("brand");
      
         out.print("<table><tbody>");
            for(Boat boat: boats){
                    float width = (float) boat.getWidth()/100;
         float length = (float) boat.getLength()/100;
                out.println("<tr id='"+boat.getBoatId()+"' onclick='getBoatId(this.id)'>");
                out.println("<th> "+boat.getBrand()+"</th>");
                out.println("<th> "+boat.getModel()+"</th>");
                out.println("<th> "+width+" m bred</th>");
                out.println("<th> "+length+" m lång</th>");
                
               
           
             out.println("</tr>");
            }
        out.print("</tbody><table>");
        
  %>
</html>
