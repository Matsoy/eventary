-- #######################################################################
-- l'événement à lieu dans une école ou à une adresse donnée
-- #######################################################################
CREATE TRIGGER event_at_a_school_or_at_a_given_address
BEFORE INSERT ON EVENT
WHEN ((address IS NULL AND school_id) OR (address IS NOT NULL AND school_id))
BEGIN
    SELECT RAISE(ABORT,'event_at_a_school_or_at_a_given_addressERROR: (address and school_id are null) or (address and school_id are not null)');
END;
