-- #######################################################################
-- la date de rentrée dans une liste d'attente = la date actuelle de la forme 'YYYY-MM-DD HH:MM:SS'
-- #######################################################################
CREATE TRIGGER waiting_date_is_current_date
BEFORE INSERT ON WAITING
WHEN (waiting_date IS NULL)
BEGIN
    UPDATE WAITING
    SET waiting_date = now()
    WHERE id = NEW.id;
END;
