<%@ page import="java.util.List" %>
<%@ page import="uk.ac.city.douglas.varv.Stock.domain.Inventory" %>
<%@ page import="uk.ac.city.douglas.varv.Stock.domain.Part" %>
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

        <!-- page title area start -->

        <div class="container">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-6">
                            <h2>Hantera<b> lager</b></h2>
                        </div>
                        <div class="col-sm-6">
                            <a href="#addInventoryNew" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Lagg till ny reservdel</span></a>
                        </div>
                    </div>
                </div>
                <div class="table-responsive">
                    <table id="table1" class="table table-striped table-hover">
                        <thead>
                        <tr>
                            <th>Artikel-nr</th>
                            <th>Aterforsaljare</th>
                            <th>Produkt</th>
                            <th>Pris ink moms</th>
                            <th>EAN-kod</th>
                            <th>Antal</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tbody>

                        <%
                            List<Inventory> inventories = (List<Inventory>)request.getAttribute("inventories");

                            for(Inventory inventory: inventories){

                                Part part = inventory.getPart();

                                out.print("<tr>");
                                out.print("<td>"+ inventory.getArtNr()+"</td>");
                                out.print("<td>"+ part.getReseller()+"</td>");
                                out.print("<td>"+ part.getBenamning()+"</td>");
                                out.print("<td>"+ part.getGetKatalogPrisInkMoms()+"</td>");
                                out.print("<td>"+ part.getEanKod()+"</td>");
                                out.print("<td>"+ inventory.getAmount()+"</td>");

                                out.print("<td>" +
                                        "<a data-value='' class='edit' id='editButton' class=\"edit\" data-toggle=\"modal\"><i class=\"material-icons\" data-toggle=\"tooltip\" title=\"Edit\">&#xE254;</i></a>" +
                                        "<a data-value='" + inventory.getArtNr()+"' id='deleteButton' class=\"delete\" data-toggle=\"modal\"><i class=\"material-icons\" data-toggle=\"tooltip\" title=\"Delete\">&#xE872;</i></a></td>");


                                out.print("</tr>");
                            }
                        %>

                        </tbody>
                    </table>
                    <div/>
                </div>
                <!-- ADd Modal HTML -->
                <div id="addInventoryNew" class="modal fade">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title">Ny del</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <form id="example-advanced-form-addInventory" action="#">
                                <h3>Info</h3>
                                <fieldset>
                                    <label>Art-nr aterforsaljare</label>
                                    <select id="resellerList" name="artNrReseller" class="form-control" required>
                                        <option selected="selected"></option>
                                    </select>

                                    <label>antal</label>
                                    <input name="amount" type="text" class="form-control" required>
                                </fieldset>


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
                                    <h4 class="modal-title">Andra lager</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                </div>
                                <div class="modal-body">
                                    <div class="form-group">
                                        <label>Antal</label>
                                        <input type="text" class="form-control" required>
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
                <div id="deleteInventory" class="modal fade">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <form>
                                <div class="modal-header">
                                    <h4 class="modal-title">Radera kund</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                </div>
                                <div class="modal-body">
                                    <p>Ar du saker att du vill radera denna <br>reservdel fran lagret?</p>
                                    <p class="text-warning"><small>Detta gar inte att angra</small></p>
                                </div>
                                <div class="modal-footer">
                                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Avbryt">
                                    <input id="eraseInventory"  type="submit" class="btn btn-danger" value="Radera">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>


                <%--Success area--%>


                <div id="successAddInventory" class="modal fade ">
                    <div class="modal-dialog">
                        <div id="modalContent" class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title">Reserv-del tillagd</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <div class="statusResponse" id="statusSuccessAddInventory"></div>
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
                <div id="successEraseInventory" class="modal fade ">
                    <div class="modal-dialog">
                        <div  class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title">Kundbat raderad</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <div class="statusResponse" id="statusSuccessEraseInventory"></div>
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

<%@include file="../modules/loadScripts.jsp"%>

<script>
    $(document).ready(function () {
        $('#table1').DataTable();
    });



    //populate reseller list for choosing in add inventory
    $.ajax({
        url:'/varv/admin/stock/FindAllPartsJson.html',
        type:'GET',
        contentType:'application/x-www-form-urlencoded; charset=UTF-8',
        dataType:'json',

        success: function(data,status,xhr){
            console.log(data);

            $.each(data
                , function(index,element){

                    $("#resellerList").append("<option value='"+index+"'>"+element+"</option>")
                })

        },
        error: function(jqXhr, textStatus,errorMessage){
            console.log(errorMessage);
        }
    })



    //pop up are u sure button and passing the customer ID
    $('.delete').click(function(e){
        e.preventDefault();
        var id = $(this).data('value');
        var name = $(this).data('name');
        var deleteModal =  $('#deleteInventory');
        deleteModal.find('#eraseInventory').data("value",id);
        deleteModal.find('#statusAreSure').html("Ar du saker pa add radera denna del");
        deleteModal.modal("toggle");
    })

    ///erase customer send request to sevlert

    $('#eraseInventory').click(function(e){
        e.preventDefault();

        var id =  $(this).data('value');
        $.ajax({
            url:'/varv/admin/inventory/addInventory.html?id='+id,
            type: 'DELETE',
            success: function (data, status, xhr) {

                $('#deleteInventory').modal("toggle");
                $('#statusSuccessEraseInventory').html("Delen ar raderad fran lagret.");

                $('#successEraseInventory').modal("toggle");
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
