<%@ page import="uk.ac.city.douglas.varv.Account.domain.Customer" %>
<%@ page import="java.util.List" %>
<%@ page import="uk.ac.city.douglas.varv.Boat.domain.BoatVariant" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="uk.ac.city.douglas.varv.Boat.domain.BoatStorage" %>
<%@ page import="uk.ac.city.douglas.varv.Boat.domain.Boat" %>
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
                            <h2>Hantera<b> vinterplats</b></h2>
                        </div>
                        <div class="col-sm-6">
                            <a href="#addBoatStorageModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Lagg till ny vinterplats</span></a>
                        </div>
                    </div>
                </div>
                <div class="table-responsive">
                    <table id="table1" class="table table-striped table-hover">
                        <thead>
                        <tr>
                            <th>Vinterplats-id</th>
                            <th>Kund</th>
                            <th>Bat</th>
                            <th>Status</th>
                            <th>Upphamtningsdatum</th>
                            <th>Avlamningsdatum</th>
                            <th>Kommentar</th>
                            <th>Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            List<BoatStorage> boatStorages = (List<BoatStorage>)request.getAttribute("boatStorages");




                            for(BoatStorage bs: boatStorages){


                                Customer customer = bs.getCustomerBoat().getCustomer();

                                Boat boat = bs.getCustomerBoat().getBoat();

                                out.print("<tr>");
                                out.print("<td>"+bs.getBoatStorageId()+"</td>");
                                out.print("<td>"+customer.getFirstName()+" &nbsp;"+customer.getLastName()+"</td>");
                                out.print("<td>"+boat.getModel()+"&nbsp;"+boat.getBrand()+"</td>");
                                out.print("<td>"+bs.getStatus()+"</td>");
                                out.print("<td>"+bs.getPickUpDate()+"</td>");
                                out.print("<td>"+bs.getDropOffDate()+"</td>");
                                out.print("<td>"+bs.getComment()+"</td>");

                                out.print("<td>" +
                                        "<a class='edit' href=\"#editVinterplatsModal\" id='editButton' class=\"edit\" data-toggle=\"modal\"><i class=\"material-icons\" data-toggle=\"tooltip\" title=\"Edit\">&#xE254;</i></a>" +
                                        "<a data-value='" + bs.getBoatStorageId()+"'id='deleteButton' class=\"delete\" data-toggle=\"modal\"><i class=\"material-icons\" data-toggle=\"tooltip\" title=\"Delete\">&#xE872;</i></a>" +
                                        "</td>");




                                out.print("</tr>");
                            }
                        %>
                        </tbody>
                    </table>
                    <div/>
                </div>
            </div>

                <!-- Ny kundbat -->
                <div id="addBoatStorageModal" class="modal fade">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title">Ny vinterplats</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <form id="add-boatStorageForm" action="#">
                                <h3>Info</h3>
                                <fieldset>
                                    <label>KundBat</label>
                                    <input name="boatVariantId" type="text" class="form-control" required>
                                    <label>Upphamtnings-datum</label>
                                    <input name="pickUpDate" type="date" class="form-control" required>
                                    <label>Avlamnings-datum</label>
                                    <input name="dropOffDate" type="date" class="form-control" required>
                                    <label>Kommentar</label>
                                    <textarea name="comment" type="text" class="form-control" required></textarea>
                                </fieldset>

                            </form>
                        </div>
                    </div>
                </div>
                <!-- Edit Modal HTML -->
                <div id="editVinterplatsModal" class="modal fade">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <form>
                                <div class="modal-header">
                                    <h4 class="modal-title">Andra vinterplats</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                </div>
                                <div class="modal-body">
                                    <div class="form-group">
                                        <label>Upphamtnings-datum</label>
                                        <input name="pickUpDate" type="date" class="form-control" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Avlamnings-datum</label>
                                        <input name="dropOffDate" type="date" class="form-control" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Kommentar</label>
                                        <textarea name="comment" class="form-control" required></textarea>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Avbryt">
                                    <input type="submit" class="btn btn-info" value="Spara">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <!-- Delete Modal HTML -->

                <div id="deleteBoatStorageModal" class="modal fade">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <form>
                                <div class="modal-header">
                                    <h4 class="modal-title">Radera vinterplats</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                </div>
                                <div class="modal-body">
                                    <p id="statusAreSure"></p>
                                </div>
                                <div class="modal-footer">
                                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Avbryt">
                                    <input id="eraseBoatStorage" type="submit" class="btn btn-basic" value="Radera">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>


                <%--successs areae--%>



                <div id="successAddBoatStorage" class="modal fade ">
                    <div class="modal-dialog">
                        <div id="modalContent" class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title">Vinterplats tillagd</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <div class="statusResponse" id="statusSuccessAddBoatStorage"></div>
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
                <div id="successEraseBoatStorage" class="modal fade ">
                    <div class="modal-dialog">
                        <div  class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title">Kundbat raderad</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <div class="statusResponse" id="statusSuccessEraseBoatStorage"></div>
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


<%@include file="../modules/loadScripts.jsp"%>


<script>
    $(document).ready(function () {
        $('#table1').DataTable();
    });



    //pop up are u sure button and passing the customer ID
    $('.delete').click(function(e){
        e.preventDefault();
        var id = $(this).data('value');
        console.log(id);
        var deleteModal =  $('#deleteBoatStorageModal');
        deleteModal.find('#eraseBoatStorage').data("value",id);
        deleteModal.find('#statusAreSure').html("Ar du saker pa add radera <span style='color:black'>" + id);
        deleteModal.modal("toggle");
    })


    ///erase boatVariant send request to sevlert

    $('#eraseBoatStorage').click(function(e){
        e.preventDefault();

        var id =  $(this).data('value');
        console.log(id);
        $.ajax({
            url:'/varv/admin/vinterplats/addBoatStorage.html?id='+id,
            type: 'DELETE',
            success: function (data, status, xhr) {

                $('#deleteBoatStorageModal').modal("toggle");
                $('#statusSuccessEraseBoatStorage').html("Vinterplats ar raderad");

                $('#successEraseBoatStorage').modal("toggle");
            }
        })
    })



    ///EDIT TOOGLE AND FILL PLACEHOLDER

    $('.edit').click(function(e){
        e.preventDefault();

        //Set placeholders
        var boatVariant = $(this).data('value');
        var form =$('#editBoatVariantModal').find('form');
        // console.log(boatVariant);
        var allInput = form.find('label');
        $('#boatVariantId').val(boatVariant['id']);

        allInput.each(function(index,value){
            // console.log(value);
            var attr = $(value).attr('name');

            var placeholder = boatVariant[attr];
            // console.log(attr);
            $(value).html( placeholder);

        });

        var textarea = form.find('textarea');
        console.log()
        $(textarea).attr("placeholder", boatVariant["comment"]);
        //show the form modal
        $('#editBoatVariantModal').modal("show");

    })
</script>
</body>

</html>
