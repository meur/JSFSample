DROP TABLE IF EXISTS v_world;

CREATE TABLE v_world (
    verzio      BIGSERIAL,
    muvelet     SMALLINT,
    id 		    BIGSERIAL,
    universe    TEXT,
    helloed	    BOOLEAN,
    CONSTRAINT fk_v_world_verzio FOREIGN KEY (verzio) REFERENCES adatbazis_verzio (id),
    CONSTRAINT pk_v_world PRIMARY KEY (id, verzio)
);
