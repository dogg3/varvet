/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.city.douglas.varv.servlets;

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
import uk.ac.city.douglas.varv.domain.BoatVariantStorage;


/**
 *
 * @author douglaslandvik
 */

@WebServlet(value="/findAllBoatVariantStorages.html")
public class FindAllBoatVariantStorages extends HttpServlet {
    
    private VarvRepository vr;
    
    @Inject
    public FindAllBoatVariantStorages(VarvRepository vr){
        this.vr =  vr;
    }
    
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException{
        response.setContentType("text/html");
      
        
        
        List<BoatVariantStorage> boatVariantStorages = vr.getAllBoatVariantStorages();

    request.setAttribute("boatVariantStorages", boatVariantStorages);
    ServletContext servletContext = getServletContext();
    RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/boatVariantStorageList.jsp");
    requestDispatcher.forward(request,response);
    }
    
}
