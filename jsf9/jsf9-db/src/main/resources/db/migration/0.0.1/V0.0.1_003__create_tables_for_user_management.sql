DROP TABLE IF EXISTS v_j_felhasznalo_szerepkor;
DROP TABLE IF EXISTS j_felhasznalo_szerepkor;
DROP TABLE IF EXISTS v_szerepkor;
DROP TABLE IF EXISTS szerepkor;
DROP TABLE IF EXISTS v_felhasznalo;
DROP TABLE IF EXISTS felhasznalo;

CREATE TABLE felhasznalo (
    id 		    BIGSERIAL 	PRIMARY KEY,
    username    TEXT        UNIQUE      NOT NULL,
    password	TEXT
);

CREATE TABLE v_felhasznalo (
    verzio      BIGINT,
    muvelet     SMALLINT,
    id 		    BIGINT,
    username    TEXT,
    password	TEXT,
    CONSTRAINT fk_v_felhasznalo FOREIGN KEY (verzio) REFERENCES adatbazis_verzio (id),
    CONSTRAINT pk_v_felhasznalo PRIMARY KEY (id, verzio)
);

CREATE TABLE szerepkor (
    id 		    BIGSERIAL 	PRIMARY KEY,
    megnevezes  TEXT        UNIQUE      NOT NULL
);

CREATE TABLE v_szerepkor (
    verzio      BIGINT,
    muvelet     SMALLINT,
    id 		    BIGINT,
    megnevezes  TEXT,
    CONSTRAINT fk_v_szerepkor FOREIGN KEY (verzio) REFERENCES adatbazis_verzio (id),
    CONSTRAINT pk_v_szerepkor PRIMARY KEY (id, verzio)
);

CREATE TABLE j_felhasznalo_szerepkor (
    id_felhasznalo   BIGINT,
    id_szerepkor     BIGINT,
    CONSTRAINT pk_j_felhasznalo_szerepkor PRIMARY KEY (id_felhasznalo, id_szerepkor),
    CONSTRAINT fk_j_felhasznalo_szerepkor_f FOREIGN KEY (id_felhasznalo) REFERENCES felhasznalo (id),
    CONSTRAINT fk_j_felhasznalo_szerepkor_s FOREIGN KEY (id_szerepkor) REFERENCES szerepkor (id)
);

CREATE TABLE v_j_felhasznalo_szerepkor (
    verzio          BIGINT,
    muvelet         SMALLINT,
    id_felhasznalo  BIGINT,
    id_szerepkor    BIGINT,
    CONSTRAINT fk_v_j_felhasznalo_szerepkor FOREIGN KEY (verzio) REFERENCES adatbazis_verzio (id),
    CONSTRAINT pk_v_j_felhasznalo_szerepkor PRIMARY KEY (id_felhasznalo, id_szerepkor, verzio)
);

INSERT INTO szerepkor (megnevezes) VALUES ('basic_user');
INSERT INTO felhasznalo (username, password) VALUES ('user', '7hHLsZBS5AsHqsDKBgwj7g=='); --password is also 'user'
INSERT INTO j_felhasznalo_szerepkor (id_felhasznalo, id_szerepkor) VALUES (
    (SELECT id FROM felhasznalo WHERE username = 'user'),
    (SELECT id FROM szerepkor WHERE megnevezes = 'basic_user')
);
