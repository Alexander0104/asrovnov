
CREATE TABLE roles (
	id				    integer PRIMARY KEY,
	name			    varchar(100)
);

CREATE TABLE users (
	id				    integer PRIMARY KEY,
	login			    varchar(100),
	role_id			  integer references roles(id)
);

CREATE TABLE rules (
	id				    integer PRIMARY KEY,
	name 			    varchar(100)
);

CREATE TABLE roles_rules (
	role_id 		  integer references roles(id),
	rule_id			  integer references rules(id)
);

CREATE TABLE category (
	id				    integer PRIMARY KEY,
	name			    varchar(100)
);


CREATE TABLE states (
	id				    integer PRIMARY KEY,
	name			    varchar(100)
);

CREATE TABLE items (
	user_id			  integer PRIMARY KEY references users(id),
	category_id		integer references category(id),
	state_id		  integer references states(id)
);


CREATE TABLE comments (
	id				    integer PRIMARY KEY,
	item_id			  integer references items(user_id),
	description		varchar(100)
);

CREATE TABLE attach (
	id				    integer PRIMARY KEY,
	item_id			  integer references items(user_id),
	file_name		  varchar(100)
);

INSERT INTO rules (id, name) VALUES (1, 'rule_1');

INSERT INTO roles (id, name) VALUES (1, 'programmer');

INSERT INTO users (id, login, role_id) VALUES (1, 'Sasha', 1);

INSERT INTO roles_rules (role_id, rule_id) VALUES (1, 1);

INSERT INTO category (id, name) VALUES (1, 'development');

INSERT INTO states(id, name) VALUES (1, 'new');

INSERT INTO items(user_id, category_id, state_id) VALUES  (1, 1, 1);

INSERT INTO comments(id, item_id, description) VALUES (1, 1, 'new product');

INSERT INTO attach(id, item_id, file_name) VALUES (1, 1, 'sql.txt');