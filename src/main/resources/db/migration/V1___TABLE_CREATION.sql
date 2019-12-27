CREATE TABLE `visitor` (
  `id` bigint(100) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `contact_person_email` varchar(255) DEFAULT NULL,
  `contact_person_name` varchar(255) DEFAULT NULL,
   `mobile_no` varchar(255) DEFAULT NULL,
   `contact_person_mobile_no` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `id_proof` varchar(255) DEFAULT NULL,
   `name` varchar(255) DEFAULT NULL,
    `reason_for_visit` varchar(255) DEFAULT NULL,
     `status` int(11) NOT NULL,
   PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1
