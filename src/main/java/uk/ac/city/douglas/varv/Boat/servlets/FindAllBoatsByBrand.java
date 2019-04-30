/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.city.douglas.varv.Boat.servlets;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import uk.ac.city.douglas.varv.Job.dao.JobDAO;
//import uk.ac.city.douglas.varv.Boat.domain.Boat;

/**
 *
 * @author douglaslandvik
 */
@WebServlet("/findAllBoatsByBrand.html")
public class FindAllBoatsByBrand extends HttpServlet {
       
    private JobDAO vr;
    
    @Inject
    public FindAllBoatsByBrand(JobDAO vr){
        this.vr =  vr;
    }
//
//    public void service(HttpServletRequest request, HttpServletResponse response)
//            throws IOException, ServletException{
//        response.setContentType("text/html");
//
////
////
////        boolean shouldUseAjax = false;
////       String brand = request.getParameter("brand");
////       shouldUseAjax = Boolean.parseBoolean(request.getParameter("shouldUseAjax"));
////       List<Boat> boats = vr.getAllBoatsByBrand(brand);
////
////        request.setAttribute("boats", boats);
////        request.setAttribute("brand", brand);
////
////        ServletContext servletContext = getServletContext();
//           RequestDispatcher requestDispatcher;
//        if(!shouldUseAjax){
//         requestDispatcher = servletContext.getRequestDispatcher("/boat/allBoatsByBrandResult.jsp");
//        }
//        else{
//
//            requestDispatcher = servletContext.getRequestDispatcher("/boat/ajaxSearchBoat.jsp");
//        }
//        requestDispatcher.forward(request,response);
//    }
//
}


