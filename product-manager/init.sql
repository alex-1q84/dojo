-- 物料基本信息
CREATE TABLE product(
prod_id INTEGER NOT NULL AUTO_INCREMENT,
prod_code VARCHAR(14) COMMENT '物料编号',
prod_name VARCHAR(64) COMMENT '物料名称',
spec_id INTEGER COMMENT '规格型号',
unit_type_id INTEGER COMMENT '计量单位',
base_type_id INTEGER COMMENT '基本类型',
minimum_amount INTEGER COMMENT '最低采购量',
remark VARCHAR(256) COMMENT '备注',
oper_id	INTEGER COMMENT '操作员',
state	TINYINT(2) COMMENT '状态',
create_date DATETIME,
update_date DATETIME,

PRIMARY KEY(prod_id)
)ENGINE=INNODB DEFAULT CHARSET=UTF8;

-- 物料申请
CREATE TABLE prod_ord(
ord_id INTEGER NOT NULL AUTO_INCREMENT,
sheet_code VARCHAR(14) COMMENT '单据编号',
station_id	INTEGER COMMENT '申请站点',
oper_id	INTEGER COMMENT '申请人ID',
oper_name VARCHAR(64) COMMENT '申请人名称',
auth_id	INTEGER COMMENT '审核人ID',
money INTEGER COMMENT '总金额',
rep_id	INTEGER COMMENT '仓库',
state	TINYINT(2) COMMENT '状态',
remark VARCHAR(256) COMMENT '申请事由',
create_date DATETIME COMMENT '申请时间',
auth_date DATETIME COMMENT '审核时间',

PRIMARY KEY(ord_id)
)ENGINE=INNODB DEFAULT CHARSET=UTF8;

-- 物料面单关系
CREATE TABLE prod_ord_rel(
rel_id INTEGER NOT NULL AUTO_INCREMENT,
ord_id INTEGER COMMENT '申请ID',
sheet_code VARCHAR(14) COMMENT '单据编号',
prod_id	INTEGER COMMENT '物料ID',
unit_type_id INTEGER COMMENT '计量单位',
minimum_amount INTEGER COMMENT '最低采购量',
amount INTEGER COMMENT '采购量',
prod_price INTEGER COMMENT '物料价格',
money	INTEGER COMMENT '金额',
remark VARCHAR(256) COMMENT '备注',

PRIMARY KEY(rel_id)
)ENGINE=INNODB DEFAULT CHARSET=UTF8;