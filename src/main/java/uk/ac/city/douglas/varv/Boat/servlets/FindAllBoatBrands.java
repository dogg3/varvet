/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.city.douglas.varv.Boat.servlets;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uk.ac.city.douglas.varv.Job.dao.JobDAO;


/**
 *
 * @author douglaslandvik
 */

@WebServlet(value="/findAllBoatBrands.html")
public class FindAllBoatBrands extends HttpServlet {
    
    private JobDAO vr;
    
    @Inject
    public FindAllBoatBrands(JobDAO vr){
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
