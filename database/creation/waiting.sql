--DROP TABLE WAITING;
PRAGMA encoding="UTF-8";
CREATE TABLE WAITING( -- table associative, entre EVENT et USER, des USER sur la liste d'attente d'un EVENT
    event_id integer NOT NULL, -- id de l'événement
    user_login text NOT NULL, -- login de l'utilisateur
    waiting_date datetime, -- date de rentr�e dans la liste d'attente
    CONSTRAINT fk_event_id_PARTICIPATION FOREIGN KEY (event_id) REFERENCES EVENT(id),
    CONSTRAINT fk_user_login_PARTICIPATION FOREIGN KEY (user_login) REFERENCES USER(login),
    CONSTRAINT pk_PARTICIPATION PRIMARY KEY (event_id, user_login) -- clé primaire constituée de 2 clés étrangères
);
