package com.example.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.example.dao.LoginDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Cette annotation définit l'URL du servlet
@WebServlet("/servlet1")
public class FirstServlet extends HttpServlet {
    // La méthode doPost est appelée par le serveur (via la méthode service) pour
    // permettre à un servlet de gérer une requête POST
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Définit le type de contenu de la réponse, ici "text/html"
        response.setContentType("text/html");
        // Crée un PrintWriter pour envoyer la réponse au client
        PrintWriter out = response.getWriter();

        // Récupère les paramètres de la requête
        String n = request.getParameter("username");
        String p = request.getParameter("userpass");

        // Si la validation est réussie, redirige vers "servlet2"
        if (LoginDao.validate(n, p)) {
            RequestDispatcher rd = request.getRequestDispatcher("servlet2");
            rd.forward(request, response);
        } else {
            // Sinon, affiche un message d'erreur et inclut le contenu de "index.html"
            out.print("Désolé, erreur de nom d'utilisateur ou de mot de passe");
            RequestDispatcher rd = request.getRequestDispatcher("index.html");
            rd.include(request, response);
        }

        // Ferme le PrintWriter
        out.close();
    }
}