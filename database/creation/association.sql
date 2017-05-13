--DROP TABLE ASSOCIATION;
PRAGMA encoding="UTF-8";
CREATE TABLE ASSOCIATION( -- table des associations
    id integer,
    name text NOT NULL, -- nom de l'association
    in_charge text NOT NULL, -- login du responsable de l'association
    CONSTRAINT pk_id_ASSOCIATION PRIMARY KEY (id)
);
