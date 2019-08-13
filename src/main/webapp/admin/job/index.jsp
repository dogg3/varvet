<%@ page import="uk.ac.city.douglas.varv.Account.domain.Customer" %>
<%@ page import="java.util.List" %>
<%@ page import="java.lang.reflect.Method" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="uk.ac.city.douglas.varv.Job.domain.Job" %>
<%@ page import="uk.ac.city.douglas.varv.Boat.domain.Boat" %>
<%@ page import="uk.ac.city.douglas.varv.Account.domain.Staff" %>
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
        <!-- header area end -->
        <!-- page title area start -->
        <%@include file="../modules/offsetArea.jsp"%>

        <!-- page title area end -->

        <div class="container">
                <div class="table-wrapper">
                    <div class="table-title">
                        <div class="row">
                            <div class="col-sm-6">
                                <h2>Hantera <b>jobb</b></h2>
                            </div>
                            <div  class="col-sm-6">
                                <a href="#addJobNew" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Lagg till nytt jobb</span></a>
                            </div>
                        </div>
                    </div>
                    ​<div class="table-responsive">
                    <table id="table1" class="table table-striped table-hover">
                        <thead>
                        <tr>
                            <th>Job-id</th>
                            <th>Kund</th>
                            <th>Bat</th>
                            <th>Status</th>
                            <th>Datum bokad</th>
                            <th>Job-typ</th>
                            <th>Estimerad tid</th>
                            <th>Aktuell tid</th>
                            <th>Kommentar</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            List<Job> jobs = (List<Job>)request.getAttribute("jobs");
                            for(Job job: jobs){
                                Boat boat = job.getBoatVariant().getBoat();
                                Customer customer = job.getBoatVariant().getCustomer();
                                out.print("<tr>");
                                out.print("<td>"+job.getJobId()+"</td>");
                                out.print("<td>"+customer.getFirstName()+" "+ customer.getLastName()+"</td>");
                                out.print("<td>"+boat.getBrand()+" "+boat.getModel()+"</td>");
                                out.print("<td>"+job.getStatus()+"</td>");
                                out.print("<td>"+job.getDateBooked()+"</td>");
                                out.print("<td>"+job.getJobType()+"</td>");
                                out.print("<td>"+job.getEstimatedTime()+"</td>");
                                out.print("<td>"+job.getActualTime()+"</td>");
                                out.print("<td>"+job.getNote()+"</td>");
                                out.print("<td>" +
                                        "<a data-value='" + job.getJobId()+"' href=\"#editEmployeeModal\" class=\"edit\" data-toggle=\"modal\"><i class=\"material-icons\" data-toggle=\"tooltip\" title=\"Edit\">&#xE254;</i></a>" +
                                        "<a data-value='" + job.getJobId()+"' href=\"\" class=\"delete\" data-toggle=\"modal\"><i class=\"material-icons\" data-toggle=\"tooltip\" title=\"Delete\">&#xE872;</i></a></td>");
                                out.print("</tr>");
                            }
                        %>
                        </tbody>
                    </table>
                </div>
                </div>​


                ​<div id="addJobNew" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">Nytt jobb</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <form id="example-advanced-form-addJob" action="#">
                            <h3>Info</h3>
                            <fieldset>
                                <label>Kundbat</label>
                                <input name="kundbat" type="text" class="form-control" required>
                                <label>Datum bokat</label>
                                <input name="date" type="date" class="form-control" required>
                                <label>Job-typ</label>
                                <input name="jobType" type="text" class="form-control" required>
                                <label>Estimerad tid (timmar)</label>
                                <input name="estimatedTime" type="text" class="form-control" required>
                                <label>Kommentar</label>
                                <textarea name="note"  class="form-control" required></textarea>
                            </fieldset>

                        </form>
                    </div>
                </div>
            </div>

                <!--end-->


                <!-- Edit Modal HTML -->
                <div id="editEmployeeModal" class="modal fade">
                    <div style="margin-top:30px" class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title">Andra jobb</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <form id="example-advanced-form-editCustomer" action="#">
                                <h3>Info</h3>
                                <fieldset>
                                    <input id="editJobId" name="jobId" style="visibility: hidden" >
                                    <label>Kommentar</label>
                                    <textarea></textarea>
                                </fieldset>
                            </form>
                        </div>
                    </div>
                </div>
                <!-- Delete Modal HTML -->
                <div id="deleteJobModal" class="modal fade">
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
                                    <input id="eraseJob" type="submit" class="btn btn-basic" value="Radera">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <!-- confirmation to modals -->




                <div id="successAddJob" class="modal fade ">
                    <div class="modal-dialog">
                        <div id="modalContent" class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title">Jobb tillagt!</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <div class="statusResponse" id="statusSuccessAddJob"></div>
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
                <div id="successEraseJob" class="modal fade ">
                    <div class="modal-dialog">
                        <div  class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title">Kund raderad</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <div class="statusResponse" id="statusSuccessEraseJob"></div>
                            <div class="modal-footer">
                                <input type="submit" class="btn btn-basic"   data-dismiss="modal" value="Ok">
                            </div>
                        </div>
                    </div>
                </div>

            </div>
            <!-- page title area end -->
        </div>
    </div>
    <!-- main content area end -->
    <!-- footer area start-->
    <%@include file="../modules/footer.jsp"%>
    <!-- footer area end-->
<!-- page container area end -->
<!-- offset area start -->
<%@include file="../modules/offsetArea.jsp"%>
<!-- offset area end -->
<%@include file="../modules/loadScripts.jsp"%>



<script>
    $(document).ready(function () {
        $('#table1').DataTable();;
    });


    //pop up are u sure button and passing the customer ID
    $('.delete').click(function(e){
        e.preventDefault();
        var id = $(this).data('value');
        var deleteModal =  $('#deleteJobModal');
        deleteModal.find('#eraseJob').data("value",id);
        deleteModal.find('#statusAreSure').html("Ar du saker pa add radera jobb med id: <span style='color:black'>" + id + "</span>");
        deleteModal.modal("toggle");
    })

    ///erase customer send request to sevlert

    $('#eraseJob').click(function(e){
        e.preventDefault();

        var id =  $(this).data('value');
        console.log(id);
        $.ajax({
            url:'/varv/admin/job/addJob.html?id='+id,
            type: 'DELETE',
            success: function (data, status, xhr) {

                $('#deleteJobModal').modal("toggle");
                $('#statusSuccessEraseJob').html("Jobb med id" + id + "<br> ar raderad.");

                $('#successEraseJob').modal("toggle");
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
