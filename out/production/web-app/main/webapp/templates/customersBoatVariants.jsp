<%-- 
    Document   : boatVariantList
    Created on : Aug 19, 2018, 7:55:16 PM
    Author     : douglaslandvik
--%>

<%@page import="java.util.List"%>
<%@page import="uk.ac.city.douglas.varv.domain.BoatVariant"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <%
        List <BoatVariant> boatVariants = (List<BoatVariant>) request.getAttribute("boatVariants");
            for(BoatVariant boatVariant: boatVariants){
                %>
          
    <div class="col-sm-6 col-lg-3" id="boatVariantCard">
                <div class="card text-white">
                  <div class="card-body pb-0">
                    <div class="btn-group float-right">
                      <button class="btn btn-transparent dropdown-toggle p-0" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="icon-settings"></i>
                      </button>
                      <div class="dropdown-menu dropdown-menu-right">
                        <a class="dropdown-item" href="#">Lägg till motor</a>
                        <a class="dropdown-item" href="#">Radera</a>
                        <a class="dropdown-item" href="#">Lägg till notis</a>
                      </div>
                    </div>
                    <div class="text-value">
        <%
   
              out.println("<div id='"+boatVariant.getBoatId()+"'><p id='boatVariantHeader'>"
                      +boatVariant.getBoat().getBrand()
                      
                      + "<br>"
                      +boatVariant.getBoat().getModel()
                             
                      + "</p>"
                      
                      +"</div>");
        
        
        %>
                    </div>
                  </div>
                </div>
              </div>
              
              
        <%
       
            }
        %> 
 

