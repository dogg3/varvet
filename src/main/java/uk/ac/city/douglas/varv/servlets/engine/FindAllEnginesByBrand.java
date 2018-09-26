/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.city.douglas.varv.servlets.engine;

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
import uk.ac.city.douglas.varv.domain.Engine;

/**
 *
 * @author douglaslandvik
 */
@WebServlet("/findAllEnginesByBrand.html")
public class FindAllEnginesByBrand extends HttpServlet {
       
    private VarvRepository vr;
    
    @Inject
    public FindAllEnginesByBrand(VarvRepository vr){
        this.vr =  vr;
    }
    
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException{
        response.setContentType("text/html");
        
       
           
        boolean shouldUseAjax = false;
        String brand = request.getParameter("brand"); 
        shouldUseAjax = Boolean.parseBoolean(request.getParameter("shouldUseAjax"));
        List<Engine> engines = vr.findEnginesByBrand(brand);

        request.setAttribute("engines", engines);

        
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher;
        requestDispatcher = servletContext.getRequestDispatcher("/ajaxSearch/ajaxSearchEnginesByBrand.jsp");
      
        requestDispatcher.forward(request,response);
    }
    
}


