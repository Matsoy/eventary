PRAGMA encoding="UTF-8";
INSERT INTO EVENT (title, descr, startDate, endDate, maxNbParticipant, organizer, orga_id, room_id) --dans Ireste, cree par E168011W membre de l'association du BDD, mais simple membre
VALUES ('Premier evenement!', 'Ceci est une courte description de ce premier evenement. Voila, rien de plus', datetime('2017-06-19 10:30:00'), datetime('2017-06-20 16:15:00'), 4, 'E168011W', 1, 31);

INSERT INTO EVENT (title, descr, startDate, endDate, maxNbParticipant, organizer, orga_id, room_id) --dans Isitem, cree par E164558G du departement ETN et qui en est le responsable
VALUES ('2eme evenement!', 'Ceci est une courte description de ce 2nd evenement. Snif', datetime('2017-06-19 11:45:00'), datetime('2017-06-22 16:15:00'), 12, 'E164558G', 6, 82);

INSERT INTO EVENT (title, descr, startDate, endDate, maxNbParticipant, organizer, address) --� une adresse ext�rieure � une �cole, cree par un utilisateur simple E148834B
VALUES ('3eme evenement!', 'Ceci est une courte description de ce 3eme evenement. Passe ton chemin maintenant', datetime('2017-06-22 22:30:00'), datetime('2017-06-23 03:00:00'), 100, 'E148834B', '19 Rue L�on Blum, 44000 Nantes');

INSERT INTO EVENT (title, descr, startDate, endDate, maxNbParticipant, organizer, address) --� une adresse ext�rieure � une �cole, cree par un utilisateur simple E167998G
VALUES ('4eme evenement!', 'Ceci est une courte description de ce 3eme evenement. Jamais 3 sans 4!', datetime('2017-06-23 21:30:00'), datetime('2017-06-24 00:30:00'), 5, 'E167998G', '4 Rue Lebrun, 44000 Nantes');


--TRIGGER ERROR: creatDate > startDate
--
--INSERT INTO EVENT (title, descr, startDate, endDate, maxNbParticipant, organizer, address) --� une adresse ext�rieure � une �cole
--VALUES ('4eme evenement!', 'Ceci est une courte description de ce 3eme evenement. Jamais 3 sans 4!', datetime('2016-05-12 21:30:00'), datetime('2017-05-13 00:30:00'), 25, 'E167998G', '4 Rue Lebrun, 44000 Nantes');


--TRIGGER ERROR: startDate > endDate
--
--INSERT INTO EVENT (title, descr, startDate, endDate, maxNbParticipant, organizer, address) --� une adresse ext�rieure � une �cole
--VALUES ('4eme evenement!', 'Ceci est une courte description de ce 3eme evenement. Jamais 3 sans 4!', datetime('2017-05-12 21:30:00'), datetime('2017-05-11 00:30:00'), 25, 'E167998G', '4 Rue Lebrun, 44000 Nantes');
