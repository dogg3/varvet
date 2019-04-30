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
                out.print("<td><a href=/varv/customer/findCustomerById.html?id="+customer.getCustomerId()+">"
                         +customer.getFirstName()+" "+customer.getLastName()+"</td>");
              
                out.print("<td>"+customer.getAdress()+" "+ customer.getCity()+"</td>");  
                out.print("<td>"+customer.getEmail()+"</td>");
                out.print("<td>"+customer.getPhoneNumber()+"</a></td>");
                
             
               out.print("</tr>");
            }
            %>
            
            <button class="btn btn-default" id="btn-confirm">Confirm</button>

<div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true" id="mi-modal">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Är du säker på detta</h4>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" id="modal-btn-si">ja</button>
        <button type="button" class="btn btn-primary" id="modal-btn-no">nej</button>
      </div>
    </div>
  </div>
</div>

<div class="alert" role="alert" id="result"></div>
            
            </tbody>
       </table>   
            <script></script>
       <jsp:include page="/footer.jsp" />

