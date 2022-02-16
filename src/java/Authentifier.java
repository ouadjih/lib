
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pavilion
 */
@WebServlet("/auth")
public class Authentifier extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String user =  request.getParameter("user");
       String pass = request.getParameter("pass");
       if("admin".equals(user) && pass.equals(pass)){
            HttpSession session = request.getSession(true);
            
            session.setAttribute("admin", user);
            session.setAttribute("pass", pass);
            response.sendRedirect(request.getContextPath() + "/Admin.jsp");
       }else
       {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            HttpSession  session=request.getSession(true);
            session.setAttribute("errorMessage", "Login Failed ");
       }
       
    }

   
}
