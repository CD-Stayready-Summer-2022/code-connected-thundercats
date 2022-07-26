CREATE TABLE IF NOT EXISTS `education` (
	`id` Integer primary key auto_increment,
    `school_name` varchar(50),
    `location` varchar(50),
    `start_date` varchar(10),
    `end_date` varchar(10),
	`field_of_study` varchar(50),
    `is_graduated` BOOLEAN,
    `grade_point_avg` DOUBLE,
    `user_profile_id` Integer
);