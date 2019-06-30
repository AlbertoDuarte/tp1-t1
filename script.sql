-- MySQL Script generated by MySQL Workbench
-- Sex 28 Jun 2019 21:03:13 -03
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`empresa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`empresa` (
  `id_empresa` INT NOT NULL,
  `nome` VARCHAR(45) NULL,
  PRIMARY KEY (`id_empresa`),
  UNIQUE INDEX `id_empresa_UNIQUE` (`id_empresa` ASC),
  UNIQUE INDEX `nome_UNIQUE` (`nome` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`agencia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`agencia` (
  `id_agencia` INT NOT NULL,
  `cep` VARCHAR(45) NULL,
  `id_empresa` INT NOT NULL,
  PRIMARY KEY (`id_agencia`, `id_empresa`),
  INDEX `fk_agencia_empresa1_idx` (`id_empresa` ASC),
  UNIQUE INDEX `id_agencia_UNIQUE` (`id_agencia` ASC),
  UNIQUE INDEX `cep_UNIQUE` (`cep` ASC),
  CONSTRAINT `fk_agencia_empresa1`
    FOREIGN KEY (`id_empresa`)
    REFERENCES `mydb`.`empresa` (`id_empresa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Categorias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Categorias` (
  `id_categoria` INT NOT NULL AUTO_INCREMENT,
  `letra` VARCHAR(45) NULL,
  `valor_diaria` DOUBLE NULL,
  PRIMARY KEY (`id_categoria`),
  UNIQUE INDEX `id_categoria_UNIQUE` (`id_categoria` ASC),
  UNIQUE INDEX `letra_UNIQUE` (`letra` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Marcas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Marcas` (
  `id_marca` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  PRIMARY KEY (`id_marca`),
  UNIQUE INDEX `id_marca_UNIQUE` (`id_marca` ASC),
  UNIQUE INDEX `nome_UNIQUE` (`nome` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Modelos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Modelos` (
  `id_modelo` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `combustivel` VARCHAR(45) NULL,
  `n_portas` VARCHAR(45) NULL,
  `id_marca` INT NOT NULL,
  PRIMARY KEY (`id_modelo`, `id_marca`),
  UNIQUE INDEX `nome_UNIQUE` (`nome` ASC),
  UNIQUE INDEX `id_modelo_UNIQUE` (`id_modelo` ASC),
  INDEX `fk_Modelos_Marcas1_idx` (`id_marca` ASC),
  CONSTRAINT `fk_Modelos_Marcas1`
    FOREIGN KEY (`id_marca`)
    REFERENCES `mydb`.`Marcas` (`id_marca`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Carros`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Carros` (
  `id_carro` INT NOT NULL AUTO_INCREMENT,
  `placa` VARCHAR(45) NULL,
  `renavam` VARCHAR(45) NULL,
  `cor` VARCHAR(45) NULL,
  `ano` INT NULL,
  `quilometragem` DOUBLE NULL,
  `id_agencia` INT NOT NULL,
  `id_categoria` INT NOT NULL,
  `id_modelo` INT NOT NULL,
  PRIMARY KEY (`id_carro`, `id_agencia`, `id_categoria`, `id_modelo`),
  INDEX `fk_Carro_agencia1_idx` (`id_agencia` ASC),
  UNIQUE INDEX `id_carro_UNIQUE` (`id_carro` ASC),
  UNIQUE INDEX `placa_UNIQUE` (`placa` ASC),
  UNIQUE INDEX `renavam_UNIQUE` (`renavam` ASC),
  INDEX `fk_Carros_Categorias1_idx` (`id_categoria` ASC),
  INDEX `fk_Carros_Modelos1_idx` (`id_modelo` ASC),
  CONSTRAINT `fk_Carro_agencia1`
    FOREIGN KEY (`id_agencia`)
    REFERENCES `mydb`.`agencia` (`id_agencia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Carros_Categorias1`
    FOREIGN KEY (`id_categoria`)
    REFERENCES `mydb`.`Categorias` (`id_categoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Carros_Modelos1`
    FOREIGN KEY (`id_modelo`)
    REFERENCES `mydb`.`Modelos` (`id_modelo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;