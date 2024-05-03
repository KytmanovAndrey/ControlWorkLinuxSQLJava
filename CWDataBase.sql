--   Создать таблицы, соответствующие иерархии из вашей диаграммы классов.
--   Заполнить таблицы данными о животных, их командах и датами рождения.

DROP DATABASE IF EXISTS human_friends;
CREATE DATABASE human_friends;
USE human_friends;

DROP TABLE IF EXISTS HumanFriends;
CREATE TABLE HumanFriends (
id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
name VARCHAR(45) NOT NULL,
type VARCHAR(45) NOT NULL,
dateOfBirth DATE NOT NULL,
commands VARCHAR(200));

INSERT INTO HumanFriends (name, type, dateOfBirth, commands) VALUES
('Fido', 'Dog', '2020-01-01', 'Sit, Stay, Fetch'),
('Buddy', 'Dog', '2018-12-10', 'Sit, Paw, Bark'),
('Bella', 'Dog', '2019-11-11', 'Sit, Stay, Roll'),
('Whiskers', 'Cat', '2019-05-15', 'Sit, Pounce'),
('Smudge', 'Cat', '2020-02-20', 'Sit, Pounce, Scratch'),
('Oliver', 'Cat', '2020-06-30', 'Meow, Scratch, Jump'),
('Hammy', 'Hamster', '2021-03-10', 'Roll, Hide'),
('Peanut', 'Hamster', '2021-08-01', 'Roll, Spin'),
('Thunder',	'Horse',    '2015-07-21',	'Trot, Canter, Gallop'),
('Storm',	'Horse',	'2014-05-05',	'Trot, Canter'),
('Blaze',	'Horse',	'2016-02-29',	'Trot, Jump, Gallop'),
('Sandy',	'Camel',	'2016-11-03',	'Walk, Carry Load'),
('Dune',	'Camel',	'2018-12-12',	'Walk, Sit'),
('Sahara',	'Camel',	'2015-08-14',	'Walk, Run'),
('Eeyore',	'Donkey',	'2017-09-18',	'Walk, Carry Load, Bray'),
('Burro',	'Donkey',	'2019-01-23',	'Walk, Bray, Kick');

DROP TABLE IF EXISTS Dogs;
CREATE TABLE Dogs (
AnimalId INT NOT NULL,
name VARCHAR(45) NOT NULL,
type VARCHAR(45) NOT NULL,
dateOfBirth DATE NOT NULL,
commands VARCHAR(200),
FOREIGN KEY (AnimalId) REFERENCES HumanFriends(id) ON UPDATE CASCADE ON DELETE CASCADE);

INSERT INTO Dogs  
SELECT * FROM HumanFriends
WHERE type = 'Dog';

DROP TABLE IF EXISTS Cats;
CREATE TABLE Cats (
AnimalId INT NOT NULL,
name VARCHAR(45) NOT NULL,
type VARCHAR(45) NOT NULL,
dateOfBirth DATE NOT NULL,
commands VARCHAR(200),
FOREIGN KEY (AnimalId) REFERENCES HumanFriends(id) ON UPDATE CASCADE ON DELETE CASCADE);

INSERT INTO Cats  
SELECT * FROM HumanFriends
WHERE type = 'Cat';

DROP TABLE IF EXISTS Hamsters;
CREATE TABLE Hamsters (
AnimalId INT NOT NULL,
name VARCHAR(45) NOT NULL,
type VARCHAR(45) NOT NULL,
dateOfBirth DATE NOT NULL,
commands VARCHAR(200),
FOREIGN KEY (AnimalId) REFERENCES HumanFriends(id) ON UPDATE CASCADE ON DELETE CASCADE);

INSERT INTO Hamsters  
SELECT * FROM HumanFriends
WHERE type = 'Hamster';

DROP TABLE IF EXISTS Horses;
CREATE TABLE Horses (
AnimalId INT NOT NULL,
name VARCHAR(45) NOT NULL,
type VARCHAR(45) NOT NULL,
dateOfBirth DATE NOT NULL,
commands VARCHAR(200),
FOREIGN KEY (AnimalId) REFERENCES HumanFriends(id) ON UPDATE CASCADE ON DELETE CASCADE);

INSERT INTO Horses  
SELECT * FROM HumanFriends
WHERE type = 'Horse';

DROP TABLE IF EXISTS Camels;
CREATE TABLE Camels (
AnimalId INT NOT NULL,
name VARCHAR(45) NOT NULL,
type VARCHAR(45) NOT NULL,
dateOfBirth DATE NOT NULL,
commands VARCHAR(200),
FOREIGN KEY (AnimalId) REFERENCES HumanFriends(id) ON UPDATE CASCADE ON DELETE CASCADE);

