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
import uk.ac.city.douglas.varv.Job.domain.TaskDescription;

/**
 *
 * @author douglaslandvik
 */
@WebServlet(value = "/admin/job/addTaskDescription.html")
public class AddTaskDescription extends HttpServlet {

    private JobDAOInterface vr;

    @Inject
    public AddTaskDescription(JobDAOInterface vr) {
        this.vr = vr;


    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("application/x-www-form-urlencoded");
        request.setCharacterEncoding("UTF-8");
        TaskDescription taskDescription = new TaskDescription();
        HashMap<String,String> taskDescriptionData = new HashMap<>();
        String json = request.getParameter("formData");
        System.out.println("formData" + json);
        JSONParser jsonParser = new JSONParser();

        try {

            JSONArray jsonArray = (JSONArray) jsonParser.parse(json);
            for(Object obj: jsonArray){
                JSONObject jsonObject = (JSONObject) obj;
                String name = (String) jsonObject.get("name");
                String value = (String) jsonObject.get("value");
                taskDescriptionData.put(name,value);
                System.out.println("name is :" +name + " value is "+ value);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        taskDescriptionData.forEach((k,v)->System.out.println(k + " " + v ));
        taskDescription.setDescription(taskDescriptionData.get("description"));
        taskDescription.setEstimatedTime(taskDescriptionData.get("estimatedTime"));
        taskDescription.setTaskType(taskDescriptionData.get("taskType"));
        vr.addTaskDescription(taskDescription);


        //sending back the status message to the client
        JSONObject returnMessage = new JSONObject();
        returnMessage.put("status","success");
        returnMessage.put("taskDescription", new JSONObject(taskDescriptionData));
        response.getWriter().print(returnMessage.toJSONString());

    }


    public void doDelete(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");
        resp.setContentType("text/plain");
        System.out.println(id);
        vr.eraseTaskDescriptionById(Integer.parseInt(id));
    }




}



