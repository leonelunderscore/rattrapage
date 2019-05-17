-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: May 17, 2019 at 03:17 PM
-- Server version: 5.7.24
-- PHP Version: 7.3.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `rattrapage`
--

-- --------------------------------------------------------

--
-- Table structure for table `apprenants`
--

CREATE TABLE `apprenants` (
  `id_student` int(10) UNSIGNED NOT NULL,
  `nomApprenant` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `apprenants`
--

INSERT INTO `apprenants` (`id_student`, `nomApprenant`) VALUES
(1, 'Yann YONTA');

-- --------------------------------------------------------

--
-- Table structure for table `apprenants_cours`
--

CREATE TABLE `apprenants_cours` (
  `dateInscription` date NOT NULL,
  `dateFin` date NOT NULL,
  `dateDesInscription` date DEFAULT NULL,
  `noteFinale` int(11) DEFAULT '0',
  `lessonId` int(11) UNSIGNED NOT NULL,
  `apprenantId` int(11) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `apprenants_cours`
--

INSERT INTO `apprenants_cours` (`dateInscription`, `dateFin`, `dateDesInscription`, `noteFinale`, `lessonId`, `apprenantId`) VALUES
('2019-05-16', '2019-08-16', NULL, 0, 1, 1),
('2019-05-16', '2019-08-16', NULL, 0, 14, 1);

-- --------------------------------------------------------

--
-- Table structure for table `cours`
--

CREATE TABLE `cours` (
  `id_lesson` int(11) UNSIGNED NOT NULL,
  `nomLesson` varchar(255) NOT NULL DEFAULT '0',
  `description` text,
  `prix` int(11) NOT NULL DEFAULT '0',
  `id_type` int(11) NOT NULL DEFAULT '0',
  `id_niveau` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cours`
--

INSERT INTO `cours` (`id_lesson`, `nomLesson`, `description`, `prix`, `id_type`, `id_niveau`) VALUES
(1, 'Introduction a la conduite', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 12000, 3, 2),
(2, 'Regles de conduite', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 16000, 2, 2),
(3, 'Observations aux carrefours', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 37000, 4, 3),
(7, 'Parking parralele inverse', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 56000, 1, 3),
(8, 'Demi angle-inverse', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 46000, 5, 3),
(10, 'Utilisation incorrecte des signaux', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 16000, 1, 1),
(11, 'Regles de stationnement', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 13000, 1, 1),
(12, 'Regles de circulations', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 22000, 3, 2),
(14, 'Feux, panneaux et marquages', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 14000, 2, 1),
(15, 'Informations pour le conducteur', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 26000, 3, 2);

-- --------------------------------------------------------

--
-- Table structure for table `niveaux_cours`
--

CREATE TABLE `niveaux_cours` (
  `id_Niveau` int(11) NOT NULL,
  `intitule` varchar(50) NOT NULL DEFAULT '0',
  `niveau` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `niveaux_cours`
--

INSERT INTO `niveaux_cours` (`id_Niveau`, `intitule`, `niveau`) VALUES
(1, 'DEBUTANT', 1),
(2, 'INTERMEDIAIRE', 2),
(3, 'AVANCE', 3);

-- --------------------------------------------------------

--
-- Table structure for table `types_cours`
--

CREATE TABLE `types_cours` (
  `id_type` int(11) NOT NULL,
  `nomType` varchar(50) NOT NULL DEFAULT '0',
  `iconType` varchar(50) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `types_cours`
--

INSERT INTO `types_cours` (`id_type`, `nomType`, `iconType`) VALUES
(1, 'Type_1', '0'),
(2, 'Type_2', '0'),
(3, 'Type_3', '0'),
(4, 'Type_4', '0'),
(5, 'Type_5', '0');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `apprenants`
--
ALTER TABLE `apprenants`
  ADD PRIMARY KEY (`id_student`);

--
-- Indexes for table `apprenants_cours`
--
ALTER TABLE `apprenants_cours`
  ADD KEY `FK_apprenants_cours_apprenants` (`apprenantId`),
  ADD KEY `FK_apprenants_cours_cours` (`lessonId`);

--
-- Indexes for table `cours`
--
ALTER TABLE `cours`
  ADD PRIMARY KEY (`id_lesson`),
  ADD KEY `FK_cours_niveaux_cours` (`id_niveau`),
  ADD KEY `FK_cours_types_cours` (`id_type`);

--
-- Indexes for table `niveaux_cours`
--
ALTER TABLE `niveaux_cours`
  ADD PRIMARY KEY (`id_Niveau`);

--
-- Indexes for table `types_cours`
--
ALTER TABLE `types_cours`
  ADD PRIMARY KEY (`id_type`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `apprenants`
--
ALTER TABLE `apprenants`
  MODIFY `id_student` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `cours`
--
ALTER TABLE `cours`
  MODIFY `id_lesson` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `niveaux_cours`
--
ALTER TABLE `niveaux_cours`
  MODIFY `id_Niveau` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `types_cours`
--
ALTER TABLE `types_cours`
  MODIFY `id_type` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `apprenants_cours`
--
ALTER TABLE `apprenants_cours`
  ADD CONSTRAINT `FK_apprenants_cours_apprenants` FOREIGN KEY (`apprenantId`) REFERENCES `apprenants` (`id_student`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_apprenants_cours_cours` FOREIGN KEY (`lessonId`) REFERENCES `cours` (`id_lesson`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `cours`
--
ALTER TABLE `cours`
  ADD CONSTRAINT `FK_cours_niveaux_cours` FOREIGN KEY (`id_niveau`) REFERENCES `niveaux_cours` (`id_Niveau`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_cours_types_cours` FOREIGN KEY (`id_type`) REFERENCES `types_cours` (`id_type`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
