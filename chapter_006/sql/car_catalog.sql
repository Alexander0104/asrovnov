
CREATE TABLE car_body (
	id				      SERIAL PRIMARY KEY,
	description		  varchar (100)

);

CREATE TABLE motor (
	id				      SERIAL PRIMARY KEY,
	description		  varchar (100)
);

CREATE TABLE transmission (
	id				      SERIAL PRIMARY KEY,
	description		  varchar (100)
);

CREATE TABLE car (
	id				      SERIAL PRIMARY KEY,
	name			      varchar (100),
	car_body_id		  INTEGER REFERENCES car_body(id),
	motor_id		    INTEGER REFERENCES motor(id),
	transmission_id INTEGER REFERENCES transmission(id)
);


INSERT INTO car_body (description) VALUES ('Sedan');
INSERT INTO car_body (description) VALUES ('Hatchback');

INSERT INTO motor (description) VALUES ('Petrol 1.8T');
INSERT INTO motor (description) VALUES ('Petrol 2.0T');

INSERT INTO transmission (description) VALUES ('AT');
INSERT INTO transmission (description) VALUES ('MT');

INSERT INTO car (name, car_body_id, motor_id, transmission_id) VALUES ('Toyota', 1, 1, 1);
INSERT INTO car (name, car_body_id, motor_id, transmission_id) VALUES ('Honda', 2, 2, 2);


--Вывести все машины
SELECT car.name, c.description, m.description, t.description FROM car
INNER JOIN car_body AS c ON car.car_body_id = c.id
INNER JOIN motor AS m ON car.motor_id = m.id
INNER JOIN transmission AS t ON car.transmission_id = t.id

--Вывести все неиспользуемые детали
SELECT cb.description AS car_body, m.description AS motor, t.description AS transmission FROM car AS c
RIGHT OUTER JOIN car_body AS cb ON c.car_body_id = cb.id
RIGHT OUTER JOIN motor AS m ON c.motor_id = m.id
RIGHT OUTER JOIN transmission AS t ON c.transmission_id = t.id
WHERE c.name IS NULL;
