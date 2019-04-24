/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.city.douglas.varv.Account.servlets.boatDatabase;

import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uk.ac.city.douglas.varv.Job.dao.VarvRepository;


/**
 *
 * @author douglaslandvik
 */

@WebServlet(value="/findAllBoatBrands.html")
public class FindAllBoatBrands extends HttpServlet {
    
    private VarvRepository vr;
    
    @Inject
    public FindAllBoatBrands(VarvRepository vr){
        this.vr =  vr;
    }
    
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException{
        response.setContentType("text/html");
      
        
      
//      List<String> brands = vr.getAllBoatBrands();
    
 
//    request.setAttribute("brands", brands);
    ServletContext servletContext = getServletContext();
    RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/boat/allBoatBrands.jsp");
    requestDispatcher.forward(request,response);
    }
    
}
