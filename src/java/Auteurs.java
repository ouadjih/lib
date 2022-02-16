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

   @WebServlet("/Auteurs")
public class Auteurs extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");
        HttpSession session = request.getSession(true);
        List auteurList = new ArrayList();
        String sqlStr = null;

            sqlStr = "SELECT `num`, `nom`, `prenom`, `dateNaissance` FROM `auteur`";
        System.out.println(sqlStr);
        try{
             Class.forName("com.mysql.jdbc.Driver").newInstance();
              Connection  conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque","root","");
            try{
                Statement statement = conn.createStatement();
                ResultSet rs = statement.executeQuery(sqlStr);
                while (rs.next()) {
                    List auteur = new ArrayList();
                    auteur.add(rs.getInt(1));
                    auteur.add(rs.getString(2));
                    auteur.add(rs.getString(3));
                    auteur.add(rs.getString(4));       
                    auteurList.add(auteur);
                }
            } catch (SQLException s){
                System.out.println("Pas d'auteur disponible !");
            }} catch(ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e){}
            request.setAttribute("auteurList", auteurList);
            session.setAttribute("auteurList", auteurList);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Listauteurs.jsp");
            dispatcher.forward(request, response);           
    }}

