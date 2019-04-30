<%-- 
    Document   : searchAllBoatsByBrand
    Created on : Aug 9, 2018, 2:47:11 PM
    Author     : douglaslandvik
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


  <jsp:include page="/header.jsp"/>
    
        <h1 class="storRubrik">Hitta båt</h1>
        
        <form action="findAllBoatsByBrand.html" method="GET">
            <label class="mellanRubrik">Sök på tillverkare <input type="text" name="brand" /></label>
            <input type="submit" value="Search" />
        </form>
        <form action="findAllBoatBrands.html" method="GET">
            <label class="mellanRubrik">Lista på alla båttillverkare </label>
            <input type="submit" value="Search" />
        </form>
    
   <jsp:include page="/footer.jsp"/>