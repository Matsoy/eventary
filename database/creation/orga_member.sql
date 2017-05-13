drop table dep_member;
drop table asso_member;
drop table department;
drop table association;

-- DROP TABLE ORGA_MEMBER;
PRAGMA encoding="UTF-8";

CREATE TABLE ORGA_MEMBER( -- table associative, entre ORGANIZATION et USER, des membres des organisations
    orga_id integer NOT NULL, -- id de l'organisation
    user_login text NOT NULL, -- login de l'utilisateur
    CONSTRAINT fk_orga_id_ORGA_MEMBER FOREIGN KEY (orga_id) REFERENCES ORGANIZATION(id),
    CONSTRAINT fk_user_login_ORGA_MEMBER FOREIGN KEY (user_login) REFERENCES USER(login),
    CONSTRAINT pk_ORGA_MEMBER PRIMARY KEY (orga_id, user_login) -- clé primaire constituée de 2 clés étrangères
);
