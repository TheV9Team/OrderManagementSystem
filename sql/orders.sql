-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 02, 2018 at 04:17 AM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `els`
--

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE IF NOT EXISTS `orders` (
  `request_number` int(10) NOT NULL AUTO_INCREMENT,
  `description` varchar(50) NOT NULL,
  `item_number` varchar(10) NOT NULL,
  `client` varchar(30) NOT NULL,
  `order_date` date NOT NULL,
  `job_number` varchar(10) NOT NULL,
  `location` varchar(20) NOT NULL,
  `qty` int(10) NOT NULL,
  `deadline` date NOT NULL,
  `to_be_cast` int(10) NOT NULL,
  `delivered_quantity` int(10) NOT NULL,
  `to_be_deliver` int(10) NOT NULL,
  `is_deleted` tinyint(1) NOT NULL,
  PRIMARY KEY (`request_number`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`request_number`, `description`, `item_number`, `client`, `order_date`, `job_number`, `location`, `qty`, `deadline`, `to_be_cast`, `delivered_quantity`, `to_be_deliver`, `is_deleted`) VALUES
(1, 'jndc', 'jjc', 'jn', '2019-09-09', 'd2', 'ffv', 87, '2018-09-07', 87, 0, 87, 0),
(2, 'bjgd', 'njeifj', 'ijioj', '2019-09-04', 'vjj', 'gv', 34, '2017-09-05', 34, 0, 34, 0);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
