
CREATE TABLE `user` (                       -- 创建用户信息表，用于权限管理
  `id` int(10) NOT NULL AUTO_INCREMENT,     -- 自增长id
  `name` varchar(50) NOT NULL,              -- 姓名
  `gender` varchar(5) NOT NULL,             -- 性别
  `city` varchar(50) DEFAULT NULL,          -- 城市
  `tel` varchar(20) DEFAULT NULL,           -- 电话
  `address` varchar(200) DEFAULT NULL,      -- 地址
  `username` varchar(32) NOT NULL,          -- 用户名用于登录
  `password` varchar(32) NOT NULL,          -- 密码用于登录
  PRIMARY KEY (`id`)
)
insert into `user` (`id`, `name`, `gender`, `city`, `tel`, `address`, `username`, `password`) values('1','管理员','男','上海',NULL,NULL,'admin','B8D47765B3464F51F43F4D975DAC9339');

CREATE TABLE `module` (						-- 创建模块表
  `id` INT(10) NOT NULL AUTO_INCREMENT,				-- 自增字段
  `type` VARCHAR(50) NOT NULL,					-- 模块型号
  `size` VARCHAR(50),						-- 模块尺寸
  `unit` VARCHAR(10),						-- 模块单位
  PRIMARY KEY (`id`)						-- 以自增字段为主键
)
-- 初始化模块表信息
INSERT INTO `module` (`id`, `type`, `size`, `unit`) VALUES('1','UGC-16-3045B','30x45','个');
INSERT INTO `module` (`id`, `type`, `size`, `unit`) VALUES('2','UGC-16-4818','48x18','个');


CREATE TABLE `modfunction` (					-- 创建模块功能表
  `id` INT(10) NOT NULL AUTO_INCREMENT,				-- 自增主键
  `name` VARCHAR(150) NOT NULL,					-- 功能名称
  `description` VARCHAR(600),					-- 功能描述
  `priority` INT(10) NOT NULL,					-- 优先级别
  `module_id` INT(10) NOT NULL,					-- 对应模块信息
  `prepass` DOUBLE(5,4) NOT NULL DEFAULT '0.0000',		-- 预计合格率
  PRIMARY KEY (`id`)	,
  KEY `module_id` (`module_id`),
  CONSTRAINT `modfunction_module_fk` FOREIGN KEY (`module_id`) REFERENCES `module` (`id`) ON DELETE CASCADE ON UPDATE CASCADE					
)

-- 初始化模块功能库信息
INSERT INTO `modfunction` (`id`, `name`, `description`, `priority`, `module_id`, `prepass`) VALUES('1','Initial','初始状态','0','1','1');
INSERT INTO `modfunction` (`id`, `name`, `description`, `priority`, `module_id`, `prepass`) VALUES('2','FTL1','上下28-30cm,左右17-25cm','1','1','0.7');
INSERT INTO `modfunction` (`id`, `name`, `description`, `priority`, `module_id`, `prepass`) VALUES('3','BCL1','上下19-28cm,左右19-28cm','1','1','0.6');
INSERT INTO `modfunction` (`id`, `name`, `description`, `priority`, `module_id`, `prepass`) VALUES('4','LBL2','左右17-25cm','2','1','0.7');
INSERT INTO `modfunction` (`id`, `name`, `description`, `priority`, `module_id`, `prepass`) VALUES('5','TBL3','上下15-20cm,左右15-20cm','3','1','0.76');
INSERT INTO `modfunction` (`id`, `name`, `description`, `priority`, `module_id`, `prepass`) VALUES('6','TKL4','15-20cm','4','1','0.78');
INSERT INTO `modfunction` (`id`, `name`, `description`, `priority`, `module_id`, `prepass`) VALUES('7','GLL5','上下12-20cm','5','1','0.75');
INSERT INTO `modfunction` (`id`, `name`, `description`, `priority`, `module_id`, `prepass`) VALUES('8','Initial','初始状态','0','2','1');


CREATE TABLE `modstore` (					-- 创建模块库存表
  `id` INT(10) NOT NULL AUTO_INCREMENT,				-- 自增主键
  `function_id` INT(10) NOT NULL,				-- 对应模块功能，这里是指测试过相关功能，并返库
  `quantity` INT(10) NOT NULL DEFAULT '0',			-- 返库数量
  `updated` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `function_id` (`function_id`),
  CONSTRAINT `modstore_function_fk` FOREIGN KEY (`function_id`) REFERENCES `modfunction` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
)


CREATE TABLE `customer` (					-- 创建客户表
  `id` INT(10) NOT NULL AUTO_INCREMENT,				-- 自增id
  `name` VARCHAR(50) NOT NULL,					-- 客户名称
  `description` VARCHAR(2000),					-- 客户详情
  `contact` VARCHAR(50),					-- 客户联系人
  `tel` VARCHAR(50),						-- 客户联系电话
  `address` VARCHAR(200),					-- 客户地址
  PRIMARY KEY (`id`)
)
-- 初始化客户信息
INSERT INTO `customer` (`id`, `name`, `description`, `contact`, `tel`, `address`) VALUES('1','方太',NULL,NULL,NULL,NULL);
INSERT INTO `customer` (`id`, `name`, `description`, `contact`, `tel`, `address`) VALUES('2','板川',NULL,NULL,NULL,NULL);
INSERT INTO `customer` (`id`, `name`, `description`, `contact`, `tel`, `address`) VALUES('3','老板',NULL,NULL,NULL,NULL);
INSERT INTO `customer` (`id`, `name`, `description`, `contact`, `tel`, `address`) VALUES('4','拓邦',NULL,NULL,NULL,NULL);
INSERT INTO `customer` (`id`, `name`, `description`, `contact`, `tel`, `address`) VALUES('5','通快',NULL,NULL,NULL,NULL);
INSERT INTO `customer` (`id`, `name`, `description`, `contact`, `tel`, `address`) VALUES('6','格力',NULL,NULL,NULL,NULL);


CREATE TABLE `cusmodfunction` (					-- 创建客户和需要功能的关系表
  `id` INT(10) NOT NULL AUTO_INCREMENT,
  `customer_id` INT(10) NOT NULL,
  `function_id` INT(10) NOT NULL,
  PRIMARY KEY (`id`,`customer_id`,`function_id`),
  KEY `customer_id` (`customer_id`),
  KEY `function_id` (`function_id`),
  CONSTRAINT `cusmodfunction_cus_fk` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `cusmodfunction_fun_fk` FOREIGN KEY (`function_id`) REFERENCES `modfunction` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
)
-- 初始化客户模块功能对应信息
INSERT INTO `cusmodfunction` (`id`, `customer_id`, `function_id`) VALUES('1','1','2');
INSERT INTO `cusmodfunction` (`id`, `customer_id`, `function_id`) VALUES('2','2','3');
INSERT INTO `cusmodfunction` (`id`, `customer_id`, `function_id`) VALUES('3','3','4');
INSERT INTO `cusmodfunction` (`id`, `customer_id`, `function_id`) VALUES('4','4','5');
INSERT INTO `cusmodfunction` (`id`, `customer_id`, `function_id`) VALUES('5','5','6');
INSERT INTO `cusmodfunction` (`id`, `customer_id`, `function_id`) VALUES('6','6','7');

