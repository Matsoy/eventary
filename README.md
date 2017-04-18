# Eventary
------------

Application permettant de voir et organiser des événements au sein d'écoles.

## Noms des étudiants du groupe
------------

* Pierre Savatte
* Neil Rittner
* Julien Triau
* Mathieu Soyer

## Nom et adresse e-mail de l’étudiant coordinateur du groupe
------------

* Neil Rittner: neil.rittner@etu.univ-nantes.fr

## Répartition des tâches
------------

* **Model**: Neil Rittner
* **View**: Pierre Savatte
* **Controller**: Julien Triau
* **Database**: Mathieu Soyer

## Commandes utiles
------------

<<<<<<< HEAD
Merger sa branche avec master

``` sh
$ git checkout master
$ git merge nom_de_la_branche_a_merger
$ git push -u origin master
=======
### Git

Merger sa branche avec master

``` sh
$ git checkout master
$ git merge nom_de_la_branche_a_merger
$ git push -u origin master
```

### MySQL

Installer MySQL sur Ubuntu

``` sh
$ sudo apt-get install mysql-server
```

Démarrer

``` sh
$ sudo service mysql start
```

Ouvrir le prompt

``` sh
$ mysql -u root -p
```

Sélectionner la base eventarydb

``` sh
mysql> use eventarydb
```

Exécuter un script sur la base

``` sh
mysql -u root -p eventarydb < monscript.sql
>>>>>>> Database
```
