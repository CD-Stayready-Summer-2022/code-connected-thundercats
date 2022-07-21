CREATE TABLE IF NOT EXISTS `message` (
    `id` INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `receiving_user` int,
    `sending_user` int,
    `content` varchar(256),
    `sent_time` TIMESTAMP NULL DEFAULT NULL
)