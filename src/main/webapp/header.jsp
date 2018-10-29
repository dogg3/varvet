<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>Ramsövarvet AB</title>
    
    <!---- jQuery --->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <!-- Bootstrap CSS CDN -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
    
    
    <!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

    
    <!-- Our Custom CSS -->
    <link rel="stylesheet" href="/varv/css/styles.css">

    <!-- Font Awesome JS -->
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js" integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ" crossorigin="anonymous"></script>
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js" integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY" crossorigin="anonymous"></script>

</head>

<body>

    <div class="wrapper">
        <!-- Sidebar Holder -->
        <nav id="sidebar">
            <div class="sidebar-header">
                <a href="/varv/index.jsp">
                <h4>Ramsövarvet AB</h4>
                <h6>Användare: <%=request.getRemoteUser()%></h6>
                </a>
            </div>

            <ul class="list-unstyled components">
                <li class="active">
                    <a href="#homeSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Båt-databas</a>
                    <ul class="collapse list-unstyled" id="homeSubmenu">
                        <li>
                        <a href="/varv/boat/findAllBoats.html">Båtar</a>
                        </li>
                        <li>
                           <a  href='/varv/engine/findAllEngines.html' class="button">Motorer</a>
                        </li>
                        <li>
                            <a  href='/varv/engine/addEngine.jsp' class="button">Lägg till motor</a>
                        </li>
                    </ul>
                </li>
                <li>
                   
                    <a href="#pageSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Kunder</a>
                    <ul class="collapse list-unstyled" id="pageSubmenu">
                        <li>
                          <a href='/varv/customer/findAllCustomers.html' class="button">Visa alla kunder</a>
                        </li>
                        <li>
                             <a href='/varv/customer/addCustomer.jsp' class="button">Lägg till ny kund</a>
                        </li>
                        <li>
                                  <a href='/varv/boatVariant/addBoatVariant.jsp' class="button">Lägg till kundbåt</a> 
                        </li>
                    </ul>
                </li>
                
            </ul>
 
            <ul class="list-unstyled CTAs">
               <li>
                    <a href="/varv/logout.html" class="download ">Logga ut</a>
                </li>
            </ul>

           
        </nav>

        <!-- Page Content Holder -->
        <div id="content">

            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">

                    <button type="button" id="sidebarCollapse" class="navbar-btn">
                        <span></span>
                        <span></span>
                        <span></span>
                    </button>
                    <button class="btn btn-dark d-inline-block d-lg-none ml-auto" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <i class="fas fa-align-justify"></i>
                    </button>

                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="nav navbar-nav ml-auto">
                            <li class="nav-item active">
                                <a class="nav-link" href="#">Page</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Page</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Page</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Page</a>
                            </li>
                        </ul>
                        
                    </div>
                    
                </div>

            </nav>
            

     