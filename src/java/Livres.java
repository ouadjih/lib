/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
import java.util.*;
/**
 *
 * @author Pavilion
 */

   @WebServlet("/Livres")
public class Livres extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");
        HttpSession session = request.getSession(true);
        List livreList = new ArrayList();
        String sqlStr = "SELECT `ISSN`, `titre`, `nbPage`, `domaine` FROM `livre`";
        System.out.println(sqlStr);
        try{
              Class.forName("com.mysql.jdbc.Driver").newInstance();
              Connection  conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque","root","");

            try{
                Statement statement = conn.createStatement();
                ResultSet rs = statement.executeQuery(sqlStr);
                while (rs.next()) {
                    List livre = new ArrayList();
                    livre.add(rs.getInt(1));
                    livre.add(rs.getString(2));
                    livre.add(rs.getInt(3));
                    livre.add(rs.getString(4));
                   
                    livreList.add(livre);
                }
            } catch (SQLException s){
                System.out.println("Pas de livre disponible !");
            }} catch(ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e){  }
            request.setAttribute("livreList", livreList);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Listlivres.jsp");
            dispatcher.forward(request, response);
    }}

