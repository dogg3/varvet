package uk.ac.city.douglas.varv.Boat.servlets;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import uk.ac.city.douglas.varv.Boat.dao.BoatDAOInterface;
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

    @WebServlet(value="/admin/boat/FindAllEnginesJson.html")
public class FindAllEnginesJson extends HttpServlet {


    private BoatDAOInterface vr;
    @Inject
    public FindAllEnginesJson(BoatDAOInterface vr) {
        this.vr = vr;

    }


        public void service(HttpServletRequest request, HttpServletResponse response)
                throws IOException, ServletException {
        response.setContentType("application/x-www-form-urlencoded");
        request.setCharacterEncoding("UTF-8");

            JSONObject returnMessage  = new JSONObject();
            List<Engine> engineList = vr.getAllEngines();
            engineList.forEach((k)-> returnMessage.put(k.getEngineId(),k.getModel()+" "+ k.getModel()));
            response.getWriter().print(returnMessage.toJSONString());
            System.out.println("HOOOOORa");
        }
    }



