-- DROP TABLE USER;
CREATE TABLE USER( -- table des utilisateurs
    login VARCHAR(50) NOT NULL, -- identifiant
    passwd VARCHAR(50) NOT NULL, -- mot de passe
    moderator INT NOT NULL, -- 1 si l'utilisateur est un modérateur, 0 sinon
    fName VARCHAR(50) NOT NULL, -- prénom
    lName VARCHAR(50) NOT NULL, -- nom
    branch VARCHAR(50), -- spécialité
    year INT, -- mot de passe
    CONSTRAINT ck_moderator_USER CHECK (moderator IN (0, 1)), -- vérification que la moderator == 0 ou 1
    CONSTRAINT ck_year_USER CHECK (year BETWEEN 2010 AND 2030), -- vérification que la date est entre 2010 et 2030 (bornes à définir).
    CONSTRAINT pk_login_USER PRIMARY KEY (login)
)
ENGINE=InnoDB;
