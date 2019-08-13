/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.city.douglas.varv.Boat.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.stream.Collectors;
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
import uk.ac.city.douglas.varv.Boat.domain.Engine;
import uk.ac.city.douglas.varv.Job.dao.JobDAO;

/**
 *
 * @author douglaslandvik
 */
@WebServlet(value = "/admin/engine/editEngine.html")
public class EditEngine extends HttpServlet {

    private BoatDAOInterface vr;

    @Inject
    public EditEngine(BoatDAOInterface vr) {
        this.vr = vr;

    }






    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws IOException, ServletException {

     String json = null;
        json = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        System.out.println(json);
        HashMap<String,String> engineData = new HashMap<>();



        JSONObject returnMessage = new JSONObject();
        returnMessage.put("status","success");
        response.getWriter().print(returnMessage.toJSONString());
    }

}


