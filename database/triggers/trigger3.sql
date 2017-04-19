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
