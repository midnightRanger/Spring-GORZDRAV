-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1:3306
-- Время создания: Дек 07 2022 г., 04:26
-- Версия сервера: 8.0.30
-- Версия PHP: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `GORZDRAV`
--
CREATE DATABASE IF NOT EXISTS `GORZDRAV` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE `GORZDRAV`;

-- --------------------------------------------------------

--
-- Структура таблицы `address`
--

CREATE TABLE `address` (
  `uid` bigint NOT NULL,
  `building` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `city` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `metro` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `street` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп данных таблицы `address`
--

INSERT INTO `address` (`uid`, `building`, `city`, `metro`, `street`) VALUES
(26, 'стр. 1', 'Москва', NULL, 'пр. Дежнева');

-- --------------------------------------------------------

--
-- Структура таблицы `course`
--

CREATE TABLE `course` (
  `uid` bigint NOT NULL,
  `end` date DEFAULT NULL,
  `expected_result` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `start` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп данных таблицы `course`
--

INSERT INTO `course` (`uid`, `end`, `expected_result`, `start`) VALUES
(1, '2022-12-05', 'Спина перестанет болеть', '2022-12-01'),
(25, '2001-05-05', 'Нормальный курс', '2002-02-02');

-- --------------------------------------------------------

--
-- Структура таблицы `course_pils`
--

CREATE TABLE `course_pils` (
  `pills_id` bigint NOT NULL,
  `course_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп данных таблицы `course_pils`
--

INSERT INTO `course_pils` (`pills_id`, `course_id`) VALUES
(1, 1),
(2, 1),
(1, 25),
(2, 25);

-- --------------------------------------------------------

--
-- Структура таблицы `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп данных таблицы `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(28);

-- --------------------------------------------------------

--
-- Структура таблицы `medical_card`
--

CREATE TABLE `medical_card` (
  `uid` bigint NOT NULL,
  `date_of_the_birth` date DEFAULT NULL,
  `height` double NOT NULL,
  `snils` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `weight` double NOT NULL,
  `polyclinic_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `polyclinic_uid` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп данных таблицы `medical_card`
--

INSERT INTO `medical_card` (`uid`, `date_of_the_birth`, `height`, `snils`, `weight`, `polyclinic_id`, `user_id`, `polyclinic_uid`) VALUES
(16, '2003-02-01', 169.99, '213123', 12312, NULL, 8, NULL),
(17, '2001-02-01', 500, '31231', 213, NULL, 13, NULL),
(18, '2001-05-01', 100.2, '31213', 213, NULL, 15, NULL);

-- --------------------------------------------------------

--
-- Структура таблицы `medical_procedure`
--

CREATE TABLE `medical_procedure` (
  `uid` bigint NOT NULL,
  `cost` double NOT NULL,
  `description` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп данных таблицы `medical_procedure`
--

INSERT INTO `medical_procedure` (`uid`, `cost`, `description`, `name`) VALUES
(1, 300, 'Обычный осмотр, вам постучат по коленке, заставят показать язык', 'Первичный осмотр'),
(24, 30, 'Очень неприятная', 'Гастэроскопия');

-- --------------------------------------------------------

--
-- Структура таблицы `passport`
--

CREATE TABLE `passport` (
  `uid` bigint NOT NULL,
  `given` date DEFAULT NULL,
  `number` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `series` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп данных таблицы `passport`
--

INSERT INTO `passport` (`uid`, `given`, `number`, `series`) VALUES
(9, '2001-11-12', '4578', '23131'),
(10, '2003-02-01', '321312', '4578'),
(12, '2001-02-01', '31231', '31231'),
(14, '2003-02-01', '321313213', '32131');

-- --------------------------------------------------------

--
-- Структура таблицы `pill`
--

CREATE TABLE `pill` (
  `uid` bigint NOT NULL,
  `contra` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `cost` double NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `norm_day` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп данных таблицы `pill`
--

INSERT INTO `pill` (`uid`, `contra`, `cost`, `name`, `norm_day`) VALUES
(1, 'НЕ ПИТЬ ПОЖИЛЫМ ДЕТЯМ', 130, 'ФЕНИБУТОМОКСАЦЕЛЛИН', '5 мг'),
(2, 'ПИТЬ ТОЛЬКО ПРИ НЕХВАТКЕ ПИВА В ОРГАНИЗМЕ', 130, 'ПИВНАЯ ТАБЛЕТКА (таблетка с пивом)', '500 л');

-- --------------------------------------------------------

--
-- Структура таблицы `polyclinic`
--

CREATE TABLE `polyclinic` (
  `uid` bigint NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `polyclinic_id` bigint DEFAULT NULL,
  `address_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп данных таблицы `polyclinic`
--

INSERT INTO `polyclinic` (`uid`, `name`, `polyclinic_id`, `address_id`) VALUES
(27, 'государственная им. Сеченова', NULL, 26);

-- --------------------------------------------------------

--
-- Структура таблицы `polyclinic_type`
--

CREATE TABLE `polyclinic_type` (
  `polyclinic_id` bigint NOT NULL,
  `types` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп данных таблицы `polyclinic_type`
--

INSERT INTO `polyclinic_type` (`polyclinic_id`, `types`) VALUES
(27, 'FREE');

-- --------------------------------------------------------

--
-- Структура таблицы `record`
--

CREATE TABLE `record` (
  `uid` bigint NOT NULL,
  `complaint` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `date` date DEFAULT NULL,
  `doctor_uid` bigint DEFAULT NULL,
  `medical_card_uid` bigint DEFAULT NULL,
  `patient_uid` bigint DEFAULT NULL,
  `procedure_uid` bigint DEFAULT NULL,
  `medical_procedure_uid` bigint DEFAULT NULL,
  `is_opened` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп данных таблицы `record`
--

INSERT INTO `record` (`uid`, `complaint`, `date`, `doctor_uid`, `medical_card_uid`, `patient_uid`, `procedure_uid`, `medical_procedure_uid`, `is_opened`) VALUES
(19, 'Болит спина - UPD', '2004-01-05', 15, 16, 8, NULL, 1, b'1');

-- --------------------------------------------------------

--
-- Структура таблицы `result`
--

CREATE TABLE `result` (
  `uid` bigint NOT NULL,
  `anamnesis` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `course_uid` bigint DEFAULT NULL,
  `record_uid` bigint DEFAULT NULL,
  `status_uid` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп данных таблицы `result`
--

INSERT INTO `result` (`uid`, `anamnesis`, `course_uid`, `record_uid`, `status_uid`) VALUES
(23, 'В возрасте 15 лет у пациента был поставлен редкий диагноз \"LIGMABALLS-19\", что отразилось на состоянии его спины.', 1, 19, 22);

-- --------------------------------------------------------

--
-- Структура таблицы `status`
--

CREATE TABLE `status` (
  `uid` bigint NOT NULL,
  `eyes` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `final_conclusion` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `pulse` double NOT NULL,
  `systolic` double NOT NULL,
  `diastolic` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп данных таблицы `status`
--

INSERT INTO `status` (`uid`, `eyes`, `final_conclusion`, `pulse`, `systolic`, `diastolic`) VALUES
(22, 'Голубые', 'Все зашибись', 40, 150, 40);

-- --------------------------------------------------------

--
-- Структура таблицы `user`
--

CREATE TABLE `user` (
  `uid` bigint NOT NULL,
  `active` bit(1) NOT NULL,
  `middlename` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `surname` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `username` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `passport_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп данных таблицы `user`
--

INSERT INTO `user` (`uid`, `active`, `middlename`, `name`, `password`, `surname`, `username`, `passport_id`) VALUES
(8, b'1', 'user', 'user', '$2a$08$CeAE8k2heta46.iPM6q4su29iXA8or6Ymma96u46Zn8qA0/fHGMA.', 'user', 'user', NULL),
(13, b'0', '32131', '3123', '12312312', '31231', '31231', NULL),
(15, b'0', '31231', '31231', '321312', '31231', '2131321', 14);

-- --------------------------------------------------------

--
-- Структура таблицы `user_role`
--

CREATE TABLE `user_role` (
  `user_id` bigint NOT NULL,
  `roles` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп данных таблицы `user_role`
--

INSERT INTO `user_role` (`user_id`, `roles`) VALUES
(8, 'USER'),
(15, 'DOCTOR');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`uid`);

--
-- Индексы таблицы `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`uid`);

--
-- Индексы таблицы `course_pils`
--
ALTER TABLE `course_pils`
  ADD KEY `FKj6tqlwgwmyde1m737ytnxfs90` (`course_id`),
  ADD KEY `FKsmh7skmsx71ovwgq198taov04` (`pills_id`);

--
-- Индексы таблицы `medical_card`
--
ALTER TABLE `medical_card`
  ADD PRIMARY KEY (`uid`),
  ADD KEY `FKh9g5nyhkx9q44m1dha1cvim1a` (`polyclinic_id`),
  ADD KEY `FKciupcvcakeu91hk9vrmxpjklg` (`user_id`),
  ADD KEY `FKabd258de0sv9o23wa45ci3vxr` (`polyclinic_uid`);

--
-- Индексы таблицы `medical_procedure`
--
ALTER TABLE `medical_procedure`
  ADD PRIMARY KEY (`uid`);

--
-- Индексы таблицы `passport`
--
ALTER TABLE `passport`
  ADD PRIMARY KEY (`uid`);

--
-- Индексы таблицы `pill`
--
ALTER TABLE `pill`
  ADD PRIMARY KEY (`uid`);

--
-- Индексы таблицы `polyclinic`
--
ALTER TABLE `polyclinic`
  ADD PRIMARY KEY (`uid`),
  ADD KEY `FKf5k7udyj14ex38jmw4xfee9jm` (`polyclinic_id`),
  ADD KEY `FKgpm1f7nxpsmfla3r8sb9a5ajg` (`address_id`);

--
-- Индексы таблицы `polyclinic_type`
--
ALTER TABLE `polyclinic_type`
  ADD KEY `FK6cy8ig3rhy8l00vncwhu91jq0` (`polyclinic_id`);

--
-- Индексы таблицы `record`
--
ALTER TABLE `record`
  ADD PRIMARY KEY (`uid`),
  ADD KEY `FKfc4j2rb2vjec2ff7v09pelpob` (`doctor_uid`),
  ADD KEY `FK1isgdsikqavpuljtp4a7cdedj` (`medical_card_uid`),
  ADD KEY `FKuewmbrooapjeryd07ew59anv` (`patient_uid`),
  ADD KEY `FKeg0g2e47hkfcfpi6u2rf8uf5t` (`medical_procedure_uid`);

--
-- Индексы таблицы `result`
--
ALTER TABLE `result`
  ADD PRIMARY KEY (`uid`),
  ADD KEY `FK62uvlftxejxnhaks19rat3pue` (`course_uid`),
  ADD KEY `FK7m8c63e67xsmn6vumlfvilb9r` (`record_uid`),
  ADD KEY `FK3bk3rg2nlxxm0e0agbun2735l` (`status_uid`);

--
-- Индексы таблицы `status`
--
ALTER TABLE `status`
  ADD PRIMARY KEY (`uid`);

--
-- Индексы таблицы `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`uid`),
  ADD KEY `FKenccdllmxulvaroj0sehh63na` (`passport_id`);

--
-- Индексы таблицы `user_role`
--
ALTER TABLE `user_role`
  ADD KEY `FK859n2jvi8ivhui0rl0esws6o` (`user_id`);

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `course_pils`
--
ALTER TABLE `course_pils`
  ADD CONSTRAINT `FKj6tqlwgwmyde1m737ytnxfs90` FOREIGN KEY (`course_id`) REFERENCES `course` (`uid`),
  ADD CONSTRAINT `FKsmh7skmsx71ovwgq198taov04` FOREIGN KEY (`pills_id`) REFERENCES `pill` (`uid`);

--
-- Ограничения внешнего ключа таблицы `medical_card`
--
ALTER TABLE `medical_card`
  ADD CONSTRAINT `FKabd258de0sv9o23wa45ci3vxr` FOREIGN KEY (`polyclinic_uid`) REFERENCES `polyclinic` (`uid`),
  ADD CONSTRAINT `FKciupcvcakeu91hk9vrmxpjklg` FOREIGN KEY (`user_id`) REFERENCES `user` (`uid`),
  ADD CONSTRAINT `FKh9g5nyhkx9q44m1dha1cvim1a` FOREIGN KEY (`polyclinic_id`) REFERENCES `polyclinic` (`uid`);

--
-- Ограничения внешнего ключа таблицы `polyclinic`
--
ALTER TABLE `polyclinic`
  ADD CONSTRAINT `FKf5k7udyj14ex38jmw4xfee9jm` FOREIGN KEY (`polyclinic_id`) REFERENCES `address` (`uid`),
  ADD CONSTRAINT `FKgpm1f7nxpsmfla3r8sb9a5ajg` FOREIGN KEY (`address_id`) REFERENCES `address` (`uid`);

--
-- Ограничения внешнего ключа таблицы `polyclinic_type`
--
ALTER TABLE `polyclinic_type`
  ADD CONSTRAINT `FK6cy8ig3rhy8l00vncwhu91jq0` FOREIGN KEY (`polyclinic_id`) REFERENCES `polyclinic` (`uid`);

--
-- Ограничения внешнего ключа таблицы `record`
--
ALTER TABLE `record`
  ADD CONSTRAINT `FK1isgdsikqavpuljtp4a7cdedj` FOREIGN KEY (`medical_card_uid`) REFERENCES `medical_card` (`uid`),
  ADD CONSTRAINT `FKeg0g2e47hkfcfpi6u2rf8uf5t` FOREIGN KEY (`medical_procedure_uid`) REFERENCES `medical_procedure` (`uid`),
  ADD CONSTRAINT `FKfc4j2rb2vjec2ff7v09pelpob` FOREIGN KEY (`doctor_uid`) REFERENCES `user` (`uid`),
  ADD CONSTRAINT `FKuewmbrooapjeryd07ew59anv` FOREIGN KEY (`patient_uid`) REFERENCES `user` (`uid`);

--
-- Ограничения внешнего ключа таблицы `result`
--
ALTER TABLE `result`
  ADD CONSTRAINT `FK3bk3rg2nlxxm0e0agbun2735l` FOREIGN KEY (`status_uid`) REFERENCES `status` (`uid`),
  ADD CONSTRAINT `FK62uvlftxejxnhaks19rat3pue` FOREIGN KEY (`course_uid`) REFERENCES `course` (`uid`),
  ADD CONSTRAINT `FK7m8c63e67xsmn6vumlfvilb9r` FOREIGN KEY (`record_uid`) REFERENCES `record` (`uid`);

--
-- Ограничения внешнего ключа таблицы `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `FKenccdllmxulvaroj0sehh63na` FOREIGN KEY (`passport_id`) REFERENCES `passport` (`uid`);

--
-- Ограничения внешнего ключа таблицы `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`uid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
