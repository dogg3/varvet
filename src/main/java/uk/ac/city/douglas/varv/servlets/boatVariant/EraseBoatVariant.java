/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.city.douglas.varv.servlets.customer;

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
import uk.ac.city.douglas.varv.domain.BoatVariant;
import uk.ac.city.douglas.varv.domain.Customer;



@WebServlet(value="/boatVariant/eraseBoatVariant.html")
public class EraseBoatVariant extends HttpServlet {
    
   private final VarvRepository vr;
    
    
    @Inject
    public EraseBoatVariant(VarvRepository vr){
    this.vr = vr;
    
    }
    
    
   @Override
    public void doPost(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
       
        response.setContentType("text/html");
         
     
        int boatId = Integer.parseInt(request.getParameter("boatId"));
        int customerId = Integer.parseInt(request.getParameter("customerId"));
       
        BoatVariant boatVariant = vr.findAllBoatVariantByCustomerIdAndBoatId(customerId, boatId);
        vr.removeBoatVariant(boatVariant);
        response.sendRedirect("/boatVariant/eraseBoatVariant.html");
 
    
    }
    
 public void doGet(HttpServletRequest request,
         HttpServletResponse response) throws ServletException, IOException {
       
        
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/templates/erased.html");
        requestDispatcher.forward(request, response);
    }

    
}
