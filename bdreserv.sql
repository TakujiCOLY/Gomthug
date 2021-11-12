-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema bdreservation
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bdreservation
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bdreservation` DEFAULT CHARACTER SET utf8 ;
USE `bdreservation` ;

-- -----------------------------------------------------
-- Table `bdreservation`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdreservation`.`User` (
  `idU` INT NOT NULL AUTO_INCREMENT,
  `loginU` VARCHAR(45) NULL,
  `mdpU` VARCHAR(45) NULL,
  PRIMARY KEY (`idU`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bdreservation`.`Compagnie`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdreservation`.`Compagnie` (
  `idComp` INT NOT NULL AUTO_INCREMENT,
  `nomComp` VARCHAR(45) NULL,
  `addrComp` VARCHAR(45) NULL,
  `contactComp` VARCHAR(45) NULL,
  `nomResponsable` VARCHAR(45) NULL,
  `prenomResponsable` VARCHAR(45) NULL,
  `User_idU` INT NOT NULL,
  PRIMARY KEY (`idComp`),
  INDEX `fk_Compagnie_User1_idx` (`User_idU` ASC),
  CONSTRAINT `fk_Compagnie_User1`
    FOREIGN KEY (`User_idU`)
    REFERENCES `bdreservation`.`User` (`idU`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bdreservation`.`itineraire`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdreservation`.`itineraire` (
  `iditineraire` INT NOT NULL AUTO_INCREMENT,
  `libelleIt` VARCHAR(45) NULL,
  PRIMARY KEY (`iditineraire`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bdreservation`.`Depart`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdreservation`.`Depart` (
  `idDep` INT NOT NULL AUTO_INCREMENT,
  `dteDep` DATETIME NULL,
  `heureDep` DATETIME NULL,
  `heureConvocation` DATETIME NULL,
  `villeDep` VARCHAR(45) NULL,
  `villeDestination` VARCHAR(45) NULL,
  `Compagnie_idComp` INT NOT NULL,
  `itineraire_iditineraire` INT NOT NULL,
  PRIMARY KEY (`idDep`),
  INDEX `fk_Depart_Compagnie_idx` (`Compagnie_idComp` ASC),
  INDEX `fk_Depart_itineraire1_idx` (`itineraire_iditineraire` ASC),
  CONSTRAINT `fk_Depart_Compagnie`
    FOREIGN KEY (`Compagnie_idComp`)
    REFERENCES `bdreservation`.`Compagnie` (`idComp`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Depart_itineraire1`
    FOREIGN KEY (`itineraire_iditineraire`)
    REFERENCES `bdreservation`.`itineraire` (`iditineraire`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bdreservation`.`Client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdreservation`.`Client` (
  `idClient` INT NOT NULL AUTO_INCREMENT,
  `nomClient` VARCHAR(45) NULL,
  `prenomClient` VARCHAR(45) NULL,
  `telClient` VARCHAR(45) NULL,
  `addrClient` VARCHAR(45) NULL,
  `mailCLient` VARCHAR(45) NULL,
  `dteInscription` DATETIME NULL,
  `User_idU` INT NOT NULL,
  PRIMARY KEY (`idClient`),
  INDEX `fk_Client_User1_idx` (`User_idU` ASC),
  CONSTRAINT `fk_Client_User1`
    FOREIGN KEY (`User_idU`)
    REFERENCES `bdreservation`.`User` (`idU`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bdreservation`.`Reservation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdreservation`.`Reservation` (
  `idReservation` INT NOT NULL AUTO_INCREMENT,
  `dteRes` DATETIME NULL,
  `nbPlace` INT NULL,
  `Depart_idDep` INT NOT NULL,
  `Client_idClient` INT NOT NULL,
  PRIMARY KEY (`idReservation`),
  INDEX `fk_Reservation_Depart1_idx` (`Depart_idDep` ASC),
  INDEX `fk_Reservation_Client1_idx` (`Client_idClient` ASC),
  CONSTRAINT `fk_Reservation_Depart1`
    FOREIGN KEY (`Depart_idDep`)
    REFERENCES `bdreservation`.`Depart` (`idDep`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reservation_Client1`
    FOREIGN KEY (`Client_idClient`)
    REFERENCES `bdreservation`.`Client` (`idClient`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bdreservation`.`Admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdreservation`.`Admin` (
  `idAdmin` INT NOT NULL AUTO_INCREMENT,
  `nomAdmin` VARCHAR(45) NULL,
  `prenomAdmin` VARCHAR(45) NULL,
  `mailAdmin` VARCHAR(45) NULL,
  `User_idU` INT NOT NULL,
  PRIMARY KEY (`idAdmin`),
  INDEX `fk_Admin_User1_idx` (`User_idU` ASC),
  CONSTRAINT `fk_Admin_User1`
    FOREIGN KEY (`User_idU`)
    REFERENCES `bdreservation`.`User` (`idU`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bdreservation`.`Passager`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdreservation`.`Passager` (
  `idPas` INT NOT NULL AUTO_INCREMENT,
  `nomPas` VARCHAR(45) NULL,
  `prenomPass` VARCHAR(45) NULL,
  `agePas` INT NULL,
  `Reservation_idReservation` INT NOT NULL,
  PRIMARY KEY (`idPas`),
  INDEX `fk_Passager_Reservation1_idx` (`Reservation_idReservation` ASC),
  CONSTRAINT `fk_Passager_Reservation1`
    FOREIGN KEY (`Reservation_idReservation`)
    REFERENCES `bdreservation`.`Reservation` (`idReservation`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
