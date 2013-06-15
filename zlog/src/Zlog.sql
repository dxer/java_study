drop database zlog;

create database zlog CHARACTER SET 'utf8' COLLATE 'utf8_general_ci';


CREATE TABLE `tb_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userName` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8;

insert into `tb_user` (userName, password, email) values ("haifeng", "haifeng","haifeng0730@126.com");