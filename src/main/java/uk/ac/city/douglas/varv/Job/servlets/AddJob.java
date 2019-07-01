/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.city.douglas.varv.Job.servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.HashMap;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.asayama.gwt.jsni.client.JSON;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import uk.ac.city.douglas.varv.Account.dao.AccountDAO;
import uk.ac.city.douglas.varv.Account.dao.AccountDAOInterface;
import uk.ac.city.douglas.varv.Account.domain.Customer;
import uk.ac.city.douglas.varv.Account.domain.Staff;
import uk.ac.city.douglas.varv.Boat.dao.BoatDAOInterface;
import uk.ac.city.douglas.varv.Boat.domain.BoatVariant;
import uk.ac.city.douglas.varv.Job.dao.JobDAO;
import uk.ac.city.douglas.varv.Job.dao.JobDAOInterface;
import uk.ac.city.douglas.varv.Job.domain.Job;

/**
 *
 * @author douglaslandvik
 */
@WebServlet(value = "/admin/job/addJob.html")
public class AddJob extends HttpServlet {

    private JobDAOInterface vr;
    private BoatDAOInterface br;
    private AccountDAOInterface ar;

    @Inject
    public AddJob(JobDAOInterface vr, BoatDAOInterface br, AccountDAOInterface ar) {
        this.vr = vr;
        this.br = br;
        this.ar = ar;

    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("application/x-www-form-urlencoded");
        request.setCharacterEncoding("UTF-8");
        Job job = new Job();
        HashMap<String,String> jobData = new HashMap<>();
        String json = request.getParameter("formData");
        JSONParser jsonParser = new JSONParser();
        try {
            JSONArray jsonArray = (JSONArray) jsonParser.parse(json);

            for(Object obj: jsonArray){
                JSONObject jsonObject = (JSONObject) obj;
                String name = (String) jsonObject.get("name");
                String value = (String) jsonObject.get("value");
                jobData.put(name,value);
                System.out.println("name is :" +name + " value is "+ value);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }


        BoatVariant boatVariant = br.findBoatVariantById(Integer.parseInt(jobData.get("kundbat")));

        //NOT SETTING ANY STAFF YET
        //        Staff staff = ar.findStaffById(Integer.parseInt(jobData.get("staff")));
//        job.setStaff(staff);

        job.setStatus("Skapat");
        job.setBoatVariant(boatVariant);
        //adding the customer
        job.populate(jobData);
        job.setStatus("Skapad");
        System.out.println(job.toString());
        vr.addJob(job);

        //sending back the status message to the client
        JSONObject returnMessage = new JSONObject();
        returnMessage.put("status","success");
        returnMessage.put("jobId", Integer.toString(job.getJobId()));
        response.getWriter().print(returnMessage.toJSONString());

    }


    public void doDelete(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");
        resp.setContentType("text/plain");
        System.out.println(id);
        vr.eraseJobById(Integer.parseInt(id));
    }




}



