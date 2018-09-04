<%-- 
    Document   : customerAdded
    Created on : Aug 21, 2018, 1:04:52 AM
    Author     : douglaslandvik
--%>

<%@page import="java.util.List"%>
<%@page import="uk.ac.city.douglas.varv.domain.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
       <jsp:include page="/header.jsp" />
        <h1>Kund tillagd med denna information</h1>
        
        
        <%
   
            
            out.println(request.getParameter("customer"));
            %>
       <jsp:include page="/footer.jsp" />
</html>
