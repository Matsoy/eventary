-- DROP TABLE BUILDING;
CREATE TABLE BUILDING( -- table des bâtiments des écoles
    id INT NOT NULL AUTO_INCREMENT,
    site_id INT NOT NULL, -- id du site où se trouve le bâtiment
    name VARCHAR(50) NOT NULL, -- nom du bâtiment
    CONSTRAINT fk_site_id_BUILDING FOREIGN KEY (site_id) REFERENCES SITE(id),
    CONSTRAINT pk_id_BUILDING PRIMARY KEY (id)
)
ENGINE=InnoDB;
