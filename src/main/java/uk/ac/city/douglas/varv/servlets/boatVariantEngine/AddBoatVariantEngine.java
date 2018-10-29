/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.city.douglas.varv.servlets.boatVariantEngine;

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
import uk.ac.city.douglas.varv.domain.BoatVariantEngine;

/**
 *
 * @author douglaslandvik
 */

@WebServlet(value="/boatVariantEngine/boatVariantEngineAdd.html")
public class AddBoatVariantEngine extends HttpServlet {
    
    private VarvRepository vr;
    
    
    @Inject
    public AddBoatVariantEngine(VarvRepository vr){
    this.vr = vr;
    
    }
    
    
    public void doPost(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
       
    
        response.setContentType("text/plain");
        request.setCharacterEncoding("UTF-8");
          String requestUrl = null;

   
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        int engineID = Integer.parseInt(request.getParameter("engineId"));
        int boatId = Integer.parseInt(request.getParameter("boatId"));

        
         
       BoatVariantEngine boatVariantEngine = new BoatVariantEngine();
       boatVariantEngine.setBoatId(boatId);
       boatVariantEngine.setCustomerId(customerId);
       boatVariantEngine.setEngineId(engineID);
       
vr.addBoatVariantEngine(boatVariantEngine);
       
        
      String url = URLEncoder.encode(boatVariantEngine.toString(),"UTF-8");
           

        response.sendRedirect("/boatVariantEngine/boatVariantEngineAdd.html?boatVariantEngine=" + url);
   

    
        
      

      
    
    }
    
 public void doGet(HttpServletRequest request, HttpServletResponse response) 
         throws ServletException, IOException {
        
         request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        System.out.println(URLEncoder.encode(request.getParameter("boatVariantEngine"), "UTF-8"));

        request.setAttribute("boatVariantEngine", URLEncoder.encode(request.getParameter("boatVariantEngine"), "UTF-8"));
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/boatVariantEngine/customerAdded.jsp");
        requestDispatcher.forward(request, response);
     
    }
}