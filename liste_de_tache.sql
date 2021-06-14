-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 01, 2021 at 11:08 AM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `liste_de_tache`
--

-- --------------------------------------------------------

--
-- Table structure for table `liste`
--

CREATE TABLE `liste` (
  `listeID` int(10) UNSIGNED NOT NULL,
  `userid` int(10) UNSIGNED NOT NULL,
  `nom` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `liste`
--

INSERT INTO `liste` (`listeID`, `userid`, `nom`) VALUES
(1, 9, 'Personnel'),
(2, 9, 'liste d\'envies'),
(3, 10, 'study'),
(4, 12, 'study'),
(5, 12, 'work'),
(6, 13, 'rrrrrrrr'),
(7, 14, 'Personnel');

-- --------------------------------------------------------

--
-- Table structure for table `taches`
--

CREATE TABLE `taches` (
  `id` int(10) UNSIGNED NOT NULL,
  `utilisateur_id` int(10) UNSIGNED NOT NULL,
  `liste` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `date_limite` date NOT NULL,
  `etat` varchar(255) NOT NULL DEFAULT 'tâche non terminée'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `taches`
--

INSERT INTO `taches` (`id`, `utilisateur_id`, `liste`, `description`, `date_limite`, `etat`) VALUES
(1, 9, 'Par Défaut', 'home work', '2021-07-02', 'tâche non terminée'),
(2, 9, 'Personnel', 'home work ', '2021-08-07', 'Tâche terminée'),
(3, 9, 'liste d\'envies', 'play valorant', '2021-09-01', 'tâche non terminée'),
(4, 10, 'Par Défaut', 'home work', '2021-05-09', 'Tâche terminée'),
(5, 12, 'Par Défaut', 'java', '2021-07-01', 'tâche non terminée'),
(7, 12, 'Par Défaut', 'ahejkabd', '2021-02-08', 'tâche non terminée'),
(8, 12, 'work', 'vsdvsdvsdv', '2021-02-08', 'tâche non terminée'),
(9, 13, 'rrrrrrrr', 'aaaaaaa', '2012-05-08', 'Tâche terminée'),
(10, 14, 'Personnel', 'play valorantfff', '2012-09-02', 'Tâche terminée'),
(11, 14, 'Personnel', 'play valorantsdsd', '2012-09-02', 'tâche non terminée');

-- --------------------------------------------------------

--
-- Table structure for table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `id` int(10) UNSIGNED NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `username`, `password`, `Email`) VALUES
(9, 'zzz', 'zzz', 'zzz'),
(10, 'bbb', 'bbb', 'bbb'),
(11, 'zeee', 'eeee', 'aaa'),
(12, 'ahmed', 'ahmed@gmail.com', '0000'),
(13, 'midou', 'midou', 'midou'),
(14, 'anissa', 'anissa', 'anissa');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `liste`
--
ALTER TABLE `liste`
  ADD PRIMARY KEY (`listeID`),
  ADD KEY `fk_user` (`userid`);

--
-- Indexes for table `taches`
--
ALTER TABLE `taches`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_utilisateur` (`utilisateur_id`);

--
-- Indexes for table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `liste`
--
ALTER TABLE `liste`
  MODIFY `listeID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `taches`
--
ALTER TABLE `taches`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `liste`
--
ALTER TABLE `liste`
  ADD CONSTRAINT `fk_user` FOREIGN KEY (`userid`) REFERENCES `utilisateur` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `taches`
--
ALTER TABLE `taches`
  ADD CONSTRAINT `fk_utilisateur` FOREIGN KEY (`utilisateur_id`) REFERENCES `utilisateur` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
