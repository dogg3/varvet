<%@ page session="true"%>

User '<%=request.getRemoteUser()%>' has been logged out.
<a href="/varv/adming/login.jsp">Logga in igen</a>



<% session.invalidate(); %>