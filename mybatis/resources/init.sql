CREATE TABLE USER(
id	INTEGER NOT NULL AUTO_INCREMENT,
`name`	VARCHAR(255),
email	VARCHAR(255),
`password`	VARCHAR(16)

PRIMARY KEY(id)
)ENGINE=INNODB DEFAULT CHARSET=UTF8;

CREATE TABLE ARTICLE(
id INTEGER NOT NULL AUTO_INCREMENT,
uid INTEGER,
title VARCHAR(255),
content TEXT,
create_date DATETIME,
update_date DATETIME,

PRIMARY KEY(id)
)ENGINE=INNODB DEFAULT CHARSET=UTF8;

CREATE TABLE ACTIVE(
id INTEGER NOT NULL AUTO_INCREMENT,
uid INTEGER,
description VARCHAR(512),
create_date DATETIME,

PRIMARY KEY(id)
)ENGINE=INNODB DEFAULT CHARSET=UTF8;