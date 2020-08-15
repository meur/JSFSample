DROP TABLE IF EXISTS world;

CREATE TABLE world (
   id 		BIGSERIAL 	PRIMARY KEY     NOT NULL,
   universe TEXT,
   helloed	BOOLEAN
);
