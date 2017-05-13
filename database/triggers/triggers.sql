DROP TRIGGER startDate_after_creatDate;
DROP TRIGGER event_at_a_school_or_at_a_given_address;
DROP TRIGGER creatDate_is_current_date;
DROP TRIGGER modifDate_is_current_date;
DROP TRIGGER waiting_date_is_current_date;
DROP TRIGGER endDate_after_startDate;

-- #######################################################################
-- avant insertion d'un evenement:: check que l'evenement a lieu dans une ecole où a une adresse donnee
-- #######################################################################
CREATE TRIGGER event_at_a_school_or_at_a_given_address
BEFORE INSERT ON EVENT
WHEN ((NEW.address IS NULL AND NEW.room_id IS NULL) OR (NEW.address AND NEW.room_id))
BEGIN
    SELECT RAISE(ABORT,'TRIGGER ERROR: (address and room_id are null) or (address and room_id are not null)');
END;

-- #######################################################################
-- apres insertion d'un evenement: la date de creation de l'evenementt = la date actuelle de la forme 'YYYY-MM-DD HH:MM:SS'
-- #######################################################################
CREATE TRIGGER creatDate_is_current_date
AFTER INSERT ON EVENT
BEGIN
    UPDATE EVENT
    SET creatDate = datetime('NOW')
    WHERE id = NEW.id;
END;

-- #######################################################################
-- apres MAJ d'un evenement:: check que sa date de debut est apres sa date de creation
-- #######################################################################
CREATE TRIGGER startDate_after_creatDate
AFTER UPDATE ON EVENT
WHEN ( strftime('%s', NEW.creatDate) > strftime('%s',  NEW.startDate) )
BEGIN
    SELECT RAISE(ABORT, 'TRIGGER ERROR: creatDate > startDate');
END;

-- #######################################################################
-- apres MAJ d'un evenement:: check que sa date de fin est apres sa date de debut
-- #######################################################################
CREATE TRIGGER endDate_after_startDate
AFTER UPDATE ON EVENT
WHEN ( strftime('%s', NEW.startDate) > strftime('%s',  NEW.endDate) )
BEGIN
    SELECT RAISE(ABORT, 'TRIGGER ERROR: startDate > endDate');
END;

-- #######################################################################
-- apres MAJ d'un événement: sauvegarde de la date courante de la forme 'YYYY-MM-DD HH:MM:SS'
-- #######################################################################
CREATE TRIGGER modifDate_is_current_date
AFTER UPDATE ON EVENT
BEGIN
    UPDATE EVENT
    SET modifDate = datetime('NOW')
    WHERE id = NEW.id;
END;

-- #######################################################################
-- apres insertion sur liste d'attente: la date de rentree dans une liste d'attente = la date actuelle de la forme 'YYYY-MM-DD HH:MM:SS'
-- #######################################################################
CREATE TRIGGER waiting_date_is_current_date
AFTER INSERT ON EVENT
BEGIN
    UPDATE WAITING
    SET waiting_date = datetime('NOW')
    WHERE id = NEW.id;
END;
