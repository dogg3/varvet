<%-- 
    Document   : engineList
    Created on : Aug 20, 2018, 2:39:11 AM
    Author     : douglaslandvik
--%>

<%@page import="uk.ac.city.douglas.varv.Job.domain.Engine"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

       <jsp:include page="/header.jsp" />
        <h1>Detta är alla motorer</h1>
        <table id="table" class="table table-striped table-bordered" style="width:100%">
            <thead>
                <tr>
                    <th>Tillverkare</th>
                    <th>Modell</th>
                    <th>Hästkraft</th>
                    <th>Cylinder</th>
                    <th>Bränsle</th>
                
                </tr>
            </thead>
   
        <tbody>     
        <%
        
                     List<Engine> engines = (List<Engine>)request.getAttribute("engines");

            
 for(Engine engine: engines){
               
                out.print("<tr>"); 
                out.print("<td><a href=findEngineById.html?id="+engine.getEngineId()+">"
                         +engine.getBrand()+"</td>");
              
                out.print("<td>"+engine.getModel()+"</td>");  
                out.print("<td>"+engine.getHorsePower()+"</td>");
             
                out.print("<td>"+engine.getCylinder()+"</td>");
                   out.print("<td>"+engine.getGas()+"</td>");
                
             
               out.print("</tr>");
            }
            %>
            
                   </tbody>
       </table> 
       <jsp:include page="/footer.jsp" />
</html>
