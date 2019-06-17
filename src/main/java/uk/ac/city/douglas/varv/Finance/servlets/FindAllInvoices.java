/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.city.douglas.varv.Finance.servlets;

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


import uk.ac.city.douglas.varv.Finance.dao.FinanceDAOInterface;
import uk.ac.city.douglas.varv.Finance.domain.Invoice;

/**
 *
 * @author douglaslandvik
 */

@WebServlet(value = "/admin/finance/invoices.html")
public class FindAllInvoices extends HttpServlet {

    private FinanceDAOInterface vr;

    @Inject
    public FindAllInvoices(FinanceDAOInterface vr) {
        this.vr = vr;

    }

    public void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        List<Invoice> invoices = vr.getAllInvoices();
        request.setAttribute("invoices", invoices);
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/admin/finance/invoices.jsp");
        requestDispatcher.forward(request, response);

    }

}
