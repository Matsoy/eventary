# Eventary
------------

Application permettant de voir et organiser des événements au sein d'écoles.

## Noms des étudiants du groupe
------------

* Pierre Savatte
* Neil Rittner
* Julien Triau
* Mathieu Soyer

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

Supprimer une branche

``` sh
$ git branch -d nom_de_la_branche_a_supprimer
$ git push origin :nom_de_la_branche_supprimee
```

Créer une branche

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

Rebuilder toute la BDD (ps: passer script du format "Windows" au format "Unix" avec la commande: dos2unix build.sh)

``` sh
$ ./build.sh
```
