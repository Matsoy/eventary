DROP TRIGGER startDate_after_creatDate;
DROP TRIGGER event_at_a_school_or_at_a_given_address;
DROP TRIGGER creaDate_is_current_date;
DROP TRIGGER waiting_date_is_current_date;


-- #######################################################################
-- la date de début de l'événemet est après la date de création
-- #######################################################################
CREATE TRIGGER startDate_after_creatDate
AFTER UPDATE ON EVENT
FOR EACH ROW
BEGIN
    SELECT CASE
    WHEN ((SELECT EVENT.id FROM EVENT WHERE (strftime('%s', creaDate) > strftime('%s', startDate))) IS NOT NULL)
        THEN RAISE(ABORT, 'startDate_after_creatDateERROR: new.creatDate > new.startDate')
    END;
END;


-- #######################################################################
-- l'événement à lieu dans une école ou à une adresse donnée
-- #######################################################################
CREATE TRIGGER event_at_a_school_or_at_a_given_address
BEFORE INSERT ON EVENT
WHEN ((address IS NULL AND school_id) OR (address IS NOT NULL AND school_id))
BEGIN
    SELECT RAISE(ABORT,'event_at_a_school_or_at_a_given_addressERROR: (address and school_id are null) or (address and school_id are not null)');
END;


-- #######################################################################
-- la date de création de l'événement = la date actuelle de la forme 'YYYY-MM-DD HH:MM:SS'
-- #######################################################################
CREATE TRIGGER creaDate_is_current_date
BEFORE INSERT ON EVENT
WHEN (creaDate IS NULL)
BEGIN
    UPDATE EVENT
    SET creaDate = now()
    WHERE id = NEW.id;
END;

-- #######################################################################
-- la date de rentr�e dans une liste d'attente = la date actuelle de la forme 'YYYY-MM-DD HH:MM:SS'
-- #######################################################################
CREATE TRIGGER waiting_date_is_current_date
BEFORE INSERT ON WAITING
WHEN (waiting_date IS NULL)
BEGIN
    UPDATE WAITING
    SET waiting_date = now()
    WHERE id = NEW.id;
END;
