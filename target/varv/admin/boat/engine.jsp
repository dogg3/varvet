<%@ page import="uk.ac.city.douglas.varv.Account.domain.Customer" %>
<%@ page import="java.util.List" %>
<%@ page import="uk.ac.city.douglas.varv.Boat.domain.BoatVariant" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="uk.ac.city.douglas.varv.Boat.domain.Engine" %>
<!doctype html>
<html class="no-js" lang="en">
<%@include file="../modules/head.jsp"%>
<body>

<div id="preloader">
    <div class="loader"></div>
</div>

<div class="page-container">

    <%@include file="../modules/sidebar.jsp"%>

    <div class="main-content">
        <%@include file="../modules/header.jsp"%>>

        <%@include file="../modules/titleArea.jsp"%>

        <div class="container">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-6">
                            <h2>Motor-databas</h2>
                        </div>
                        <div class="col-sm-6">
                            <a href="#addEngine" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Lagg till ny motor</span></a>
                        </div>
                    </div>
                </div>
                <div class="table-responsive">
                    <table id="table1" class="table table-striped table-hover">
                        <thead>
                        <tr>
                            <th>id</th>
                            <th>Marke</th>
                            <th>Modell</th>
                            <th>Ar</th>
                            <th>Hastkrafter</th>
                            <th>Typ</th>
                            <th>Cylinder</th>
                            <th>Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            List<Engine> engines = (List<Engine>)request.getAttribute("engines");




                            for(Engine e: engines){

                                JSONObject engineJson = new JSONObject();
                                engineJson.put("engineId", e.getEngineId());
                                engineJson.put("brand", e.getBrand());
                                engineJson.put("year", e.getYear());
                                engineJson.put("horsePower", e.getHorsePower());
                                engineJson.put("type", e.getType());
                                engineJson.put("cylinder", e.getCylinder());
                                engineJson.put("gas", e.getGas());
                                engineJson.put("model", e.getModel());

                                out.print("<tr>");
                                out.print("<td>"+e.getEngineId()+"</td>");
                                out.print("<td>"+e.getBrand()+"</td>");
                                out.print("<td>"+e.getModel()+"</td>");
                                out.print("<td>"+e.getYear()+"</td>");
                                out.print("<td>"+e.getHorsePower()+"</td>");
                                out.print("<td>"+e.getType()+"</td>");
                                out.print("<td>"+e.getCylinder()+"</td>");

                                out.print("<td>" +
                                        "<a class='edit' data-value='"+engineJson+"' id='editButton' class=\"edit\" data-toggle=\"modal\"><i class=\"material-icons\" data-toggle=\"tooltip\" title=\"Edit\">&#xE254;</i></a>" +
                                        "<a data-value='" + e.getEngineId()+"'id='deleteButton' class=\"delete\" data-toggle=\"modal\"><i class=\"material-icons\" data-toggle=\"tooltip\" title=\"Delete\">&#xE872;</i></a>" +
                                        "</td>");




                                out.print("</tr>");
                            }
                        %>
                        </tbody>
                    </table>
                    <div/>
                </div>

                <!-- Ny kundbat -->
                <div id="addEngine" class="modal fade">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title">Lagg till motor</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <form id="add-engineForm" action="#">
                                <h3>Info</h3>
                                <fieldset>
                                    <label>Marke</label>
                                    <input name="Brand" type="text" class="form-control" required>

                                    <label>Modell</label>
                                    <input name="Model" type="text" class="form-control" required>

                                    <label>Typ</label>
                                    <input name="Type" type="text" class="form-control" required>


                                    <label>Ar</label>
                                    <input name="Year" type="text" class="form-control" required>
                                    <label>Hastkrafter</label>
                                    <input name="HorsePower" type="text" class="form-control" required>
                                    <label>Cylinder</label>
                                    <input name="Cylinder" type="text" class="form-control" required>
                                    <label>Bransle</label>
                                    <input name="Gas" type="text" class="form-control" required>

                                </fieldset>

                            </form>
                        </div>
                    </div>
                </div>
                <!-- Edit Modal HTML -->
                <div id="editEngineModal" class="modal fade">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <form id="editEngineForm">
                                <div class="modal-header">
                                    <h4 class="modal-title">Andra kundbats-data</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                </div>
                                <div class="modal-body">
                                    <div class="form-group">
                                        <label>Marke</label>
                                        <input class="form-control" type="text" name="brand"></input>
                                    </div>
                                    <div class="form-group">
                                        <label>Ar</label>
                                        <input class="form-control" type="text" name="year"></input>
                                    </div>
                                    <div class="form-group">
                                        <label>Hastkrafter</label>
                                        <input type="text" name="horsePower" class="form-control" required></input>
                                    </div>
                                    <div class="form-group">
                                        <label>Typ</label>
                                        <input type="text" name="type" class="form-control" required></input>
                                    </div>
                                    <div class="form-group">
                                        <label>Cylinder</label>
                                        <input type="text" name="cylinder" class="form-control" required></input>
                                    </div>
                                    <div class="form-group">
                                        <label>Bransle</label>
                                        <input type="text" name="gas" class="form-control" required></input>
                                    </div>
                                    <div class="form-group">
                                        <label>Modell</label>
                                        <input type="text" name="model" class="form-control" required></input>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Avbryt">
                                    <input id="editEngineSubmit" type="submit" class="btn btn-info"/>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <!-- Delete Modal HTML -->

                <div id="deleteEngineModal" class="modal fade">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <form>
                                <div class="modal-header">
                                    <h4 class="modal-title">Radera motor</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                </div>
                                <div class="modal-body">
                                    <p id="statusAreSure"></p>
                                </div>
                                <div class="modal-footer">
                                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Avbryt">
                                    <input id="eraseEngine" type="submit" class="btn btn-basic" value="Radera">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>


                <%--successs areae--%>



                <div id="successAddEngine" class="modal fade ">
                    <div class="modal-dialog">
                        <div id="modalContent" class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title">Kund tillagd</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <div class="statusResponse" id="statusSuccessAddEngine"></div>
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
                <div id="successEraseEngine" class="modal fade ">
                    <div class="modal-dialog">
                        <div  class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title">Kundbat raderad</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <div class="statusResponse" id="statusSuccessEraseEngine"></div>
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
        var deleteModal =  $('#deleteEngineModal');
        deleteModal.find('#eraseEngine').data("value",id);
        deleteModal.find('#statusAreSure').html("Ar du saker pa add radera denna motor");
        deleteModal.modal("toggle");
        console.log($(this).data('name'));
    })


    ///erase boatVariant send request to sevlert

    $('#eraseEngine').click(function(e){
        e.preventDefault();

        var id =  $(this).data('value');


        $.ajax({
            url:'/varv/admin/addEngine.html?id='+id,
            type: 'DELETE',
            success: function (data, status, xhr) {
                    console.log("h");
                $('#deleteEngineModal').modal("toggle");
                $('#statusSuccessEraseEngine').html("Motorn ar raderad!");

                $('#successEraseEngine').modal("toggle");
            }
        })
    })




    ///EDIT TOOGLE AND FILL PLACEHOLDER

    $('.edit').click(function(e){
        e.preventDefault();

        //Set placeholders
        var engine = $(this).data('value');
        console.log(engine);
        var form =$('#editEngineModal').find('form');
        var allInput = form.find('input');
        $('#boatEngineId').val(engine['id']);

        allInput.each(function(index,value){
            // console.log(value);
            var attr = $(value).attr('name');
            console.log(value);
            var placeholder = engine[attr];
            $(value).attr( "placeholder",placeholder);

        });
        //show the form modal
        $('#editEngineModal').modal("show");

    })


    //Handle edit Submit
    document.getElementById("editEngineSubmit").addEventListener("click",(event)=>{
       event.preventDefault();
        var formData = new Map();
        var editForm = document.getElementById("editEngineForm")
        var arr = [...editForm];
        arr.forEach(item=>{
            var attr = item.getAttribute('name');
            var value = item.value;
            if(!!attr && !!value){
                formData.set(attr, value);
            }


        })

        const url = "/varv/admin/engine/editEngine.html";


        let obj = {};
        formData.forEach((item,key)=>{
            obj[key]=item;
        })

    console.log(obj);

        fetch(url,{
            method: 'POST', // or 'PUT'
            body: JSON.stringify(obj), // data can be `string` or {object}!
            headers:{
                'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
            }
        })
            .then(res => res.json())
            .then(response => console.log('Success:', JSON.stringify(response)))
            .catch(error => console.error('Error:', error));



    })

</script>
</body>

</html>
