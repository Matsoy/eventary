-- DROP TABLE DEPARTMENT;
CREATE TABLE DEPARTMENT( -- table des département d'enseignement
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL, -- nom du département
    CONSTRAINT pk_id_DEPARTMENT PRIMARY KEY (id)
)
ENGINE=InnoDB;
