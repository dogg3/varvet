   var engineId = null;

function searchEngine(engineBrand){
             var shouldUseAjax = true;
             var engineBrand = engineBrand;
             var request=new XMLHttpRequest();
          
            request.onreadystatechange = function() {
              
            if (this.readyState == 4 && this.status == 200) {
                if( this.responseText){
            document.getElementById("engineResult").innerHTML = this.responseText;
            }
            }
            };
              request.open("GET", "/varv/findAllEnginesByBrand.html?brand="+engineBrand+"&shouldUseAjax="+shouldUseAjax, true);
              
              
                     request.send();        
    }
     function getEngineId(clickdId){
        engineId = clickdId;

       document.getElementById("engineResult").innerHTML = document.getElementById(clickdId).innerHTML;

         
      shouldSearchForEngine = false;

         }