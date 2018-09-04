/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.city.douglas.varv.servlets;

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
import uk.ac.city.douglas.varv.domain.Customer;

/**
 *
 * @author douglaslandvik
 */
@WebServlet(value="/addCustomer.html")
public class AddCustomer extends HttpServlet {
    
    private VarvRepository vr;
    
    
    @Inject
    public AddCustomer(VarvRepository vr){
    this.vr = vr;
    
    }
    
    
    public void doPost(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
       
       response.setContentType("text/html");
         
     
         
       String firstName =  request.getParameter("firstName");
       String lastName = request.getParameter("lastName");
       Long personNr =  Long.parseLong(request.getParameter("personNr"));
       String adress = request.getParameter("adress");
       String phoneNumber = request.getParameter("phoneNumber");
       String email = request.getParameter("email");
     
       
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setPersonNr(personNr);
        customer.setAdress(adress);
        customer.setPhoneNumber(phoneNumber);
        customer.setEmail(email);
       
        vr.saveCustomer(customer);
        response.sendRedirect("/varv/addCustomer.html?customer="+customer.toString());
 
    
    }
    
 public void doGet(HttpServletRequest request,
         HttpServletResponse response) throws ServletException, IOException {
       
        request.setAttribute("customer", request.getParameter("customer"));
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/customerAdded.jsp");
        requestDispatcher.forward(request, response);
    }
}