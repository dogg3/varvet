<%-- 
    Document   : boatProfule
    Created on : Aug 19, 2018, 7:55:16 PM
    Author     : douglaslandvik
--%>

<%@page import="java.util.List"%>
<%@page import="uk.ac.city.douglas.varv.domain.Boat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <jsp:include page="/header.jsp" />

        <%
        Boat boat = (Boat) request.getAttribute("boat");
        float width = (float) boat.getWidth()/100;
         float length = (float) boat.getLength()/100;
              
              out.println("<h2>"+boat.getBrand() + boat.getModel()+"</h2>");
                          out.print("<p> Kategori: "+ boat.getMainCatagory() + " - " + boat.getSubCatagory() +" </p>");
              out.print("<p>Bredd: "+ width+" meter</p>");
              out.print("<p>Längd "+ length+" meter</p>");
              out.print("<p>Vikt: "+ boat.getWeight()+" kg</p>");
              
              if(boat.getDescription()!=null){
              out.print("<p>Beskrivning: <br>"+ boat.getDescription()+"</p>");
          
              }
             
        %>
      <jsp:include page="/footer.jsp" />
</html>
