/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.city.douglas.varv.servlets.customer;

import java.io.IOException;
import java.net.URLEncoder;
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
       
        response.setContentType("text/plain");
        request.setCharacterEncoding("UTF-8");
     
       
       Customer customer = new Customer();
         
       String firstName =  request.getParameter("firstName");
       String lastName = request.getParameter("lastName");
       Long personNr = null;
       if(request.getParameter("personNr")== " "){
        personNr =  Long.parseLong(request.getParameter("personNr"));
        
        
       
     
       }
       String adress = request.getParameter("adress");
       String phoneNumber = request.getParameter("phoneNumber");
       String email = request.getParameter("email");
       String city = request.getParameter("city");
       String reference = request.getParameter("referens");
       String note = request.getParameter("note");
     
       
       
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setPersonNr(personNr);
        customer.setAdress(adress);
        customer.setCity(city);
        customer.setPhoneNumber(phoneNumber);
        customer.setEmail(email);
        customer.setReference(reference);
        customer.setNote(note);
       
       
        vr.saveCustomer(customer);
       
        
        String url = URLEncoder.encode(customer.getFirstName(),"UTF-8");
           

        response.sendRedirect("/varv/addCustomer.html?customer=" + url);
   

 
    }
    
 public void doGet(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        System.out.println(URLEncoder.encode(request.getParameter("customer"),"UTF-8"));
       
        request.setAttribute("customer", URLEncoder.encode(request.getParameter("customer"),"UTF-8"));
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/customerAdded.jsp");
        requestDispatcher.forward(request, response);
    }
}