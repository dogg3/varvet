<%-- 
    Document   : customerAdded
    Created on : Aug 20, 2018, 2:39:11 AM
    Author     : douglaslandvik
--%>

<%@page import="java.util.List"%>
<%@page import="uk.ac.city.douglas.varv.Account.domain.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="/varv/css/customer.css">

<jsp:include page="/header.jsp" />
        <h1>Detta är alla kunder</h1>
       
        <table id="table1" class="table table-striped table-bordered" style="width:100%">
            <thead>
                <tr>
                    <th>Kund-ID</th>
                    <th>Namn</th>
                    <th>Telefon</th>
                    <th>Email</th>
                    <th>Rabatt</th>
                    <th>Adress</th>
                    <th>Smeknamn</th>
                    <th>andra</th>
                </tr>
            </thead>
        
        <tbody>  
        <%
            List<Customer> customers = (List<Customer>)request.getAttribute("customers");
            
   
               for(Customer customer: customers){
             
                out.print("<tr>");
                out.print("<td><a href=/varv/customer/findCustomerById.html?id="+customer.getCustomerID()+">"+
                       customer.getCustomerID()+"</td>");

                out.print("<td>"+customer.getFirstName()+" "+ customer.getLastName()+"</td>");
                out.print("<td>"+customer.getTel()+"</td>");
                out.print("<td>"+customer.getEmail()+"</td>");
                out.print("<td>"+customer.getDiscountPlan()+"</td>");
                out.print("<td>"+customer.getAddress().getPostCode()
                        + "<br>"+customer.getAddress().getStreet() +"</td>");
                out.print("<td>"+customer.getIdentifier()+"</a></td>");

                   out.print("<td><a href=\"#editEmployeeModal\" class=\"edit\" data-toggle=\"modal\"><i class=\"material-icons\" data-toggle=\"tooltip\" title=\"Edit\">&#xE254;</i></a><a href=\"#deleteEmployeeModal\" class=\"delete\" data-toggle=\"modal\"><i class=\"material-icons\" data-toggle=\"tooltip\" title=\"Delete\">&#xE872;</i></a></td>");



               out.print("</tr>");
            }
            %>


        <!-- Edit Modal HTML -->
        <div id="addEmployeeModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form>
                        <div class="modal-header">
                            <h4 class="modal-title">Add Employee</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <label>Name</label>
                                <input type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Email</label>
                                <input type="email" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Address</label>
                                <textarea class="form-control" required></textarea>
                            </div>
                            <div class="form-group">
                                <label>Phone</label>
                                <input type="text" class="form-control" required>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                            <input type="submit" class="btn btn-success" value="Add">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- Edit Modal HTML -->
        <div id="editEmployeeModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form>
                        <div class="modal-header">
                            <h4 class="modal-title">Edit Employee</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <label>Name</label>
                                <input type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Email</label>
                                <input type="email" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Address</label>
                                <textarea class="form-control" required></textarea>
                            </div>
                            <div class="form-group">
                                <label>Phone</label>
                                <input type="text" class="form-control" required>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                            <input type="submit" class="btn btn-info" value="Save">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- Delete Modal HTML -->
        <div id="deleteEmployeeModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form>
                        <div class="modal-header">
                            <h4 class="modal-title">Delete Employee</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">
                            <p>Are you sure you want to delete these Records?</p>
                            <p class="text-warning"><small>This action cannot be undone.</small></p>
                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                            <input type="submit" class="btn btn-danger" value="Delete">
                        </div>
                    </form>
                </div>
            </div>
        </div>
       <jsp:include page="/footer.jsp" />

