-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Dim 01 Janvier 2017 à 10:21
-- Version du serveur :  5.6.20-log
-- Version de PHP :  5.4.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `contact`
--

-- --------------------------------------------------------

--
-- Structure de la table `address`
--

CREATE TABLE IF NOT EXISTS `address` (
`id` int(32) NOT NULL,
  `idContact` int(32) NOT NULL,
  `street` varchar(32) NOT NULL,
  `city` varchar(32) NOT NULL,
  `zip` varchar(32) NOT NULL,
  `country` varchar(32) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=38 ;


-- --------------------------------------------------------

--
-- Structure de la table `books`
--

CREATE TABLE IF NOT EXISTS `books` (
  `idGroup` int(32) NOT NULL,
  `idContact` int(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



-- --------------------------------------------------------

--
-- Structure de la table `contact`
--

CREATE TABLE IF NOT EXISTS `contact` (
  `firstName` varchar(32) NOT NULL,
  `lastName` varchar(32) NOT NULL,
  `email` varchar(32) NOT NULL,
`id` int(32) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=42 ;


-- --------------------------------------------------------

--
-- Structure de la table `contactgroup`
--

CREATE TABLE IF NOT EXISTS `contactgroup` (
`groupId` int(32) NOT NULL,
  `groupName` varchar(32) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;


-- --------------------------------------------------------

--
-- Structure de la table `phonenumber`
--

CREATE TABLE IF NOT EXISTS `phonenumber` (
`id` int(32) NOT NULL,
  `idContact` int(11) NOT NULL,
  `phoneKind` varchar(32) NOT NULL,
  `phoneNumber` varchar(32) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;


--
-- Index pour les tables exportées
--

--
-- Index pour la table `address`
--
ALTER TABLE `address`
 ADD PRIMARY KEY (`id`), ADD KEY `idContact` (`idContact`);

--
-- Index pour la table `books`
--
ALTER TABLE `books`
 ADD KEY `idGroup` (`idGroup`), ADD KEY `idContact` (`idContact`), ADD KEY `idGroup_2` (`idGroup`), ADD KEY `idContact_2` (`idContact`);

--
-- Index pour la table `contact`
--
ALTER TABLE `contact`
 ADD PRIMARY KEY (`id`);

--
-- Index pour la table `contactgroup`
--
ALTER TABLE `contactgroup`
 ADD PRIMARY KEY (`groupId`);

--
-- Index pour la table `phonenumber`
--
ALTER TABLE `phonenumber`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `idContact` (`idContact`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `address`
--
ALTER TABLE `address`
MODIFY `id` int(32) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=38;
--
-- AUTO_INCREMENT pour la table `contact`
--
ALTER TABLE `contact`
MODIFY `id` int(32) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=42;
--
-- AUTO_INCREMENT pour la table `contactgroup`
--
ALTER TABLE `contactgroup`
MODIFY `groupId` int(32) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `phonenumber`
--
ALTER TABLE `phonenumber`
MODIFY `id` int(32) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=12;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `address`
--
ALTER TABLE `address`
ADD CONSTRAINT `address_ibfk_1` FOREIGN KEY (`idContact`) REFERENCES `contact` (`id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `books`
--
ALTER TABLE `books`
ADD CONSTRAINT `books_ibfk_2` FOREIGN KEY (`idContact`) REFERENCES `contact` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `books_ibfk_3` FOREIGN KEY (`idGroup`) REFERENCES `contactgroup` (`groupId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `phonenumber`
--
ALTER TABLE `phonenumber`
ADD CONSTRAINT `phonenumber_ibfk_2` FOREIGN KEY (`idContact`) REFERENCES `contact` (`id`) ON DELETE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
