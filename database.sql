CREATE TABLE `users` (
`id` int NOT NULL,
`email` varchar(255) NULL,
`password` varchar(255) NULL,
`role` varchar(255) NULL,
`status` varchar(255) NULL,
PRIMARY KEY (`id`) 
);

CREATE TABLE `bills` (
`id` int NOT NULL,
`date` date NULL,
`time` time NULL,
`products` varchar(255) NULL,
`total` float(255,0) NULL,
PRIMARY KEY (`id`) 
);

CREATE TABLE `products` (
`id` int NOT NULL,
`name` varchar(255) NULL,
`date` date NULL,
`price` float(10,2) NULL,
`stock` int(255) NULL,
`description` varchar(255) NULL,
`category` int NULL,
PRIMARY KEY (`id`) 
);

CREATE TABLE `reports` (
`id` int NOT NULL,
`products` varchar(255) NULL,
`description` varchar(255) NULL,
PRIMARY KEY (`id`) 
);

CREATE TABLE `categories` (
`id` int NOT NULL,
`name` varchar(255) NULL,
PRIMARY KEY (`id`) 
);


ALTER TABLE `products` ADD CONSTRAINT `relation_prodcut_category` FOREIGN KEY (`category`) REFERENCES `categories` (`id`);

