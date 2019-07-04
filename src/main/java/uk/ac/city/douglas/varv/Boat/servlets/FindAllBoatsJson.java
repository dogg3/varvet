package uk.ac.city.douglas.varv.Boat.servlets;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import uk.ac.city.douglas.varv.Boat.dao.BoatDAOInterface;
import uk.ac.city.douglas.varv.Boat.domain.Boat;
import uk.ac.city.douglas.varv.Boat.domain.Engine;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@WebServlet(value="/admin/boat/FindAllBoatsJson.html")
public class FindAllBoatsJson extends HttpServlet {


    private BoatDAOInterface vr;
    @Inject
    public FindAllBoatsJson(BoatDAOInterface vr) {
        this.vr = vr;

    }


    public void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("application/x-www-form-urlencoded");
        request.setCharacterEncoding("UTF-8");

        JSONObject returnMessage  = new JSONObject();
        List<Boat> boatList = vr.getAllBoats();
        boatList.forEach((k)-> returnMessage.put(k.getBoatId(),k.getModel()+" "+ k.getModel()));
        response.getWriter().print(returnMessage.toJSONString());
    }
}



