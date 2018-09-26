<%-- 
    Document   : customerProfile
    Created on : Aug 19, 2018, 7:55:16 PM
    Author     : douglaslandvik
--%>



<%@page import="uk.ac.city.douglas.varv.domain.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <link rel="stylesheet" href="css/customer.css">
    
<!DOCTYPE html>
<html class="pageId-10">
     <jsp:include page="/header.jsp" />
     <div class="container">
        <%
       Customer customer = (Customer) request.getAttribute("customer");
             out.print(
                     "<div id='profileId' value='"+customer.getCustomerId()+"' class='col-md-12 profile'>"
                      +"<h2 id='mellanRubrik'>Profil</h2>"
                    + "<li>Namn:  " +customer.getFirstName()+" "+customer.getLastName()+"</li>"
                     + "<li>Adress:  " +customer.getAdress()+" "+ customer.getCity()+"</li>"
                     + "<li>Email:  "+customer.getEmail()+"</li>"
                     + "<li>Telefon:  " +customer.getPhoneNumber()+"</li>"
                     + "<li>Person/org-nr: "+customer.getPersonNr()+"</li>" 
                     + "<li>Referens: "+customer.getReference()+"</li>"
                     + "<li>Notis:  "+customer.getNote()+"</li></div>"
                    );
           
        %>
        
        <!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter">
  Lägg till kundbåt
</button>
</div>

      <jsp:include page="/footer.jsp" />
      
</html>

<!-- Modal -->
<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">Lägg till ny kundbåt</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          
      <jsp:include page="/templates/addBoatVariant.jsp" />
      </div>
      <div class="modal-footer">
        
      </div>
    </div>
  </div>
</div>