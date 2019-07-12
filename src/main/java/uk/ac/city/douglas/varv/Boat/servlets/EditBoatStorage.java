/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.city.douglas.varv.Boat.servlets;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.HashMap;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import uk.ac.city.douglas.varv.Account.dao.AccountDAO;
import uk.ac.city.douglas.varv.Account.dao.AccountDAOInterface;
import uk.ac.city.douglas.varv.Account.domain.Customer;
import uk.ac.city.douglas.varv.Account.domain.Staff;
import uk.ac.city.douglas.varv.Boat.dao.BoatDAOInterface;
import uk.ac.city.douglas.varv.Boat.domain.BoatStorage;
import uk.ac.city.douglas.varv.Boat.domain.BoatVariant;
import uk.ac.city.douglas.varv.Job.dao.JobDAO;

/**
 *
 * @author douglaslandvik
 */
@WebServlet(value = "/admin/boat/addBoatStorage.html")
public class EditBoatStorage extends HttpServlet {

    private BoatDAOInterface vr;

    @Inject
    public EditBoatStorage(BoatDAOInterface vr) {
        this.vr = vr;

    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("application/x-www-form-urlencoded");
        request.setCharacterEncoding("UTF-8");


        BoatStorage boatStorage = new BoatStorage();
        HashMap<String,String> boatStorageData = new HashMap<>();
        String json = request.getParameter("formData");
        System.out.println(json);
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


//edit the boatVariant
        vr.editBoatStorage(boatStorageData);
        //sending back the status message to the client
        JSONObject returnMessage = new JSONObject();
        returnMessage.put("status","success");
        returnMessage.put("boatStorage", boatStorage.getBoatStorageId());
        response.getWriter().print(returnMessage.toJSONString());
    }

}
