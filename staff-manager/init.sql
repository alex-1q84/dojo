CREATE DATABASE staffmanager;
GRANT ALL ON staffmanager.* TO hai;
USE staffmanager;

CREATE TABLE department(
id	INTEGER NOT NULL AUTO_INCREMENT,
`code`	VARCHAR(4) COMMENT '部门编号',
`name`	VARCHAR(128) COMMENT '部门名称',

PRIMARY KEY(id)
)ENGINE=INNODB DEFAULT CHARSET=UTF8;

CREATE TABLE staff(
id INTEGER NOT NULL AUTO_INCREMENT,
dept_id INTEGER COMMENT '所属部门',
station_id	INTEGER COMMENT '所属站点',
`code` VARCHAR(12) COMMENT '工号',
`name` VARCHAR(64),
phone	VARCHAR(15),
`password`	VARCHAR(16) COMMENT '把枪密码',
address	VARCHAR(255),
op_type	TINYINT COMMENT '操作员类型',
priv_barcode BOOL COMMENT '是否私有条码',
create_date DATETIME,
update_date DATETIME,

PRIMARY KEY(id)
)ENGINE=INNODB DEFAULT CHARSET=UTF8;
