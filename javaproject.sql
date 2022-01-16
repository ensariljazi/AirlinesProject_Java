-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 16, 2022 at 03:11 AM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `javaproject`
--

-- --------------------------------------------------------

--
-- Table structure for table `agencies`
--

CREATE TABLE `agencies` (
  `id` int(11) NOT NULL,
  `agencyname` varchar(30) NOT NULL,
  `agencynumber` varchar(30) NOT NULL,
  `location` varchar(30) NOT NULL,
  `workers` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `agencies`
--

INSERT INTO `agencies` (`id`, `agencyname`, `agencynumber`, `location`, `workers`) VALUES
(1, 'Fibula', '+38970123124', 'Skopje', 1),
(2, 'Sava Tours', '+38972718193', 'Gostivar', 3),
(3, 'ETC', '+38975555191', 'Skopje', 4);

-- --------------------------------------------------------

--
-- Table structure for table `airlines`
--

CREATE TABLE `airlines` (
  `id` int(11) NOT NULL,
  `companyname` text NOT NULL,
  `flightlist` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `airlines`
--

INSERT INTO `airlines` (`id`, `companyname`, `flightlist`) VALUES
(1, 'WizzAir', NULL),
(2, 'TurkishAirlines', NULL),
(3, 'FlyEmirates', NULL),
(4, 'FlyQatar', NULL),
(5, 'FlyDubai', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `bank`
--

CREATE TABLE `bank` (
  `id` int(11) NOT NULL,
  `cardnumber` varchar(20) NOT NULL,
  `ccv` varchar(5) NOT NULL,
  `balance` double NOT NULL,
  `costumerID` int(11) DEFAULT NULL,
  `type` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bank`
--

INSERT INTO `bank` (`id`, `cardnumber`, `ccv`, `balance`, `costumerID`, `type`) VALUES
(1, '1427812631289736', '123', 100, 2, 'Visa'),
(2, '21312541251231623', '213', 100, 3, 'Debit'),
(5, '12312453215321324', '123', 4123, 3, 'MasterCale'),
(6, '1235412352361', '1233', 1076, 1, 'ciniPay'),
(7, '1231241231341234', '123', 231, 1, 'MiraxhVersion');

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `id` int(11) NOT NULL,
  `name` varchar(15) NOT NULL,
  `surname` varchar(15) NOT NULL,
  `embg` text NOT NULL,
  `to_pay` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`id`, `name`, `surname`, `embg`, `to_pay`) VALUES
(1, 'Miraxh', 'Etemi', '22443', 0),
(2, 'Jasin', 'Etemi', '12443', 0),
(3, 'Ensar', 'Iljazi', '12849', 0),
(5, 'Idriz', 'Seferi', '2334594291', 0);

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

CREATE TABLE `employees` (
  `id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `surname` varchar(20) NOT NULL,
  `embg` varchar(20) NOT NULL,
  `works_at` int(11) DEFAULT NULL,
  `age` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employees`
--

INSERT INTO `employees` (`id`, `name`, `surname`, `embg`, `works_at`, `age`) VALUES
(1, 'Besim', 'Gashi', '123456', 1, 25),
(3, 'Miraxh', 'Lika', '569856', 2, 21),
(4, 'Julia', 'Bobna', '659874', 3, 20);

-- --------------------------------------------------------

--
-- Table structure for table `flights`
--

CREATE TABLE `flights` (
  `id` int(11) NOT NULL,
  `ticket_number` text NOT NULL,
  `destination` varchar(35) NOT NULL,
  `reservationID` int(11) DEFAULT NULL,
  `bookingFlightID` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `departure` varchar(30) DEFAULT NULL,
  `agencyflights` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `flights`
--

INSERT INTO `flights` (`id`, `ticket_number`, `destination`, `reservationID`, `bookingFlightID`, `price`, `departure`, `agencyflights`) VALUES
(1, '12345', 'Skopje', 1, 2, 100, '02.02.2022 / 22:05', 1),
(4, '72181', 'Milano, Italy', 5, 2, 44.99, '11.03.2022 / 1:00', 1),
(5, '231811', 'Dubai, Saudi Arabia', 1, 1, 44, '30.03.2022 / 3:00', 2),
(6, '12312', 'Antalya, Turkey', 2, 3, 88, '13.09.2021 / 2:00', 3);

-- --------------------------------------------------------

--
-- Table structure for table `flightspends`
--

CREATE TABLE `flightspends` (
  `id` int(11) NOT NULL,
  `numberofflights` int(11) NOT NULL,
  `sumofspends` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `flightspends`
--

INSERT INTO `flightspends` (`id`, `numberofflights`, `sumofspends`) VALUES
(1, 3, 200);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `agencies`
--
ALTER TABLE `agencies`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_workers` (`workers`);

--
-- Indexes for table `airlines`
--
ALTER TABLE `airlines`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_flightsmode` (`flightlist`);

--
-- Indexes for table `bank`
--
ALTER TABLE `bank`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_customerid` (`costumerID`);

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_employees` (`works_at`);

--
-- Indexes for table `flights`
--
ALTER TABLE `flights`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_reservations` (`reservationID`),
  ADD KEY `fk_bookingFlights` (`bookingFlightID`),
  ADD KEY `fk_agency` (`agencyflights`);

--
-- Indexes for table `flightspends`
--
ALTER TABLE `flightspends`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `agencies`
--
ALTER TABLE `agencies`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `airlines`
--
ALTER TABLE `airlines`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `bank`
--
ALTER TABLE `bank`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `customers`
--
ALTER TABLE `customers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `employees`
--
ALTER TABLE `employees`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `flights`
--
ALTER TABLE `flights`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `flightspends`
--
ALTER TABLE `flightspends`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `agencies`
--
ALTER TABLE `agencies`
  ADD CONSTRAINT `FK_workers` FOREIGN KEY (`workers`) REFERENCES `employees` (`id`);

--
-- Constraints for table `bank`
--
ALTER TABLE `bank`
  ADD CONSTRAINT `FK_customerid` FOREIGN KEY (`costumerID`) REFERENCES `customers` (`id`);

--
-- Constraints for table `employees`
--
ALTER TABLE `employees`
  ADD CONSTRAINT `FK_employees` FOREIGN KEY (`works_at`) REFERENCES `agencies` (`id`);

--
-- Constraints for table `flights`
--
ALTER TABLE `flights`
  ADD CONSTRAINT `FK_reservations` FOREIGN KEY (`reservationID`) REFERENCES `airlines` (`id`),
  ADD CONSTRAINT `fk_agency` FOREIGN KEY (`agencyflights`) REFERENCES `agencies` (`id`),
  ADD CONSTRAINT `fk_bookingFlights` FOREIGN KEY (`bookingFlightID`) REFERENCES `customers` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
