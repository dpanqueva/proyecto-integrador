-- MySQL Workbench Synchronization
-- Generated: 2022-08-24 12:13
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: dpanquev

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `dh_proyecto_integrador` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci ;

CREATE TABLE IF NOT EXISTS `dh_proyecto_integrador`.`dh_producto` (
  `producto_id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NOT NULL,
  `anio_estreno` VARCHAR(4) NOT NULL,
  `descripcion` TEXT NOT NULL,
  `ciudad_id` INT(11) NOT NULL,
  `categoria_id` INT(11) NOT NULL,
  `imagen_id` INT(11) NOT NULL,
  `politica_id` INT(11) NOT NULL,
  PRIMARY KEY (`producto_id`),
  INDEX `fk_dh_producto_dh_ciudad_idx` (`ciudad_id` ASC) ,
  INDEX `fk_dh_producto_dh_categoria1_idx` (`categoria_id` ASC) ,
  INDEX `fk_dh_producto_dh_imagenes1_idx` (`imagen_id` ASC) ,
  INDEX `fk_dh_producto_dh_politica1_idx` (`politica_id` ASC) ,
  CONSTRAINT `fk_dh_producto_dh_ciudad`
    FOREIGN KEY (`ciudad_id`)
    REFERENCES `dh_proyecto_integrador`.`dh_ciudad` (`ciudad_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_dh_producto_dh_categoria1`
    FOREIGN KEY (`categoria_id`)
    REFERENCES `dh_proyecto_integrador`.`dh_categoria` (`categoria_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_dh_producto_dh_imagenes1`
    FOREIGN KEY (`imagen_id`)
    REFERENCES `dh_proyecto_integrador`.`dh_imagenes` (`imagen_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_dh_producto_dh_politica1`
    FOREIGN KEY (`politica_id`)
    REFERENCES `dh_proyecto_integrador`.`dh_politica` (`politica_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = INNODB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;

CREATE TABLE IF NOT EXISTS `dh_proyecto_integrador`.`dh_categoria` (
  `categoria_id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NOT NULL,
  `tipo` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`categoria_id`))
ENGINE = INNODB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;

CREATE TABLE IF NOT EXISTS `dh_proyecto_integrador`.`dh_caracteristica` (
  `caracteristica_id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NOT NULL,
  `tipo` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`caracteristica_id`))
ENGINE = INNODB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;

CREATE TABLE IF NOT EXISTS `dh_proyecto_integrador`.`dh_ciudad` (
  `ciudad_id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NOT NULL,
  `pais` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`ciudad_id`))
ENGINE = INNODB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;

CREATE TABLE IF NOT EXISTS `dh_proyecto_integrador`.`dh_producto_caracteristica` (
  `prod_carac_id` INT(11) NOT NULL AUTO_INCREMENT,
  `producto_id` INT(11) NOT NULL,
  `caracteristica_id` INT(11) NOT NULL,
  PRIMARY KEY (`prod_carac_id`),
  INDEX `fk_dh_producto_caracteristica_dh_producto1_idx` (`producto_id` ASC) ,
  INDEX `fk_dh_producto_caracteristica_dh_caracteristica1_idx` (`caracteristica_id` ASC) ,
  CONSTRAINT `fk_dh_producto_caracteristica_dh_producto1`
    FOREIGN KEY (`producto_id`)
    REFERENCES `dh_proyecto_integrador`.`dh_producto` (`producto_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_dh_producto_caracteristica_dh_caracteristica1`
    FOREIGN KEY (`caracteristica_id`)
    REFERENCES `dh_proyecto_integrador`.`dh_caracteristica` (`caracteristica_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = INNODB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;

CREATE TABLE IF NOT EXISTS `dh_proyecto_integrador`.`dh_imagenes` (
  `imagen_id` INT(11) NOT NULL AUTO_INCREMENT,
  `url` VARCHAR(100) NOT NULL,
  `nombre` VARCHAR(50) NOT NULL,
  `descripcion` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`imagen_id`))
ENGINE = INNODB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;

