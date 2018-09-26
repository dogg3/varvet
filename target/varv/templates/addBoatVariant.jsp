<%-- 
    Document   : addBoatVariant
    Created on : Jan 1, 2018, 3:52:54 AM
    Author     : douglaslandvik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans|Roboto+Slab" rel="stylesheet">
        <script src="scripts/ajaxSearchBoat.js"></script>
         <script src="scripts/ajaxSearchEngine.js"></script>
         
  

           <script>
                $(document).ready(function(){
                      var customerId = document.getElementById('profileId').getAttribute('value');
           
             $('#form').submit(function (evt) {
            evt.preventDefault();
            addBoatVariant();
             });
            });
             function addBoatVariant(){
                 var year = $('#year').val();
                 var description = $('#description').val();
                  var customerId = document.getElementById('profileId').getAttribute('value');
      
                
                var param = "boatId="+ boatId + "&engineId="+  engineId + "&year=" + year +"&description=" + description + "&customerId="+customerId    ;
                
                 var request = new XMLHttpRequest;
              

                 request.onreadystatechange = function() {
                     if(this.readyState == 4 && this.status == 200){
                       document.getElementById("statusMessage").innerHTML = this.responseText;
                        document.getElementById("form").style.display = "none";
                       console.log("success");
                     } 
                 }
                request.open("POST", "/varv/boatVariantAdd.html", true);
                request.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
                request.send(param);
                 
             }
         </script>



        <form  id="form">

            <label>Båt<input type="text" name="boat" /></label><br/>
       
            <div id="result"></div>
       

           
             <label>Motor<input id="engineBrand" type="text" name="engineBrand" /></label><br />
             <div id="engineResult"></div>
              <label>Årgång<input id="year" type="text" name="year" /></label><br />
             <label>Beskrivning<br><input id="description" style="width:200px;height:100px;" type="text" name="description" /></label><br />
            
             <br>
            <input  type="submit" value="Lägg till kundbåt" />
           
           
        </form>
      <div id="statusMessage"></div>

</html>
