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


/**
 *
 * @author douglaslandvik
 */

@WebServlet(value="/varv/boatAdd.html")
public class AddBoat extends HttpServlet {
    
    private VarvRepository vr;
    
    
    @Inject
    public AddBoat(VarvRepository vr){
    this.vr = vr;
    
    }
    
    
    public void doPost(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
       
    
       request.setCharacterEncoding("UTF-8"); 
       response.setCharacterEncoding("UTF-8");
     
         
       String brand =  request.getParameter("brand");
       String model = request.getParameter("model");
       float length = Float.parseFloat(request.getParameter("length"));
       float width = Float.parseFloat(request.getParameter("width"));
     
//
//        Boat boat = new Boat();
////        boat.setBrand(brand);
////        boat.setLength(length);
////        boat.setModel(model);
////        boat.setWidth(width);
//        vr.saveBoat(boat);
//        response.sendRedirect("/varv/boatAdd.html?boat="+boat.toString());
//
    
    }
    
 public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("boat", request.getParameter("boat"));
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/boat/boatAdded.jsp");
        requestDispatcher.forward(request, response);
    }
    
     
}
