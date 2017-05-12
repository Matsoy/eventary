--delete from event;
PRAGMA encoding="UTF-8";
INSERT INTO EVENT (title, descr, startDate, endDate, maxNbParticipant, organizer, room_id) --dans Ireste
VALUES ('Premier evenement!', 'Ceci est une courte description de ce premier evenement. Voila, rien de plus', datetime('2017-05-12 10:30:00'), datetime('2017-05-14 16:15:00'), 4, 'E168011W', 31);

INSERT INTO EVENT (title, descr, startDate, endDate, maxNbParticipant, organizer, room_id) --dans Isitem
VALUES ('2eme evenement!', 'Ceci est une courte description de ce 2nd evenement. Snif', datetime('2017-05-13 11:45:00'), datetime('2017-06-03 16:15:00'), 12, 'E147093J', 82);

INSERT INTO EVENT (title, descr, startDate, endDate, maxNbParticipant, organizer, address) --à une adresse extérieure à une école
VALUES ('3eme evenement!', 'Ceci est une courte description de ce 3eme evenement. Passe ton chemin maintenant', datetime('2017-06-12 22:30:00'), datetime('2017-06-13 03:00:00'), 100, 'E148834B', '19 Rue Léon Blum, 44000 Nantes');

INSERT INTO EVENT (title, descr, startDate, endDate, maxNbParticipant, organizer, address) --à une adresse extérieure à une école
VALUES ('4eme evenement!', 'Ceci est une courte description de ce 3eme evenement. Jamais 3 sans 4!', datetime('2017-05-12 21:30:00'), datetime('2017-05-13 00:30:00'), 25, 'E167998G', '4 Rue Lebrun, 44000 Nantes');


--TRIGGER ERROR: creatDate > startDate
--
--INSERT INTO EVENT (title, descr, startDate, endDate, maxNbParticipant, organizer, address) --à une adresse extérieure à une école
--VALUES ('4eme evenement!', 'Ceci est une courte description de ce 3eme evenement. Jamais 3 sans 4!', datetime('2016-05-12 21:30:00'), datetime('2017-05-13 00:30:00'), 25, 'E167998G', '4 Rue Lebrun, 44000 Nantes');


--TRIGGER ERROR: startDate > endDate
--
--INSERT INTO EVENT (title, descr, startDate, endDate, maxNbParticipant, organizer, address) --à une adresse extérieure à une école
--VALUES ('4eme evenement!', 'Ceci est une courte description de ce 3eme evenement. Jamais 3 sans 4!', datetime('2017-05-12 21:30:00'), datetime('2017-05-11 00:30:00'), 25, 'E167998G', '4 Rue Lebrun, 44000 Nantes');
