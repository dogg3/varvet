<%-- 
    Document   : boatList
    Created on : Aug 19, 2018, 7:55:16 PM
    Author     : douglaslandvik
--%>

<%@page import="java.util.List"%>
<%@page import="uk.ac.city.douglas.varv.Boat.domain.Boat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

     <jsp:include page="/header.jsp" />

     <h1>Detta är alla tillgängliga båtar</h1>
      <table id="table" class="table table-striped table-bordered" style="width:100%">
            <thead>
                <tr>
                    <th>Tillverkare</th>
                    <th>Modell</th>
                    <th>Längd</th>
                    <th>Bredd</th>
                    <th>Vikt</th>
                </tr>
            </thead>
   
        <tbody>  
        <%
            List<Boat> boats = (List<Boat>)request.getAttribute("boats");
            
   
               for(Boat boat: boats){
                   float width = (float) boat.getWidth()/100;
                   float length = (float) boat.getLength()/100;
                out.print("<tr>"); 
                out.print("<td><a href=findBoatById.html?id="+boat.getBoatId()+">"
                         +boat.getBrand()+"</td>");
              
                out.print("<td>"+boat.getModel()+"</td>");  
                out.print("<td>"+length+"</td>");
                out.print("<td>"+width+"</td>");
                out.print("<td>"+boat.getWeight()+"</td>");
                
             
               out.print("</tr>");
            }
            %>
            </tbody>
       </table>   
      <jsp:include page="/footer.jsp" />

