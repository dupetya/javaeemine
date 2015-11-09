DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;

CREATE TABLE users (
  id bigint NOT NULL PRIMARY KEY,
  dob datetime NOT NULL,
  email varchar(255) NOT NULL,
  pass varchar(255) NOT NULL,
  username varchar(255) NOT NULL,
);

CREATE TABLE roles (
  role_id bigint NOT NULL PRIMARY KEY,
  role_name varchar(255) NOT NULL,
);

CREATE TABLE user_roles (
  user_id bigint NOT NULL,
  role_id bigint NOT NULL,
);


