/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.city.douglas.varv.Account.servlets.customer;

import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uk.ac.city.douglas.varv.Account.domain.Customer;
import uk.ac.city.douglas.varv.Job.dao.VarvRepository;

/**
 *
 * @author douglaslandvik
 */
@WebServlet(value = "/admin/customer/index.html")
public class FindAllCustomers extends HttpServlet {

    private VarvRepository vr;

    @Inject
    public FindAllCustomers(VarvRepository vr) {
        this.vr = vr;

    }

    public void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        List<Customer> customers = vr.getAllCustomers();
        customers.forEach(customer ->
                System.out.println("this is cusotmer" + customer)
                );

        request.setAttribute("customers", customers);
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/admin/customer/index.jsp");
        requestDispatcher.forward(request, response);

    }

}
