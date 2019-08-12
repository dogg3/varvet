<%@ page import="uk.ac.city.douglas.varv.Account.domain.Customer" %>
<%@ page import="java.util.List" %>
<%@ page import="uk.ac.city.douglas.varv.Finance.domain.Invoice" %>
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
                            <h2>Hantera<b> fakturor</b></h2>
                        </div>
                        <div class="col-sm-6">
                            <a href="#addInvoiceModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Lagg till ny faktura</span></a>
                        </div>
                    </div>
                </div>
                <div class="table-responsive">
                    <table id="table1" class="table table-striped table-hover">
                        <thead>
                        <tr>
                            <th>Faktura #</th>
                            <th>Datum</th>
                            <th>Kostnad ex moms</th>
                            <th>Moms</th>
                            <th>Kostnad ink moms</th>
                            <th>Status</th>
                            <th>Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                        List<Invoice> invoices = (List<Invoice>)request.getAttribute("invoices");


                        for(Invoice invoice: invoices){

                        out.print("<tr>");


                        out.print("<td>"+invoice.getInvoiceNo()+"</td>");
                        out.print("<td>"+invoice.getDate()+"</td>");
                        out.print("<td>"+invoice.getCost()+"</td>");
                        out.print("<td>"+invoice.getVat()+"</td>");
                        out.print("<td>"+invoice.getCostAfterVat()+"</td>");
                        out.print("<td>"+invoice.getStatus()+"</td>");
                        out.print("<td><a href=\"#editInvoiceModal\" class=\"edit\" data-toggle=\"modal\"><i class=\"material-icons\" data-toggle=\"tooltip\" title=\"Edit\">&#xE254;</i></a>" +
                                "<a href=\"#deleteInvoiceModal\" class=\"delete\" data-toggle=\"modal\"><i class=\"material-icons\" data-toggle=\"tooltip\" title=\"Delete\">&#xE872;</i></a></td>");



                        out.print("</tr>");
                        }
                        %>
                        </tbody>
                    </table>
                    <div/>
                </div>
                <!-- Edit Modal HTML -->
                <div id="addInvoiceModal" class="modal fade">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <form>
                                <div class="modal-header">
                                    <h4 class="modal-title">Lagg till faktura</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                </div>
                                <div class="modal-body">
                                    <div class="form-group">
                                        <label>Faktura #</label>
                                        <input type="text" class="form-control" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Datum</label>
                                        <input type="date" class="form-control" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Kostand ex moms</label>
                                        <input type="text" class="form-control" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Moms</label>
                                        <input type="text" class="form-control" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Status</label>
                                        <input type="text" class="form-control" required>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                                    <input type="submit" class="btn btn-success" value="Add">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <!-- Edit Modal HTML -->
                <div id="editInvoiceModal" class="modal fade">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <form>
                                <div class="modal-header">
                                    <h4 class="modal-title">Andra faktura-data</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                </div>
                                <div class="modal-body">
                                    < <div class="form-group">
                                    <label>Datum</label>
                                    <input type="date" class="form-control" required>
                                </div>
                                    <div class="form-group">
                                        <label>Kostand ex moms</label>
                                        <input type="text" class="form-control" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Moms</label>
                                        <input type="text" class="form-control" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Status</label>
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
                <div id="deleteInvoiceModa" class="modal fade">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <form>
                                <div class="modal-header">
                                    <h4 class="modal-title">Radera faktura</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                </div>
                                <div class="modal-body">
                                    <p>Ar du saker att du vill radera denna Faktura?</p>
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
    <footer>
        <div class="footer-area">
            <p>Ramsovarvet 2019</p>
        </div>
    </footer>
    <!-- footer area end-->
</div>
<!-- page container area end -->
<!-- offset area start -->
<%@include file="../modules/offsetArea.jsp"%>
<!-- offset area end -->
<!-- jquery latest version -->
<%@include file="../modules/loadScripts.jsp"%>
<script>
    $(document).ready(function () {
        $('#table1').DataTable();
    });
</script>
</body>

</html>


