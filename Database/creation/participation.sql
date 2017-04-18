-- DROP TABLE PARTICIPATION;
CREATE TABLE PARTICIPATION( -- table associative, entre EVENT et USER, des participations
    event_id INT NOT NULL, -- id de l'événement
    user_login VARCHAR(50) NOT NULL, -- login de l'utilisateur
    CONSTRAINT fk_event_id_PARTICIPATION FOREIGN KEY (event_id) REFERENCES EVENT(id),
    CONSTRAINT fk_user_login_PARTICIPATION FOREIGN KEY (user_login) REFERENCES USER(login),
    CONSTRAINT pk_PARTICIPATION PRIMARY KEY (event_id, user_login) -- clé primaire constituée de 2 clés étrangères
)
ENGINE=InnoDB;
