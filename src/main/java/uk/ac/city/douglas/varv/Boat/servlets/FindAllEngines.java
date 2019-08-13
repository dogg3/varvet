/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.city.douglas.varv.Boat.servlets;
import com.fasterxml.jackson.databind.ObjectMapper;


import uk.ac.city.douglas.varv.Boat.dao.BoatDAOInterface;
import uk.ac.city.douglas.varv.Boat.domain.Engine;
import uk.ac.city.douglas.varv.Job.dao.JobDAO;
import uk.ac.city.douglas.varv.Boat.domain.Boat;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
//import uk.ac.city.douglas.varv.Boat.domain.Boat;

/**
 *
 * @author douglaslandvik
 */

@WebServlet(value="/admin/boat/engine.html")
public class FindAllEngines extends HttpServlet {

    private BoatDAOInterface dao;

    @Inject
    public FindAllEngines(BoatDAOInterface dao){
        this.dao =  dao;
    }

    public void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html");

        List<Engine> engines = dao.getAllEngines();

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(engines);

        request.setAttribute("engines", engines);
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/admin/boat/engine.jsp");
        requestDispatcher.forward(request,response);
    }

}