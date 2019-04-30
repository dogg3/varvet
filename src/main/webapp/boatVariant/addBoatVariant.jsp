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
        <script src="/varv/scripts/ajaxSearchBoat.js"></script>
         <script src="/varv/scripts/ajaxSearchEngine.js"></script>
         
  
    <jsp:include page="/header.jsp" />
           <script>
                $(document).ready(function(){
        
             $('#form').submit(function (evt) {
            evt.preventDefault();
            addBoatVariant();
             });
            });
             function addBoatVariant(){
                 var year = $('#year').val();
                 var description = $('#description').val();
                 if((year || description || boatId || engineId)==null){
                     alert("hej");
                 }
                 var param = "boatId="+ boatId + "&engineId="+  engineId + "&year=" + year +"&description=" + description;
                
                 var request = new XMLHttpRequest;
              

                 request.onreadystatechange = function() {
                     if(this.readyState == 4 && this.status == 200){
                       document.getElementById("statusMessage").innerHTML = this.responseText;
                         console.log("success");
                     }else{
                               console.log("somethiong fucked");
                     } 
                 }
                request.open("POST", "/varv/boatVariant/boatVariantAdd.html", true);
                request.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
                request.send(param);
                 
             }
         </script>

     <h1>Lägg till kundbåt</h1>

        <form  id="form">

            <label>Båt<input type="text" name="boat" required /></label><br/>
       
            <div id="result"></div>
       

           
             <label>Motor<input  id="engineBrand" type="text" name="engineBrand" required /></label><br />
             <div id="engineResult"></div>
              <label>Årgång<input id="year" type="text" name="year" /></label><br />
             <label>Beskrivning<br><input id="description" style="width:200px;height:100px;" type="text" name="description" /></label><br />
            
             <br>
            <input  type="submit" value="Lägg till båt" />
            <div id="statusMessage"></div>
        </form>
      <jsp:include page="/footer.jsp" />
</html>
