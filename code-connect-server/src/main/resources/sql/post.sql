CREATE TABLE IF NOT EXISTS `posts` (
	`id` Integer primary key auto_increment,
    `content` varchar(200),
    `publishDate` DATE,
    `likes` Integer,
    `user_profile_id` Integer
);

 /* publishDate type might be changed */