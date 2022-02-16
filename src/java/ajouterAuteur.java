import com.mysql.jdbc.Driver;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet("/ajouterAuteur")
public class ajouterAuteur extends HttpServlet {
    
    @Override
    protected void doPost (HttpServletRequest r, HttpServletResponse s )
            throws IOException , ServletException 
    {
           String nom = r.getParameter("nom");
           String prenom = r.getParameter("prenom");
           String dateNaissance =r.getParameter("dateNaissance");
           int a=0;
           
           PrintWriter p= s.getWriter();
           try{        
               //connection a la base des donnes
                Class.forName("com.mysql.jdbc.Driver");                
                Connection c= DriverManager.getConnection("jdbc:mysql://localhost/bibliotheque","root","");            
                Statement st=c.createStatement();
               // excution de la requete              
                st.executeUpdate("INSERT INTO `auteur`( `nom`, `prenom`, `dateNaissance`) VALUES ('"+nom+"','"+prenom+"','"+dateNaissance+"')");
                RequestDispatcher rd=r.getRequestDispatcher("Admin.jsp");
                rd.forward(r, s);
                
               
           }
               catch (ClassNotFoundException | SQLException | ServletException | IOException e)
                  {       
                         p.print("error"+e);
                  } 
            
    }
    
}
