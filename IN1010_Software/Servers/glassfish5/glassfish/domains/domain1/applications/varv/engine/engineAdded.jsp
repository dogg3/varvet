<%-- 
    Document   : engineAdded
    Created on : Jan 1, 2018, 3:52:54 AM
    Author     : douglaslandvik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="/header.jsp" />
     <h1>Båt tillagd</h1>
     <%
       
         String engine = request.getParameter("engine");
         out.println(engine);
         %>
      <jsp:include page="/footer.jsp" />
</html>
