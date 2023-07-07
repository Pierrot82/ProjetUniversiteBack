-- Table matiere
INSERT INTO `final`.`matiere` (`nom`) VALUES ('Infomatique');
INSERT INTO `final`.`matiere` (`nom`) VALUES ('Marketing');

-- Table cours
INSERT INTO `final`.`cours` (`nom`) VALUES ('UML');
INSERT INTO `final`.`cours` (`nom`) VALUES ('BDD');
INSERT INTO `final`.`cours` (`nom`) VALUES ('HTML/CSS');
INSERT INTO `final`.`cours` (`nom`) VALUES ('Java EE');
INSERT INTO `final`.`cours` (`nom`) VALUES ('JavaScript');
INSERT INTO `final`.`cours` (`nom`) VALUES ('ORM Hibernate');
INSERT INTO `final`.`cours` (`nom`) VALUES ('Spring');
INSERT INTO `final`.`cours` (`nom`) VALUES ('Agile');
INSERT INTO `final`.`cours` (`nom`) VALUES ('GIT');
INSERT INTO `final`.`cours` (`nom`) VALUES ('Jenkins');
INSERT INTO `final`.`cours` (`nom`) VALUES ('Angular'); 
UPDATE `final`.`cours` SET `id_matiere` = '1' WHERE (`id_cours` = '1');
UPDATE `final`.`cours` SET `id_matiere` = '1' WHERE (`id_cours` = '2');
UPDATE `final`.`cours` SET `id_matiere` = '1' WHERE (`id_cours` = '3');
UPDATE `final`.`cours` SET `id_matiere` = '1' WHERE (`id_cours` = '4');
UPDATE `final`.`cours` SET `id_matiere` = '1' WHERE (`id_cours` = '5');
UPDATE `final`.`cours` SET `id_matiere` = '1' WHERE (`id_cours` = '6');
UPDATE `final`.`cours` SET `id_matiere` = '1' WHERE (`id_cours` = '7');
UPDATE `final`.`cours` SET `id_matiere` = '1' WHERE (`id_cours` = '8');
UPDATE `final`.`cours` SET `id_matiere` = '1' WHERE (`id_cours` = '9');
UPDATE `final`.`cours` SET `id_matiere` = '1' WHERE (`id_cours` = '10');
UPDATE `final`.`cours` SET `id_matiere` = '1' WHERE (`id_cours` = '11');

-- Table personne
INSERT INTO final.personne (date_naissance, nom, prenom) VALUES
('1985-03-12', 'Dupont', 'Jean'),
('1992-08-25', 'Martin', 'Sophie'),
('1978-11-05', 'Lefebvre', 'Thomas'),
('1990-02-15', 'Dubois', 'Laura'),
('1982-06-29', 'Thomas', 'Julie'),
('1975-09-18', 'Robert', 'Pierre'),
('1996-12-03', 'Richard', 'Emma'),
('1989-04-21', 'Petit', 'Lucas'),
('1987-07-14', 'Durand', 'Manon'),
('1993-10-08', 'Leroy', 'Alexandre'),
('1980-01-31', 'Moreau', 'Camille'),
('1973-04-26', 'Simon', 'Charlotte'),
('1998-07-09', 'Michel', 'Antoine'),
('1984-10-17', 'Lefevre', 'Catherine'),
('1991-03-02', 'Garcia', 'Nicolas'),
('1977-06-15', 'Roux', 'Amélie'),
('1995-09-28', 'Fournier', 'Étienne'),
('1986-02-10', 'Girard', 'Mathilde'),
('1979-05-23', 'Caron', 'Valentin'),
('1997-08-07', 'André', 'Éléonore');

