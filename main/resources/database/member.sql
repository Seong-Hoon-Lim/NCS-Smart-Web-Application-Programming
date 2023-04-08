USE member;
SHOW TABLES;

DROP TABLE member;
CREATE TABLE member (
    `id` 		 VARCHAR(10)	NOT NULL,
    `password` 	 VARCHAR(10)	NOT NULL,
    `name`		 VARCHAR(10)    NOT NULL,
    `gender` 	 VARCHAR(4)	    NULL DEFAULT NULL,
    `birth`		 VARCHAR(10)	NULL DEFAULT NULL,
    `mail`		 VARCHAR(30)	NULL DEFAULT NULL,
    `phone`		 VARCHAR(20)	NULL DEFAULT NULL,
    `zipcode` 	 VARCHAR(5)     NULL DEFAULT NULL,
    `address01`  VARCHAR(100)   NULL DEFAULT NULL,
    `address02`  VARCHAR(100)   NULL DEFAULT NULL,
    `registDay` VARCHAR(50)    NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
);
SELECT * FROM member;

DROP TABLE `board`;
CREATE TABLE `board` (
    `num`   int NOT NULL AUTO_INCREMENT,
    `id`        VARCHAR(10) NOT NULL,
    `name`      VARCHAR(10) NOT NULL,
    `subject`   VARCHAR(100) NOT NULL,
    `content`   TEXT NOT NULL,
    `registDay` VARCHAR(30),
    `hit`       int,
    `ip`        VARCHAR(20),
    PRIMARY KEY (`num`)
) DEFAULT CHARSET=utf8;

SELECT * FROM `board`;