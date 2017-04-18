-- DROP TABLE ASSO_MEMBER;
CREATE TABLE ASSO_MEMBER( -- table associative, entre ASSOCIATION et USER, des membres des associations
    association_id INT NOT NULL, -- id de l'association
    user_login VARCHAR(50) NOT NULL, -- login de l'utilisateur
    CONSTRAINT pk_ASSO_MEMBER PRIMARY KEY (association_id, user_login), -- clé primaire constituée de 2 clés étrangères
    CONSTRAINT fk_association_id_ASSO_MEMBER FOREIGN KEY (association_id) REFERENCES ASSOCIATION(id),
    CONSTRAINT fk_user_login_ASSO_MEMBER FOREIGN KEY (user_login) REFERENCES USER(login)
)
ENGINE=InnoDB;
