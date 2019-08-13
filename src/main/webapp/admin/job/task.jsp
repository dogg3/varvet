<%@ page import="java.util.List" %>

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
        <%@include file="../modules/titleArea.jsp"%>
        <!-- page title area end -->

        <div class="container">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-6">
                            <h2>Hantera <b>arbetsuppgifter</b></h2>
                        </div>
                        <div  class="col-sm-6">
                            <a href="#addTaskNew" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Lagg till ny arbetsuppgift</span></a>
                        </div>
                    </div>
                </div>
                ​
                ​<div class="table-responsive">
                <table id="table1" class="table table-striped table-hover">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Kategori</th>
                        <th>Estimerad tid</th>
                        <th>Beskrivning</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        List<TaskDescription> taskDescriptions = (List<TaskDescription>)request.getAttribute("taskDescriptions");


                        for(TaskDescription taskDescription: taskDescriptions){

                            out.print("<tr>");

                            out.print("<td>"+taskDescription.getTaskDescriptionID()+"</td>");
                            out.print("<td>"+taskDescription.getTaskType()+"</td>");
                            out.print("<td>"+taskDescription.getEstimatedTime()+"</td>");
                            out.print("<td>"+taskDescription.getDescription()+"</td>");

                            out.print("<td><a href=\"#editTaskModal\" class=\"edit\" data-toggle=\"modal\"><i class=\"material-icons\" data-toggle=\"tooltip\" title=\"Edit\">&#xE254;</i></a>" +
                                    "<a data-value='" + taskDescription.getTaskDescriptionID()+ "' href=\"#\" class=\"delete\" data-toggle=\"modal\"><i class=\"material-icons\" data-toggle=\"tooltip\" title=\"Delete\">&#xE872;</i></a></td>");



                            out.print("</tr>");
                        }
                    %>
                    </tbody>
                </table>
                <div/>
            </div>​

                ​

                <!--add employee moda -->

                ​<div id="addTaskNew" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">Ny arbetsuppgift</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <form id="example-advanced-form-addTask" action="#">
                            <h3>Info</h3>
                            <fieldset>
                                <label>Kategori</label>
                                <input name="taskType" type="text" class="form-control" required>
                                <label>Estimerad tid (timmar)</label>
                                <input name="estimatedTime" type="text" class="form-control" required>
                                <label>Job-typ</label>
                                <input name="jobType" type="text" class="form-control" required>
                                <label>Beskrivning</label>
                                <textarea name="description"  class="form-control" required></textarea>
                            </fieldset>
                            <h3>Delar</h3>
                            <fieldset>

                                <label>Del fran lagret</label>
                                <select id="firstInventoryList" class="form-control inventoryList" name="firstPart" required>
                                    <option selected="selected"></option>
                                </select>
                            <label>Antal</label>
                            <input id="firstPartAmount" name="firstPartAmount" type="text" class="form-control" required>
                                <button id="firstPart">Lagg till del</button>
                            </fieldset>

                        </form>
                    </div>
                </div>
            </div>

                <!--end-->

                <!-- add Modal HTML -->

                <!--get all info from current customer -->

                <!-- Edit Modal HTML -->
                <div id="editTaskModal" class="modal fade">
                    <div style="margin-top:30px" class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title">Andra arbetsuppgift</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <form id="example-advanced-form-editCustomer" action="#">
                                <h3>Info</h3>
                                <fieldset>
                                    <input id="editCustomerId" name="taskType" style="visibility: hidden" >
                                    <label>Kategori</label>
                                    <input name="estimatedTime" type="text" class="form-control" >
                                    <label>Estimerad tid</label>
                                    <input name="description" type="text" class="form-control" >
                                    <label>Beskrivning</label>
                                </fieldset>

                                <h3>Delar</h3>
                                <fieldset>
                                    <label>Del fran lagret</label>
                                    <select  class="form-control inventoryList" name="firstPart" required>
                                        <option selected="selected"></option>
                                    </select>
                                    <label>Antal</label>
                                    <input  name="firstPartAmount" type="text" class="form-control" required>
                                    <button>Lagg till del</button>
                                </fieldset>
                                </fieldset>
                            </form>
                        </div>
                    </div>
                </div>
                <!-- Delete Modal HTML -->
                <div id="deleteTaskDescriptionModal" class="modal fade">
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
                                    <input id="eraseTaskDescription" type="submit" class="btn btn-basic" value="Radera">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <!-- confirmation to modals -->




                <div id="successAddTaskDescription" class="modal fade ">
                    <div class="modal-dialog">
                        <div id="modalContent" class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title">Arbetstuppgift tillagt!</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <div class="statusResponse" id="statusSuccessAddTaskDescription"></div>
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
                <div id="successEraseTaskDescription" class="modal fade ">
                    <div class="modal-dialog">
                        <div  class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title">Kund raderad</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <div class="statusResponse" id="statusSuccessEraseTaskDescription"></div>
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
</div>
<!-- page container area end -->
<!-- offset area start -->
<%@include file="../modules/offsetArea.jsp"%>
<!-- offset area end -->
<%@include file="../modules/loadScripts.jsp"%>
<script>
    $(document).ready(function () {
        $('#table1').DataTable();
        $("#example-basic").steps({
            headerTag: "h3",res
            bodyTag: "section",
            transitionEffect: "slideLeft",
            autoFocus: true
        });inv


////FILL PARTS CHPOOSING PART



        $.ajax({
            url:'/varv/admin/stock/FindAllPartsJson.html',
            type:'GET',
            contentType:'application/x-www-form-urlencoded; charset=UTF-8',
            dataType:'json',

            success: function(data,status,xhr){
                console.log(data);

                $.each(data
                    , function(index,element){

                        $(".inventoryList").append("<option value='"+index+"'>"+element+"</option>")
                    })

            },
            error: function(jqXhr, textStatus,errorMessage){
                console.log(errorMessage);
            }
        })




        //WHEN ADDOING PART
        function hej (resetForm) {
            $("#firstPart").click(function (e) {
                e.preventDefault();
                console.log("hej");
                var count = 1;
                var selectedOption = $("#firstInventoryList").children("option:selected").html();
                var partId =  $("#firstInventoryList").children("option:selected").val();
                console.log(selectedOption);
                var amount = $("#firstPartAmount").val();

                console.log(amount);


                var id = "part" + count;
                $("#firstPart").after("<p id='"+partId+"' class='partInP'>" + amount + "st :" + selectedOption + "</p>");
                count++;



                resetForm();

            })

        }

     var resetForm =  function resetForm(){
            var form = $("#firstPart").closest('form');
            form.find("#firstPartAmount, #firstInventoryList").val("");
            console.log(form);
        }

        hej(resetForm);

    });



    //pop up are u sure button and passing the customer ID
    $('.delete').click(function(e){
        e.preventDefault();
        var id = $(this).data('value');
        var deleteModal =  $('#deleteTaskDescriptionModal');
        deleteModal.find('#eraseTaskDescription').data("value",id);
        deleteModal.find('#statusAreSure').html("Ar du saker pa add radera jobb med id: <span style='color:black'>" + id + "</span>");
        deleteModal.modal("toggle");
    })

    ///erase customer send request to sevlert

    $('#eraseTaskDescription').click(function(e){
        e.preventDefault();

        var id =  $(this).data('value');
        console.log(id);
        $.ajax({
            url:'/varv/admin/job/addTaskDescription.html?id='+id,
            type: 'DELETE',
            success: function (data, status, xhr) {

                $('#deleteTaskDescriptionModal').modal("toggle");
                $('#statusSuccessEraseTaskDescription').html("Arbetsuppgift med id" + name+ "<br> ar raderad.");

                $('#successEraseTaskDescription').modal("toggle");
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
