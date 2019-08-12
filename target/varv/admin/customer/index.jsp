<%@ page import="uk.ac.city.douglas.varv.Account.domain.Customer" %>
<%@ page import="java.util.List" %>
<%@ page import="org.json.simple.JSONObject" %>



<!doctype html>
<html class="no-js" lang="en">

<%@include file="../modules/head.jsp"%>

<body>

<div id="preloader">
    <div class="loader"></div>
</div>
<!-- preloader area end -->
<!-- page container area start -->
<div class="page-container">
    <!-- sidebar menu area start -->
    <%@include file="../modules/sidebar.jsp"%>
    <!-- sidebar menu area end -->
    <!-- main content area start -->
    <div class="main-content">
        <!-- header area start -->
        <%@include file="../modules/header.jsp"%>

        <%@include file="../modules/titleArea.jsp"%>

        <div class="container">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-6">
                            <h2>Hantera <b>kunder</b></h2>
                        </div>
                        <div  class="col-sm-6">
                            <a href="#addEmployeeNew" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Lagg till ny kund</span></a>
                        </div>
                    </div>
                </div>
                <div class="table-responsive">
                <table id="table1" class="table table-striped table-hover">
                    <thead>
                    <tr>
                        <th>Kund-ID</th>
                        <th>Namn</th>
                        <th>Telefon</th>
                        <th>Email</th>
                        <th>Rabatt</th>
                        <th>Adress</th>
                        <th>Smeknamn</th>
                        <th>Actions</th>
                    </tr>
                    </thead>
                    <tbody>

                            <%
                List<Customer> customers = (List<Customer>)request.getAttribute("customers");

                for(Customer customer: customers){

                    JSONObject customerJSon = new JSONObject();
                    customerJSon.put("customerId", customer.getCustomerID());
                    customerJSon.put("firstName", customer.getFirstName());
                    customerJSon.put("lastName", customer.getLastName());
                    customerJSon.put("tel", customer.getTel());
                    customerJSon.put("email", customer.getEmail());
                    customerJSon.put("discountPlan", customer.getDiscountPlan());
                    customerJSon.put("postCode", customer.getPostCode());
                    customerJSon.put("street", customer.getStreet());
                    customerJSon.put("identifier", customer.getIdentifier());
                    customerJSon.put("town", customer.getTown());


                    out.print("<tr id='customer-tr-id' data-value='" + customer.getCustomerID()+"'>");
                    out.print("<td>"+ customer.getCustomerID()+"</td>");
                    out.print("<td id=customer-tr-name data-value='"+customer.getFirstName()+" " +customer.getLastName()+"'>" +customer.getFirstName()+" "+ customer.getLastName()+"</td>");
                    out.print("<td>"+customer.getTel()+"</td>");
                    out.print("<td>"+customer.getEmail()+"</td>");
                    out.print("<td>"+customer.getDiscountPlan()+"</td>");
                    out.print("<td>"+customer.getPostCode()
                            + "<br>"+customer.getStreet() + "<br>" +
                           customer.getTown()+ "</td>");
                    out.print("<td>"+customer.getIdentifier()+"</a></td>");

                    out.print("<td>" +
                            "<a data-value='" +customerJSon +"' class='edit' id='editButton' class=\"edit\" data-toggle=\"modal\"><i class=\"material-icons\" data-toggle=\"tooltip\" title=\"Edit\">&#xE254;</i></a>" +
                            "<a data-value='" + customer.getCustomerID()+"' data-name='" + customer.getFirstName()+" "+customer.getLastName() +"'id='deleteButton' class=\"delete\" data-toggle=\"modal\"><i class=\"material-icons\" data-toggle=\"tooltip\" title=\"Delete\">&#xE872;</i></a></td>");



                    out.print("</tr>");
                }
            %>

                    </tbody>
                </table>
                <div/>
            </div>

                <!--add employee modal -->

                <div id="addEmployeeNew" class="modal fade">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title">Ny kund</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <form id="example-advanced-form" action="#">
                                <h3>Info</h3>
                                <fieldset>
                                    <label>Fornamn</label>
                                    <input name="firstName" type="text" class="form-control" required>
                                    <label>Efternamn</label>
                                    <input name="lastName" type="text" class="form-control" required>
                                    <label>Smeknamn</label>
                                    <input name="identifier" type="text" class="form-control" required>
                                    <label>Telefon</label>
                                    <input name="tel" type="text" class="form-control" required>
                                    <label>Email</label>
                                    <input name="email" type="email" class="form-control" required>
                                    <label>Rabatt</label>
                                    <input name="discountPlan" type="text" class="form-control" required>
                                </fieldset>

                                <h3>Adress</h3>
                                <fieldset>
                                    <label>Gata</label>
                                    <input name="street" type="text" class="form-control" required>
                                    <label>Stad</label>
                                    <input name="town" type="text" class="form-control" required>
                                    <label>Post-nummer</label>
                                    <input name="postCode" type="text" class="form-control" required>
                                </fieldset>
                            </form>
                        </div>
                    </div>
                </div>

                <!--end-->

            <!-- add Modal HTML -->

                <!--get all info from current customer -->

            <!-- Edit Modal HTML -->
                <div id="editEmployeeModal" class="modal fade">
                    <div style="margin-top:30px" class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title">Andra kund</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <form id="example-advanced-form-editCustomer" action="#">
                                <h3>Info</h3>
                                <fieldset>
                                    <input id="editCustomerId" name="customerId" style="visibility: hidden" >
                                    <label>Fornamn</label>
                                    <input name="firstName" type="text" class="form-control" >
                                    <label>Efternamn</label>
                                    <input name="lastName" type="text" class="form-control" >
                                    <label>Smeknamn</label>
                                    <input name="identifier" type="text" class="form-control" >
                                    <label>Telefon</label>
                                    <input name="tel" type="text" class="form-control" >
                                    <label>Email</label>
                                    <input name="email" type="email" class="form-control" >
                                    <label>Rabatt</label>
                                    <input name="discountPlan" type="text" class="form-control" >
                                </fieldset>

                                <h3>Adress</h3>
                                <fieldset>
                                    <label>Gata</label>
                                    <input name="street" type="text" class="form-control" >
                                    <label>Stad</label>
                                    <input name="town" type="text" class="form-control" >
                                    <label>Post-nummer</label>
                                    <input name="postCode" type="text" class="form-control" >
                                </fieldset>
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
                                <h4 class="modal-title">Radera kund</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <div class="modal-body">
                                <p id="statusAreSure"></p>
                            </div>
                            <div class="modal-footer">
                                <input type="button" class="btn btn-default" data-dismiss="modal" value="Avbryt">
                                <input id="eraseCustomer" type="submit" class="btn btn-basic" value="Radera">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
                <!-- confirmation to modals -->




                <div id="successAddEmployee" class="modal fade ">
                    <div class="modal-dialog">
                        <div id="modalContent" class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title">Kund tillagd</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                                <div class="statusResponse" id="statusSuccessAddCustomer"></div>
                            <div class="modal-footer">
                                <input type="submit" class="btn btn-basic" data-dismiss="modal" value="Ok">
                            </div>
                        </div>
                    </div>
                </div>

                <div id="successEditCustomer" class="modal fade ">
                    <div class="modal-dialog">
                        <div  class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title">Kund uppdaterad</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <div class="statusResponse" id="statusSuccessEditCustomer"></div>
                            <div class="modal-footer">
                                <input type="submit" class="btn btn-basic"  data-dismiss="modal"  value="Ok">
                            </div>
                        </div>
                    </div>
                </div>
                <div id="successEraseCustomer" class="modal fade ">
                    <div class="modal-dialog">
                        <div  class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title">Kund raderad</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <div class="statusResponse" id="statusSuccessEraseCustomer"></div>
                            <div class="modal-footer">
                                <input type="submit" class="btn btn-basic"   data-dismiss="modal" value="Ok">
                            </div>
                        </div>
                    </div>
                </div>

        </div>
        </div>
    </div>
    <!-- main content area end -->
    <!-- footer area start-->
