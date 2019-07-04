<%@ page import="uk.ac.city.douglas.varv.Account.domain.Customer" %>
<%@ page import="java.util.List" %>
<%@ page import="java.lang.reflect.Method" %>
<%@ page import="java.util.LinkedList" %>
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
    <script src="/varv/admin/assets/js/vendor/modernizr-2.8.3.min.js"></script>
</head>

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
                                <li><a href="/varv/admin/inventory/index.jsp">Lager-vy</a></li>
                                <li><a href="/varv/admin/inventory/resellers.jsp">Byggplast</a></li>
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

        <div class="container">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-6">
                            <h2>Hantera <b>kunder</b></h2>
                        </div>
                        <div  class="col-sm-6">
                            <a href="#addEmployeeNew" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Lagg till ny kund</span></a>
                        </div>
                    </div>
                </div>
                <div class="table-responsive">
                <table id="table1" class="table table-striped table-hover">
                    <thead>
                    <tr>
                        <th>Kund-ID</th>
                        <th>Namn</th>
                        <th>Telefon</th>
                        <th>Email</th>
                        <th>Rabatt</th>
                        <th>Adress</th>
                        <th>Smeknamn</th>
                        <th>Actions</th>
                    </tr>
                    </thead>
                    <tbody>

                            <%
                List<Customer> customers = (List<Customer>)request.getAttribute("customers");

                for(Customer customer: customers){

                    JSONObject customerJSon = new JSONObject();
                    customerJSon.put("customerId", customer.getCustomerID());
                    customerJSon.put("firstName", customer.getFirstName());
                    customerJSon.put("lastName", customer.getLastName());
                    customerJSon.put("tel", customer.getTel());
                    customerJSon.put("email", customer.getEmail());
                    customerJSon.put("discountPlan", customer.getDiscountPlan());
                    customerJSon.put("postCode", customer.getPostCode());
                    customerJSon.put("street", customer.getStreet());
                    customerJSon.put("identifier", customer.getIdentifier());
                    customerJSon.put("town", customer.getTown());


                    out.print("<tr id='customer-tr-id' data-value='" + customer.getCustomerID()+"'>");
                    out.print("<td>"+ customer.getCustomerID()+"</td>");
                    out.print("<td id=customer-tr-name data-value='"+customer.getFirstName()+" " +customer.getLastName()+"'>" +customer.getFirstName()+" "+ customer.getLastName()+"</td>");
                    out.print("<td>"+customer.getTel()+"</td>");
                    out.print("<td>"+customer.getEmail()+"</td>");
                    out.print("<td>"+customer.getDiscountPlan()+"</td>");
                    out.print("<td>"+customer.getPostCode()
                            + "<br>"+customer.getStreet() + "<br>" +
                           customer.getTown()+ "</td>");
                    out.print("<td>"+customer.getIdentifier()+"</a></td>");

                    out.print("<td>" +
                            "<a data-value='" +customerJSon +"' class='edit' id='editButton' class=\"edit\" data-toggle=\"modal\"><i class=\"material-icons\" data-toggle=\"tooltip\" title=\"Edit\">&#xE254;</i></a>" +
                            "<a data-value='" + customer.getCustomerID()+"' data-name='" + customer.getFirstName()+" "+customer.getLastName() +"'id='deleteButton' class=\"delete\" data-toggle=\"modal\"><i class=\"material-icons\" data-toggle=\"tooltip\" title=\"Delete\">&#xE872;</i></a></td>");



                    out.print("</tr>");
                }
            %>

                    </tbody>
                </table>
                <div/>
            </div>

                <!--add employee moda -->

                <div id="addEmployeeNew" class="modal fade">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title">Ny kund</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <form id="example-advanced-form" action="#">
                                <h3>Info</h3>
                                <fieldset>
                                    <label>Fornamn</label>
                                    <input name="firstName" type="text" class="form-control" required>
                                    <label>Efternamn</label>
                                    <input name="lastName" type="text" class="form-control" required>
                                    <label>Smeknamn</label>
                                    <input name="identifier" type="text" class="form-control" required>
                                    <label>Telefon</label>
                                    <input name="tel" type="text" class="form-control" required>
                                    <label>Email</label>
                                    <input name="email" type="email" class="form-control" required>
                                    <label>Rabatt</label>
                                    <input name="discountPlan" type="text" class="form-control" required>
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

                <!--end-->

            <!-- add Modal HTML -->

                <!--get all info from current customer -->

            <!-- Edit Modal HTML -->
                <div id="editEmployeeModal" class="modal fade">
                    <div style="margin-top:30px" class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title">Andra kund</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <form id="example-advanced-form-editCustomer" action="#">
                                <h3>Info</h3>
                                <fieldset>
                                    <input id="editCustomerId" name="customerId" style="visibility: hidden" >
                                    <label>Fornamn</label>
                                    <input name="firstName" type="text" class="form-control" >
                                    <label>Efternamn</label>
                                    <input name="lastName" type="text" class="form-control" >
                                    <label>Smeknamn</label>
                                    <input name="identifier" type="text" class="form-control" >
                                    <label>Telefon</label>
                                    <input name="tel" type="text" class="form-control" >
                                    <label>Email</label>
                                    <input name="email" type="email" class="form-control" >
                                    <label>Rabatt</label>
                                    <input name="discountPlan" type="text" class="form-control" >
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
            <div id="deleteEmployeeModal" class="modal fade">
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
                                <input id="eraseCustomer" type="submit" class="btn btn-basic" value="Radera">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
                <!-- confirmation to modals -->




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
                <div id="successEraseCustomer" class="modal fade ">
                    <div class="modal-dialog">
                        <div  class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title">Kund raderad</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <div class="statusResponse" id="statusSuccessEraseCustomer"></div>
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
<!-- offset area end -->
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
        $("#example-basic").steps({
            headerTag: "h3",
            bodyTag: "section",
            transitionEffect: "slideLeft",
            autoFocus: true
        });
    });

    //pop up are u sure button and passing the customer ID
    $('.delete').click(function(e){
        e.preventDefault();
        var id = $(this).data('value');
        var name = $(this).data('name');
        var deleteModal =  $('#deleteEmployeeModal');
        deleteModal.find('#eraseCustomer').data("value",id);
        deleteModal.find('#eraseCustomer').data("name",name);
        deleteModal.find('#statusAreSure').html("Ar du saker pa add radera <span style='color:black'>" + name + "</span>");
        deleteModal.modal("toggle");
        console.log($(this).data('name'));
    })

    ///erase customer send request to sevlert

    $('#eraseCustomer').click(function(e){
        e.preventDefault();

      var id =  $(this).data('value');
      var name = $(this).data('name');
        $.ajax({
            url:'/varv/admin/customer/addCustomer.html?id='+id,
            type: 'DELETE',
            success: function (data, status, xhr) {

                $('#deleteEmployeeModal').modal("toggle");
                $('#statusSuccessEraseCustomer').html(name+ " ar raderad.");

                $('#successEraseCustomer').modal("toggle");
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