CREATE TABLE IF NOT EXISTS `dh_proyecto_integrador`.`dh_politica` (
  `politica_id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NOT NULL,
  `descripcion` TEXT NOT NULL,
  `multa` FLOAT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`politica_id`))
ENGINE = INNODB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;

CREATE TABLE IF NOT EXISTS `dh_proyecto_integrador`.`dh_usuario` (
  `usuario_id` INT(11) NOT NULL AUTO_INCREMENT,
  `cedula` VARCHAR(50) NOT NULL,
  `correo` VARCHAR(50) NOT NULL,
  `clave` VARCHAR(100) NOT NULL,
  `nombre` VARCHAR(50) NOT NULL,
  `apellido` VARCHAR(50) NOT NULL,
  `role_id` INT(11) NOT NULL,
  PRIMARY KEY (`usuario_id`),
  UNIQUE INDEX `cedula_UNIQUE` (`cedula` ASC) ,
  UNIQUE INDEX `correo_UNIQUE` (`correo` ASC) ,
  INDEX `fk_dh_usuario_dh_rol1_idx` (`role_id` ASC) ,
  CONSTRAINT `fk_dh_usuario_dh_rol1`
    FOREIGN KEY (`role_id`)
    REFERENCES `dh_proyecto_integrador`.`dh_role` (`role_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = INNODB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;

CREATE TABLE IF NOT EXISTS `dh_proyecto_integrador`.`dh_role` (
  `role_id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NOT NULL,
  `snactivo` VARCHAR(1) NOT NULL DEFAULT 'S',
  PRIMARY KEY (`role_id`),
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC) )
ENGINE = INNODB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;

CREATE TABLE IF NOT EXISTS `dh_proyecto_integrador`.`dh_reserva` (
  `reserva_id` INT(11) NOT NULL AUTO_INCREMENT,
  `feinicio_reserva` DATE NOT NULL,
  `fefin_reserva` DATE NOT NULL,
  `usuario_id` INT(11) NOT NULL,
  `producto_id` INT(11) NOT NULL,
  PRIMARY KEY (`reserva_id`),
  INDEX `fk_dh_reserva_dh_usuario1_idx` (`usuario_id` ASC),
  INDEX `fk_dh_reserva_dh_producto1_idx` (`producto_id` ASC),
  CONSTRAINT `fk_dh_reserva_dh_usuario1`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `dh_proyecto_integrador`.`dh_usuario` (`usuario_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_dh_reserva_dh_producto1`
    FOREIGN KEY (`producto_id`)
    REFERENCES `dh_proyecto_integrador`.`dh_producto` (`producto_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = INNODB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


CREATE TABLE IF NOT EXISTS `dh_proyecto_integrador`.`dh_favorito` (
  `favorito_id` INT(11) NOT NULL AUTO_INCREMENT,
  `usuario_id` INT(11) NOT NULL,
  `producto_id` INT(11) NOT NULL,
  PRIMARY KEY (`favorito_id`),
  INDEX `fk_dh_favorito_dh_usuario1_idx` (`usuario_id` ASC),
  INDEX `fk_dh_favorito_dh_producto1_idx` (`producto_id` ASC),
  CONSTRAINT `fk_dh_favorito_dh_usuario1`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `dh_proyecto_integrador`.`dh_usuario` (`usuario_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_dh_favorito_dh_producto1`
    FOREIGN KEY (`producto_id`)
    REFERENCES `dh_proyecto_integrador`.`dh_producto` (`producto_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = INNODB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;



INSERT INTO `dh_proyecto_integrador`.`dh_caracteristica` (`nombre`, `tipo`) VALUES ('Aire acondicionado', 'Air');
INSERT INTO `dh_proyecto_integrador`.`dh_caracteristica` (`nombre`, `tipo`) VALUES ('Piscina', 'Piscina');

INSERT INTO `dh_proyecto_integrador`.`dh_imagenes` (`url`, `nombre`, `descripcion`) VALUES ('http://localhost:8080/images', 'mi-imagen.png', 'una imagen');
INSERT INTO `dh_proyecto_integrador`.`dh_politica` (`nombre`, `descripcion`, `multa`) VALUES ('check-in', 'el check-in es antes de las 10am', '1000');

INSERT INTO `dh_proyecto_integrador`.`dh_ciudad` (`nombre`, `pais`) VALUES ('Bogota', 'Colombia');
INSERT INTO `dh_proyecto_integrador`.`dh_ciudad` (`nombre`, `pais`) VALUES ('Medellin', 'Colombia');

INSERT INTO `dh_proyecto_integrador`.`dh_categoria` (`nombre`, `tipo`) VALUES ('Apartamento', 'Vivienda');
INSERT INTO `dh_proyecto_integrador`.`dh_categoria` (`nombre`, `tipo`) VALUES ('Automovil', 'Auto');

INSERT INTO `dh_proyecto_integrador`.`dh_role` (`nombre`) VALUES ('ROLE_ADMIN');
INSERT INTO `dh_proyecto_integrador`.`dh_role` (`nombre`) VALUES ('ROLE_USER'); 

INSERT INTO `dh_proyecto_integrador`.`dh_usuario` (`cedula`, `correo`, `clave`, `nombre`, `apellido`, `role_id`) VALUES ('1234567890', 'correo@gmail.com', '$2a$10$TzMMHNtXEwvRg1Yd1voRFueordr3IvMFYT85hJQYsuTPYWtnBZpNW', 'Diego', 'Panqueva', '1'); 
INSERT INTO `dh_proyecto_integrador`.`dh_usuario` (`cedula`, `correo`, `clave`, `nombre`, `apellido`, `role_id`) VALUES ('1234567891', 'otro@hotmail.com', '$2a$10$TzMMHNtXEwvRg1Yd1voRFueordr3IvMFYT85hJQYsuTPYWtnBZpNW', 'Alejandro', 'Benitez', '2'); 

INSERT INTO `dh_proyecto_integrador`.`dh_favorito` (`usuario_id`, `producto_id`) VALUES ('1', '2');
INSERT INTO `dh_proyecto_integrador`.`dh_favorito` (`usuario_id`, `producto_id`) VALUES ('1', '1'); 