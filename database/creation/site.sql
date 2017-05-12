-- DROP TABLE SITE;
PRAGMA encoding="UTF-8";
CREATE TABLE SITE( -- table des sites des écoles
    id integer,
    school_id integer NOT NULL, -- id de l'école où se trouve le site
    name text NOT NULL, -- nom du site
    CONSTRAINT fk_school_id_SITE FOREIGN KEY (school_id) REFERENCES SCHOOL(id),
    CONSTRAINT pk_id_SITE PRIMARY KEY (id)
);
