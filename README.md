# Projet de Login Simple

Ce projet est une application simple de login qui utilise deux servlets. Il est construit avec Maven et utilise Tomcat comme serveur. La base de données est gérée avec Docker.

## Prérequis

- Java
- Maven
- Docker

## Installation

1. Clonez ce dépôt sur votre machine locale.
2. Naviguez jusqu'au dossier du projet.

## Exécution de l'application

Pour exécuter l'application, utilisez la commande suivante :

```bash
mvn tomcat7:run
```

L'application sera alors accessible à l'adresse localhost:8080.

## Gestion de la base de données

Pour lancer la base de données, utilisez la commande suivante :

```bash
docker-compose up
```

## Servlets

Le projet contient deux servlets :

1. FirstServlet : Gère le processus de login.
2. WelcomeServlet : Affiche un message de bienvenue une fois que l'utilisateur est connecté.
