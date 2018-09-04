<%-- 
    Document   : engineList
    Created on : Aug 20, 2018, 2:39:11 AM
    Author     : douglaslandvik
--%>

<%@page import="uk.ac.city.douglas.varv.domain.Engine"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
       <jsp:include page="/header.jsp" />
        <h1>Detta är alla kunder</h1>
        <%
        
                     List<Engine> engines = (List<Engine>)request.getAttribute("engines");

            
for(Engine engine: engines){
    out.println("<li>"+engine+"</li>");
}
            %>
            
            
       <jsp:include page="/footer.jsp" />
</html>
