CREATE SEQUENCE hibernate_sequence;

CREATE TABLE adatbazis_verzio (
    id          BIGSERIAL   PRIMARY KEY,
    timestamp   TIMESTAMP,
    username    TEXT
);
