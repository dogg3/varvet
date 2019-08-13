<%@ page import="uk.ac.city.douglas.varv.Account.domain.Customer" %>
<%@ page import="java.util.List" %>
<%@ page import="uk.ac.city.douglas.varv.Boat.domain.BoatVariant" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="uk.ac.city.douglas.varv.Boat.domain.BoatVariantEngine" %>
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
                            <h2>Hantera<b> kundbatsmotorer</b></h2>
                        </div>
                        <div class="col-sm-6">
                            <a href="#addBoatVariantEngineModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Lagg till ny kundbats-motor</span></a>
                        </div>
                    </div>
                </div>
                <div class="table-responsive">
                    <table id="table1" class="table table-striped table-hover">
                        <thead>
                        <tr>
                            <th>KundBatsmotor-id</th>
                            <th>Kundbats-id</th>
                            <th>Motor-namn</th>
                            <th>Kund-namn</th>
                            <th>Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                        List<BoatVariantEngine> boatVariantEngines = (List<BoatVariantEngine>)request.getAttribute("boatVariantEngines");


                        for(BoatVariantEngine be: boatVariantEngines){


                        out.print("<tr>");
                        out.print("<td>"+be.getCustomerBoatEngineId()+"</td>");
                        out.print("<td>"+be.getBoatVariant().getCustomerBoatId()+"</td>");
                        out.print("<td>"+be.getEngine().getModel()+"</td>");
                        out.print("<td>"+be.getBoatVariant().getCustomer().getFirstName()+"&nbsp;"+be.getBoatVariant().getCustomer().getLastName() +"</td>");

                        out.print("<td>" +
                        "<a class='edit' id='editButton' class=\"edit\" data-toggle=\"modal\"><i class=\"material-icons\" data-toggle=\"tooltip\" title=\"Edit\">&#xE254;</i></a>" +
                        "<a data-value='" +be.getCustomerBoatEngineId()+" 'id='deleteButton' class=\"delete\" data-toggle=\"modal\"><i class=\"material-icons\" data-toggle=\"tooltip\" title=\"Delete\">&#xE872;</i></a>" +
                        "</td>");




                        out.print("</tr>");
                        }
                        %>
                        </tbody>
                    </table>
                    <div/>
                </div>

                <!-- Ny kundbat -->
                <div id="addBoatVariantEngineModal" class="modal fade">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title">Ny kundbats-motor</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <form id="add-boatVariantForm" action="#">
                                <h3>Info</h3>
                                <fieldset>
                                    <label>kundbats-id</label>
                                    <input name="boatVariantId" type="text" class="form-control" required>
                                    <label>motor-id</label>
                                    <input name="engineId" type="text" class="form-control" required>
                                </fieldset>

                            </form>
                        </div>
                    </div>
                </div>
                <!-- Edit Modal HTML -->
                <div id="editBoatVariantModal" class="modal fade">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <form>
                                <div class="modal-header">
                                    <h4 class="modal-title">Andra kundbats-data</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                </div>
                                <div class="modal-body">
                                    <div class="form-group">
                                        <label>Kund</label>
                                        <label name="customer"></label>
                                    </div>
                                    <div class="form-group">
                                        <label>Bat</label>
                                        <label name="boat"></label>
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

                <div id="deleteBoatVariantModal" class="modal fade">
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
                                    <input id="eraseBoatVariant" type="submit" class="btn btn-basic" value="Radera">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>


                <%--successs areae--%>



                <div id="successAddBoatVariantEngine" class="modal fade ">
                    <div class="modal-dialog">
                        <div id="modalContent" class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title">Kund tillagd</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <div class="statusResponse" id="statusSuccessAddBoatVariantEngine"></div>
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
                <div id="successEraseBoatVariant" class="modal fade ">
                    <div class="modal-dialog">
                        <div  class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title">Kundbat raderad</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <div class="statusResponse" id="statusSuccessEraseBoatVariant"></div>
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
        var name = $(this).data('name');
        var boat = $(this).data('boat');
        var deleteModal =  $('#deleteBoatVariantModal');
        deleteModal.find('#eraseBoatVariant').data("value",id);
        deleteModal.find('#eraseBoatVariant').data("name",name);
        deleteModal.find('#eraseBoatVariant').data("boat",boat);
        deleteModal.find('#statusAreSure').html("Ar du saker pa add radera <span style='color:black'>" + name + "'s</span><br>" + boat);
        deleteModal.modal("toggle");
        console.log($(this).data('name'));
    })


    ///erase boatVariant send request to sevlert

    $('#eraseBoatVariant').click(function(e){
        e.preventDefault();

        var id =  $(this).data('value');
        console.log(id);
        var name = $(this).data('name');
        var boat = $(this).data('boat');
        $.ajax({
            url:'/varv/admin/boatVariant/addBoatVariant.html?id='+id,
            type: 'DELETE',
            success: function (data, status, xhr) {

                $('#deleteBoatVariantModal').modal("toggle");
                $('#statusSuccessEraseBoatVariant').html(name+ "s "+boat+" ar raderad.");

                $('#successEraseBoatVariant').modal("toggle");
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
