/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.city.douglas.varv.Account.servlets.boatDatabase;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uk.ac.city.douglas.varv.Job.dao.VarvRepository;
//import uk.ac.city.douglas.varv.Job.domain.Boat;

/**
 *
 * @author douglaslandvik
 */

@WebServlet(value="/findBoatById.html")
public class FindBoatById extends HttpServlet {
    
    private VarvRepository vr;
//
//    @Inject
//    public FindBoatById(VarvRepository vr){
//        this.vr =  vr;
//    }
//
//    public void service(HttpServletRequest request, HttpServletResponse response)
//            throws IOException, ServletException{
//        response.setContentType("text/html");
//
//
//            int id =  Integer.parseInt(request.getParameter("id"));
//
//      Boat boat = vr.findBoatById(id);
//      String brand = boat.getBrand();
//      String model = boat.getModel();
//      int length = boat.getLength();
//      int width = boat.getWidth();
//      String description = boat.getDescription();
//
//    request.setAttribute("boat", boat);
//    request.setAttribute("brand", brand);
//    request.setAttribute("model", model);
//    request.setAttribute("length", length);
//    request.setAttribute("width", width);
//    request.setAttribute("description", description);
//
//
//    ServletContext servletContext = getServletContext();
//    RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/boat/boatProfile.jsp");
//    requestDispatcher.forward(request,response);
//    }
//
}
