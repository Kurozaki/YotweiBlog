CREATE database weiblog;

use weiblog;


CREATE TABLE wb_tags (
  id INT NOT NULL KEY auto_increment,
  name VARCHAR (12) NOT NULL
) ENGINE=InnoDB, DEFAULT charset=utf8;


CREATE TABLE wb_article (
  id INT NOT NULL KEY auto_increment,
  title VARCHAR (32) NOT NULL,
  intro VARCHAR (256) NOT NULL,
  content text NOT NULL,
  create_time BIGINT DEFAULT 0,
  article_type TINYINT DEFAULT 0 COMMENT '原创/转载',
  read_count INT DEFAULT 0,
  comment_floor_count INT DEFAULT 0
) ENGINE=InnoDB auto_increment=1000, DEFAULT charset=utf8;


CREATE TABLE wb_guest_msg(
  id INT NOT NULL KEY auto_increment,
  guest_type TINYINT DEFAULT 0,
  guest_id BIGINT NOT NULL,
  content text NOT NULL,
  reply_id INT DEFAULT 0,
  create_time BIGINT DEFAULT 0
) ENGINE=InnoDB, DEFAULT charset=utf8;


CREATE TABLE wb_admin(
  id INT NOT NULL KEY auto_increment,
  account VARCHAR (12) NOT NULL,
  password CHAR (32) NOT NULL,
  nickname VARCHAR (16) NOT NULL
) ENGINE=InnoDB, DEFAULT charset=utf8;

/* 多对多的关系连接表 */

CREATE TABLE rel_article_tag (
  article_id INT NOT NULL,
  tag_id INT NOT NULL,
  PRIMARY KEY (article_id, tag_id)
) ENGINE=InnoDB, DEFAULT charset=utf8;


/* 插入数据 */
insert into wb_tags (name) values ('Java');
insert into wb_tags (name) values ('HTTP');
insert into wb_tags (name) values ('算法');
insert into wb_tags (name) values ('密码学');

insert into rel_article_tag (article_id, tag_id) values (1000, 1000);
insert into rel_article_tag (article_id, tag_id) values (1000, 1002);
insert into rel_article_tag (article_id, tag_id) values (1001, 1000);

insert into wb_admin (id, account, password, nickname) values (NULL ,'yotwei', md5('kurozaki'), 'Yotwei');