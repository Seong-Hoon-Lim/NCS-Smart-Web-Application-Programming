CREATE TABLE ModUser (
 id		BIGINT		PRIMARY KEY AUTO_INCREMENT
,userId		VARCHAR(20)	NOT NULL
,passwd		VARCHAR(20)	NOT	NULL
,userName	VARCHAR(20)	NOT	NULL
,birthDate	DATE		NOT	NULL
,email		VARCHAR(50)	NOT	NULL
,regDate	TIMESTAMP	NOT	NULL	DEFAULT	CURRENT_TIMESTAMP
	
)AUTO_INCREMENT = 1001;
	
SELECT * from ModUser;