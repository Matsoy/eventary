-- DROP TABLE DEP_MEMBER;
CREATE TABLE DEP_MEMBER( -- table associative, entre DEPARTMENT et USER, des membres des départements
    department_id integer NOT NULL, -- id de l'association
    user_login text NOT NULL, -- login de l'utilisateur
    CONSTRAINT fk_department_id_DEP_MEMBER FOREIGN KEY (department_id) REFERENCES DEPARTMENT(id),
    CONSTRAINT fk_user_login_DEP_MEMBER FOREIGN KEY (user_login) REFERENCES USER(login),
    CONSTRAINT pk_DEP_MEMBER PRIMARY KEY (department_id, user_login) -- clé primaire constituée de 2 clés étrangères
);
