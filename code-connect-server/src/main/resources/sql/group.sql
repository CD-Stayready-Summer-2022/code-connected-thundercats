CREATE TABLE IF NOT EXISTS `comments` (
    `id` Integer primary key auto_increment,
    `content` varchar(256),
    `user_profile_id` Integer,
    `post_id` Integer
    );