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

### Git

Merger sa branche avec master

``` sh
$ git checkout master
$ git merge nom_de_la_branche_a_merger
$ git push -u origin master
```

### MySQL

Installer SQLite sur Ubuntu

``` sh
$ sudo apt-get install sqlite3
```

Ouvrir le prompt

``` sh
$ sqlite3
```

Quitter le prompt

``` sh
sqlite3> .quit
```

Exécuter un script sql sur la base. Par exemple: appliquer les triggers sur la base

``` sh
sqlite3 eventary.db < Database/triggers/triggers.sql
```
