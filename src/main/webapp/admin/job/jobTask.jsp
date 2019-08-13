<%@ page import="uk.ac.city.douglas.varv.Account.domain.Customer" %>
<%@ page import="java.util.List" %>
<%@ page import="java.lang.reflect.Method" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="uk.ac.city.douglas.varv.Job.domain.Job" %>
<%@ page import="uk.ac.city.douglas.varv.Boat.domain.Boat" %>
<%@ page import="uk.ac.city.douglas.varv.Account.domain.Staff" %>
<%@ page import="uk.ac.city.douglas.varv.Job.domain.JobTask" %>
<%@ page import="uk.ac.city.douglas.varv.Job.domain.TaskDescription" %>
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
        <%@include file="../modules/titleArea.jsp"%>

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
                        <th>Arbetsuppgifts-id</th>
                        <th>Beskrivning</th>
                        <th>Kommentar</th>
                        <th>Status</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        List<JobTask> jobTasks = (List<JobTask>)request.getAttribute("jobTasks");


                        for(JobTask jobTask: jobTasks){
                         Job job = jobTask.getJob();
                         TaskDescription task = jobTask.getTaskDescription();
                            out.print("<tr>");

                            out.print("<td>"+job.getJobId()+"</td>");
                            out.print("<td>"+task.getTaskDescriptionID()+"</td>");
                            out.print("<td>"+task.getDescription()+"</td>");
                            out.print("<td>"+jobTask.getComment()+"</td>");
                            out.print("<td>"+jobTask.getStatus()+"</td>");

                            out.print("<td>" +
                                    "<a data-value='" +jobTask.getJobTaskId()+"' href=\"#editEmployeeModal\" class=\"edit\" data-toggle=\"modal\"><i class=\"material-icons\" data-toggle=\"tooltip\" title=\"Edit\">&#xE254;</i></a>" +
                                    "<a data-value='" + jobTask.getJobTaskId()+"' href=\"\" class=\"delete\" data-toggle=\"modal\"><i class=\"material-icons\" data-toggle=\"tooltip\" title=\"Delete\">&#xE872;</i></a></td>");



                            out.print("</tr>");
                        }
                    %>
                    </tbody>
                </table>
                <div/>
            </div>​


                ​<div id="addJobNew" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">Nytt jobb</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <form id="example-advanced-form-addJobTask" action="#">
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

                            <h3>Arbeten</h3>
                            <fieldset>
                                <label>Anstalld</label>
                                <input name="staff" type="text" class="form-control" required>
                                <label>Arbetsuppgift</label>
                                <input name="taskDescription" type="text" class="form-control" required>
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
            </div>
    </div>
    <!-- main content area end -->
    <!-- footer area start-->
    <!-- page title area end -->
    <!-- page title area end -->
<%@include file="../modules/footer.jsp"%>
    <!-- footer area end-->
</div>

<%@include file="../modules/offsetArea.jsp"%>
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
                $('#statusSuccessEraseJob').html("Jobb med id" + name+ "<br> ar raderad.");

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
