CREATE OR REPLACE TABLE EVENT( -- table des événements
    id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(50) NOT NULL, -- titre
    descr VARCHAR(200) NOT NULL, -- description
    creatDate DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP, -- date de création = par défaut la date actuelle de la forme 'YYYY-MM-DD HH:MM:SS'
    startDate DATETIME NOT NULL, -- date de début
    endDate DATETIME NOT NULL, -- date de fin
    duration INT NOT NULL, --durée en minute
    modifDate DATETIME, -- date de dernière modification
    cancelDate DATETIME, -- date d'annulation
    maxNbParticipant INT, -- nombre maximum de participants
    organizer INT NOT NULL, -- id de l'organisateur
    school_id INT, -- id de l'école dans laquelle se déroule l'événement
    address VARCHAR(50), -- adresse de l'événement, si il n'a pas lieu dans une école
    CONSTRAINT pk_id_EVENT PRIMARY KEY (id)
)
ENGINE=INNODB;


CREATE OR REPLACE TABLE USER( -- table des utilisateurs
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
ENGINE=INNODB;


CREATE OR REPLACE TABLE PARTICIPATION( -- table associative, entre EVENT et USER, des participations
    event_id int, -- id de l'événement
    user_login int, -- login de l'utilisateur
    CONSTRAINT pk_PARTICIPATION PRIMARY KEY (event_id, user_login), -- clé primaire constituée de 2 clés étrangères
    CONSTRAINT fk_event_id_PARTICIPATION FOREIGN KEY (event_id) REFERENCES EVENT(user_login),
    CONSTRAINT fk_user_login_PARTICIPATION FOREIGN KEY (user_login) REFERENCES USER(user_login)
)
ENGINE=INNODB;


CREATE OR REPLACE TABLE SCHOOL( -- table des écoles
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL, -- nom de l'école
    CONSTRAINT pk_id_SCHOOL PRIMARY KEY (id)
)
ENGINE=INNODB;


CREATE OR REPLACE TABLE SITE( -- table des sites des écoles
    id INT NOT NULL AUTO_INCREMENT,
    school_id INT NOT NULL, -- id de l'école où se trouve le site
    name VARCHAR(50) NOT NULL, -- nom du site
    CONSTRAINT pk_id_SITE PRIMARY KEY (id),
    CONSTRAINT fk_school_id_SITE FOREIGN KEY (school_id) REFERENCES SCHOOL(school_id)
)
ENGINE=INNODB;


CREATE OR REPLACE TABLE BUILDING( -- table des bâtiments des écoles
    id INT NOT NULL AUTO_INCREMENT,
    site_id INT NOT NULL, -- id du site où se trouve le bâtiment
    name VARCHAR(50) NOT NULL, -- nom du bâtiment
    CONSTRAINT pk_id_BUILDING PRIMARY KEY (id),
    CONSTRAINT fk_site_id_BUILDING FOREIGN KEY (site_id) REFERENCES SITE(site_id)
)
ENGINE=INNODB;


CREATE OR REPLACE TABLE ASSOCIATION( -- table des associations
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL -- nom de l'association
)
ENGINE=INNODB;


CREATE OR REPLACE TABLE DEPARTMENT( -- table des département d'enseignement
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL -- nom du département
)
ENGINE=INNODB;

CREATE OR REPLACE TABLE ASSO_MEMBER( -- table associative, entre ASSOCIATION et USER, des membres des associations
    association_id int, -- id de l'association
    user_login int, -- login de l'utilisateur
    CONSTRAINT pk_ASSO_MEMBER PRIMARY KEY (association_id, user_login), -- clé primaire constituée de 2 clés étrangères
    CONSTRAINT fk_association_id_ASSO_MEMBER FOREIGN KEY (association_id) REFERENCES ASSOCIATION(association_id),
    CONSTRAINT fk_user_login_ASSO_MEMBER FOREIGN KEY (user_login) REFERENCES USER(user_login)
)
ENGINE=INNODB;

CREATE OR REPLACE TABLE DEP_MEMBER( -- table associative, entre DEPARTMENT et USER, des membres des départements
    department_id int, -- id de l'association
    user_login int, -- login de l'utilisateur
    CONSTRAINT pk_DEP_MEMBER PRIMARY KEY (department_id, user_login), -- clé primaire constituée de 2 clés étrangères
    CONSTRAINT fk_department_id_DEP_MEMBER FOREIGN KEY (department_id) REFERENCES DEPARTMENT(department_id),
    CONSTRAINT fk_user_login_DEP_MEMBER FOREIGN KEY (user_login) REFERENCES USER(user_login)
)
ENGINE=INNODB;
