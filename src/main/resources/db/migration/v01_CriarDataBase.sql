CREATE TABLE  article  (
   id  bigint(20) NOT NULL AUTO_INCREMENT,
   title  varchar(255) DEFAULT NULL,
   made_date  datetime DEFAULT NULL,
   aproved  bit(1) DEFAULT NULL,
   text  varchar(255) DEFAULT NULL,
   author  varchar(50) DEFAULT NULL,
   updated datetime DEFAULT NULL,
  PRIMARY KEY ( id )
) ENGINE=InnoDB DEFAULT CHARSET=utf8

