-- DROP TABLE ORGA_MEMBER;
PRAGMA encoding="UTF-8";

CREATE TABLE NOTIFICATION(
    id integer,
    user_login integer NOT NULL, -- login de l'utilisateur
    messsage text NOT NULL, -- le corps de la notification
    CONSTRAINT fk_user_login_NOTIFICATION FOREIGN KEY (user_login) REFERENCES USER(login),
    CONSTRAINT pk_id_NOTIFICATION PRIMARY KEY (id)
);
