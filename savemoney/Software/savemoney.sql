-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 24-Jun-2018 às 19:04
-- Versão do servidor: 10.1.32-MariaDB
-- PHP Version: 7.2.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `savemoney`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_objetivo`
--

CREATE TABLE `tbl_objetivo` (
  `idObjetivo` int(11) NOT NULL,
  `nomeObjetivo` varchar(45) DEFAULT NULL,
  `custoObjetivo` double DEFAULT NULL,
  `dispMensal` double DEFAULT NULL,
  `dispDiaria` double DEFAULT NULL,
  `tempoMes` double DEFAULT NULL,
  `tempoDias` double DEFAULT NULL,
  `saldoObjetivo` double DEFAULT NULL,
  `idUsuario` int(25) NOT NULL,
  `ultimoCadastro` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tbl_objetivo`
--

INSERT INTO `tbl_objetivo` (`idObjetivo`, `nomeObjetivo`, `custoObjetivo`, `dispMensal`, `dispDiaria`, `tempoMes`, `tempoDias`, `saldoObjetivo`, `idUsuario`, `ultimoCadastro`) VALUES
(0, 'teste', 23, 23, 10, 10.9, 16516.98, 1000, 1, '2018-06-24 15:41:50'),
(1, 'Comprar um camelo', 8000, 500, 16.66666603088379, 16, 480.00001831054755, 0, 0, '2018-06-24 16:57:51');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_usuario`
--

CREATE TABLE `tbl_usuario` (
  `idUsuario` int(11) NOT NULL,
  `loginUsuario` varchar(45) DEFAULT NULL,
  `senhaUsuario` varchar(45) DEFAULT NULL,
  `ultimoAcesso` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tbl_usuario`
--

INSERT INTO `tbl_usuario` (`idUsuario`, `loginUsuario`, `senhaUsuario`, `ultimoAcesso`) VALUES
(1, 'Ariel', '123', '2018-06-24 15:36:51'),
(3, 'Savemoney', '321', '2018-06-22 23:36:16');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_objetivo`
--
ALTER TABLE `tbl_objetivo`
  ADD PRIMARY KEY (`idObjetivo`);

--
-- Indexes for table `tbl_usuario`
--
ALTER TABLE `tbl_usuario`
  ADD PRIMARY KEY (`idUsuario`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_objetivo`
--
ALTER TABLE `tbl_objetivo`
  MODIFY `idObjetivo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tbl_usuario`
--
ALTER TABLE `tbl_usuario`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
