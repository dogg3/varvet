<%@ page import="uk.ac.city.douglas.varv.Account.domain.Customer" %>
<%@ page import="java.util.List" %>
<%@ page import="uk.ac.city.douglas.varv.Account.domain.Staff" %>
<%@ page import="org.json.simple.JSONObject" %>


<!doctype html>
<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Ramsovarvet AB</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" type="image/png" href="/varv/admin/assets/images/icon/favicon-boat.png">
    <link rel="stylesheet" href="/varv/admin/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="/varv/admin/assets/css/font-awesome.min.css">
    <link rel="stylesheet" href="/varv/admin/assets/css/themify-icons.css">
    <link rel="stylesheet" href="/varv/admin/assets/css/metisMenu.css">
    <link rel="stylesheet" href="/varv/admin/assets/css/owl.carousel.min.css">
    <link rel="stylesheet" href="/varv/admin/assets/css/slicknav.min.css">
    <!-- amchart css -->
    <link rel="stylesheet" href="https://www.amcharts.com/lib/3/plugins/export/export.css" type="text/css" media="all" />
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
    <!-- others css -->
    <link rel="stylesheet" href="/varv/admin/assets/css/typography.css">
    <link rel="stylesheet" href="/varv/admin/assets/css/default-css.css">
    <link rel="stylesheet" href="/varv/admin/assets/css/styles.css">
    <link rel="stylesheet" href="/varv/admin/assets/css/responsive.css">
    <link rel="stylesheet" href="/varv/admin/assets/css/step-jq.css">
    <!-- modernizr css -->
    <script src="/varv/admin/assets/js/vendor/modernizr-2.8.3.min.js"></script>s
</head>

<body>

<div id="preloader">
    <div class="loader"></div>
</div>
<!-- preloader area end -->
<!-- page container area start -->
<div class="page-container">
    <%@include file="../modules/sidebar.jsp"%>
    <div class="main-content">
        <%@include file="../modules/header.jsp"%>

        <%@include file="../modules/titleArea.jsp"%>

        <div class="container">
            <div style="padding:35px" class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-6">
                            <h2>Hantera <b>anstallda</b></h2>
                        </div>
                        <div class="col-sm-6">
                            <a href="#addStaffModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Lagg till ny anstalld</span></a>
                        </div>
                    </div>
                </div>
                <div class="table-responsive">
                    <table id="table1" class="table table-striped table-hover">
                        <thead>
                        <tr>
                            <th>Anstallds-ID</th>
                            <th>Namn</th>
                            <th>Telefon</th>
                            <th>Email</th>
                            <th>Tim-lon</th>
                            <th>Adress</th>
                            <th>Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            List<Staff> staffs = (List<Staff>)request.getAttribute("staffs");
                System.out.println("hej");
                            for(Staff staff: staffs){

                            JSONObject staffJSon = new JSONObject();
                                staffJSon.put("staffId", staff.getStaffId());
                                staffJSon.put("firstName", staff.getFirstName());
                                staffJSon.put("lastName", staff.getLastName());
                                staffJSon.put("tel", staff.getTel());
                                staffJSon.put("email", staff.getEmail());
                                staffJSon.put("postCode", staff.getPostCode());
                                staffJSon.put("street", staff.getStreet());
                                staffJSon.put("town", staff.getTown());


                                out.print("<tr id='staff-tr-id' data-value='" + staff.getStaffId()+"'>");
                                out.print("<td>"+ staff.getStaffId()+"</td>");
                                out.print("<td id=staff-tr-name data-value='"+staff.getFirstName()+" " +staff.getLastName()+"'>" +staff.getFirstName()+" "+ staff.getLastName()+"</td>");
                                out.print("<td>"+staff.getTel()+"</td>");
                                out.print("<td>"+staff.getEmail()+"</td>");
                                out.print("<td>"+staff.getHourlyRate()+"</td>");
                                out.print("<td>"+staff.getPostCode()
                                        + "<br>"+staff.getStreet() + "<br>" +
                                        staff.getTown()+ "</td>");

                                out.print("<td>" +
                                        "<a data-value='" +staffJSon +"' class='edit' id='editButton' class=\"edit\" data-toggle=\"modal\"><i class=\"material-icons\" data-toggle=\"tooltip\" title=\"Edit\">&#xE254;</i></a>" +
                                        "<a data-value='" + staff.getStaffId()+"' data-name='" + staff.getFirstName()+" "+staff.getLastName() +"'id='deleteButton' class=\"delete\" data-toggle=\"modal\"><i class=\"material-icons\" data-toggle=\"tooltip\" title=\"Delete\">&#xE872;</i></a></td>");



                                out.print("</tr>");
                            }
                        %>

                        </tbody>
                    </table>
                    <div/>
                </div>

                <!-- add Modal HTML -->
                <div id="addStaffModal" class="modal fade">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title">Ny anstalld</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <form id="example-advanced-form-addStaff" action="#">
                                <h3>Info</h3>
                                <fieldset>
                                    <label>Fornamn</label>
                                    <input name="firstName" type="text" class="form-control" required>
                                    <label>Efternamn</label>
                                    <input name="lastName" type="text" class="form-control" required>
                                    <label>Telefon</label>
                                    <input name="tel" type="text" class="form-control" required>
                                    <label>Email</label>
                                    <input name="email" type="email" class="form-control" required>
                                    <label>Tim-lon</label>
                                    <input name="hourlyRate" type="text" class="form-control" required>
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
                <!-- Edit Modal HTML -->
                <div id="editStaffModal" class="modal fade">
                    <div style="margin-top:30px" class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title">Andra anstalld</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <form id="example-advanced-form-editStaff" action="#">
                                <h3>Info</h3>
                                <fieldset>
                                    <input id="editStaffId" name="staffId" style="visibility: hidden" >
                                    <label>Fornamn</label>
                                    <input name="firstName" type="text" class="form-control" >
                                    <label>Efternamn</label>
                                    <input name="lastName" type="text" class="form-control" >
                                    <label>Telefon</label>
                                    <input name="tel" type="text" class="form-control" >
                                    <label>Email</label>
                                    <input name="email" type="email" class="form-control" >
                                    <label>Timlon</label>
                                    <input name="hourlyRate" type="text" class="form-control" >
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
                <div id="deleteStaffModal" class="modal fade">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <form>
                                <div class="modal-header">
                                    <h4 class="modal-title">Ta bort anstalld</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                </div>
                                <div class="modal-body">
                                    <p id="statusAreSure"></p>
                                </div>
                                <div class="modal-footer">
                                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Avbryt">
                                    <input id="eraseStaff" type="submit" class="btn btn-basic" value="Radera">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>


                <!-- confirmation to modals -->
                <div id="successAddStaff" class="modal fade ">
                    <div class="modal-dialog">
                        <div id="modalContent" class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title">Anstalld tillagd</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <div class="statusResponse" id="statusSuccessAddStaff"></div>
                            <div class="modal-footer">
                                <input type="submit" class="btn btn-basic" data-dismiss="modal" value="Ok">
                            </div>
                        </div>
                    </div>
                </div>
                <div id="successEraseStaff" class="modal fade ">
                    <div class="modal-dialog">
                        <div  class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title">Kund raderad</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <div class="statusResponse" id="statusSuccessEraseStaff"></div>
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
 <%@include file="../modules/footer.jsp"%>
