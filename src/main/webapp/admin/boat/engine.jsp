<%@ page import="uk.ac.city.douglas.varv.Account.domain.Customer" %>
<%@ page import="java.util.List" %>
<%@ page import="uk.ac.city.douglas.varv.Boat.domain.BoatVariant" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="uk.ac.city.douglas.varv.Boat.domain.Engine" %>
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
    <script src="/varv/admin/assets/js/vendor/modernizr-2.8.3.min.js"></script>

<body>

<div id="preloader">
    <div class="loader"></div>
</div>
<!-- preloader area end -->
<!-- page container area start -->
<div class="page-container">
    <!-- sidebar menu area start -->
    <div class="sidebar-menu">
        <div class="sidebar-header">
            <a href="/varv/admin/index.html">
                <div class="logo">
                    <h2 style="color:white">Ramsovarvet</h2>
                </div>
            </a>
        </div>
        <div class="main-menu">
            <div class="menu-inner">
                <nav>
                    <ul class="metismenu" id="menu">
                        <li><a href="/varv/admin/customer/index.html"><i class="ti-target"></i> <span>Kunder</span></a></li>
                        <li><a href="/varv/admin/staff/index.html"><i class="ti-user-alt"></i> <span>Anstallda</span></a></li>
                        <li>
                            <a href="javascript:void(0)" aria-expanded="true"><i class="ti-anchor"></i>
                                <span>Batar</span></a>
                            <ul class="collapse">
                                <li><a href="/varv/admin/boat/index.html">Bat-databas</a></li>
                                <li><a href="/varv/admin/boat/customerBoats.html">Kundbatar</a></li>
                                <li><a href="/varv/admin/boat/vinterplats.html">Vinterplats</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="javascript:void(0)" aria-expanded="true"><i class="ti-money"></i>
                                <span>Ekonomi</span></a>
                            <ul class="collapse">
                                <li><a href="/varv/admin/finance/invoices.html">Faktura-vy</a></li>
                                <li><a href="/varv/admin/finance/generateInvoice.jsp">Generera faktura</a></li>
                                <li><a href="/varv/admin/finance/generateReports.jsp">Generera rapporter</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="javascript:void(0)" aria-expanded="true"><i class="ti-hummer"></i>
                                <span>Jobb</span></a>
                            <ul class="collapse">
                                <li><a href="/varv/admin/job/index.html">Jobb-vy</a></li>
                                <li><a href="/varv/admin/job/task.html">Arbetsuppgifter</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="javascript:void(0)" aria-expanded="true"><i class="ti-archive"></i>
                                <span>Lager</span></a>
                            <ul class="collapse">
                                <li><a href="/varv/admin/inventory/index.html">Lager-vy</a></li>
                                <li><a href="/varv/admin/inventory/resellers.html">Byggplast</a></li>
                            </ul>
                        </li>
                        <li><a href="/varv/admin/secure/index.jsp"><i class="ti-dashboard"></i> <span>Sakerhet</span></a></li>

                    </ul>
                </nav>
            </div>
        </div>
    </div>
    <!-- sidebar menu area end -->
    <!-- main content area start -->
    <div class="main-content">
        <!-- header area start -->
        <div class="header-area">
            <div class="row align-items-center">
                <!-- nav and search button -->
                <div class="col-md-6 col-sm-8 clearfix">
                    <div class="nav-btn pull-left">
                        <span></span>
                        <span></span>
                        <span></span>
                    </div>
                    <div class="search-box pull-left">
                        <form action="#">
                            <input type="text" name="search" placeholder="Sok..." required>
                            <i class="ti-search"></i>
                        </form>
                    </div>
                </div>
                <!-- profile info & task notification -->
                <div class="col-md-6 col-sm-4 clearfix">
                    <ul class="notification-area pull-right">
                        <li id="full-view"><i class="ti-fullscreen"></i></li>
                        <li id="full-view-exit"><i class="ti-zoom-out"></i></li>
                        <li class="dropdown">
                            <i class="ti-bell dropdown-toggle" data-toggle="dropdown">
                                <span>2</span>
                            </i>
                            <div class="dropdown-menu bell-notify-box notify-box">
                                <span class="notify-title">You have 3 new notifications <a href="#">view all</a></span>
                                <div class="nofity-list">
                                    <a href="#" class="notify-item">
                                        <div class="notify-thumb"><i class="ti-key btn-danger"></i></div>
                                        <div class="notify-text">
                                            <p>You have Changed Your Password</p>
                                            <span>Just Now</span>
                                        </div>
                                    </a>
                                    <a href="#" class="notify-item">
                                        <div class="notify-thumb"><i class="ti-comments-smiley btn-info"></i></div>
                                        <div class="notify-text">
                                            <p>New Commetns On Post</p>
                                            <span>30 Seconds ago</span>
                                        </div>
                                    </a>
                                    <a href="#" class="notify-item">
                                        <div class="notify-thumb"><i class="ti-key btn-primary"></i></div>
                                        <div class="notify-text">
                                            <p>Some special like you</p>
                                            <span>Just Now</span>
                                        </div>
                                    </a>
                                    <a href="#" class="notify-item">
                                        <div class="notify-thumb"><i class="ti-comments-smiley btn-info"></i></div>
                                        <div class="notify-text">
                                            <p>New Commetns On Post</p>
                                            <span>30 Seconds ago</span>
                                        </div>
                                    </a>
                                    <a href="#" class="notify-item">
                                        <div class="notify-thumb"><i class="ti-key btn-primary"></i></div>
                                        <div class="notify-text">
                                            <p>Some special like you</p>
                                            <span>Just Now</span>
                                        </div>
                                    </a>
                                    <a href="#" class="notify-item">
                                        <div class="notify-thumb"><i class="ti-key btn-danger"></i></div>
                                        <div class="notify-text">
                                            <p>You have Changed Your Password</p>
                                            <span>Just Now</span>
                                        </div>
                                    </a>
                                    <a href="#" class="notify-item">
                                        <div class="notify-thumb"><i class="ti-key btn-danger"></i></div>
                                        <div class="notify-text">
                                            <p>You have Changed Your Password</p>
                                            <span>Just Now</span>
                                        </div>
                                    </a>
                                </div>
                            </div>
                        </li>
                        <li class="dropdown">
                            <i class="fa fa-envelope-o dropdown-toggle" data-toggle="dropdown"><span>3</span></i>
                            <div class="dropdown-menu notify-box nt-enveloper-box">
                                <span class="notify-title">You have 3 new notifications <a href="#">view all</a></span>
                                <div class="nofity-list">
                                    <a href="#" class="notify-item">
                                        <div class="notify-thumb">
                                            <img src="/varv/admin/assets/images/author/author-img1.jpg" alt="image">
                                        </div>
                                        <div class="notify-text">
                                            <p>Aglae Mayer</p>
                                            <span class="msg">Hey I am waiting for you...</span>
                                            <span>3:15 PM</span>
                                        </div>
                                    </a>
                                    <a href="#" class="notify-item">
                                        <div class="notify-thumb">
                                            <img src="/varv/admin/assets/images/author/author-img2.jpg" alt="image">
                                        </div>
                                        <div class="notify-text">
                                            <p>Aglae Mayer</p>
                                            <span class="msg">When you can connect with me...</span>
                                            <span>3:15 PM</span>
                                        </div>
                                    </a>
                                    <a href="#" class="notify-item">
                                        <div class="notify-thumb">
                                            <img src="/varv/admin/assets/images/author/author-img3.jpg" alt="image">
                                        </div>
                                        <div class="notify-text">
                                            <p>Aglae Mayer</p>
                                            <span class="msg">I missed you so much...</span>
                                            <span>3:15 PM</span>
                                        </div>
                                    </a>
                                    <a href="#" class="notify-item">
                                        <div class="notify-thumb">
                                            <img src="/varv/admin/assets/images/author/author-img4.jpg" alt="image">
                                        </div>
                                        <div class="notify-text">
                                            <p>Aglae Mayer</p>
                                            <span class="msg">Your product is completely Ready...</span>
                                            <span>3:15 PM</span>
                                        </div>
                                    </a>
                                    <a href="#" class="notify-item">
                                        <div class="notify-thumb">
                                            <img src="/varv/admin/assets/images/author/author-img2.jpg" alt="image">
                                        </div>
                                        <div class="notify-text">
                                            <p>Aglae Mayer</p>
                                            <span class="msg">Hey I am waiting for you...</span>
                                            <span>3:15 PM</span>
                                        </div>
                                    </a>
                                    <a href="#" class="notify-item">
                                        <div class="notify-thumb">
                                            <img src="/varv/admin/assets/images/author/author-img1.jpg" alt="image">
                                        </div>
                                        <div class="notify-text">
                                            <p>Aglae Mayer</p>
                                            <span class="msg">Hey I am waiting for you...</span>
                                            <span>3:15 PM</span>
                                        </div>
                                    </a>
                                    <a href="#" class="notify-item">
                                        <div class="notify-thumb">
                                            <img src="/varv/admin/assets/images/author/author-img3.jpg" alt="image">
                                        </div>
                                        <div class="notify-text">
                                            <p>Aglae Mayer</p>
                                            <span class="msg">Hey I am waiting for you...</span>
                                            <span>3:15 PM</span>
                                        </div>
                                    </a>
                                </div>
                            </div>
                        </li>
                        <li class="settings-btn">
                            <i class="ti-settings"></i>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <!-- header area end -->
        <!-- page title area start -->
        <div style="padding:20px" class="page-title-area">
            <div class="row align-items-center">
                <div class="col-sm-6">
                    <div class="breadcrumbs-area clearfix">
                        <h4 class="page-title pull-left">Motorer</h4>
                        <ul class="breadcrumbs pull-left">
                            <li>Batar /</li>
                            <li><span>Motorer</span></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>

        <div class="container">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-6">
                            <h2>Motor-databas</h2>
                        </div>
                        <div class="col-sm-6">
                            <a href="#addBoatVariantModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Lagg till ny motor</span></a>
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

                                out.print("<tr>");
                                out.print("<td>"+e.getEngineId()+"</td>");
                                out.print("<td>"+e.getBrand()+"</td>");
                                out.print("<td>"+e.getModel()+"</td>");
                                out.print("<td>"+e.getYear()+"</td>");
                                out.print("<td>"+e.getHorsePower()+"</td>");
                                out.print("<td>"+e.getType()+"</td>");
                                out.print("<td>"+e.getCylinder()+"</td>");

                                out.print("<td>" +
                                        "<a class='edit' id='editButton' class=\"edit\" data-toggle=\"modal\"><i class=\"material-icons\" data-toggle=\"tooltip\" title=\"Edit\">&#xE254;</i></a>" +
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
                                    <input name="customer" type="text" class="form-control" required>
                                    <label>Boat</label>
                                    <input name="boat" type="text" class="form-control" required>
                                    <label>Kommentar</label>
                                    <input name="description" type="text" class="form-control" required>
                                    <label>Ar</label>
                                    <input name="year" type="text" class="form-control" required>
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
    <footer>
        <div class="footer-area">
            <p>Ramsovarvet 2019</p>
        </div>
    </footer>
    <!-- footer area end-->
</div>
<!-- page container area end -->
<!-- offset area start -->
<div class="offset-area">
    <div class="offset-close"><i class="ti-close"></i></div>
    <ul class="nav offset-menu-tab">
        <li><a class="active" data-toggle="tab" href="#activity">Activity</a></li>
        <li><a data-toggle="tab" href="#settings">Settings</a></li>
    </ul>
    <div class="offset-content tab-content">
        <div id="activity" class="tab-pane fade in show active">
            <div class="recent-activity">
                <div class="timeline-task">
                    <div class="icon bg1">
                        <i class="fa fa-envelope"></i>
                    </div>
                    <div class="tm-title">
                        <h4>Rashed sent you an email</h4>
                        <span class="time"><i class="ti-time"></i>09:35</span>
                    </div>
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Esse distinctio itaque at.
                    </p>
                </div>
                <div class="timeline-task">
                    <div class="icon bg2">
                        <i class="fa fa-check"></i>
                    </div>
                    <div class="tm-title">
                        <h4>Added</h4>
                        <span class="time"><i class="ti-time"></i>7 Minutes Ago</span>
                    </div>
                    <p>Lorem ipsum dolor sit amet consectetur.
                    </p>
                </div>
                <div class="timeline-task">
                    <div class="icon bg2">
                        <i class="fa fa-exclamation-triangle"></i>
                    </div>
                    <div class="tm-title">
                        <h4>You missed you Password!</h4>
                        <span class="time"><i class="ti-time"></i>09:20 Am</span>
                    </div>
                </div>
                <div class="timeline-task">
                    <div class="icon bg3">
                        <i class="fa fa-bomb"></i>
                    </div>
                    <div class="tm-title">
                        <h4>Member waiting for you Attention</h4>
                        <span class="time"><i class="ti-time"></i>09:35</span>
                    </div>
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Esse distinctio itaque at.
                    </p>
                </div>
                <div class="timeline-task">
                    <div class="icon bg3">
                        <i class="ti-signal"></i>
                    </div>
                    <div class="tm-title">
                        <h4>You Added Kaji Patha few minutes ago</h4>
                        <span class="time"><i class="ti-time"></i>01 minutes ago</span>
                    </div>
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Esse distinctio itaque at.
                    </p>
                </div>
                <div class="timeline-task">
                    <div class="icon bg1">
                        <i class="fa fa-envelope"></i>
                    </div>
                    <div class="tm-title">
                        <h4>Ratul Hamba sent you an email</h4>
                        <span class="time"><i class="ti-time"></i>09:35</span>
                    </div>
                    <p>Hello sir , where are you, i am egerly waiting for you.
                    </p>
                </div>
                <div class="timeline-task">
                    <div class="icon bg2">
                        <i class="fa fa-exclamation-triangle"></i>
                    </div>
                    <div class="tm-title">
                        <h4>Rashed sent you an email</h4>
                        <span class="time"><i class="ti-time"></i>09:35</span>
                    </div>
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Esse distinctio itaque at.
                    </p>
                </div>
                <div class="timeline-task">
                    <div class="icon bg2">
                        <i class="fa fa-exclamation-triangle"></i>
                    </div>
                    <div class="tm-title">
                        <h4>Rashed sent you an email</h4>
                        <span class="time"><i class="ti-time"></i>09:35</span>
                    </div>
                </div>
                <div class="timeline-task">
                    <div class="icon bg3">
                        <i class="fa fa-bomb"></i>
                    </div>
                    <div class="tm-title">
                        <h4>Rashed sent you an email</h4>
                        <span class="time"><i class="ti-time"></i>09:35</span>
                    </div>
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Esse distinctio itaque at.
                    </p>
                </div>
                <div class="timeline-task">
                    <div class="icon bg3">
                        <i class="ti-signal"></i>
                    </div>
                    <div class="tm-title">
                        <h4>Rashed sent you an email</h4>
                        <span class="time"><i class="ti-time"></i>09:35</span>
                    </div>
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Esse distinctio itaque at.
                    </p>
                </div>
            </div>
        </div>
        <div id="settings" class="tab-pane fade">
            <div class="offset-settings">
                <h4>General Settings</h4>
                <div class="settings-list">
                    <div class="s-settings">
                        <div class="s-sw-title">
                            <h5>Notifications</h5>
                            <div class="s-swtich">
                                <input type="checkbox" id="switch1" />
                                <label for="switch1">Toggle</label>
                            </div>
                        </div>
                        <p>Keep it 'On' When you want to get all the notification.</p>
                    </div>
                    <div class="s-settings">
                        <div class="s-sw-title">
                            <h5>Show recent activity</h5>
                            <div class="s-swtich">
                                <input type="checkbox" id="switch2" />
                                <label for="switch2">Toggle</label>
                            </div>
                        </div>
                        <p>The for attribute is necessary to bind our custom checkbox with the input.</p>
                    </div>
                    <div class="s-settings">
                        <div class="s-sw-title">
                            <h5>Show your emails</h5>
                            <div class="s-swtich">
                                <input type="checkbox" id="switch3" />
                                <label for="switch3">Toggle</label>
                            </div>
                        </div>
                        <p>Show email so that easily find you.</p>
                    </div>
                    <div class="s-settings">
                        <div class="s-sw-title">
                            <h5>Show Task statistics</h5>
                            <div class="s-swtich">
                                <input type="checkbox" id="switch4" />
                                <label for="switch4">Toggle</label>
                            </div>
                        </div>
                        <p>The for attribute is necessary to bind our custom checkbox with the input.</p>
                    </div>
                    <div class="s-settings">
                        <div class="s-sw-title">
                            <h5>Notifications</h5>
                            <div class="s-swtich">
                                <input type="checkbox" id="switch5" />
                                <label for="switch5">Toggle</label>
                            </div>
                        </div>
                        <p>Use checkboxes when looking for yes or no answers.</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- jquery latest version -->
<script src="/varv/admin/assets/js/vendor/jquery-2.2.4.min.js"></script>
<script src="/varv/admin/assets/js/vendor/jquery.steps.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.min.js"></script>
<!-- bootstrap 4 js -->
<script src="/varv/admin/assets/js/popper.min.js"></script>
<script src="/varv/admin/assets/js/bootstrap.min.js"></script>

<script src="/varv/admin/assets/js/owl.carousel.min.js"></script>
<script src="/varv/admin/assets/js/metisMenu.min.js"></script>
<script src="/varv/admin/assets/js/jquery.slimscroll.min.js"></script>
<script src="/varv/admin/assets/js/jquery.slicknav.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>

<!--jquery form plygin -->
<script src="/varv/admin/assets/js/jquery.form.min.js"></script>
<!-- start chart js -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.min.js"></script>
<!-- start highcharts js -->
<script src="https://code.highcharts.com/highcharts.js"></script>
<!-- start zingchart js -->
<script src="https://cdn.zingchart.com/zingchart.min.js"></script>
<script>
    zingchart.MODULESDIR = "https://cdn.zingchart.com/modules/";
    ZC.LICENSE = ["569d52cefae586f634c54f86dc99e6a9", "ee6b7db5b51705a13dc2339db3edaf6d"];
</script>
<!-- all line chart activation -->
<script src="/varv/admin/assets/js/line-chart.js"></script>
<!-- all pie chart -->
<script src="/varv/admin/assets/js/pie-chart.js"></script>
<!-- others plugins -->
<script src="/varv/admin/assets/js/plugins.js"></script>
<script src="/varv/admin/assets/js/scripts.js"></script>
<script src="/varv/admin/assets/js/jq-modal.js"></script>

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
