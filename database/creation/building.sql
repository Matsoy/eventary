-- DROP TABLE BUILDING;
PRAGMA encoding="UTF-8";
CREATE TABLE BUILDING( -- table des bâtiments des écoles
    id integer,
    site_id integer NOT NULL, -- id du site où se trouve le bâtiment
    name text NOT NULL, -- nom du bâtiment
    CONSTRAINT fk_site_id_BUILDING FOREIGN KEY (site_id) REFERENCES SITE(id),
    CONSTRAINT pk_id_BUILDING PRIMARY KEY (id)
);
