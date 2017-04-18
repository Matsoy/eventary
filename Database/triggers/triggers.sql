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

-- #######################################################################
-- l'événement à lieu dans une école ou à une adresse donnée
-- #######################################################################
CREATE TRIGGER event_at_a_school_or_at_a_given_address
BEFORE INSERT
   ON EVENT FOR EACH ROW
BEGIN
    IF new.address IS NULL AND new.school_id IS NULL THEN -- si il n'y a pas d'adresse NI d'école désignée
        SET msg = concat('event_at_a_school_or_at_a_given_addressERROR: address and school_id are null: ', cast(new.id AS CHAR));
        signal sqlstate '45001' SET message_text = msg;
    ELSE IF new.address IS NOT NULL AND new.school_id IS NOT NULL THEN -- si il y a une adresse ET une école désignée
        SET msg = concat('event_at_a_school_or_at_a_given_addressERROR: address and school_id are not null: ', cast(new.id AS CHAR));
        signal sqlstate '45002' SET message_text = msg;
    END IF;
END; //

DELIMITER ;


-- #######################################################################
-- la date de création de l'événement = la date actuelle de la forme 'YYYY-MM-DD HH:MM:SS'
-- #######################################################################
CREATE TRIGGER creaDate_is_current_date
BEFORE INSERT
   ON EVENT FOR EACH ROW
BEGIN
    IF new.creaDate IS NULL THEN
        SET new.creaDate = NOW();
    END IF;
END; //

DELIMITER ;
