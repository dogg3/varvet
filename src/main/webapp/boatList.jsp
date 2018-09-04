<%-- 
    Document   : boatList
    Created on : Aug 19, 2018, 7:55:16 PM
    Author     : douglaslandvik
--%>

<%@page import="java.util.List"%>
<%@page import="uk.ac.city.douglas.varv.domain.Boat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <jsp:include page="/header.jsp" />
     <h1>Detta är alla tillgängliga båtar</h1>
        <%
        List <Boat> boats = (List<Boat>) request.getAttribute("boats");
            for(Boat boat: boats){
              out.println("<li>"+boat+"</li>");
            }
        
        %>
      <jsp:include page="/footer.jsp" />
</html>
