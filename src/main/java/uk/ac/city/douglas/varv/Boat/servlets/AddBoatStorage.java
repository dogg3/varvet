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
import uk.ac.city.douglas.varv.Boat.domain.*;

/**
 *
 * @author douglaslandvik
 */
@WebServlet(value = "/admin/vinterplats/addBoatStorage.html")
public class AddBoatStorage extends HttpServlet {

    private BoatDAOInterface vr;
    private AccountDAOInterface ar;
    @Inject
    public AddBoatStorage(BoatDAOInterface vr, AccountDAOInterface ar) {
        this.vr = vr;
        this.ar = ar;

    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("application/x-www-form-urlencoded");
        request.setCharacterEncoding("UTF-8");
        BoatStorage boatStorage = new BoatStorage();
        HashMap<String,String> boatStorageData = new HashMap<>();
        String json = request.getParameter("formData");
        JSONParser jsonParser = new JSONParser();
        try {
            JSONArray jsonArray = (JSONArray) jsonParser.parse(json);

            for(Object obj: jsonArray){
                JSONObject jsonObject = (JSONObject) obj;
                String name = (String) jsonObject.get("name");
                String value = (String) jsonObject.get("value");
                boatStorageData.put(name,value);
                System.out.println("name is :" +name + " value is "+ value);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }


        BoatVariant customerBoat = vr.findBoatVariantById(Integer.parseInt(boatStorageData.get("boatVariantId")));

        boatStorage.setCustomerBoat(customerBoat);
        boatStorage.setDropOffDate(boatStorageData.get("dropOffDate"));
        boatStorage.setPickUpDate(boatStorageData.get("pickUpDate"));
        boatStorage.setComment(boatStorageData.get("comment"));
        boatStorage.setStatus("Accepterad");

        vr.addBoatStorage(boatStorage);


        //sending back the status message to the client
        JSONObject returnMessage = new JSONObject();
        returnMessage.put("status","success");
        returnMessage.put("name",boatStorage.getCustomerBoat().getCustomer().getFirstName());
        returnMessage.put("boat", boatStorage.getCustomerBoat().getBoat().getBrand()+" "+boatStorage.getCustomerBoat().getBoat().getModel());
        response.getWriter().print(returnMessage.toJSONString());

    }

    public void doDelete(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");
        resp.setContentType("text/plain");
        System.out.println(id);
        vr.eraseBoatStorageById(Integer.parseInt(id));
    }

}



