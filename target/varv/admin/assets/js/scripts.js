
(function($) {
    "use strict";

    /*================================
    Preloader
    ==================================*/

    var preloader = $('#preloader');
    $(window).on('load', function() {
        preloader.fadeOut('slow', function() { $(this).remove(); });
    });

    /*================================
    sidebar collapsing
    ==================================*/
    $('.nav-btn').on('click', function() {
        $('.page-container').toggleClass('sbar_collapsed');
    });

    /*================================
    Start Footer resizer
    ==================================*/
    var e = function() {
        var e = (window.innerHeight > 0 ? window.innerHeight : this.screen.height) - 5;
        (e -= 67) < 1 && (e = 1), e > 67 && $(".main-content").css("min-height", e + "px")
    };
    $(window).ready(e), $(window).on("resize", e);

    /*================================
    sidebar menu
    ==================================*/
    $("#menu").metisMenu();

    /*================================
    slimscroll activation
    ==================================*/
    $('.menu-inner').slimScroll({
        height: 'auto'
    });
    $('.nofity-list').slimScroll({
        height: '435px'
    });
    $('.timeline-area').slimScroll({
        height: '500px'
    });
    $('.recent-activity').slimScroll({
        height: 'calc(100vh - 114px)'
    });
    $('.settings-list').slimScroll({
        height: 'calc(100vh - 158px)'
    });

    /*================================
    stickey Header
    ==================================*/
    $(window).on('scroll', function() {
        var scroll = $(window).scrollTop(),
            mainHeader = $('#sticky-header'),
            mainHeaderHeight = mainHeader.innerHeight();

        // console.log(mainHeader.innerHeight());
        if (scroll > 1) {
            $("#sticky-header").addClass("sticky-menu");
        } else {
            $("#sticky-header").removeClass("sticky-menu");
        }
    });

    /*================================
    form bootstrap validation
    ==================================*/
    $('[data-toggle="popover"]').popover()

    /*------------- Start form Validation -------------*/
    window.addEventListener('load', function() {
        // Fetch all the forms we want to apply custom Bootstrap validation styles to
        var forms = document.getElementsByClassName('needs-validation');
        // Loop over them and prevent submission
        var validation = Array.prototype.filter.call(forms, function(form) {
            form.addEventListener('submit', function(event) {
                if (form.checkValidity() === false) {
                    event.preventDefault();
                    event.stopPropagation();
                }
                form.classList.add('was-validated');
            }, false);
        });
    }, false);

    /*================================
    datatable active
    ==================================*/
    if ($('#dataTable').length) {
        $('#dataTable').DataTable({
            responsive: true
        });
    }
    if ($('#dataTable2').length) {
        $('#dataTable2').DataTable({
            responsive: true
        });
    }
    if ($('#dataTable3').length) {
        $('#dataTable3').DataTable({
            responsive: true
        });
    }


    /*================================
    Slicknav mobile menu
    ==================================*/
    $('ul#nav_menu').slicknav({
        prependTo: "#mobile_menu"
    });

    /*================================
    login form
    ==================================*/
    $('.form-gp input').on('focus', function() {
        $(this).parent('.form-gp').addClass('focused');
    });
    $('.form-gp input').on('focusout', function() {
        if ($(this).val().length === 0) {
            $(this).parent('.form-gp').removeClass('focused');
        }
    });

    /*================================
    slider-area background setting
    ==================================*/
    $('.settings-btn, .offset-close').on('click', function() {
        $('.offset-area').toggleClass('show_hide');
        $('.settings-btn').toggleClass('active');
    });

    /*================================
    Owl Carousel
    ==================================*/
    function slider_area() {
        var owl = $('.testimonial-carousel').owlCarousel({
            margin: 50,
            loop: true,
            autoplay: false,
            nav: false,
            dots: true,
            responsive: {
                0: {
                    items: 1
                },
                450: {
                    items: 1
                },
                768: {
                    items: 2
                },
                1000: {
                    items: 2
                },
                1360: {
                    items: 1
                },
                1600: {
                    items: 2
                }
            }
        });
    }
    slider_area();

    /*================================
    Fullscreen Page
    ==================================*/

    if ($('#full-view').length) {

        var requestFullscreen = function(ele) {
            if (ele.requestFullscreen) {
                ele.requestFullscreen();
            } else if (ele.webkitRequestFullscreen) {
                ele.webkitRequestFullscreen();
            } else if (ele.mozRequestFullScreen) {
                ele.mozRequestFullScreen();
            } else if (ele.msRequestFullscreen) {
                ele.msRequestFullscreen();
            } else {
                console.log('Fullscreen API is not supported.');
            }
        };

        var exitFullscreen = function() {
            if (document.exitFullscreen) {
                document.exitFullscreen();
            } else if (document.webkitExitFullscreen) {
                document.webkitExitFullscreen();
            } else if (document.mozCancelFullScreen) {
                document.mozCancelFullScreen();
            } else if (document.msExitFullscreen) {
                document.msExitFullscreen();
            } else {
                console.log('Fullscreen API is not supported.');
            }
        };

        var fsDocButton = document.getElementById('full-view');
        var fsExitDocButton = document.getElementById('full-view-exit');

        fsDocButton.addEventListener('click', function(e) {
            e.preventDefault();
            requestFullscreen(document.documentElement);
            $('body').addClass('expanded');
        });

        fsExitDocButton.addEventListener('click', function(e) {
            e.preventDefault();
            exitFullscreen();
            $('body').removeClass('expanded');
        });
    }



////////////////CUSTOMER//////////////////////////////////

    //ADD CUSTOMER FORM
    var form = $("#example-advanced-form").show();



    form.steps({
        headerTag: "h3",
        bodyTag: "fieldset",
        transitionEffect: "slideLeft",
        labels: {
            current: "Aktuellt steg:",
            pagination: "Pagination",
            finish: "Lagg till",
            next: "Nasta",
            previous: "Forra",
            loading: "Laddar ..."
        },
        onStepChanging: function (event, currentIndex, newIndex)
        {
            // Allways allow previous action even if the current form is not valid!
            if (currentIndex > newIndex)
            {
                return true;
            }
            // Forbid next action on "Warning" step if the user is to young
            if (newIndex === 3 && Number($("#age-2").val()) < 18)
            {
                return false;
            }
            // Needed in some cases if the user went back (clean up)
            if (currentIndex < newIndex)
            {
                // To remove error styles
                form.find(".body:eq(" + newIndex + ") label.error").remove();
                form.find(".body:eq(" + newIndex + ") .error").removeClass("error");
            }
            form.validate().settings.ignore = ":disabled,:hidden";
            return form.valid();
        },
        onStepChanged: function (event, currentIndex, priorIndex)
        {
            // Used to skip the "Warning" step if the user is old enough.
            if (currentIndex === 2 && Number($("#age-2").val()) >= 18)
            {
                form.steps("next");
            }
            // Used to skip the "Warning" step if the user is old enough and wants to the previous step.
            if (currentIndex === 2 && priorIndex === 3)
            {
                form.steps("previous");
            }
        },
        onFinishing: function (event, currentIndex)
        {
            form.validate().settings.ignore = ":disabled";
            return form.valid();
        },
        onFinished: function (event, currentIndex)
        {
            var data = JSON.stringify($(form).serializeArray());


            $.ajax({
                url:'/varv/admin/customer/addCustomer.html',
                type:'POST',
                contentType:'application/x-www-form-urlencoded; charset=UTF-8',
                dataType:'json',
                data: {formData:data
                },
                success: function(data,status,xhr){
                var statusMessage;
                    if(data.status=="success"){
                statusMessage = data.customer;
                    }
                    $('#statusSuccessAddCustomer').html(statusMessage + " har lagts till!");
                    $('#addEmployeeNew').modal('toggle');
                    $('#successAddEmployee').modal('toggle');
                    $('#example-advanced-form').resetForm();
                    form.steps("previous");
                },
                error: function(jqXhr, textStatus,errorMessage){
                    console.log(errorMessage);
                }
            })
        }
    }).validate({
        errorPlacement: function errorPlacement(error, element) { element.before(error); },
        rules: {
            confirm: {
                equalTo: "#password-2"
            }
        }
    });



 ////////////////////////EDIT-CUSTOMER FORM /////////////////////////////////////////////////////////////////
    var editCustomerForm = $("#example-advanced-form-editCustomer").show();



    editCustomerForm.steps({
        headerTag: "h3",
        bodyTag: "fieldset",
        transitionEffect: "slideLeft",
        labels: {
            current: "Aktuellt steg:",
            pagination: "Pagination",
            finish: "Submit",
            next: "Nasta",
            previous: "Forra",
            loading: "Laddar ..."
        },
        onStepChanging: function (event, currentIndex, newIndex)
        {
            // Allways allow previous action even if the current form is not valid!
            if (currentIndex > newIndex)
            {
                return true;
            }
            // Needed in some cases if the user went back (clean up)
            if (currentIndex < newIndex)
            {
                // To remove error styles
                editCustomerForm.find(".body:eq(" + newIndex + ") label.error").remove();
                editCustomerForm.find(".body:eq(" + newIndex + ") .error").removeClass("error");
            }
            editCustomerForm.validate().settings.ignore = ":disabled,:hidden";
            return editCustomerForm.valid();
        },
        onStepChanged: function (event, currentIndex, priorIndex)
        {

        },
        onFinishing: function (event, currentIndex)
        {
            editCustomerForm.validate().settings.ignore = ":disabled";
            return editCustomerForm.valid();
        },
        onFinished: function (event, currentIndex)
        {
            var data = JSON.stringify($(editCustomerForm).serializeArray());

            var firstName = $('#example-advanced-form-editCustomer').find("input[name=firstName]");
            var lastName = $('#example-advanced-form-editCustomer').find("input[name=lastName]");


            $.ajax({
                url:'/varv/admin/customer/editCustomer.html',
                type:'POST',
                contentType:'application/x-www-form-urlencoded; charset=UTF-8',
                dataType:'json',
                data: {formData:data
                },
                success: function(data,status,xhr){
                    var statusMessage;
                    if(data.status=="success"){
                        statusMessage =   firstName.attr('placeholder')  + " " + lastName.attr('placeholder');
                    }
                    $('#statusSuccessEditCustomer').html("Kund: " + statusMessage + " har uppdaterats!");
                    $('#editEmployeeModal').modal('hide');
                    $('#successEditCustomer').modal('show');
                    $('#example-advanced-form-editCustomer').resetForm();
                    editCustomerForm.steps("previous");
                },
                error: function(jqXhr, textStatus,errorMessage){
                    console.log(errorMessage);
                }
            })
        }
    });



    ///////////////////////////STAFF///////////////////////////////////


    //ADD STAFF FORM

    //ADD CUSTOMER FORM
    var formAddStaff = $("#example-advanced-form-addStaff").show();



    formAddStaff.steps({
        headerTag: "h3",
        bodyTag: "fieldset",
        transitionEffect: "slideLeft",
        labels: {
            current: "Aktuellt steg:",
            pagination: "Pagination",
            finish: "Lagg till",
            next: "Nasta",
            previous: "Forra",
            loading: "Laddar ..."
        },
        onStepChanging: function (event, currentIndex, newIndex)
        {
            // Allways allow previous action even if the current form is not valid!
            if (currentIndex > newIndex)
            {
                return true;
            }
            // Forbid next action on "Warning" step if the user is to young
            if (newIndex === 3 && Number($("#age-2").val()) < 18)
            {
                return false;
            }
            // Needed in some cases if the user went back (clean up)
            if (currentIndex < newIndex)
            {
                // To remove error styles
                formAddStaff.find(".body:eq(" + newIndex + ") label.error").remove();
                formAddStaff.find(".body:eq(" + newIndex + ") .error").removeClass("error");
            }
            formAddStaff.validate().settings.ignore = ":disabled,:hidden";
            return formAddStaff.valid();
        },
        onStepChanged: function (event, currentIndex, priorIndex)
        {

        },
        onFinishing: function (event, currentIndex)
        {
            formAddStaff.validate().settings.ignore = ":disabled";
            return formAddStaff.valid();
        },
        onFinished: function (event, currentIndex)
        {
            var data = JSON.stringify($(formAddStaff).serializeArray());


            $.ajax({
                url:'/varv/admin/staff/addStaff.html',
                type:'POST',
                contentType:'application/x-www-form-urlencoded; charset=UTF-8',
                dataType:'json',
                data: {formData:data
                },
                success: function(data,status,xhr){
                    var statusMessage;
                    if(data.status=="success"){
                        statusMessage = data.staff;
                    }
                    $('#statusSuccessAddStaff').html(statusMessage + " har lagts till!");
                    $('#addStaffModal').modal('toggle');
                    $('#successAddStaff').modal('toggle');
                    $('#example-advanced-form-addStaff').resetForm();
                    formAddStaff.steps("previous");
                },
                error: function(jqXhr, textStatus,errorMessage){
                    console.log(errorMessage);
                }
            })
        }
    });

    ////EDIT STAFF //////
    var editStaffForm = $("#example-advanced-form-editStaff").show();



    editStaffForm.steps({
        headerTag: "h3",
        bodyTag: "fieldset",
        transitionEffect: "slideLeft",
        labels: {
            current: "Aktuellt steg:",
            pagination: "Pagination",
            finish: "Submit",
            next: "Nasta",
            previous: "Forra",
            loading: "Laddar ..."
        },
        onStepChanging: function (event, currentIndex, newIndex)
        {
            // Allways allow previous action even if the current form is not valid!
            if (currentIndex > newIndex)
            {
                return true;
            }
            // Needed in some cases if the user went back (clean up)
            if (currentIndex < newIndex)
            {
                // To remove error styles
                editStaffForm.find(".body:eq(" + newIndex + ") label.error").remove();
                editStaffForm.find(".body:eq(" + newIndex + ") .error").removeClass("error");
            }
            editStaffForm.validate().settings.ignore = ":disabled,:hidden";
            return editStaffForm.valid();
        },
        onStepChanged: function (event, currentIndex, priorIndex)
        {

        },
        onFinishing: function (event, currentIndex)
        {
            editStaffForm.validate().settings.ignore = ":disabled";
            return editStaffForm.valid();
        },
        onFinished: function (event, currentIndex)
        {
            var data = JSON.stringify($(editStaffForm).serializeArray());

            var firstName = $('#example-advanced-form-editStaff').find("input[name=firstName]");
            var lastName = $('#example-advanced-form-editStaff').find("input[name=lastName]");


            $.ajax({
                url:'/varv/admin/staff/editStaff.html',
                type:'POST',
                contentType:'application/x-www-form-urlencoded; charset=UTF-8',
                dataType:'json',
                data: {formData:data
                },
                success: function(data,status,xhr){
                    var statusMessage;
                    if(data.status=="success"){
                        statusMessage =   firstName.attr('placeholder')  + " " + lastName.attr('placeholder');
                    }
                    // $('#statusSuccessEditStaff').html("Kund: " + statusMessage + " har uppdaterats!");
                    $('#editStaffModal').modal('hide');
                    // $('#successEditStaff').modal('show');
                    $('#example-advanced-form-editStaff').resetForm();
                    editStaffForm.steps("previous");
                },
                error: function(jqXhr, textStatus,errorMessage){
                    console.log(errorMessage);
                }
            })
        }
    });

    //// ADD BOATVARIANT pppppppppppppppppppp

    var addBoatVariantForm = $("#add-boatVariantForm").show();


    addBoatVariantForm.steps({
        headerTag: "h3",
        bodyTag: "fieldset",
        transitionEffect: "slideLeft",
        labels: {
            current: "Aktuellt steg:",
            pagination: "Pagination",
            finish: "Lagg till",
            next: "Nasta",
            previous: "Forra",
            loading: "Laddar ..."
        },
        onStepChanging: function (event, currentIndex, newIndex)
        {
            // Allways allow previous action even if the current addBoatVariantForm is not valid!
            if (currentIndex > newIndex)
            {
                return true;
            }
            // Needed in some cases if the user went back (clean up)
            if (currentIndex < newIndex)
            {
                // To remove error styles
                addBoatVariantForm.find(".body:eq(" + newIndex + ") label.error").remove();
                addBoatVariantForm.find(".body:eq(" + newIndex + ") .error").removeClass("error");
            }
            addBoatVariantForm.validate().settings.ignore = ":disabled,:hidden";
            return addBoatVariantForm.valid();
        },
        onStepChanged: function (event, currentIndex, priorIndex)
        {
            // Used to skip the "Warning" step if the user is old enough.
            if (currentIndex === 2 && Number($("#age-2").val()) >= 18)
            {
                addBoatVariantForm.steps("next");
            }
            // Used to skip the "Warning" step if the user is old enough and wants to the previous step.
            if (currentIndex === 2 && priorIndex === 3)
            {
                addBoatVariantForm.steps("previous");
            }
        },
        onFinishing: function (event, currentIndex)
        {
            addBoatVariantForm.validate().settings.ignore = ":disabled";
            return addBoatVariantForm.valid();
        },
        onFinished: function (event, currentIndex)
        {
            var data = JSON.stringify($(addBoatVariantForm).serializeArray());


            $.ajax({
                url:'/varv/admin/customer/addCustomer.html',
                type:'POST',
                contentType:'application/x-www-form-urlencoded; charset=UTF-8',
                dataType:'json',
                data: {addBoatVariantFormData:data
                },
                success: function(data,status,xhr){
                    var statusMessage;
                    if(data.status=="success"){
                        statusMessage = data.customer;
                    }
                    $('#statusSuccessAddCustomer').html(statusMessage + " har lagts till!");
                    $('#addEmployeeNew').modal('toggle');
                    $('#successAddEmployee').modal('toggle');
                    $('#example-advanced-addBoatVariantForm').resetForm();
                    addBoatVariantForm.steps("previous");
                },
                error: function(jqXhr, textStatus,errorMessage){
                    console.log(errorMessage);
                }
            })
        }
    }).validate({
        errorPlacement: function errorPlacement(error, element) { element.before(error); },
        rules: {
            confirm: {
                equalTo: "#password-2"
            }
        }
    });




})(jQuery);