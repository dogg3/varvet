/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.city.douglas.varv.servlets.engine;

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
import uk.ac.city.douglas.varv.domain.Boat;
import uk.ac.city.douglas.varv.domain.Engine;

/**
 *
 * @author douglaslandvik
 */

@WebServlet(value="/engineAdd.html")
public class AddEngine extends HttpServlet {
    
    private VarvRepository vr;
    
    
    @Inject
    public AddEngine(VarvRepository vr){
    this.vr = vr;
    
    }
    
    
    public void doPost(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
       
    
       request.setCharacterEncoding("UTF-8"); 
       response.setCharacterEncoding("UTF-8");
     
         
       String brand =  request.getParameter("brand");
       String model = request.getParameter("model");
       int year = Integer.parseInt(request.getParameter("year"));
       float horsePower = Float.parseFloat(request.getParameter("horsePower"));
       String type = request.getParameter("type");
       int cylinder = Integer.parseInt(request.getParameter("cylinder"));
       String gas = request.getParameter("gas");
     
       
        Engine engine = new Engine();
        engine.setBrand(brand);
        engine.setModel(model);
        engine.setCylinder(cylinder);
        engine.setYear(year);
        engine.setHorsePower(horsePower);
        engine.setType(type);

        engine.setGas(gas);
        
        vr.addEngine(engine);
        
        
        response.sendRedirect("/varv/engineAdd.html?engine="+engine.toString());
 
    
    }
    
 public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("engine", request.getParameter("engine"));
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/engineAdded.jsp");
        requestDispatcher.forward(request, response);
    }
    
     
}
