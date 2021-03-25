CREATE TABLE IF NOT EXISTS tb_user CASCADE;
CREATE TABLE tb_user (
  user_id int(20) NOT NULL AUTO_INCREMENT,
  kakao_id varchar(200) DEFAULT '',
  kakao_name varchar(200) DEFAULT '',
  kakao_photo_url varchar(512) DEFAULT '',
  point int(11) DEFAULT '0',
  access_token varchar(200) DEFAULT '',
  item varchar(200) DEFAULT '',
  play_hour int(11) DEFAULT '0',
  ranking int(11) DEFAULT '0',
  PRIMARY KEY (user_id)
);
