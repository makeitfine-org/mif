----
--  Created under not commercial project "Make it fine"
--
--  Copyright 2017-2021
----

CREATE TABLE WORKER
(
    ID INT NOT NULL,
    PRIMARY KEY (ID),
    FOREIGN KEY (ID) REFERENCES CONTACT (ID)
);

CREATE TABLE CUSTOMER
(
    ID INT NOT NULL,
    PRIMARY KEY (ID),
    FOREIGN KEY (ID) REFERENCES CONTACT (ID)
);

INSERT INTO WORKER
VALUES (1);

INSERT INTO WORKER
VALUES (2);

INSERT INTO WORKER
VALUES (3);

INSERT INTO WORKER
VALUES (5);

INSERT INTO WORKER
VALUES (8);

INSERT INTO CUSTOMER
VALUES (4);

INSERT INTO CUSTOMER
VALUES (6);

INSERT INTO CUSTOMER
VALUES (7);
