-- DROP TABLE ROOM;
CREATE TABLE ROOM( -- table des salles
    id integer,
    nbPlaces integer NOT NULL DEFAULT 0, -- le nombre de places dans la salle
    name text NOT NULL, -- nom de la salle
    CONSTRAINT pk_id_ROOM PRIMARY KEY (id)
);
