/*
 *  Created under not commercial project "Make it fine"
 *
 *  Copyright 2017-2021
 */

ALTER TABLE APP_USER
    DROP COLUMN STATE;

ALTER TABLE APP_USER
    ADD STATE ENUM ('ACTIVE', 'INACTIVE', 'DELETED', 'LOCKED');

UPDATE APP_USER
SET STATE = 'ACTIVE'
where ID = 1;

UPDATE APP_USER
SET STATE = 'ACTIVE'
where ID = 2;

UPDATE APP_USER
SET STATE = 'INACTIVE'
where ID = 3;

UPDATE APP_USER
SET STATE = 'LOCKED'
where ID = 4;

UPDATE APP_USER
SET STATE = 'INACTIVE'
where ID = 5;

UPDATE APP_USER
SET STATE = 'ACTIVE'
where ID = 6;

UPDATE APP_USER
SET STATE = 'ACTIVE'
where ID = 7;

UPDATE APP_USER
SET STATE = 'ACTIVE'
where ID = 8;
