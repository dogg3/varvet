<%@ page import="java.util.List" %>
<%@ page import="uk.ac.city.douglas.varv.Boat.domain.BoatVariant" %>
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
        <!-- header area end -->
        <!-- page title area start -->
        <%@include file="../modules/titleArea.jsp"%>

        <div class="container">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-6">
                            <h2>Hantera<b> kundbatar</b></h2>
                        </div>
                        <div class="col-sm-6">
                            <a href="#addBoatVariantModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Lagg till ny kundbat</span></a>
                        </div>
                    </div>
                </div>
                <div class="table-responsive">
                    <table id="table1" class="table table-striped table-hover">
                        <thead>
                        <tr>
                            <th>Kund</th>
                            <th>Bat</th>
                            <th>Langd cm</th>
                            <th>Bredd cm</th>
                            <th>Ar</th>
                            <th>Kommentar</th>
                            <th>Actions</th>
                        </tr>
                        </thead>
                        <tbody>
    <%
                        List<BoatVariant> boatVariants = (List<BoatVariant>)request.getAttribute("customerBoats");

            for(BoatVariant b : boatVariants){
                System.out.println(b.toString());
            }


                        for(BoatVariant b: boatVariants){


                            JSONObject boatVariantJson = new JSONObject();
                            boatVariantJson.put("id", b.getCustomerBoatId());
                            boatVariantJson.put("boat", b.getBoat().getBrand() +" " + b.getBoat().getModel());
                            boatVariantJson.put("customer", b.getCustomer().getFirstName() +" " + b.getCustomer().getLastName());
                            boatVariantJson.put("comment", b.getDescription());
                            boatVariantJson.put("year", b.getYear());

                        out.print("<tr>");
                        out.print("<td>"+b.getCustomer().getFirstName()+"&nbsp;"+ b.getCustomer().getLastName()+"</td>");
                        out.print("<td>"+b.getBoat().getBrand()+"&nbsp; "+b.getBoat().getModel()+"</td>");
                        out.print("<td>"+b.getBoat().getLength()+"</td>");
                        out.print("<td>"+b.getBoat().getWidth()+"</td>");
                        out.print("<td>"+b.getYear()+"</td>");
                        out.print("<td>"+b.getDescription()+"</td>");

                            out.print("<td>" +
                                    "<a data-value='"+boatVariantJson+"' class='edit' id='editButton' class=\"edit\" data-toggle=\"modal\"><i class=\"material-icons\" data-toggle=\"tooltip\" title=\"Edit\">&#xE254;</i></a>" +
                                    "<a data-value='" + b.getCustomerBoatId()+"'data-boat='"+b.getBoat().getBrand()+"&nbsp;"+b.getBoat().getModel() +"' data-name='" + b.getCustomer().getFirstName()+" "+b.getCustomer().getLastName() +"'id='deleteButton' class=\"delete\" data-toggle=\"modal\"><i class=\"material-icons\" data-toggle=\"tooltip\" title=\"Delete\">&#xE872;</i></a>" +
                                    "</td>");




                            out.print("</tr>");
                        }
                        %>
                        </tbody>
                    </table>
                    <div/>
                </div>

                <!-- Ny kundbat -->
                <div id="addBoatVariantModal" class="modal fade">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title">Ny kundbat</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <form id="add-boatVariantForm" action="#">
                                <h3>Info</h3>
                                <fieldset>
                                    <label>Kund</label>
                                    <select id="customerList" name="customer" class="form-control" required>
                                        <option selected="selected"></option>
                                    </select>
                                    <label>Boat</label>
                                    <select id="boatList" name="boat" class="form-control" required>
                                        <option selected="selected"></option>
                                    </select>
                                    <label>Ar</label>
                                    <input  type="number" min="1900" max="2099" step="1" name="year" class="form-control" required>
                                    <label>Kommentar</label>
                                    <textarea name="description" type="text" class="form-control" required></textarea>
                                </fieldset>
                                <h3>Motorer</h3>
                                <fieldset>
                                    <label>Motorer</label>
                                    <select id="engineList" name="engineList"  class="form-control" required>
                                        <option selected="selected"></option>
                                    </select>
                                    <label>Antal</label>
                                    <input  type="number" min="1" max="5" step="1" name="amount" class="form-control" required>



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
    <!-- footer area end-->
</div>
<!-- page container area end -->
<!-- offset area start -->
<%@include file="../modules/offsetArea.jsp"%>
<%@include file="../modules/loadScripts.jsp"%>

<script>
    $(document).ready(function () {
        $('#table1').DataTable();

        //populate boats

        //populate customer list for choosing in add customer
        $.ajax({
            url:'/varv/admin/boat/FindAllBoatsJson.html',
            type:'GET',
            contentType:'application/x-www-form-urlencoded; charset=UTF-8',
            dataType:'json',

            success: function(data,status,xhr){
                console.log(data);

                $.each(data
                    , function(index,element){

                        $("#boatList").append("<option value='"+index+"'>"+element+"</option>")
                    })

            },
            error: function(jqXhr, textStatus,errorMessage){
                console.log(errorMessage);
            }
        })





        //populate customer list for choosing in add customer
            $.ajax({
                url:'/varv/admin/customer/FindAllEnginesJson.html',
                type:'GET',
                contentType:'application/x-www-form-urlencoded; charset=UTF-8',
                dataType:'json',

                success: function(data,status,xhr){
                    console.log(data);

                    $.each(data
                        , function(index,element){

                            $("#customerList").append("<option value='"+index+"'>"+element+"</option>")
                        })

                },
                error: function(jqXhr, textStatus,errorMessage){
                    console.log(errorMessage);
                }
            })



        ///Populate engine list for choosing in addengin
        $.ajax({
            url:'/varv/admin/boat/FindAllEnginesJson.html',
            type:'GET',
            contentType:'application/x-www-form-urlencoded; charset=UTF-8',
            dataType:'json',

            success: function(data,status,xhr){
                console.log(data);

                $.each(data
                    , function(index,element){

                        $("#engineList").append("<option value='"+index+"'>"+element+"</option>")
                    })

            },
            error: function(jqXhr, textStatus,errorMessage){
                console.log(errorMessage);
            }
        })
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
