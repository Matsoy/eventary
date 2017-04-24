# Eventary
------------

Application permettant de voir et organiser des �v�nements au sein d'�coles.

## Noms des �tudiants du groupe
------------

* Pierre Savatte
* Neil Rittner
* Julien Triau
* Mathieu Soyer

## Nom et adresse e-mail de l��tudiant coordinateur du groupe
------------

* Neil Rittner: neil.rittner@etu.univ-nantes.fr

## R�partition des t�ches
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

Supprimer une branche

``` sh
$ git branch -d nom_de_la_branche_a_supprimer
$ git push origin :nom_de_la_branche_supprimee
```

Cr�er une branche

``` sh
$ git checkout -b nom_de_la_branche_a_creer
$ git push -u origin nom_de_la_branche_creee
```

### SQLite3

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

Ex�cuter un script sql sur la base. Par exemple: appliquer les triggers sur la base

``` sh
sqlite3 eventary.db < triggers/triggers.sql
```