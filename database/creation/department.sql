-- DROP TABLE DEPARTMENT;
CREATE TABLE DEPARTMENT( -- table des département d'enseignement
    id integer,
    name text NOT NULL, -- nom du département
    CONSTRAINT pk_id_DEPARTMENT PRIMARY KEY (id)
);
