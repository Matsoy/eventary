-- DROP TABLE SCHOOL;
CREATE TABLE SCHOOL( -- table des écoles
    id integer,
    name text NOT NULL, -- nom de l'école
    CONSTRAINT pk_id_SCHOOL PRIMARY KEY (id)
);
