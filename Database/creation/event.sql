-- DROP TABLE EVENT;
CREATE TABLE EVENT( -- table des événements
    id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(50) NOT NULL, -- titre
    descr VARCHAR(200) NOT NULL, -- description
    creatDate DATETIME, -- date de création
    startDate DATETIME NOT NULL, -- date de début
    endDate DATETIME NOT NULL, -- date de fin
    modifDate DATETIME, -- date de dernière modification
    cancelDate DATETIME, -- date d'annulation
    maxNbParticipant INT NOT NULL, -- nombre maximum de participants
    organizer INT NOT NULL, -- id de l'organisateur
    school_id INT, -- id de l'école dans laquelle se déroule l'événement
    address VARCHAR(50), -- adresse de l'événement, si il n'a pas lieu dans une école
    CONSTRAINT pk_id_EVENT PRIMARY KEY (id)
)
ENGINE=InnoDB;
