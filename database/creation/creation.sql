CREATE TABLE EVENT( -- table des événements
    id integer,
    title text NOT NULL, -- titre
    descr text NOT NULL, -- description
    creatDate datetime, -- date de création
    startDate datetime NOT NULL, -- date de début
    endDate datetime NOT NULL, -- date de fin
    modifDate datetime, -- date de dernière modification
    cancelDate datetime, -- date d'annulation
    maxNbParticipant integer NOT NULL, -- nombre maximum de participants
    organizer text NOT NULL, -- id de l'organisateur
    school_id integer, -- id de l'école dans laquelle se déroule l'événement
    address text, -- adresse de l'événement, si il n'a pas lieu dans une école
    CONSTRAINT pk_id_EVENT PRIMARY KEY (id)
);


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


CREATE TABLE PARTICIPATION( -- table associative, entre EVENT et USER, des participations
    event_id integer NOT NULL, -- id de l'événement
    user_login text NOT NULL, -- login de l'utilisateur
    CONSTRAINT fk_event_id_PARTICIPATION FOREIGN KEY (event_id) REFERENCES EVENT(id),
    CONSTRAINT fk_user_login_PARTICIPATION FOREIGN KEY (user_login) REFERENCES USER(login),
    CONSTRAINT pk_PARTICIPATION PRIMARY KEY (event_id, user_login) -- clé primaire constituée de 2 clés étrangères
);


CREATE TABLE WAITING( -- table associative, entre EVENT et USER, des USER sur la liste d'attente d'un EVENT
    event_id integer NOT NULL, -- id de l'événement
    user_login text NOT NULL, -- login de l'utilisateur
    waiting_date datetime, -- date de rentr�e dans la liste d'attente
    CONSTRAINT fk_event_id_PARTICIPATION FOREIGN KEY (event_id) REFERENCES EVENT(id),
    CONSTRAINT fk_user_login_PARTICIPATION FOREIGN KEY (user_login) REFERENCES USER(login),
    CONSTRAINT pk_PARTICIPATION PRIMARY KEY (event_id, user_login) -- clé primaire constituée de 2 clés étrangères
);


CREATE TABLE SCHOOL( -- table des écoles
    id integer,
    name text NOT NULL, -- nom de l'école
    CONSTRAINT pk_id_SCHOOL PRIMARY KEY (id)
);


CREATE TABLE SITE( -- table des sites des écoles
    id integer,
    school_id integer NOT NULL, -- id de l'école où se trouve le site
    name text NOT NULL, -- nom du site
    CONSTRAINT fk_school_id_SITE FOREIGN KEY (school_id) REFERENCES SCHOOL(id),
    CONSTRAINT pk_id_SITE PRIMARY KEY (id)
);


CREATE TABLE BUILDING( -- table des bâtiments des écoles
    id integer,
    site_id integer NOT NULL, -- id du site où se trouve le bâtiment
    name text NOT NULL, -- nom du bâtiment
    CONSTRAINT fk_site_id_BUILDING FOREIGN KEY (site_id) REFERENCES SITE(id),
    CONSTRAINT pk_id_BUILDING PRIMARY KEY (id)
);

CREATE TABLE ROOM( -- table des salles
    id integer,
    building_id integer NOT NULL, -- id du batiment où se trouve la salle
    nbPlaces integer NOT NULL DEFAULT 0, -- le nombre de places dans la salle
    name text NOT NULL, -- nom de la salle
    CONSTRAINT pk_id_ROOM PRIMARY KEY (id)
);


CREATE TABLE ASSOCIATION( -- table des associations
    id integer,
    name text NOT NULL, -- nom de l'association
    CONSTRAINT pk_id_ASSOCIATION PRIMARY KEY (id)
);


CREATE TABLE DEPARTMENT( -- table des département d'enseignement
    id integer,
    name text NOT NULL, -- nom du département
    CONSTRAINT pk_id_DEPARTMENT PRIMARY KEY (id)
);


CREATE TABLE ASSO_MEMBER( -- table associative, entre ASSOCIATION et USER, des membres des associations
    association_id integer NOT NULL, -- id de l'association
    user_login text NOT NULL, -- login de l'utilisateur
    CONSTRAINT pk_ASSO_MEMBER PRIMARY KEY (association_id, user_login), -- clé primaire constituée de 2 clés étrangères
    CONSTRAINT fk_association_id_ASSO_MEMBER FOREIGN KEY (association_id) REFERENCES ASSOCIATION(id),
    CONSTRAINT fk_user_login_ASSO_MEMBER FOREIGN KEY (user_login) REFERENCES USER(login)
);


CREATE TABLE DEP_MEMBER( -- table associative, entre DEPARTMENT et USER, des membres des départements
    department_id integer NOT NULL, -- id de l'association
    user_login text NOT NULL, -- login de l'utilisateur
    CONSTRAINT fk_department_id_DEP_MEMBER FOREIGN KEY (department_id) REFERENCES DEPARTMENT(id),
    CONSTRAINT fk_user_login_DEP_MEMBER FOREIGN KEY (user_login) REFERENCES USER(login),
    CONSTRAINT pk_DEP_MEMBER PRIMARY KEY (department_id, user_login) -- clé primaire constituée de 2 clés étrangères
);
