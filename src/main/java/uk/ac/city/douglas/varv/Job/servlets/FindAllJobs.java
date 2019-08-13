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

/**
 *
 * @author douglaslandvik
 */
@WebServlet(value = "/admin/job/index.html")
public class FindAllJobs extends HttpServlet {

    private JobDAOInterface vr;

    @Inject
    public FindAllJobs(JobDAOInterface vr) {
        this.vr = vr;

    }

    public void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html");
        List<Job> jobs = vr.getAllJobs();

        request.setAttribute("jobs", jobs);
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/admin/job/index.jsp");
        requestDispatcher.forward(request, response);

    }

}
