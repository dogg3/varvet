/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.city.douglas.varv.Account.servlets.customer;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uk.ac.city.douglas.varv.Account.domain.Customer;
import uk.ac.city.douglas.varv.Job.dao.JobDAO;

/**
 *
 * @author douglaslandvik
 */

@WebServlet(value="/customer/findCustomerById.html")

public class FindCustomerById extends HttpServlet {
    
    private JobDAO vr;
    
    @Inject
    public FindCustomerById(JobDAO vr){
        this.vr =  vr;
    }
    
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException{
            response.setContentType("text/html");
           
      
        
            int id =  Integer.parseInt(request.getParameter("id")); 
        
//      Customer customer = vr.findCustomerById(id);
//    request.setAttribute("customer", customer);
                    
    ServletContext servletContext = getServletContext();
    RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/customer/customerProfile.jsp");
    requestDispatcher.forward(request,response);
    }
    
}