</div>
<!-- page container area end -->
<!-- offset area start -->
<%@include file="../modules/offsetArea.jsp"%>
<!-- offset area end -->
<%@include file="../modules/loadScripts.jsp"%>


<script>
    $(document).ready(function () {
        $('#table1').DataTable();
    });


    //////////////////DELETE
    //pop up are u sure button and passing the customer ID
    $('.delete').click(function(e){
        e.preventDefault();
        var id = $(this).data('value');
        var name = $(this).data('name');
        var deleteModal =  $('#deleteStaffModal');
        deleteModal.find('#eraseStaff').data("value",id);
        deleteModal.find('#eraseStaff').data("name",name);
        deleteModal.find('#statusAreSure').html("Ar du saker pa add radera <span style='color:black'>" + name + "</span>");
        deleteModal.modal("toggle");
        console.log($(this).data('name'));
    })

        //SEND DELETE REQUEST TO SERVLET AddStaff
    $('#eraseStaff').click(function(e){
        e.preventDefault();

        var id =  $(this).data('value');
        var name = $(this).data('name');
        $.ajax({
            url:'/varv/admin/staff/addStaff.html?id='+id,
            type: 'DELETE',
            success: function (data, status, xhr) {

                $('#deleteStaffModal').modal("toggle");
                $('#statusSuccessEraseStaff').html(name+ " ar raderad.");
                $('#successEraseStaff').modal("toggle");
            }
        })
    })


    ///EDIT STAFF /////////
    //fill placeholder with correct valie//

    $('.edit').click(function(e){
        e.preventDefault();

        //Set placeholders
        var staff = $(this).data('value');
        console.log(staff);
        var form =$('#editStaffModal').find('form');
      console.log($.type(form));
        var allInput = form.find('input');
        //Set correct staff id to an input that is hidden
        //The script in script.js knows what staff to edit
        $('#editStaffId').val(staff['staffId']);

        allInput.each(function(index,value){
            var attr = $(value).attr('name');
            var placeholder = staff[attr];
            $(value).attr("placeholder", placeholder);

        });

        //show the form modal
        $('#editStaffModal').modal("show");

    })


</script>
</body>

</html>
