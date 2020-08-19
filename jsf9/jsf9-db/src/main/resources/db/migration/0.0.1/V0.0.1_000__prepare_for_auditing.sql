CREATE SEQUENCE hibernate_sequence;

CREATE TABLE adatbazis_verzio (
    id          BIGSERIAL   PRIMARY KEY     NOT NULL,
    timestamp   TIMESTAMP,
    username    TEXT
);
