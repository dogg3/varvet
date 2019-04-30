<%-- 
    Document   : eraseCustomerById
    Created on : Aug 21, 2018, 11:39:59 AM
    Author     : douglaslandvik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <jsp:include page="/header.jsp" />
        <h1>Ta bort kund med kund-id</h1>
             <form action="/varv/customer/eraseCustomer.html" method="POST">
            <label>Kund-id: <input type="text" name="id" /></label><br />
            <input type="submit" value="Ta bort kund" />
        </form>
       <jsp:include page="/footer.jsp" />
</html>
