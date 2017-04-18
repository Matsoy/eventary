-- DROP TABLE SITE;
CREATE TABLE SITE( -- table des sites des écoles
    id INT NOT NULL AUTO_INCREMENT,
    school_id INT NOT NULL, -- id de l'école où se trouve le site
    name VARCHAR(50) NOT NULL, -- nom du site
    CONSTRAINT fk_school_id_SITE FOREIGN KEY (school_id) REFERENCES SCHOOL(id),
    CONSTRAINT pk_id_SITE PRIMARY KEY (id)
)
ENGINE=InnoDB;