-- Table etudiant
INSERT INTO `final`.`etudiant` (`date_inscription`, `id`) VALUES ('2023-09-09', '2');
INSERT INTO `final`.`etudiant` (`date_inscription`, `id`) VALUES ('2022-09-09', '4');
INSERT INTO `final`.`etudiant` (`date_inscription`, `id`) VALUES ('2022-09-09', '7');
INSERT INTO `final`.`etudiant` (`date_inscription`, `id`) VALUES ('2017-09-09', '10');
INSERT INTO `final`.`etudiant` (`date_inscription`, `id`) VALUES ('2016-09-09', '13');
INSERT INTO `final`.`etudiant` (`date_inscription`, `id`) VALUES ('2018-09-09', '15');
INSERT INTO `final`.`etudiant` (`date_inscription`, `id`) VALUES ('2019-09-09', '17');
INSERT INTO `final`.`etudiant` (`date_inscription`, `id`) VALUES ('2020-09-09', '20');

-- Table enseignant
INSERT INTO `final`.`enseignant` (`date_embauche`, `id`, `matiere_id_matiere`) VALUES ('2009-01-01', '1', '1');
INSERT INTO `final`.`enseignant` (`date_embauche`, `id`, `matiere_id_matiere`) VALUES ('2010-01-01', '3', '1');
INSERT INTO `final`.`enseignant` (`date_embauche`, `id`, `matiere_id_matiere`) VALUES ('2011-01-01', '5', '1');
INSERT INTO `final`.`enseignant` (`date_embauche`, `id`, `matiere_id_matiere`) VALUES ('2012-01-01', '6', '1');
INSERT INTO `final`.`enseignant` (`date_embauche`, `id`, `matiere_id_matiere`) VALUES ('2013-01-01', '8', '1');
INSERT INTO `final`.`enseignant` (`date_embauche`, `id`, `matiere_id_matiere`) VALUES ('2008-01-01', '9', '1');
INSERT INTO `final`.`enseignant` (`date_embauche`, `id`, `matiere_id_matiere`) VALUES ('2007-01-01', '11', '1');
INSERT INTO `final`.`enseignant` (`date_embauche`, `id`, `matiere_id_matiere`) VALUES ('2014-01-01', '12', '1');
INSERT INTO `final`.`enseignant` (`date_embauche`, `id`, `matiere_id_matiere`) VALUES ('2015-01-01', '14', '1');
INSERT INTO `final`.`enseignant` (`date_embauche`, `id`, `matiere_id_matiere`) VALUES ('2016-01-01', '16', '1');
INSERT INTO `final`.`enseignant` (`date_embauche`, `id`, `matiere_id_matiere`) VALUES ('2017-01-01', '18', '1');
INSERT INTO `final`.`enseignant` (`date_embauche`, `id`, `matiere_id_matiere`) VALUES ('2018-01-01', '19', '1');

-- Table correction
INSERT INTO `final`.`correction` (`id_correction`) VALUES ('1');
INSERT INTO `final`.`correction` (`id_correction`) VALUES ('2');
INSERT INTO `final`.`correction` (`id_correction`) VALUES ('3');

-- Table examen
INSERT INTO `final`.`examen` (`coef`, `date`, `duree`, `id_correction`, `id_matiere`, `intitule`) VALUES ('1', '2023-07-18', '2', '1', '1', 'Exam1');
INSERT INTO `final`.`examen` (`coef`, `date`, `duree`, `id_correction`, `id_matiere`, `intitule`) VALUES ('2', '2023-07-12', '4', '2', '1', 'Exam2');

-- Table formation 
INSERT INTO `final`.`formation` (`niveau_etude`, `diplome`, `intitule`, `description`) VALUES ('3', 'Licence', 'Licence Informatique', 'blablabla');
INSERT INTO `final`.`formation` (`niveau_etude`, `diplome`, `intitule`, `description`) VALUES ('5', 'Master', 'Master Informatique', 'blablabla');

-- Table copie
INSERT INTO `final`.`copie` (`id`, `id_examen`, `note`) VALUES ('2', '1', '17');
INSERT INTO `final`.`copie` (`id`, `id_examen`, `note`) VALUES ('4', '2', '13');















