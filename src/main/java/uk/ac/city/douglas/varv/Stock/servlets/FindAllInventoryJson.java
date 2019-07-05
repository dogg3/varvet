package uk.ac.city.douglas.varv.Stock.servlets;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import uk.ac.city.douglas.varv.Boat.dao.BoatDAOInterface;
import uk.ac.city.douglas.varv.Boat.domain.Engine;
import uk.ac.city.douglas.varv.Stock.dao.StockDAOInterface;
import uk.ac.city.douglas.varv.Stock.domain.Inventory;
import uk.ac.city.douglas.varv.Stock.domain.Part;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@WebServlet(value="/admin/stock/FindAllInventoryJson.html")
public class FindAllInventoryJson extends HttpServlet {


    private StockDAOInterface vr;
    @Inject
    public FindAllInventoryJson(StockDAOInterface vr) {
        this.vr = vr;

    }


    public void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("application/x-www-form-urlencoded");
        request.setCharacterEncoding("UTF-8");

        JSONObject returnMessage  = new JSONObject();
        List<Inventory> inventoryList = vr.getAllInventoris();
        inventoryList.forEach((k)-> returnMessage.put(k.getArtNr(),k.getPart().getBenamning()+". pris ink moms:"+ k.getPart().getGetKatalogPrisInkMoms()));
        response.getWriter().print(returnMessage.toJSONString());
    }
}



