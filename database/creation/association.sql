-- DROP TABLE ASSOCIATION;
CREATE TABLE ASSOCIATION( -- table des associations
    id integer,
    name text NOT NULL, -- nom de l'association
    CONSTRAINT pk_id_ASSOCIATION PRIMARY KEY (id)
);
