<%-- 
    Document   : customerProfile
    Created on : Aug 19, 2018, 7:55:16 PM
    Author     : douglaslandvik
--%>



<%@page import="uk.ac.city.douglas.varv.domain.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="pageId-10">
     <jsp:include page="/header.jsp" />

        <%
       Customer customer = (Customer) request.getAttribute("customer");
 
             out.print("<table><thead>"
                     + "<tr>"
                     
                     + "<th>Namn</th>"
                     + "<th>Adress</th>"
                     + "<th>Email</th>"
                     + "<th>TelfonNummer</th>"
                     + "<th>Person-org-nr</th>"
                     + "<th>Referens</th>"
                     + "<th>Notis</th>"
                     + "</tr></thead>");
                out.print("<tbody><tr>"); 
                out.print("<td>"+customer.getFirstName()+" "+customer.getLastName()+"</td>");
              
                out.print("<td>"+customer.getAdress()+" "+ customer.getCity()+"</td>");  
                out.print("<td>"+customer.getEmail()+"</td>");
                out.print("<td>"+customer.getPhoneNumber()+"</td>");
                
             
               out.print("</tr></tbody>");
              out.print("</table>");
        %>
      <jsp:include page="/footer.jsp" />
</html>
