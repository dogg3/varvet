/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.city.douglas.varv.servlets.boatVariant;


import java.io.IOException;
import java.io.PrintWriter;
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

     

             PrintWriter writer = response.getWriter();
             

    
       String errorMessage = null;

       
     
        int boatId = Integer.parseInt(request.getParameter("boatId"));
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        int year = Integer.parseInt(request.getParameter("year"));
        String description = request.getParameter("description");
    
            
        if(errorMessage==null){
          BoatVariant boatVariant = new BoatVariant();
         
          boatVariant.setBoatId(boatId);
          boatVariant.setYear(year);
          boatVariant.setDescription(description);
          boatVariant.setCustomerId(customerId);

    
       try{
         vr.saveBoatVariant(boatVariant);
         }catch(Exception e){
            writer.append("A error happend");
        }
       
       
         requestUrl = URLEncoder.encode(boatVariant.toString(),"UTF-8");
          
           
         try{
        response.sendRedirect("/varv/boatVariant/boatVariantAdd.html?boatVariant="+requestUrl);
         }catch(Exception e){
             writer.append(e.toString());
         }
        
         
         }
        
//      
      
    
    }
    
 public void doGet(HttpServletRequest request, HttpServletResponse response) 
         throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
       PrintWriter writer = response.getWriter();
     
   
        request.setAttribute("boatVariant", request.getParameter("boatVariant"));
      
    
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/boatVariant/boatVariantAdded.jsp");
        
        try{
        requestDispatcher.forward(request, response);
        }
        catch(Exception e){
            System.out.println("An error occyre when trying to forward ");
            
        }
    }
    
     
}
