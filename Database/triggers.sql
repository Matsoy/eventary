DELIMITER // -- // = le délimiteur des différents triggers

-- #######################################################################
-- la date de début de l'événemet est après la date de création
-- #######################################################################
CREATE TRIGGER startDate_after_creatDate
BEFORE INSERT
   ON EVENT FOR EACH ROW
BEGIN
    IF (new.creatDate > new.startDate) THEN -- si la date de début est avant la date de création
        SET msg = concat('startDate_after_creatDateERROR: new.creatDate > new.startDate: ', cast(new.id AS CHAR));
        signal sqlstate '45000' SET message_text = msg;
    END IF;
END; //

DELIMITER ;
