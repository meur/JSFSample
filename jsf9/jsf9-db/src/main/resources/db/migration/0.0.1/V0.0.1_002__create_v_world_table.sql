DROP TABLE IF EXISTS v_world;

CREATE TABLE v_world (
    verzio      BIGINT,
    muvelet     SMALLINT,
    id 		    BIGINT,
    universe    TEXT,
    helloed	    BOOLEAN,
    CONSTRAINT fk_v_world_verzio FOREIGN KEY (verzio) REFERENCES adatbazis_verzio (id),
    CONSTRAINT pk_v_world PRIMARY KEY (id, verzio)
);
