DROP TABLE IF EXISTS PERSON;
  
CREATE TABLE PERSON (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(250) NOT NULL,
    last_name VARCHAR(250) NOT NULL,
    age INT NOT NULL,
    favourite_colour VARCHAR(250) DEFAULT NULL
);

CREATE TABLE HOBBY (
    id INT AUTO_INCREMENT PRIMARY KEY,
    hobby_name VARCHAR(600) NOT NULL,
    person_id INT NOT NULL,
    foreign key (person_id) references person(id)
 );