/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.city.douglas.varv.Stock.servlets;

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


import uk.ac.city.douglas.varv.Stock.dao.StockDAOInterface;
import uk.ac.city.douglas.varv.Stock.domain.Inventory;
import uk.ac.city.douglas.varv.Stock.domain.Part;

/**
 *
 * @author douglaslandvik
 */
@WebServlet(value = "/admin/inventory/resellers.html")
public class FindAllParts extends HttpServlet {

    private StockDAOInterface vr;

    @Inject
    public FindAllParts(StockDAOInterface vr) {
        this.vr = vr;

    }

    public void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        List<Part> parts = vr.getAllParts();
        request.setAttribute("parts", parts);
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/admin/inventory/resellers.jsp");
        requestDispatcher.forward(request, response);

    }

}
