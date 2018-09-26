/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.city.douglas.varv.servlets.boatVariant;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uk.ac.city.douglas.varv.dao.VarvRepository;
import uk.ac.city.douglas.varv.dao.VarvRepositoryJPQL;
import uk.ac.city.douglas.varv.domain.Boat;
import uk.ac.city.douglas.varv.domain.BoatVariant;


/**
 *
 * @author douglaslandvik
 */

@WebServlet(value="/findBoatVariantsByCustomerId.html")
public class FindBoatVariantsByCustomerId extends HttpServlet {
    
    private VarvRepository vr;
    
    @Inject
    public FindBoatVariantsByCustomerId(VarvRepository vr){
        this.vr =  vr;
    }
    
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException{
        response.setContentType("text/html");
      
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        
     List<BoatVariant> boatVariants = vr.findAllBoatVariantByCustomerId(customerId);

    request.setAttribute("boatVariants", boatVariants);
    ServletContext servletContext = getServletContext();
    RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/boatVariant/boatVariantList.jsp");
    requestDispatcher.forward(request,response);
    }
    
}
