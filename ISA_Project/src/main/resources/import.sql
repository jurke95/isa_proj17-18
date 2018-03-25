INSERT INTO `peca`.`cinema` (`id`, `location`, `name`) VALUES ('1', 'Novi Sad', 'Arena');
INSERT INTO `peca`.`cinema` (`id`, `location`, `name`) VALUES ('2', 'Beograd', 'Zvezdara');
INSERT INTO `peca`.`cinema` (`id`, `location`, `name`) VALUES ('3', 'Nis', 'Cair');
INSERT INTO peca.user (id,email, role, password,name, surname,city,phonenumber, active, confirmationToken) VALUES (1,"jurke@gmail.com","admin", "si","d","n","ns","broj",1, "43");
INSERT INTO `peca`.`user` (`id`,`email`, `role`, `password`,`name`, `surname`, `city`,`phonenumber`, `active`, `confirmationToken`) VALUES ('2','nicic@gmail.com', 'admin', 'si','m','j','ns','broj', 0, '34');
INSERT INTO `peca`.`user` (`id`,`email`, `role`, `password`,`name`, `surname`, `city`,`phonenumber`, `active`, `confirmationToken`) VALUES ('3','stefan@gmail.com', 'admin', 'si','s','s','ns','broj',1, '45');
INSERT INTO `peca`.`theatre` (`id`, `location`, `name`) VALUES ('1', 'Novi Sad', 'SNP');
INSERT INTO `peca`.`theatre` (`id`, `location`, `name`) VALUES ('2', 'Beograd', 'P.Mladih');
INSERT INTO `peca`.`theatre` (`id`, `location`, `name`) VALUES ('3', 'Nis', 'pozoristeNis');
INSERT INTO `peca`.`ad` (`id`, `name`, `description`,`date`, `image`,`user_id`) VALUES ('1', 'patike', 'prodajemPatike',NULL, 'slikapatika', '1');
INSERT INTO `peca`.`ad` (`id`, `name`, `description`,`date`, `image`,`user_id`) VALUES ('2', 'cipele', 'prodajemCipele',NULL, 'slikapatika', '1');
INSERT INTO `peca`.`ad` (`id`, `name`, `description`,`date`, `image`,`user_id`) VALUES ('3', 'kisobran', 'prodajemKisobran',NULL, 'slikapatika', '2');
INSERT INTO `peca`.`ad` (`id`, `name`, `description`,`date`, `image`,`user_id`) VALUES ('4', 'casa', 'prodajemCasu',NULL, 'slikapatika', '3');
INSERT INTO `peca`.`product` (`id`, `name`, `description`,`image`, `boxoffice`) VALUES ('1', 'dzemper', 'plaviDzemper','slikadzempera','srpskonarodno');
INSERT INTO `peca`.`product` (`id`, `name`, `description`,`image`, `boxoffice`) VALUES ('2', 'olovka', 'opisolovka','slikaolovka','p.mladih');
INSERT INTO `peca`.`product` (`id`, `name`, `description`,`image`, `boxoffice`) VALUES ('3', 'bicikl', 'biciklopis','slikbicikl','cair');
INSERT INTO `peca`.`offer` (`id`, `bid`, `ad_id`,`user_id`) VALUES ('1', '100','2','3');
INSERT INTO `peca`.`offer` (`id`, `bid`, `ad_id`,`user_id`) VALUES ('2', '50','2','1');
INSERT INTO `peca`.`offer` (`id`, `bid`, `ad_id`,`user_id`) VALUES ('3', '60','2','2');


