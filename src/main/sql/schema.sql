-- 数据库创建脚本

-- 创建数据库
CREATE DATABASE seckill;
-- 使用数据库
USE seckill;

-- 创建秒杀库存表
CREATE TABLE seckill (
  `seckill_id`  BIGINT       NOT NULL AUTO_INCREMENT
  COMMENT '商品库存id',
  `name`        VARCHAR(120) NOT NULL
  COMMENT '商品名称',
  `number`      INT          NOT NULL
  COMMENT '库存量',
  `start_time`  TIMESTAMP    NOT NULL
  COMMENT '开始时间',
  `end_time`    TIMESTAMP    NOT NULL
  COMMENT '结束时间',
  `create_time` TIMESTAMP    NOT NULL DEFAULT current_timestamp
  COMMENT '创建时间',
  PRIMARY KEY (seckill_id),
  KEY idx_start_time(start_time),
  KEY idx_end_time(end_time),
  KEY idx_create_time(create_time)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1000
  DEFAULT CHARSET = utf8
  COMMENT = '秒杀库存表';

-- 初始化数据
INSERT INTO seckill (name, number, start_time, end_time)
VALUES
  ('1000元秒杀iphone6', 300, '2016-10-12 00:00:00', '2016-10-13 00:00:00'),
  ('700元秒杀ipad', 500, '2016-10-19 00:00:00', '2016-10-20 00:00:00'),
  ('500元秒杀小米', 700, '2016-10-13 00:00:00', '2016-10-14 00:00:00'),
  ('300元秒杀小米note', 1000, '2016-10-12 00:00:00', '2016-10-13 00:00:00');

-- 创建秒杀成功明细表
-- 用户登录认证相关信息
CREATE TABLE success_killed (
  `seckill_id`  BIGINT    NOT NULL
  COMMENT '秒杀商品id',
  `user_phone`  BIGINT    NOT NULL
  COMMENT '用户手机号',
  `state`       TINYINT   NOT NULL DEFAULT -1
  COMMENT '状态标示：-1：无效，0：成功，1：已付款，2：已发货',
  `create_time` TIMESTAMP NOT NULL DEFAULT current_timestamp
  COMMENT '创建时间',
  PRIMARY KEY (seckill_id, user_phone),
  KEY idx_create_time(create_time)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT = '秒杀成功明细表'