
<%@page import="uk.ac.city.douglas.varv.domain.Storage"%>
<%@page import="java.util.List"%>
<%@page import="uk.ac.city.douglas.varv.domain.Boat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <jsp:include page="/header.jsp" />
     <h1>Detta är alla tillgängliga förvaringsutrymmen</h1>
        <%
        List<Storage> storages = (List<Storage>) request.getAttribute("storage");
            for(Storage storage :storages){
              out.println("<li>"+storage+"</li>");
            }
        
        %>
      <jsp:include page="/footer.jsp" />
</html>
