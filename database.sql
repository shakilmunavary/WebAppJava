-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema bucketlist
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bucketlist
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bucketlist` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `bucketlist` ;

-- -----------------------------------------------------
-- Table `bucketlist`.`tbl_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bucketlist`.`tbl_user` (
  `user_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `user_name` VARCHAR(45) NULL DEFAULT NULL,
  `user_email` VARCHAR(45) NULL DEFAULT NULL,
  `user_password` VARCHAR(45) NULL DEFAULT NULL,
  `user_rating` TINYINT(4) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 20
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

USE `bucketlist` ;

-- -----------------------------------------------------
-- procedure sp_createUser
-- -----------------------------------------------------

DELIMITER $$
USE `bucketlist`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_createUser`(
    IN p_name VARCHAR(20),
    IN p_email VARCHAR(20),
    IN p_password VARCHAR(20),
    IN p_rating tinyint
)
BEGIN
    if ( select exists (select 1 from tbl_user where user_name = p_name) ) THEN
     
        select 'Username Exists !!';
     
    ELSE
     
        insert into tbl_user
        (
            user_name,
            user_email,
            user_password,
            user_rating
        )
        values
        (
            p_name,
            p_email,
            p_password,
            p_rating
        );
     
    END IF;
END$$

DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
