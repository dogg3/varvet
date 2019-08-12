<!doctype html>
<html class="no-js" lang="en">


<%@include file="../modules/head.jsp"%>
<body>

<![endif]-->
<!-- preloader area start -->
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
        <!-- page title area end -->
        <div class="main-content-inner">
            <!-- color pricing start -->
            <div class="row">
                <div class="col-xl-3 col-ml-6 col-mdl-4 col-sm-6 mt-5">
                    <div class="card">
                        <div class="pricing-list">
                            <div class="prc-head">
                                <h4>Backa upp databas</h4>
                            </div>
                            <div class="prc-list">
                                <ul>
                                    <li><a href="#">En gang i manden</a></li>
                                </ul>
                                <a href="#">Buy Package</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-xl-3 col-ml-6 col-mdl-4 col-sm-6 mt-5">
                    <div class="card">
                        <div class="pricing-list">
                            <div class="prc-head">
                                <h4>Aterstall databas</h4>
                            </div>
                            <div class="prc-list">
                                <ul>
                                    <li><a href="#">Aterstall databas</a></li>
                                </ul>
                                <a href="#"Aterstall</a>
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
<!-- offset area end -->
<%@include file="../modules/loadScripts.jsp"%>
</body>

</html>
