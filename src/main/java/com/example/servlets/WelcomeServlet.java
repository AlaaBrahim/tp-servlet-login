package com.example.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Cette annotation définit l'URL du servlet
@WebServlet("/servlet2")
public class WelcomeServlet extends HttpServlet {
    // La méthode doPost est appelée par le serveur (via la méthode service) pour permettre à un servlet de gérer une requête POST
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Définit le type de contenu de la réponse, ici "text/html"
        response.setContentType("text/html");
        // Crée un PrintWriter pour envoyer la réponse au client
        PrintWriter out = response.getWriter();

        // Récupère le paramètre 'username' de la requête
        String n = request.getParameter("username");
        // Envoie un message de bienvenue au client
        out.print("Welcome " + n);

        // Ferme le PrintWriter
        out.close();
    }
}