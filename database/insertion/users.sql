PRAGMA encoding="UTF-8";
-- insertion des User avec les mots de passe en clair
-- ils seront hashés par la suite 
--delete from user;
INSERT INTO USER --mdp = admin
VALUES ('admin', 'd033e22ae348aeb5660fc2140aec35850c4da997', 1, 'PrenomAdmin', 'NomAdmin', '', '2019');

INSERT INTO USER --mdp = petitkiwi
VALUES ('E168011W', '383489914769684bc1ff9b567aff05fc8ee02519', 0, 'Mathieu', 'Soyer', 'INFO', '2019');

INSERT INTO USER --mdp = neil
VALUES ('E147093J', '822ec91a7ef82248fd36162ca8ac3283eba70848', 0, 'Neil', 'Rittner', 'INFO', '2019');

INSERT INTO USER --mdp = azerty
VALUES ('E148834B', '9cf95dacd226dcf43da376cdb6cbba7035218921 ', 0, 'Pierre', 'Savatte', 'INFO', '2019');

INSERT INTO USER --mdp = motdepasse
VALUES ('E167998G', '940c0f26fd5a30775bb1cbd1f6840398d39bb813', 0, 'Julien', 'Triau', 'INFO', '2019');





