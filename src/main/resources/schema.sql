DROP TABLE IF EXISTS T_SHORTEN_URL;
CREATE TABLE T_SHORTEN_URL (
                             SEQ int generated by default as identity primary key,
                             ORIGINAL_URL VARCHAR2(500),
                             SHORTEN_URL VARCHAR2(500),
                             COUNT int
);

insert into T_SHORTEN_URL (SEQ, ORIGINAL_URL, SHORTEN_URL, COUNT) values (100000, 'dummy', 'dummy', 1);