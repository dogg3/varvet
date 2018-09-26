<%-- 
    Document   : customerAdded
    Created on : Aug 20, 2018, 2:39:11 AM
    Author     : douglaslandvik
--%>

<%@page import="java.util.List"%>
<%@page import="uk.ac.city.douglas.varv.domain.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

       <jsp:include page="/header.jsp" />
        <h1>Detta är alla kunder</h1>
       
        <table id="table" class="table table-striped table-bordered" style="width:100%">
            <thead>
                <tr>
                    <th>Namn</th>
                    <th>Adress</th>
                    <th>Email</th>
                    <th>Telefon-nr</th>
                </tr>
            </thead>
        
        <tbody>  
        <%
            List<Customer> customers = (List<Customer>)request.getAttribute("customers");
            
   
               for(Customer customer: customers){
             
                out.print("<tr>"); 
                out.print("<td><a href=findCustomerById.html?id="+customer.getCustomerId()+">"
                         +customer.getFirstName()+" "+customer.getLastName()+"</td>");
              
                out.print("<td>"+customer.getAdress()+" "+ customer.getCity()+"</td>");  
                out.print("<td>"+customer.getEmail()+"</td>");
                out.print("<td>"+customer.getPhoneNumber()+"</a></td>");
                
             
               out.print("</tr>");
            }
            %>
            </tbody>
       </table>   
       
       <jsp:include page="/footer.jsp" />

