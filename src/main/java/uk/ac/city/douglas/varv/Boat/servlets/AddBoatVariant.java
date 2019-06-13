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

/**
 *
 * @author douglaslandvik
 */
@WebServlet(value = "/admin/boatVariant/addBoatVariant.html")
public class AddBoatVariant extends HttpServlet {

    private BoatDAOInterface vr;
    private AccountDAOInterface ar;
    @Inject
    public AddBoatVariant(BoatDAOInterface vr, AccountDAOInterface ar) {
        this.vr = vr;
        this.ar = ar;

    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("application/x-www-form-urlencoded");
        request.setCharacterEncoding("UTF-8");
        BoatVariant boatVariant = new BoatVariant();
        HashMap<String,String> boatVariantData = new HashMap<>();
        String json = request.getParameter("formData");
        JSONParser jsonParser = new JSONParser();
        try {
            JSONArray jsonArray = (JSONArray) jsonParser.parse(json);

            for(Object obj: jsonArray){
                JSONObject jsonObject = (JSONObject) obj;
                String name = (String) jsonObject.get("name");
                String value = (String) jsonObject.get("value");
                boatVariantData.put(name,value);
                System.out.println("name is :" +name + " value is "+ value);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        Boat boat = vr.getBoatById(Integer.parseInt(boatVariantData.get("boatId")));
        Customer customer = ar.findCustomerById(Integer.parseInt(boatVariantData.get("customerId")));

        boatVariant.populate(boat,customer,boatVariantData);
        vr.addBoatVariant(boatVariant);

        //sending back the status message to the client
        JSONObject returnMessage = new JSONObject();
        returnMessage.put("status","success");
        returnMessage.put("customer", boatVariant.getCustomer().getFirstName() + " " +boatVariant.getBoat().getModel());
        response.getWriter().print(returnMessage.toJSONString());

    }

}