<%@include file="../modules/footer.jsp"%>
    <!-- footer area end-->
</div>
<!-- page container area end -->
<!-- offset area start -->
<%@include file="../modules/offsetArea.jsp"%>
<!-- offset area end -->
<!-- jquery latest version -->
<%@include file="../modules/loadScripts.jsp"%>
<script>
    $(document).ready(function () {
        $('#table1').DataTable();
        $("#example-basic").steps({
            headerTag: "h3",
            bodyTag: "section",
            transitionEffect: "slideLeft",
            autoFocus: true
        });
    });

    //pop up are u sure button and passing the customer ID
    $('.delete').click(function(e){
        e.preventDefault();
        var id = $(this).data('value');
        var name = $(this).data('name');
        var deleteModal =  $('#deleteEmployeeModal');
        deleteModal.find('#eraseCustomer').data("value",id);
        deleteModal.find('#eraseCustomer').data("name",name);
        deleteModal.find('#statusAreSure').html("Ar du saker pa add radera <span style='color:black'>" + name + "</span>");
        deleteModal.modal("toggle");
        console.log($(this).data('name'));
    })

    ///erase customer send request to sevlert

    $('#eraseCustomer').click(function(e){
        e.preventDefault();

      var id =  $(this).data('value');
      var name = $(this).data('name');
        $.ajax({
            url:'/varv/admin/customer/addCustomer.html?id='+id,
            type: 'DELETE',
            success: function (data, status, xhr) {

                $('#deleteEmployeeModal').modal("toggle");
                $('#statusSuccessEraseCustomer').html(name+ " ar raderad.");

                $('#successEraseCustomer').modal("toggle");
            }
        })
    })



    //edit toogle and fill placeholder
    $('.edit').click(function(e){
        e.preventDefault();

        //Set placeholders
        var customer = $(this).data('value');
        var form =$('#editEmployeeModal').find('form');
        var allInput = form.find('input');
        $('#editCustomerId').val(customer['customerId']);

        allInput.each(function(index,value){
            var attr = $(value).attr('name');
            var placeholder = customer[attr];
            $(value).attr("placeholder", placeholder);

        });

        //show the form modal
        $('#editEmployeeModal').modal("show");

    })
</script>
</body>

</html>
