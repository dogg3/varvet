/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.city.douglas.varv.Account.servlets.customer;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.HashMap;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uk.ac.city.douglas.varv.Account.dao.AccountDAO;
import uk.ac.city.douglas.varv.Account.dao.AccountDAOInterface;
import uk.ac.city.douglas.varv.Account.domain.Customer;
import uk.ac.city.douglas.varv.Job.dao.JobDAO;

/**
 *
 * @author douglaslandvik
 */
@WebServlet(value = "/admin/customer/editCustomer.html")
public class EditCustomer extends HttpServlet {

    private AccountDAOInterface vr;

    @Inject
    public EditCustomer(AccountDAOInterface vr) {
        this.vr = vr;

    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/plain");
        request.setCharacterEncoding("UTF-8");

        HashMap<String,String> customerData = new HashMap<>();
        Enumeration<String> parameters = request.getParameterNames();
        while(parameters.hasMoreElements()){
            customerData.put(parameters.nextElement(),request.getParameter(parameters.nextElement()));
        }

        vr.editCustomer(customerData);
        Customer customer = vr.findCustomerById(Integer.parseInt(customerData.get("customerId")));
        String url = URLEncoder.encode(customer.getFirstName(), "UTF-8");
        response.sendRedirect("/admin/customer/index.html" + url);
    }

}
