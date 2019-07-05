package uk.ac.city.douglas.varv.Stock.servlets;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import uk.ac.city.douglas.varv.Boat.dao.BoatDAOInterface;
import uk.ac.city.douglas.varv.Boat.domain.Engine;
import uk.ac.city.douglas.varv.Stock.dao.StockDAOInterface;
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

@WebServlet(value="/admin/stock/FindAllPartsJson.html")
public class FindAllPartsJson extends HttpServlet {


    private StockDAOInterface vr;
    @Inject
    public FindAllPartsJson(StockDAOInterface vr) {
        this.vr = vr;

    }


    public void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("application/x-www-form-urlencoded");
        request.setCharacterEncoding("UTF-8");

        JSONObject returnMessage  = new JSONObject();
        List<Part> partList = vr.getAllParts();
        partList.forEach((k)-> returnMessage.put(k.getArtNr(),k.getBenamning()+" : "+ k.getReseller()));
        response.getWriter().print(returnMessage.toJSONString());
    }
}



