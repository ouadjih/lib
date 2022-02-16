import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.mysql.jdbc.Driver;
import java.sql.*; 
import javax.servlet.annotation.WebServlet;



@WebServlet("/ajouterLivre")
public class ajouterLivre extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest r, HttpServletResponse s )
            throws IOException , ServletException 
    {
          
           String titre = r.getParameter("titre");
           String resume = r.getParameter("resume");
           int nbPage = Integer.parseInt(r.getParameter("nbPage"));
           String domaine = r.getParameter("domaine");
          
           PrintWriter p= s.getWriter();
           try{
                
                Class.forName("com.mysql.jdbc.Driver"); 
                Connection c= DriverManager.getConnection("jdbc:mysql://localhost/bibliotheque","root","");
                Statement st=c.createStatement();
                              
         
           st.executeUpdate("INSERT INTO `livre`(`titre`, `resume`, `nbPage`, `domaine`)VALUES('"+titre+"','"+resume+"','"+nbPage+"','"+domaine+"')");
                RequestDispatcher rd=r.getRequestDispatcher("Admin.jsp");
                rd.forward(r, s);
                
           }
               catch (ClassNotFoundException | SQLException e)
                  {
                         p.print("error"+e);
                  }            
    }
    
}

