/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.city.douglas.varv.servlets.boatVariant;

import java.io.IOException;
import java.net.URLEncoder;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uk.ac.city.douglas.varv.dao.VarvRepository;
import uk.ac.city.douglas.varv.domain.Boat;
import uk.ac.city.douglas.varv.domain.BoatVariant;

/**
 *
 * @author douglaslandvik
 */

@WebServlet(value="/boatVariant/boatVariantAdd.html")
public class AddBoatVariant extends HttpServlet {
    
    private VarvRepository vr;
    
    
    @Inject
    public AddBoatVariant(VarvRepository vr){
    this.vr = vr;
    
    }
    
    
    public void doPost(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
       
    
        response.setContentType("text/plain");
        request.setCharacterEncoding("UTF-8");
          String requestUrl = null;

     
         
       int engineId = Integer.parseInt(request.getParameter("engineId"));
       String errorMessage = null;
      
       int boatId = 0;
       int year = 0;
       
     
        boatId = Integer.parseInt(request.getParameter("boatId"));
        int customerId = Integer.parseInt(request.getParameter("customerId"));
    
        
        //årtal
        try {
        year = Integer.parseInt(request.getParameter("year"));
        }catch(java.lang.NumberFormatException je){
           errorMessage="Du skrev in bokstäver i årtal, båten är inte tillagd. Ladda om sidan och försök igen.";
        }catch(java.lang.NullPointerException e){
            errorMessage="Fyll i årtal";
            System.out.println("nullPointer");
        }catch(Exception e){
            errorMessage = "Något gick snett, pröva igen";
        }
    
               
        String description = request.getParameter("description");
    
            
        if(errorMessage==null){
          BoatVariant boatVariant = new BoatVariant();
         
          boatVariant.setBoatId(boatId);
          boatVariant.setYear(year);
          boatVariant.setDescription(description);
          boatVariant.setCustomerId(customerId);

    
          try{ 
              vr.saveBoatVariant(boatVariant);
            
              }
             catch(Exception e){   
                  errorMessage = "Det gick inte att lägga till i databases, dubbelkolla om kunden inte redan har en sådan båt tillagd";  
                  requestUrl = URLEncoder.encode(errorMessage,"UTF-8");
                  response.sendRedirect("/varv/boatVariant/boatVariantAdd.html?errorMessage="+requestUrl);
                } 
          
          
            requestUrl = URLEncoder.encode(boatVariant.toString(),"UTF-8");
          
            response.sendRedirect("/varv/boatVariant/boatVariantAdd.html?boatVariant="+requestUrl);
            
          }else{
     
           requestUrl = URLEncoder.encode(errorMessage,"UTF-8");
           response.sendRedirect("/varv/boatVariant/boatVariantAdd.html?errorMessage="+requestUrl);
        } 
      
    
    }
    
 public void doGet(HttpServletRequest request, HttpServletResponse response) 
         throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
     
        if(request.getParameter("boatVariant")!=null){
        request.setAttribute("boatVariant", request.getParameter("boatVariant"));
        }else{
         request.setAttribute("errorMessage", request.getParameter("errorMessage"));
        }
    
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/boatVariant/boatVariantAdded.jsp");
        requestDispatcher.forward(request, response);
    }
    
     
}
