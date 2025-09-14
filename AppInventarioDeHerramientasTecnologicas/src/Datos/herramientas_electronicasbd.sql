-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-11-2024 a las 03:31:36
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `herramientas electronicasbd`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `herramientas`
--

CREATE TABLE `herramientas` (
  `id` int(11) NOT NULL,
  `codigo` decimal(10,2) DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `precio` decimal(10,2) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `herramientas`
--

INSERT INTO `herramientas` (`id`, `codigo`, `nombre`, `precio`, `cantidad`) VALUES
(1, 200001.00, 'Multímetro Digital Pro', 52000.00, 11),
(2, 200002.00, 'Osciloscopio', 5400.00, 12),
(3, 200003.00, 'Fuente de Alimentación', 5600.00, 13),
(4, 200004.00, 'Analizador Lógico', 5800.00, 14),
(5, 200005.00, 'Estación de Soldadura', 6000.00, 15),
(6, 200006.00, 'Generador de Señales', 6200.00, 16),
(7, 200007.00, 'Probador de Circuitos', 6400.00, 17),
(8, 200008.00, 'Cámara Térmica', 6600.00, 18),
(9, 200009.00, 'Medidor de Campo Electromagnético', 6800.00, 19),
(10, 200010.00, 'Analizador de Espectro', 7000.00, 20),
(11, 200011.00, 'Sonda de Corriente', 7200.00, 21),
(12, 200012.00, 'Medidor de Capacitancia', 7400.00, 22),
(13, 200013.00, 'Medidor de Inductancia', 7600.00, 23),
(14, 200014.00, 'Calibrador de Presión', 7800.00, 24),
(15, 200015.00, 'Medidor de Resistencia de Aislamiento', 8000.00, 25),
(16, 200016.00, 'Analizador de Potencia', 8200.00, 26),
(17, 200017.00, 'Medidor de Impedancia', 8400.00, 27),
(18, 200018.00, 'Comprobador de Redes', 8600.00, 28),
(19, 200019.00, 'Medidor de Distorsión Armónica', 8800.00, 29),
(20, 200020.00, 'Analizador Vectorial', 9000.00, 30),
(21, 200021.00, 'Medidor de RF', 9200.00, 31),
(22, 200022.00, 'Probador de Transistores', 9400.00, 32),
(23, 200023.00, 'Generador de Funciones Arbitrarias', 9600.00, 33),
(24, 200024.00, 'Medidor de Luz', 9800.00, 34),
(25, 200025.00, 'Medidor de Sonido', 10000.00, 35),
(26, 200026.00, 'Pinza Amperimétrica', 10200.00, 36),
(27, 200027.00, 'Trazador de Curvas', 10400.00, 37),
(28, 200028.00, 'Medidor de Frecuencia', 10600.00, 38),
(29, 200029.00, 'Probador de Diodos', 10800.00, 39),
(30, 200030.00, 'Analizador de Redes', 11000.00, 40),
(31, 200031.00, 'Medidor de Fugas de Corriente', 11200.00, 41),
(32, 200032.00, 'Medidor de Microondas', 11400.00, 42),
(33, 200033.00, 'Calibrador de Temperatura', 11600.00, 43),
(34, 200034.00, 'Oscilador de Cristal', 11800.00, 44),
(35, 200035.00, 'Detector de Humedad', 12000.00, 45),
(36, 200036.00, 'Medidor de Voltaje RMS', 12200.00, 46),
(37, 200037.00, 'Probador de Continuidad', 12400.00, 47),
(38, 200038.00, 'Probador de Capacidad de Baterías', 12600.00, 48),
(39, 200039.00, 'Medidor de Coeficiente de Reflejo', 12800.00, 49),
(40, 200040.00, 'Generador de Ruido', 13000.00, 50);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `apellido` varchar(50) DEFAULT NULL,
  `num_cedula` varchar(20) DEFAULT NULL,
  `correo` varchar(100) DEFAULT NULL,
  `contraseña` varchar(100) DEFAULT NULL,
  `num_telefono` varchar(15) DEFAULT NULL,
  `saldo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `nombre`, `apellido`, `num_cedula`, `correo`, `contraseña`, `num_telefono`, `saldo`) VALUES
(1, 'mauricio', 'fonck', '1051736741', 'mauro@gmail.com', '0109', '3215017983', '20000000');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `herramientas`
--
ALTER TABLE `herramientas`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `num_cedula` (`num_cedula`),
  ADD UNIQUE KEY `correo` (`correo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `herramientas`
--
ALTER TABLE `herramientas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
