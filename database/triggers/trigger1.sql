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
