/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.city.douglas.varv.Boat.servlets;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import uk.ac.city.douglas.varv.Account.dao.AccountDAOInterface;
import uk.ac.city.douglas.varv.Account.domain.Customer;
import uk.ac.city.douglas.varv.Boat.dao.BoatDAOInterface;
import uk.ac.city.douglas.varv.Boat.domain.Boat;
import uk.ac.city.douglas.varv.Boat.domain.BoatVariant;
import uk.ac.city.douglas.varv.Boat.domain.BoatVariantEngine;
import uk.ac.city.douglas.varv.Boat.domain.Engine;

/**
 *
 * @author douglaslandvik
 */
@WebServlet(value = "/admin/boatVariant/addBoatVariantEngine.html")
public class AddBoatVariantEngine extends HttpServlet {

    private BoatDAOInterface vr;
    private AccountDAOInterface ar;
    @Inject
    public AddBoatVariantEngine(BoatDAOInterface vr, AccountDAOInterface ar) {
        this.vr = vr;
        this.ar = ar;

    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("application/x-www-form-urlencoded");
        request.setCharacterEncoding("UTF-8");
        BoatVariantEngine boatVariantEngine = new BoatVariantEngine();
        HashMap<String,String> boatVariantEngineData = new HashMap<>();
        String json = request.getParameter("formData");
        JSONParser jsonParser = new JSONParser();
        try {
            JSONArray jsonArray = (JSONArray) jsonParser.parse(json);

            for(Object obj: jsonArray){
                JSONObject jsonObject = (JSONObject) obj;
                String name = (String) jsonObject.get("name");
                String value = (String) jsonObject.get("value");
                boatVariantEngineData.put(name,value);
                System.out.println("name is :" +name + " value is "+ value);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        BoatVariant boatVariant = vr.findBoatVariantById(Integer.parseInt(boatVariantEngineData.get("boatVariantId")));
        Engine engine = vr.findEngineById(Integer.parseInt(boatVariantEngineData.get("engineId")));

        boatVariantEngine.setBoatVariant(boatVariant);
        boatVariantEngine.setEngine(engine);
        vr.addBoatVariantEngine(boatVariantEngine);

        //sending back the status message to the client
        JSONObject returnMessage = new JSONObject();
        returnMessage.put("status","success");
        response.getWriter().print(returnMessage.toJSONString());

    }

    public void doDelete(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");
        resp.setContentType("text/plain");
        System.out.println(id);
        vr.eraseBoatVariantEngineById(Integer.parseInt(id));
    }

}



