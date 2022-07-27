CREATE DATABASE `code_connect`;

use `code_connect`;

CREATE TABLE IF NOT EXISTS `message` (
                                         `id` INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
                                         `content` varchar(256),
    `date` DATETIME
    );

CREATE TABLE IF NOT EXISTS `posts` (
                                       `id` Integer primary key auto_increment,
                                       `content` varchar(200),
    `publishDate` DATE,
    `likes` Integer,
    `user_profile_id` Integer
    );

CREATE TABLE IF NOT EXISTS `comments` (
                                          `id` Integer primary key auto_increment,
                                          `content` varchar(256),
    `user_profile_id` Integer,
    `post_id` Integer
    );

CREATE TABLE IF NOT EXISTS `userprofiles` (
                                              `id` Integer primary key auto_increment,
                                              `first_name` varchar(50),
    `last_name` varchar(50),
    `email` varchar(50),
    `skills` varchar(50),
    `accomplishments` varchar(50),
    `group_id` Integer
    );

CREATE TABLE IF NOT EXISTS `groups` (
                                        `id` Integer primary key auto_increment,
                                        `content` varchar(256),
    `owner_id` bigint not null,
    `post_id` Integer
    );

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