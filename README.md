# ApartmentBilling
For Billing between friends


Database Queries
CREATE DATABASE `apartmentbilling` /*!40100 DEFAULT CHARACTER SET utf8 */;
CREATE TABLE `common_expenses` (
  `ID` int(11) NOT NULL,
  `NAME` varchar(45) NOT NULL,
  `AMOUNT` int(11) NOT NULL,
  `SPENTBY` varchar(45) NOT NULL,
  `ENTEREDDATE` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
