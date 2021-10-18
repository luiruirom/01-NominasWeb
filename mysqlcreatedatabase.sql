/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`nominas` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `nominas`;

/*Table structure for table `empleados` */

DROP TABLE IF EXISTS `empleados`;

CREATE TABLE empleados (
nombre VARCHAR(30) not null,
dni VARCHAR(9) not null,
sexo CHAR(1) not null,
categoria INT(2) not null,
anyos INT(3) not null,
PRIMARY KEY (`dni`),
CONSTRAINT DNI_EMP_FK FOREIGN KEY (`dni`) REFERENCES nominas(`dni`),
CONSTRAINT SEXO_CHECK CHECK (sexo = 'M' OR sexo = 'F'),
CONSTRAINT CATEGORIA_CHECK CHECK (categoria >=1 AND categoria <=10),
CONSTRAINT ANYOS_CHECK CHECK (anyos >=0)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `nominas` */

DROP TABLE IF EXISTS `empleados`;

CREATE TABLE nominas (
dni VARCHAR(9) not null,  
sueldo INT not null,
PRIMARY KEY (`dni`),
CONSTRAINT DNI_NOM_FK FOREIGN KEY (`dni`) REFERENCES empleados(`dni`) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `empleados` */

insert  into `empleados`(`nombre`,`dni`,`sexo`,`categoria`,`anyos`) values 
('James Cosling','48811600B','M','4 ','7'),
('Ada Lovealace','48814047C','F','1 ','0'),
('Joe Biden','28251761X','M','2 ','5');

