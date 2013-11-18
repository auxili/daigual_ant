-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.6.13 - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             8.0.0.4396
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando estructura de base de datos para banco
DROP DATABASE IF EXISTS `banco`;
CREATE DATABASE IF NOT EXISTS `banco` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `banco`;


-- Volcando estructura para tabla banco.cuentabancaria
DROP TABLE IF EXISTS `cuentabancaria`;
CREATE TABLE IF NOT EXISTS `cuentabancaria` (
  `idCuentaBancaria` int(11) NOT NULL DEFAULT '0',
  `sucursalBancaria` varchar(20) DEFAULT NULL,
  `numeroCuenta` varchar(20) DEFAULT NULL,
  `dc` varchar(2) DEFAULT NULL,
  `saldo` bigint(20) DEFAULT NULL,
  `cif` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`idCuentaBancaria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla banco.cuentabancaria: ~3 rows (aproximadamente)
DELETE FROM `cuentabancaria`;
/*!40000 ALTER TABLE `cuentabancaria` DISABLE KEYS */;
INSERT INTO `cuentabancaria` (`idCuentaBancaria`, `sucursalBancaria`, `numeroCuenta`, `dc`, `saldo`, `cif`) VALUES
	(1, 'CajaAhorro', '00000123', '12', 25000, '44554455s'),
	(2, 'CajaAhorro', '00000124', '34', 25000, '33454455s'),
	(3, 'CajaAhorro', '00000125', '21', 25000, '987987987A');
/*!40000 ALTER TABLE `cuentabancaria` ENABLE KEYS */;


-- Volcando estructura para tabla banco.entidadbancaria
DROP TABLE IF EXISTS `entidadbancaria`;
CREATE TABLE IF NOT EXISTS `entidadbancaria` (
  `id` int(11) NOT NULL,
  `codigoEntidad` varchar(50) DEFAULT NULL,
  `nombre` varchar(20) DEFAULT NULL,
  `cif` varchar(20) DEFAULT NULL,
  `tipoEntidadBancaria` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla banco.entidadbancaria: ~5 rows (aproximadamente)
DELETE FROM `entidadbancaria`;
/*!40000 ALTER TABLE `entidadbancaria` DISABLE KEYS */;
INSERT INTO `entidadbancaria` (`id`, `codigoEntidad`, `nombre`, `cif`, `tipoEntidadBancaria`) VALUES
	(1, '2323', 'entidad2', '321321321e', 'Banco'),
	(3, '2343', 'entidad3', '654654654', 'Banco'),
	(4, '2343', 'Bonco3', '654654654', 'Banco'),
	(6, '654654', 'entidadInsertadaDAO', '9865498654', 'Banco'),
	(8, '654654', 'entidadInsertadaDAO', '9865498654', 'Banco'),
	(13, 'otroBanco', 'bancquisimo', 'superbanco', NULL);
/*!40000 ALTER TABLE `entidadbancaria` ENABLE KEYS */;


-- Volcando estructura para tabla banco.movimientobancario
DROP TABLE IF EXISTS `movimientobancario`;
CREATE TABLE IF NOT EXISTS `movimientobancario` (
  `idMovimientoBancario` int(11) NOT NULL DEFAULT '0',
  `tipoMovimientoBancario` varchar(10) DEFAULT NULL,
  `importe` bigint(20) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `saldoTotal` bigint(20) DEFAULT NULL,
  `concepto` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`idMovimientoBancario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla banco.movimientobancario: ~2 rows (aproximadamente)
DELETE FROM `movimientobancario`;
/*!40000 ALTER TABLE `movimientobancario` DISABLE KEYS */;
INSERT INTO `movimientobancario` (`idMovimientoBancario`, `tipoMovimientoBancario`, `importe`, `fecha`, `saldoTotal`, `concepto`) VALUES
	(1, 'debe', 2000, '2013-09-30', 300000, 'varios'),
	(2, 'haver', 300, '2013-09-30', 40000, 'ovarios');
/*!40000 ALTER TABLE `movimientobancario` ENABLE KEYS */;


-- Volcando estructura para tabla banco.sucursalbancaria
DROP TABLE IF EXISTS `sucursalbancaria`;
CREATE TABLE IF NOT EXISTS `sucursalbancaria` (
  `idSucursalBancaria` int(11) NOT NULL DEFAULT '0',
  `entidadBancaria` varchar(20) DEFAULT NULL,
  `codigoSucursal` int(11) DEFAULT NULL,
  `nombre` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idSucursalBancaria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla banco.sucursalbancaria: ~2 rows (aproximadamente)
DELETE FROM `sucursalbancaria`;
/*!40000 ALTER TABLE `sucursalbancaria` DISABLE KEYS */;
INSERT INTO `sucursalbancaria` (`idSucursalBancaria`, `entidadBancaria`, `codigoSucursal`, `nombre`) VALUES
	(1, 'entidad1', 555, 'entiodad1'),
	(2, 'entidad2', 444, 'entidad2');
/*!40000 ALTER TABLE `sucursalbancaria` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
