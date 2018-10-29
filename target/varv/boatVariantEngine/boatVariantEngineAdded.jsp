<%-- 
    Document   : boatVariantEngineAdded
    Created on : Aug 21, 2018, 1:04:52 AM
    Author     : douglaslandvik
--%>

<%@page import="java.util.List"%>
<%@page import="uk.ac.city.douglas.varv.domain.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
       <jsp:include page="/header.jsp" />
        <h1>Motor till kundbåt tillagd</h1>
        
        
        <%
            out.println(request.getParameter("boatVariantEngine"));
            %>
       <jsp:include page="/footer.jsp" />
</html>
