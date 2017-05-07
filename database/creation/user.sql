--DROP TABLE USER;
CREATE TABLE USER( -- table des utilisateurs
    login text NOT NULL, -- identifiant
    passwd text NOT NULL, -- mot de passe
    moderator integer NOT NULL, -- 1 si l'utilisateur est un modérateur, 0 sinon
    fName text NOT NULL, -- prénom
    lName text NOT NULL, -- nom
    branch text, -- spécialité
    year integer, -- mot de passe
    CONSTRAINT ck_moderator_USER CHECK (moderator IN (0, 1)), -- vérification que la moderator == 0 ou 1
    CONSTRAINT pk_login_USER PRIMARY KEY (login)
);
