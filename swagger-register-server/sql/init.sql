CREATE DATABASE `swagger_register_server`;

USE `swagger_register_server`;

CREATE TABLE `group_info` (
                              `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
                              `name` varchar(64) NOT NULL COMMENT 'groupName',
                              `location` varchar(128) NOT NULL COMMENT 'location',
                              `version` varchar(16) NOT NULL COMMENT 'version',
                              `url` varchar(128) NOT NULL COMMENT 'url',
                              `app_name` varchar(64) DEFAULT NULL COMMENT '服务名（spring.application.name）',
                              `gateway` varchar(64) DEFAULT NULL COMMENT '网关，无则不填',
                              PRIMARY KEY (`id`),
                              UNIQUE KEY `group_info_name` (`name`) COMMENT 'group name唯一',
                              UNIQUE KEY `group_info_app_name` (`app_name`) COMMENT 'appname唯一'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `swagger_json` (
                                `id` int(11) NOT NULL AUTO_INCREMENT,
                                `group_name` varchar(64) NOT NULL,
                                `content` longtext NOT NULL COMMENT 'swagger具体信息',
                                PRIMARY KEY (`id`),
                                UNIQUE KEY `swagger_json_groupname` (`group_name`) COMMENT 'groupName唯一'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

insert  into `group_info`(`id`,`name`,`location`,`version`,`url`,`app_name`,`gateway`) values
(1,'swagger注册中心','/v2/api-docs?group=swagger注册中心','2.0','/v2/api-docs?group=swagger注册中心','swagger-register-server',NULL);
