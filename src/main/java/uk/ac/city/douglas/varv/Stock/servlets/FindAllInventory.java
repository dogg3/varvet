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

/**
 *
 * @author douglaslandvik
 */
@WebServlet(value = "/admin/inventory/index.html")
public class FindAllInventory extends HttpServlet {

    private StockDAOInterface vr;

    @Inject
    public FindAllInventory(StockDAOInterface vr) {
        this.vr = vr;

    }

    public void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        List<Inventory> inventories = vr.getAllInventoris();
        request.setAttribute("inventories", inventories);
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/admin/inventory/index.jsp");
        requestDispatcher.forward(request, response);

    }

}
