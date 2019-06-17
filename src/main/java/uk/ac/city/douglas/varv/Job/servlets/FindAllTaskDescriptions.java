/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.city.douglas.varv.Job.servlets;

import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import uk.ac.city.douglas.varv.Account.dao.AccountDAO;
import uk.ac.city.douglas.varv.Account.dao.AccountDAOInterface;
import uk.ac.city.douglas.varv.Account.domain.Customer;
import uk.ac.city.douglas.varv.Job.dao.JobDAO;
import uk.ac.city.douglas.varv.Job.dao.JobDAOInterface;
import uk.ac.city.douglas.varv.Job.domain.Job;
import uk.ac.city.douglas.varv.Job.domain.TaskDescription;

/**
 *
 * @author douglaslandvik
 */
@WebServlet(value = "/admin/job/task.html")
public class FindAllTaskDescriptions extends HttpServlet {

    private JobDAOInterface vr;

    @Inject
    public FindAllTaskDescriptions(JobDAOInterface vr) {
        this.vr = vr;

    }

    public void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        List<TaskDescription> taskDescriptions = vr.getAllTaskDescriptions();

        taskDescriptions.forEach(t->System.out.println("TASKDESCR"+ t));
        request.setAttribute("taskDescriptions", taskDescriptions);
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/admin/job/task.jsp");
        requestDispatcher.forward(request, response);

    }

}
