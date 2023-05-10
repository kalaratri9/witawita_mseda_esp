-- DROP DATABASE "transfer" ------------
DROP DATABASE IF EXISTS `transfer`;
-- ---------------------------------------------------------

-- CREATE DATABASE "transfer" ----------
CREATE DATABASE `transfer` CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `transfer`;
-- ---------------------------------------------------------

-- CREATE TABLE "external_transfer" --------------------------------------
CREATE TABLE `external_transfer`( 
	`external_transfer_id` Int(10) UNSIGNED AUTO_INCREMENT NOT NULL,
	`destination_account_id` Int(10) UNSIGNED NOT NULL,
	`amount` Decimal( 10, 2 ) NULL,
	`description` VarChar( 100 ) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
	`reference_number` bigint NOT NULL,
	`transfer_status` Char( 2 ) CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
	`creation_datetime` datetime NOT NULL,
	PRIMARY KEY ( `external_transfer_id` ) )
CHARACTER SET = utf8
COLLATE = utf8_general_ci
ENGINE = InnoDB
AUTO_INCREMENT = 1;
-- -------------------------------------------------------------

-- CREATE TABLE "received_messages" ---------------------------------------
CREATE TABLE `received_messages` (
  `consumer_id` VARCHAR(500),
  `message_id` VARCHAR(500),
  `creation_time` BIGINT,
  PRIMARY KEY(consumer_id, message_id)
);
-- -------------------------------------------------------------

-- CREATE TABLE "message" ---------------------------------------
CREATE TABLE `message` (
  `id` VarChar(255) PRIMARY KEY,
  `destination` VarChar(1000) NOT NULL,
  `headers` VarChar(1000) NOT NULL,
  `payload` VarChar(3000) NOT NULL,
  `creation_time` BIGINT,
  `published` VarChar(1) default '0'
);
-- -------------------------------------------------------------
