-- DROP TABLE ORGANIZATION;
PRAGMA encoding="UTF-8";

CREATE TABLE ORGANIZATION( -- table des département d'enseignement
    id integer,
    name text NOT NULL, -- nom du département
    in_charge text NOT NULL, -- login du responsable du departement
    type_orga text CHECK (type_orga IN ('dpt', 'asso')), -- type d'organisation (association ou departement)
    CONSTRAINT pk_id_ORGANIZATION PRIMARY KEY (id)
);
