-- DROP DATABASE "bank_registration" ------------
DROP DATABASE IF EXISTS `bank_registration`;
-- ---------------------------------------------------------

-- CREATE DATABASE "bank_registration" ----------
CREATE DATABASE `bank_registration` CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `bank_registration`;
-- ---------------------------------------------------------

-- CREATE TABLE "bank_customer_data" --------------------------------
CREATE TABLE `bank_customer_data` ( 
     `bank_customer_data_id` Int(10) UNSIGNED AUTO_INCREMENT NOT NULL,
     `client_id` Int(10) UNSIGNED NOT NULL,
     `bp_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
     `digital_bank_Id` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
     `customer_id` Int(10) UNSIGNED NULL,
     `creation_datetime` datetime NOT NULL,
     `modification_datetime` datetime NULL,
     PRIMARY KEY ( `bank_customer_data_id` ) )
CHARACTER SET = utf8
COLLATE = utf8_general_ci
ENGINE = InnoDB
AUTO_INCREMENT = 1;
-- -------------------------------------------------------------

-- CREATE TABLE "message" ---------------------------------------
CREATE TABLE `message` (
  `id` VARCHAR(255) PRIMARY KEY,
  `destination` LONGTEXT NOT NULL,
  `headers` LONGTEXT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `payload` LONGTEXT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `published` SMALLINT DEFAULT 0,
  `message_partition` SMALLINT,
  `creation_time` BIGINT
);
-- -------------------------------------------------------------


ALTER TABLE `bank_registration`.`bank_customer_data` ADD COLUMN `bank_enrolled` Int(1) UNSIGNED NOT NULL DEFAULT 0 AFTER `customer_id`;
