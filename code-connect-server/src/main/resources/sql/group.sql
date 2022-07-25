CREATE TABLE IF NOT EXISTS `groups` (
    `id` Integer primary key auto_increment,
    `content` varchar(256),
    `owner_id` bigint not null,
    `post_id` Integer
);