CREATE TABLE IF NOT EXISTS `experience` (
	`id` Integer primary key auto_increment,
    `job_title` varchar(50),
    `company` varchar(50),
    `location` varchar(10),
    `start_date` varchar(10),
	`end_date` varchar(50),
    `employment_type` varchar(50),
    `user_profile_id` Integer
);