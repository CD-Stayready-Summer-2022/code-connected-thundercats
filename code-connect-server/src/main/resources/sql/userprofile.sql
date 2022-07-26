CREATE TABLE IF NOT EXISTS `userprofiles` (
    `id` Integer primary key auto_increment,
    `first_name` varchar(50),
    `last_name` varchar(50),
    `email` varchar(50),
    `skills` varchar(50),
    `accomplishments` varchar(50),
    `group_id` Integer
    );