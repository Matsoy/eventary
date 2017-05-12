--DROP TABLE ROOM;
PRAGMA encoding="UTF-8";
CREATE TABLE ROOM( -- table des salles
    id integer,
    building_id integer NOT NULL, -- id du batiment où se trouve la salle
    nbPlaces integer NOT NULL DEFAULT 0, -- le nombre de places dans la salle
    name text NOT NULL, -- nom de la salle
    CONSTRAINT pk_id_ROOM PRIMARY KEY (id)
);
