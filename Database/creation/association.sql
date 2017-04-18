-- DROP TABLE ASSOCIATION;
CREATE TABLE ASSOCIATION( -- table des associations
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL, -- nom de l'association
    CONSTRAINT pk_id_ASSOCIATION PRIMARY KEY (id)
)
ENGINE=InnoDB;
