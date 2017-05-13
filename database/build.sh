#!/bin/bash

clear

function runscripts {
    printf "%s" "Suppression des tables et de leur contenu"
    $(sqlite3 eventary.db < deletion/deletion.sql)
    printf "\n"

    printf "%s" "Création des tables"
    printf "\n"
    printf "%s" "     user"
    $(sqlite3 eventary.db < creation/user.sql)
    printf "\n"
    printf "%s" "     event"
    $(sqlite3 eventary.db < creation/event.sql)
    printf "\n"
    printf "%s" "     organization"
    $(sqlite3 eventary.db < creation/organization.sql)
    printf "\n"
    printf "%s" "     school"
    $(sqlite3 eventary.db < creation/school.sql)
    printf "\n"
    printf "%s" "     site"
    $(sqlite3 eventary.db < creation/site.sql)
    printf "\n"
    printf "%s" "     building"
    $(sqlite3 eventary.db < creation/building.sql)
    printf "\n"
    printf "%s" "     room"
    $(sqlite3 eventary.db < creation/room.sql)
    printf "\n"
    printf "%s" "     orga_member"
    $(sqlite3 eventary.db < creation/orga_member.sql)
    printf "\n"
    printf "%s" "     waiting"
    $(sqlite3 eventary.db < creation/waiting.sql)
    printf "\n"
    printf "%s" "     participation"
    $(sqlite3 eventary.db < creation/participation.sql)
    printf "\n"

    printf "%s" ""
    printf "\n"
    printf "%s" "Exécution des triggers"
    $(sqlite3 eventary.db < triggers/triggers.sql)
    printf "\n"

    printf "%s" ""
    printf "\n"
    printf "%s" "Insertion des tuples dans les tables"
    printf "\n"
    printf "%s" "     users"
    $(sqlite3 eventary.db < insertion/users.sql)
    printf "\n"
    printf "%s" "     events"
    $(sqlite3 eventary.db < insertion/events.sql)
    printf "\n"
    printf "%s" "     organizations"
    $(sqlite3 eventary.db < insertion/organizations.sql)
    printf "\n"
    printf "%s" "     schools"
    $(sqlite3 eventary.db < insertion/schools.sql)
    printf "\n"
    printf "%s" "     sites"
    $(sqlite3 eventary.db < insertion/sites.sql)
    printf "\n"
    printf "%s" "     buildings"
    $(sqlite3 eventary.db < insertion/buildings.sql)
    printf "\n"
    printf "%s" "     rooms"
    $(sqlite3 eventary.db < insertion/rooms.sql)
    printf "\n"
    printf "%s" "     orga_members"
    $(sqlite3 eventary.db < insertion/orga_members.sql)
    printf "\n"
    printf "%s" "     waitings"
    $(sqlite3 eventary.db < insertion/waitings.sql)
    printf "\n"
    printf "%s" "     participation"
    $(sqlite3 eventary.db < insertion/participations.sql)
    printf "\n"

    printf "%s" ""
    printf "\n"
    printf "%s" "DONE"

    # arret de la barre de chargement
    progressbar=false

    exit
}

spinner()
{
    local pid=$!
    local delay=0.001
    local spinstr='...............'
    while [ "$(ps a | awk '{print $1}' | grep $pid)" ]; do
        local temp=${spinstr#?}
        printf "$spinstr"
        local spinstr=$temp${spinstr%"$temp"}
        sleep $delay
    done
    echo ""
}

runscripts & spinner
