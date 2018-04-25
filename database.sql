CREATE DATABASE `study` /*!40100 DEFAULT CHARACTER SET utf8 */

create table customer(
	id int primary key auto_increment,
	user_id VARCHAR(18) not null,
	user_name VARCHAR(200) not null,
	age int not null,
	vip TINYINT not null,
	address VARCHAR(1000)
);
INSERT INTO `study`.`customer` (`user_id`, `user_name`, `age`, `vip`, `address`) VALUES ('214134354657658776', '朱兵', '22', '1', '北京');
