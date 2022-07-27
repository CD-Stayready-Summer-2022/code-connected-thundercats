CREATE TABLE IF NOT EXISTS `groups` (
    `id` Integer primary key auto_increment,
    `content` varchar(256),
    `owner_id` bigint not null,
    `post_id` Integer
);


// NEW \\

CREATE TABLE IF NOT EXISTS `groups`(
	`id` INTEGER PRIMARY KEY AUTO_INCREMENT,
    `name_of_group` varchar(50),
	`user_profile_id` INTEGER
);

\\ NEW  //