INSERT INTO Camels 
SELECT * FROM HumanFriends
WHERE type = 'Camel';

DROP TABLE IF EXISTS Donkeys;
CREATE TABLE Donkeys (
AnimalId INT NOT NULL,
name VARCHAR(45) NOT NULL,
type VARCHAR(45) NOT NULL,
dateOfBirth DATE NOT NULL,
commands VARCHAR(200),
FOREIGN KEY (AnimalId) REFERENCES HumanFriends(id) ON UPDATE CASCADE ON DELETE CASCADE);

INSERT INTO Donkeys  
SELECT * FROM HumanFriends
WHERE type = 'Donkey';

DROP TABLE IF EXISTS Pets;
CREATE TABLE Pets (
AnimalId INT NOT NULL,
name VARCHAR(45) NOT NULL,
type VARCHAR(45) NOT NULL,
dateOfBirth DATE NOT NULL,
commands VARCHAR(200),
FOREIGN KEY (AnimalId) REFERENCES HumanFriends(id) ON UPDATE CASCADE ON DELETE CASCADE);

INSERT INTO Pets  
SELECT * FROM HumanFriends
WHERE type = 'Cat' OR type ='Dog' OR type = 'Hamster';

DROP TABLE IF EXISTS PackAnimals;
CREATE TABLE PackAnimals (
AnimalId INT NOT NULL,
name VARCHAR(45) NOT NULL,
type VARCHAR(45) NOT NULL,
dateOfBirth DATE NOT NULL,
commands VARCHAR(200),
FOREIGN KEY (AnimalId) REFERENCES HumanFriends(id) ON UPDATE CASCADE ON DELETE CASCADE);

INSERT INTO PackAnimals 
SELECT * FROM HumanFriends
WHERE type = 'Horse' OR type = 'Camel' OR type = 'Donkey';

SELECT * FROM HumanFriends;
SELECT * FROM Pets;
SELECT * FROM PackAnimals;
SELECT * FROM Dogs;
SELECT * FROM Cats;
SELECT * FROM Hamsters;
SELECT * FROM Horses;
SELECT * FROM Camels;
SELECT * FROM Donkeys;

--  Удалить записи о верблюдах и объединить таблицы лошадей и ослов.

SET SQL_SAFE_UPDATES = 0;
DELETE FROM HumanFriends WHERE type = 'Camel';
SET SQL_SAFE_UPDATES = 1;

SELECT * FROM horses
UNION ALL
SELECT * FROM donkeys;

--  Создать новую таблицу для животных в возрасте от 1 до 3 лет и вычислить их возраст с точностью до месяца.

DROP TABLE IF EXISTS Animals1To3Years;
CREATE TABLE Animals1To3Years (
AnimalId INT NOT NULL,
name VARCHAR(45) NOT NULL,
type VARCHAR(45) NOT NULL,
dateOfBirth DATE NOT NULL,
commands VARCHAR(200),
age_month INT,
FOREIGN KEY (AnimalId) REFERENCES HumanFriends(id) ON UPDATE CASCADE ON DELETE CASCADE);

INSERT INTO Animals1To3Years 
SELECT *, TIMESTAMPDIFF(MONTH, dateOfBirth, CURDATE()) FROM HumanFriends
WHERE dateOfBirth BETWEEN DATE_SUB(CURDATE(), INTERVAL 3 YEAR) AND DATE_SUB(CURDATE(), INTERVAL 1 YEAR);

SELECT * FROM Animals1To3Years;

-- Объединить все созданные таблицы в одну, сохраняя информацию о принадлежности к исходным таблицам.

SELECT * FROM HumanFriends hf
LEFT JOIN Pets ON hf.id = Pets.AnimalId
LEFT JOIN PackAnimals ON hf.id = PackAnimals.AnimalId
LEFT JOIN Dogs ON hf.id = Dogs.AnimalId
LEFT JOIN Cats ON hf.id = Cats.AnimalId
LEFT JOIN Hamsters ON hf.id = Hamsters.AnimalId
LEFT JOIN Horses ON hf.id = Horses.AnimalId
LEFT JOIN Camels ON hf.id = Camels.AnimalId
LEFT JOIN Donkeys ON hf.id = Donkeys.AnimalId
LEFT JOIN Animals1To3Years ON hf.id = Animals1To3Years.AnimalId;




