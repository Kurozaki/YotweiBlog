CREATE TABLE wb_article_preview(
  id INT KEY AUTO_INCREMENT,
  title VARCHAR (30) NOT NULL UNIQUE,
  intro VARCHAR (200) NOT NULL,
  create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  article_type TINYINT DEFAULT 0,
  read_count INT DEFAULT 0
) charset=utf8, engine=innodb, auto_increment=1000;


CREATE TABLE wb_article_content(
  article_id INT KEY,
  content TEXTcrea
) charset=utf8, engine=innodb;

CREATE TABLE wb_tag(
  id INT KEY AUTO_INCREMENT,
  name CHAR (16)
) charset=utf8, engine=innodb, auto_increment=1000;

CREATE TABLE r_article_tag(
  article_id INT,
  tag_id INT,
  KEY (article_id, tag_id)
)  charset=utf8, engine=innodb;

CREATE TABLE wb_timeline(
  id INT KEY AUTO_INCREMENT,
  create_time DATE,
  content VARCHAR (1000),
  assoc_url VARCHAR (100)
)  charset=utf8, engine=innodb;
