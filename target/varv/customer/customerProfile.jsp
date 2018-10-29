<%-- 
    Document   : customerProfile
    Created on : Aug 19, 2018, 7:55:16 PM
    Author     : douglaslandvik
--%>



<%@page import="uk.ac.city.douglas.varv.domain.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="/varv/css/customer.css">


<!DOCTYPE html>
<html class="pageId-10">
    <jsp:include page="/header.jsp" />

<!----Script for showing boatVariantsForTheCustomer--->
    <script>
        $(window).on('load', function () {

            var customerId = $('#profileId').attr("value");
            getBoatVariantsByCustomerId(customerId);

            function refreshBoatVaraintsListOnProfile() {
                getBoatVariantsByCustomerId(customerId);
            }
        });

        function getBoatVariantsByCustomerId(customerId) {
            var customerId = customerId;

            var request = new XMLHttpRequest();
            
            request.onreadystatechange = function () {

                if (this.readyState == 4 && this.status == 200) {

                    document.getElementById("boatVariants").innerHTML = this.responseText;
                }
            };
            request.open("GET", "/varv/boatVariants/findBoatVariantsByCustomerId.html?customerId=" + customerId, true);
            request.send();
        }

    </script>
    <div class="container">

        <%--kund-profil----%>
        <%
            Customer customer = (Customer) request.getAttribute("customer");
            out.print(
                    "<div id='profileId' value='" + customer.getCustomerId() + "' class='col-md-12 profile'>"
                    + "<h2 id='mellanRubrik'>Profil</h2>"
                    + "<li>Namn:  " + customer.getFirstName() + " " + customer.getLastName() + "</li>"
                    + "<li>Adress:  " + customer.getAdress() + " " + customer.getCity() + "</li>"
                    + "<li>Email:  " + customer.getEmail() + "</li>"
                    + "<li>Telefon:  " + customer.getPhoneNumber() + "</li>"
                    + "<li>Person/org-nr: " + customer.getPersonNr() + "</li>"
                    + "<li>Referens: " + customer.getReference() + "</li>"
                    + "<li>Notis:  " + customer.getNote() + "</li></div>"
            );

        %>

        
        <div id="customerContainer">
            <h3 style="text-align: center; padding-bottom:20px;">Kundbåtar</h3>
            <div id="boatVariants">


            </div>
            <!-- Button trigger modal -->
            <div style="display: flex; justify-content: center;">
                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter">
                    Lägg till kundbåt
                </button>
            </div>
         <div>

    </div>





<button class="btn btn-default" id="btn-confirm-erase">Confirm</button>

<div id="result-erase"></div>









<jsp:include page="/footer.jsp" />


        

    <!-- Modal pop up for adding new customerboat (boatVariant) -->
<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLongTitle">Lägg till ny kundbåt</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">

                <jsp:include page="/templates/addBoatVariant.jsp" />
            </div>
            <div class="modal-footer">
                 <div class="alert" role="alert" id="result-erase"></div>
            </div>
        </div>
    </div>
</div>
            
    <!-- Modal pop up for erasing customerBoat -->        
 <div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true" id="mi-modal">
  <div class="modal-dialog modal-sm" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Är du säker på detta?</h4>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" id="modal-btn-si">ja</button>
        <button type="button" class="btn btn-primary" id="modal-btn-no">nej</button>
      </div>
    </div>
  </div>
</div>  
 
            
         
<!--As the models has to be outside the html-tag we have to append them to the body so 
it will be clickable when showed
--->
<script>
                $('#exampleModalCenter').appendTo("body") ;
                 $('#mi-modal').appendTo("body") ;
</script>


       <!--These are importants for the erase-are-u-sure, 
       it messed up the css a little 
       as the neccessary bootstrap is overriding a lot of css-->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
  
  
  
         <!--modalconfirm is an evenlistner on confirmations-button
            it shows the modal
            it hides the modal and triggers a callback function
            depending on the value clicked in the modal
         -->
  <script type="text/javascript">
var modalConfirm = function(callback){
  
  $("#btn-confirm-erase").on("click", function(){
    $("#mi-modal").modal('show');
    
  });

  $("#modal-btn-si").on("click", function(){
    callback(true);
    $("#mi-modal").modal('hide');
  });
  
  $("#modal-btn-no").on("click", function(){
    callback(false);
    $("#mi-modal").modal('hide');
  });
};



modalConfirm(function(confirm){
  if(confirm){
    //action if customer wants to erase
    
    $("#result-erase").html("erased");
        eraseCustomer(function(){
            //show the result message 
            
        });
        
  }else{
    //Acciones si el usuario no confirma
    $("#result-erase").html("not erased");
  }
});


var eraseCustomer = function(callback){
    //sendAjax - to erase
    
}

  </script>
