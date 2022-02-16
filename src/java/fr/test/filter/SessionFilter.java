package fr.test.filter;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionFilter implements Filter{

@Override
public void destroy() {
// TODO Auto-generated method stub

}

@Override
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
HttpSession session = ((HttpServletRequest) request).getSession();

// On recupere le bean de session
String  user = (String) session.getAttribute("user");

if( user ==null ) {
// la session n'est pas valide....on retourne au login
((HttpServletResponse) response).sendRedirect("index.html");
} else {
// on autorise l'acces...la page demandée peut s'afficher
chain.doFilter(request,response);
}
}



    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
} 