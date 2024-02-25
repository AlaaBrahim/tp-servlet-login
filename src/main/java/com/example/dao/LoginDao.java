package com.example.dao;

import java.sql.*;

// Cette classe contient une méthode pour valider les informations de connexion d'un utilisateur
public class LoginDao {
    // Cette méthode prend en paramètre le nom d'utilisateur et le mot de passe, et
    // retourne un booléen indiquant si la validation a réussi ou non
    public static boolean validate(String name, String pass) {
        boolean status = false;
        ResultSet rs;
        try {
            // Définition des paramètres de connexion à la base de données
            String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
            String user = "postgres";
            String password = "postgres";

            // Établissement de la connexion à la base de données
            Connection connection = DriverManager.getConnection(jdbcUrl, user, password);

            // Création de la table 'userreg' si elle n'existe pas déjà
            connection.createStatement().execute(
                    " create table IF NOT EXISTS userreg(name varchar(40),pass varchar(40));");

            // Vérification de l'existence de l'utilisateur 'admin'
            rs = connection.createStatement().executeQuery(
                    "select * from userreg where name='admin';");

            // Si l'utilisateur 'admin' n'existe pas, on le crée
            if (!rs.next()) {
                connection.createStatement().execute(
                        "insert into userreg values('admin','admin');");
            }

            // Préparation de la requête SQL pour vérifier les informations de connexion de
            // l'utilisateur
            PreparedStatement ps = connection.prepareStatement(
                    "select * from userreg where name=? and pass=?");
            ps.setString(1, name);
            ps.setString(2, pass);

            // Exécution de la requête SQL
            rs = ps.executeQuery();
            // Si la requête retourne un résultat, cela signifie que les informations de
            // connexion sont valides
            status = rs.next();

        } catch (Exception e) {
            // Affichage de l'exception en cas d'erreur
            System.out.println(e);
        }
        // Retour du statut de la validation
        return status;
    }
}