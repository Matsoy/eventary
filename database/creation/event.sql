--DROP TABLE EVENT;

PRAGMA encoding="UTF-8";
CREATE TABLE EVENT( -- table des événements
    id integer,
    title text NOT NULL, -- titre
    descr text NOT NULL, -- description
    creatDate datetime, -- date de création
    startDate datetime NOT NULL, -- date de début
    endDate datetime NOT NULL, -- date de fin
    modifDate datetime, -- date de dernière modification
    cancelDate datetime, -- date d'annulation
    maxNbParticipant integer NOT NULL, -- nombre maximum de participants
    organizer integer NOT NULL, -- id de l'organisateur
	orga_id interger, -- id de l'organisation qui a cree l'evenement (null si orga cree par un simple utilisateur)    
	room_id integer, -- id de la salle ( > batiment > site > �cole)
    address text, -- adresse de l'événement, si il n'a pas lieu dans une école
    CONSTRAINT pk_id_EVENT PRIMARY KEY (id)
);