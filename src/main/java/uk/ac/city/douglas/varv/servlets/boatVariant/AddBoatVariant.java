/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.city.douglas.varv.servlets.boatVariant;

import java.io.IOException;
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

@WebServlet(value="/boatVariantAdd.html")
public class AddBoatVariant extends HttpServlet {
    
    private VarvRepository vr;
    
    
    @Inject
    public AddBoatVariant(VarvRepository vr){
    this.vr = vr;
    
    }
    
    
    public void doPost(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
       
    
       
       response.setCharacterEncoding("UTF-8");
     
         
       int customerId = Integer.parseInt(request.getParameter("customerId"));
       String boatBrand =  request.getParameter("boatBrand");
       String boatModel = request.getParameter("boatModel");
       int year = Integer.parseInt(request.getParameter("year"));
       
       String description = request.getParameter("description"); 
    
            
        BoatVariant boatVariant = new BoatVariant();
        boatVariant.setCustomerId(customerId);        

        boatVariant.setYear(year);
    
        boatVariant.setDescription(description);
        
        vr.saveBoatVariant(boatVariant);
        
        
        response.sendRedirect("/varv/boatVariantAdd.html?boatVariant="+boatVariant.toString());
 
    
    }
    
 public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("boatVariant", request.getParameter("boatVariant"));
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/boatVariantAdded.jsp");
        requestDispatcher.forward(request, response);
    }
    
     
}
