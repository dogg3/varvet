/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.city.douglas.varv.servlets.boatDatabase;

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
import uk.ac.city.douglas.varv.dao.VarvRepository;
import uk.ac.city.douglas.varv.domain.Boat;

/**
 *
 * @author douglaslandvik
 */
@WebServlet("/findAllBoatsByBrand.html")
public class FindAllBoatsByBrand extends HttpServlet {
       
    private VarvRepository vr;
    
    @Inject
    public FindAllBoatsByBrand(VarvRepository vr){
        this.vr =  vr;
    }
    
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException{
        response.setContentType("text/html");
        
       
           
        boolean shouldUseAjax = false;
       String brand = request.getParameter("brand"); 
       shouldUseAjax = Boolean.parseBoolean(request.getParameter("shouldUseAjax"));
       List<Boat> boats = vr.getAllBoatsByBrand(brand);

        request.setAttribute("boats", boats);
        request.setAttribute("brand", brand);
        
        ServletContext servletContext = getServletContext();
           RequestDispatcher requestDispatcher;
        if(!shouldUseAjax){
         requestDispatcher = servletContext.getRequestDispatcher("/boat/allBoatsByBrandResult.jsp");
        }
        else{
             
            requestDispatcher = servletContext.getRequestDispatcher("/boat/ajaxSearchBoat.jsp");
        }
        requestDispatcher.forward(request,response);
    }
    
}


