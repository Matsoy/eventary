-- DROP TABLE SCHOOL;
CREATE TABLE SCHOOL( -- table des écoles
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL, -- nom de l'école
    CONSTRAINT pk_id_SCHOOL PRIMARY KEY (id)
)
ENGINE=InnoDB;
