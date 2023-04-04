USE member;
SHOW TABLES;
DROP TABLE `member`;
CREATE TABLE `member` (
    `id` 		VARCHAR(10)	NOT NULL,
    `password` 	VARCHAR(10)	NOT NULL,
    `name`		VARCHAR(10) NOT NULL,
    `gender` 	VARCHAR(4)	NULL DEFAULT NULL,
    `birth`		VARCHAR(10)	NULL DEFAULT NULL,
    `mail`		VARCHAR(30)	NULL DEFAULT NULL,
    `phone`		VARCHAR(20)	NULL DEFAULT NULL,
    `address` 	VARCHAR(90) NULL DEFAULT NULL,
    `regist_day` VARCHAR(50) NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
);
INSERT INTO `member` (`id`, `password`, `name`, `gender`, `birth`, `mail`, `phone`, `address`) VALUES ('spring', '1111', '가길동', '남', '19880121', 'spring@gmail.com', '01023234411', '대구시 중구');
SELECT * FROM `member`;