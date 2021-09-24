-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 24, 2021 at 06:02 AM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bd_app`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_cliente`
--

CREATE TABLE `tbl_cliente` (
  `id_cliente` int(11) NOT NULL,
  `nombre_cliente` varchar(45) NOT NULL,
  `apellido_cliente` varchar(45) NOT NULL,
  `direccion_cliente` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_cliente_android`
--

CREATE TABLE `tbl_cliente_android` (
  `id_cliente` int(11) NOT NULL,
  `nombre_cliente` varchar(45) NOT NULL,
  `apellido_cliente` varchar(45) NOT NULL,
  `direccion_cliente` varchar(50) NOT NULL,
  `correo_cliente` varchar(50) NOT NULL,
  `clave_cliente` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_cliente_android`
--

INSERT INTO `tbl_cliente_android` (`id_cliente`, `nombre_cliente`, `apellido_cliente`, `direccion_cliente`, `correo_cliente`, `clave_cliente`) VALUES
(1, 'Abigail', 'Espina', 'Zona 7', 'abi@gmail.com', 'abi123'),
(2, 'Heydy', 'Martinez', 'Zona 11', 'heydy@gmail.com', 'heydy123'),
(3, 'Omar', 'Espina', 'Zona 7', 'omar@gmail.com', 'omar123'),
(4, 'Ellen', 'Espina', 'Zona 7', 'ellen@gmail.com', 'ellen123'),
(5, 'Grace', 'Espina', 'Zona 11', 'grace@gmail.com', 'grace123'),
(6, 'Janet', 'Espina', 'Zona 11', 'janet@gmail.com', 'janet123'),
(7, 'Eugenia', 'Sarceno', 'Zona 11', 'eugenia@gmail.com', 'eugenia123'),
(8, 'heydy', 'martinez', 'zona 7', 'heydyhmplan6@yahoo.es', 'omaraby');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_compra`
--

CREATE TABLE `tbl_compra` (
  `id_compra` int(11) NOT NULL,
  `fecha_compra` date NOT NULL,
  `cantidad_producto` int(11) NOT NULL,
  `precio_producto` int(11) NOT NULL,
  `fk_id_producto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_detalle_factura`
--

CREATE TABLE `tbl_detalle_factura` (
  `id_detalle_factura` int(11) NOT NULL,
  `cantidad_producto` int(11) NOT NULL,
  `total_factura` int(11) NOT NULL,
  `fk_id_producto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_estado_pedido`
--

CREATE TABLE `tbl_estado_pedido` (
  `id_estado_pedido` int(11) NOT NULL,
  `estado_pedido` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_estado_pedido`
--

INSERT INTO `tbl_estado_pedido` (`id_estado_pedido`, `estado_pedido`) VALUES
(1, 'Recibido'),
(2, 'Enviado'),
(3, 'Entregado');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_factura`
--

CREATE TABLE `tbl_factura` (
  `id_factura` int(11) NOT NULL,
  `fecha_factura` date NOT NULL,
  `fk_id_cliente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_pedido`
--

CREATE TABLE `tbl_pedido` (
  `id_pedido` int(11) NOT NULL,
  `fecha_pedido` date NOT NULL,
  `fk_id_cliente` int(11) NOT NULL,
  `fk_id_producto_pedido` int(11) NOT NULL,
  `descripcion_pedido` varchar(100) NOT NULL,
  `precio_pedido` double NOT NULL,
  `cantidad_pedido` int(11) NOT NULL,
  `total_pedido` double NOT NULL,
  `fk_id_estadop` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_pedido`
--

INSERT INTO `tbl_pedido` (`id_pedido`, `fecha_pedido`, `fk_id_cliente`, `fk_id_producto_pedido`, `descripcion_pedido`, `precio_pedido`, `cantidad_pedido`, `total_pedido`, `fk_id_estadop`) VALUES
(1, '2021-09-24', 1, 2, 'Vitamina D', 60, 5, 300, 1),
(2, '2021-09-24', 1, 3, 'Caja Aspirina', 25, 4, 100, 1),
(3, '0000-00-00', 1, 1, 'Vitamina C', 25, 1, 25, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_producto`
--

CREATE TABLE `tbl_producto` (
  `id_producto` int(11) NOT NULL,
  `nombre_producto` varchar(45) NOT NULL,
  `tipo_producto` varchar(45) NOT NULL,
  `descripcion_producto` varchar(100) NOT NULL,
  `fk_id_proveedor` int(11) NOT NULL,
  `precio_producto` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_producto`
--

INSERT INTO `tbl_producto` (`id_producto`, `nombre_producto`, `tipo_producto`, `descripcion_producto`, `fk_id_proveedor`, `precio_producto`) VALUES
(1, 'Vitamina C', 'Vitaminas', 'Vitamina C para fortalecer el sistema inmunológico', 1, 50),
(2, 'Vitamina D', 'Vitaminas', 'Vitamina D para fortalecer el sistema inmunológico', 2, 60),
(3, 'Caja Aspirina', 'Pastilla', 'Aspirina Bayer por caja', 2, 25);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_proveedor`
--

CREATE TABLE `tbl_proveedor` (
  `id_proveedor` int(11) NOT NULL,
  `nombre_proveedor` varchar(45) NOT NULL,
  `telefono_proveedor` int(11) NOT NULL,
  `direccion_proveedor` varchar(50) NOT NULL,
  `correo_proveedor` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_proveedor`
--

INSERT INTO `tbl_proveedor` (`id_proveedor`, `nombre_proveedor`, `telefono_proveedor`, `direccion_proveedor`, `correo_proveedor`) VALUES
(1, 'Laboratorio Villa Nueva', 22345678, 'Villa Nueva', 'labvn@gmail.com'),
(2, 'Laboratorio Guatemala', 23456789, 'Zona 11 Guatemala', 'labgt@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_tipo_usuario`
--

CREATE TABLE `tbl_tipo_usuario` (
  `id_tipo_usuario` int(11) NOT NULL,
  `nombre_tipo_usuario` varchar(35) NOT NULL,
  `descripcion_tipo_usuario` varchar(35) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_usuario`
--

CREATE TABLE `tbl_usuario` (
  `id_usuario` int(11) NOT NULL,
  `usuario` varchar(45) NOT NULL,
  `clave_usuario` varchar(50) NOT NULL,
  `fk_id_tipo_usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_cliente`
--
ALTER TABLE `tbl_cliente`
  ADD PRIMARY KEY (`id_cliente`);

--
-- Indexes for table `tbl_cliente_android`
--
ALTER TABLE `tbl_cliente_android`
  ADD PRIMARY KEY (`id_cliente`);

--
-- Indexes for table `tbl_compra`
--
ALTER TABLE `tbl_compra`
  ADD PRIMARY KEY (`id_compra`),
  ADD KEY `FK3` (`fk_id_producto`);

--
-- Indexes for table `tbl_detalle_factura`
--
ALTER TABLE `tbl_detalle_factura`
  ADD PRIMARY KEY (`id_detalle_factura`),
  ADD KEY `FK5` (`fk_id_producto`);

--
-- Indexes for table `tbl_estado_pedido`
--
ALTER TABLE `tbl_estado_pedido`
  ADD PRIMARY KEY (`id_estado_pedido`);

--
-- Indexes for table `tbl_factura`
--
ALTER TABLE `tbl_factura`
  ADD PRIMARY KEY (`id_factura`),
  ADD KEY `FK4` (`fk_id_cliente`);

--
-- Indexes for table `tbl_pedido`
--
ALTER TABLE `tbl_pedido`
  ADD PRIMARY KEY (`id_pedido`),
  ADD KEY `FK6` (`fk_id_producto_pedido`),
  ADD KEY `FK7` (`fk_id_cliente`),
  ADD KEY `FK9` (`fk_id_estadop`);

--
-- Indexes for table `tbl_producto`
--
ALTER TABLE `tbl_producto`
  ADD PRIMARY KEY (`id_producto`),
  ADD KEY `FK8` (`fk_id_proveedor`);

--
-- Indexes for table `tbl_proveedor`
--
ALTER TABLE `tbl_proveedor`
  ADD PRIMARY KEY (`id_proveedor`);

--
-- Indexes for table `tbl_tipo_usuario`
--
ALTER TABLE `tbl_tipo_usuario`
  ADD PRIMARY KEY (`id_tipo_usuario`);

--
-- Indexes for table `tbl_usuario`
--
ALTER TABLE `tbl_usuario`
  ADD PRIMARY KEY (`id_usuario`),
  ADD KEY `FK2` (`fk_id_tipo_usuario`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_cliente`
--
ALTER TABLE `tbl_cliente`
  MODIFY `id_cliente` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_cliente_android`
--
ALTER TABLE `tbl_cliente_android`
  MODIFY `id_cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `tbl_compra`
--
ALTER TABLE `tbl_compra`
  MODIFY `id_compra` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_detalle_factura`
--
ALTER TABLE `tbl_detalle_factura`
  MODIFY `id_detalle_factura` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_estado_pedido`
--
ALTER TABLE `tbl_estado_pedido`
  MODIFY `id_estado_pedido` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `tbl_factura`
--
ALTER TABLE `tbl_factura`
  MODIFY `id_factura` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_pedido`
--
ALTER TABLE `tbl_pedido`
  MODIFY `id_pedido` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `tbl_producto`
--
ALTER TABLE `tbl_producto`
  MODIFY `id_producto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `tbl_proveedor`
--
ALTER TABLE `tbl_proveedor`
  MODIFY `id_proveedor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tbl_tipo_usuario`
--
ALTER TABLE `tbl_tipo_usuario`
  MODIFY `id_tipo_usuario` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_usuario`
--
ALTER TABLE `tbl_usuario`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_compra`
--
ALTER TABLE `tbl_compra`
  ADD CONSTRAINT `FK3` FOREIGN KEY (`fk_id_producto`) REFERENCES `tbl_producto` (`id_producto`);

--
-- Constraints for table `tbl_detalle_factura`
--
ALTER TABLE `tbl_detalle_factura`
  ADD CONSTRAINT `FK5` FOREIGN KEY (`fk_id_producto`) REFERENCES `tbl_producto` (`id_producto`);

--
-- Constraints for table `tbl_factura`
--
ALTER TABLE `tbl_factura`
  ADD CONSTRAINT `FK4` FOREIGN KEY (`fk_id_cliente`) REFERENCES `tbl_cliente` (`id_cliente`);

--
-- Constraints for table `tbl_pedido`
--
ALTER TABLE `tbl_pedido`
  ADD CONSTRAINT `FK6` FOREIGN KEY (`fk_id_producto_pedido`) REFERENCES `tbl_producto` (`id_producto`),
  ADD CONSTRAINT `FK7` FOREIGN KEY (`fk_id_cliente`) REFERENCES `tbl_cliente_android` (`id_cliente`),
  ADD CONSTRAINT `FK9` FOREIGN KEY (`fk_id_estadop`) REFERENCES `tbl_estado_pedido` (`id_estado_pedido`);

--
-- Constraints for table `tbl_producto`
--
ALTER TABLE `tbl_producto`
  ADD CONSTRAINT `FK8` FOREIGN KEY (`fk_id_proveedor`) REFERENCES `tbl_proveedor` (`id_proveedor`);

--
-- Constraints for table `tbl_usuario`
--
ALTER TABLE `tbl_usuario`
  ADD CONSTRAINT `FK2` FOREIGN KEY (`fk_id_tipo_usuario`) REFERENCES `tbl_tipo_usuario` (`id_tipo_usuario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
