/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.city.douglas.varv.Account.servlets.customer;

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

import uk.ac.city.douglas.varv.Account.dao.AccountDAOInterface;
import uk.ac.city.douglas.varv.Job.dao.JobDAO;


@WebServlet(value="/customer/eraseCustomer.html")
public class EraseCustomer extends HttpServlet {
    
   private final AccountDAOInterface vr;
    
    
    @Inject
    public EraseCustomer(AccountDAOInterface vr){
    this.vr = vr;
    
    }
    
    
   @Override
    public void doPost(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
       

        response.setContentType("text/html");
        int id = Integer.parseInt(request.getParameter("id"));
        vr.eraseCustomerById(id);
        String url = URLEncoder.encode("erased", "UTF-8");
        response.sendRedirect("/admin/customer/index.html"+url);
    }
    

}
