 
  shouldSearchForBoat = true;
  var shouldSearchForEngine = false;
   var boatId = null;
 
 
 window.onkeyup = keyup;
       var inputTextValue;
      
   function keyup(e) {
    
    inputTextValue = e.target.value;
    if(shouldSearchForBoat){
         searchBoat(inputTextValue);
         
    }
    
    if(shouldSearchForEngine){
         searchEngine(inputTextValue);
         
    }
    
}
          function searchBoat(boatBrand){
             var shouldUseAjax = true;
             var boatBrand = boatBrand;
             var request=new XMLHttpRequest();
          
            request.onreadystatechange = function() {
               console.log(this.status);
            if (this.readyState == 4 && this.status == 200) {
           if( this.responseText){
            document.getElementById("result").innerHTML = this.responseText;
            }
            }
            };
              request.open("GET", "/varv/findAllBoatsByBrand.html?brand="+boatBrand+"&shouldUseAjax="+shouldUseAjax, true);
              
              
                     request.send();        
    }
    
    function getBoatId(clickdId){
        boatId = clickdId;
       console.log(clickdId);
       document.getElementById("result").innerHTML = document.getElementById(clickdId).innerHTML;
   
         
       shouldSearchForBoat = false;
       shouldSearchForEngine = true;

         }
         
         
         