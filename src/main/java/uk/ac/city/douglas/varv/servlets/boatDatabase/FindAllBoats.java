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

@WebServlet(value="/boat/findAllBoats.html")
public class FindAllBoats extends HttpServlet {
    
    private VarvRepository vr;
    
    @Inject
    public FindAllBoats(VarvRepository vr){
        this.vr =  vr;
    }
    
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException{
        response.setContentType("text/html");
      
        
        
        List<Boat> boats = vr.getAllBoats();
        System.out.println(boats);

    request.setAttribute("boats", boats);
    ServletContext servletContext = getServletContext();
    RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/boat/boatList.jsp");
    requestDispatcher.forward(request,response);
    }
    
}
