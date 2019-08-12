<%@ page import="uk.ac.city.douglas.varv.Account.domain.Customer" %>
<%@ page import="java.util.List" %>
<%@ page import="uk.ac.city.douglas.varv.Stock.domain.Part" %>
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
                            <h2>Aterforsaljare</h2>
                        </div>

                    </div>
                </div>
                <div class="table-responsive">
                    <table id="table1" class="table table-striped table-hover">
                        <thead>
                        <tr>
                            <th>Aterforsaljare</th>
                            <th>Artikel-nr</th>
                            <th>Beskrivning</th>
                            <th>Varugrupp</th>
                            <th>Katalogpris ex-moms</th>
                            <th>Katalogpris ink-moms</th>
                            <th>Momskod</th>
                            <th>EAN-kod</th>
                            <th>Bestall</th>
                        </tr>
                        </thead>
                        <tbody>

                            <%
                        List<Part> parts = (List<Part>)request.getAttribute("parts");


                        for(Part part: parts){

                           //Set all the values of each Part row into a json object
                            // Then passing the jsonObject as a data-value onClick function of the
                            //Edit button when the modal is popping up
                            //the script that is invoked is at the end of this file

                            JSONObject partJson = new JSONObject();
                            partJson.put("artNr", part.getArtNr());
                            partJson.put("benamning", part.getBenamning());
                            partJson.put("vaurGrupp", part.getVaruGrupp());
                            partJson.put("katalogPrisExMoms", part.getKatalogPrisExMoms());
                            partJson.put("katalogPrisInkMoms", part.getGetKatalogPrisInkMoms());


                        out.print("<tr>");


                        out.print("<td>"+part.getReseller()+"</td>");
                        out.print("<td>"+part.getArtNr()+"</td>");
                        out.print("<td>"+part.getBenamning()+"</td>");
                        out.print("<td>"+part.getVaruGrupp()+"</td>");
                        out.print("<td>"+part.getKatalogPrisExMoms()+" kr</td>");
                        out.print("<td>"+part.getGetKatalogPrisInkMoms()+" kr</td>");
                        out.print("<td>"+part.getMomsKod()+"</td>");
                        out.print("<td>"+part.getEanKod()+"</td>");

                            out.print("<td>" +
                                    "<a data-value='"+partJson+"' class='edit' id='editButton' class=\"edit\" data-toggle=\"modal\"><i class=\"material-icons\" data-toggle=\"tooltip\" title=\"Edit\">&#xE254;</i></a></td>");


                        out.print("</tr>");
                        }
                        %>

                        </tbody>
                    </table>
                    <div/>
                </div>
                <!-- Edit Modal HTML -->
                <div id="orderPartModal" class="modal fade">
                    <div class="modal-dialog">
                        <div class="modal-content">
                                <div class="modal-header">
                                    <h4 class="modal-title">Bestall del</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                </div>
                                <div class="modal-body">
                                    <div class="form-group">
                                        <label style="font-size: 1.7em" id="benamning"></label><br>
                                        <label>Artikel nr:</label>&nbsp;<label style="font-size: 1.3em" id="artNrInModal"></label><br>
                                        <label>Katalogpris ex moms:</label>&nbsp;<label style="font-size: 1.3em" id="katalogPrisExMoms"></label>&nbsp;<span style="font-size: 1.3em">SEK</span><br>
                                        <label>Katalogpris ink moms:</label>&nbsp;<label style="font-size: 1.3em" id="katalogPrisInkMoms"></label>&nbsp;<span style="font-size: 1.3em">SEK</span><br>
                                        <label style="font-size: 1.5em">Antal</label>
                                        <input type="text" class="form-control" required>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                                    <input type="submit" class="btn btn-success" value="Bestall">
                                </div>
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
                                    <h4 class="modal-title">Andra kund-data</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                </div>
                                <div class="modal-body">
                                    <div class="form-group">
                                        <label>Name</label>
                                        <input type="text" class="form-control" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Email</label>
                                        <input type="email" class="form-control" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Address</label>
                                        <textarea class="form-control" required></textarea>
                                    </div>
                                    <div class="form-group">
                                        <label>Phone</label>
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
                <div id="deleteEmployeeModal" class="modal fade">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <form>
                                <div class="modal-header">
                                    <h4 class="modal-title">Radera kund</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                </div>
                                <div class="modal-body">
                                    <p>Ar du saker att du vill radera denna kund?</p>
                                    <p class="text-warning"><small>Detta gar inte att angra</small></p>
                                </div>
                                <div class="modal-footer">
                                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Avbryt">
                                    <input type="submit" class="btn btn-danger" value="Radera">
                                </div>
                            </form>
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



    ///Order Part /////////

    $('.edit').click(function(e){
        e.preventDefault();

        //Set placeholders
        //the variable part is taking the jsonObject that was passed in the form
        var part = $(this).data('value');

        //This is putting the form into a variale
        var form =$('#orderPartModal').find('form');

        console.log(part);
        console.log(part['artNr'])

        //Set correct staff id to an input that is hidden
        //The script in script.js knows what staff to edit
        $('#benamning').html(part['benamning']);
        $('#artNrInModal').html(part['artNr']);
        $('#katalogPrisExMoms').html(part['katalogPrisExMoms']);
        $('#katalogPrisInkMoms').html(part['katalogPrisInkMoms']);




        //show the form modal
        $('#orderPartModal').modal("show");

    })

</script>
</body>

</html>
