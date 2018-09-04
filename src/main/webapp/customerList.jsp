<%-- 
    Document   : customerAdded
    Created on : Aug 20, 2018, 2:39:11 AM
    Author     : douglaslandvik
--%>

<%@page import="java.util.List"%>
<%@page import="uk.ac.city.douglas.varv.domain.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
       <jsp:include page="/header.jsp" />
        <h1>Detta är alla kunder</h1>
        <%
            List<Customer> customers = (List<Customer>)request.getAttribute("customers");
            
for(Customer customer: customers){
    out.println("<li>"+customer+"</li>");
}
            %>
            
            
       <jsp:include page="/footer.jsp" />
</html>
