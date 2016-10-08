CREATE USER 'payment'@'%' IDENTIFIED BY 'payment';
GRANT ALL PRIVILEGES ON *.* TO 'payment'@'%';

CREATE DATABASE `payment` CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

use payment