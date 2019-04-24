/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.city.douglas.varv.Account.servlets;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uk.ac.city.douglas.varv.Job.dao.VarvRepository;

/**
 *
 * @author douglaslandvik
 */

@WebServlet(value="/logout.html")
public class LogOut extends HttpServlet {
    
    private VarvRepository vr;
    
    @Inject
    public LogOut(VarvRepository vr){
        this.vr =  vr;
    }
    
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException{
        response.setContentType("text/html");
      
        
       
     HttpSession session = request.getSession();
    session.invalidate();
    response.sendRedirect("/varv/loginForm.jsp");
            
            }
    
}
