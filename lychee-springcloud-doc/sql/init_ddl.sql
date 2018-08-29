CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `role_code` varchar(255) COLLATE utf8_bin NOT NULL,
  `role_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_jqdita2l45v2gglry7bp8kl1f` (`role_code`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `gender` varchar(1) COLLATE utf8_bin NOT NULL,
  `password` varchar(255) COLLATE utf8_bin NOT NULL,
  `user_real_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `username` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_51bvuyvihefoh4kp5syh2jpi4` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `role_code` varchar(255) COLLATE utf8_bin NOT NULL,
  `username` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKdpcww1t3hhjsuxisdjygqps40` (`username`,`role_code`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
