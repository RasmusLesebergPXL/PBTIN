-- create database pxldb;
-- \c pxldb

-- create user secadv with password 'ilovesecurity';
-- grant all privileges on database pxldb to secadv;
-- BEGIN;

-- create table users (id serial primary key, user_name text not null unique, password text not null);
-- grant all privileges on table users to secadv;

-- insert into users (user_name, password) values ('pxl-admin', 'insecureandlovinit') ;
-- insert into users (user_name, password) values ('george', 'iwishihadbetteradmins') ;

-- COMMIT;

CREATE DATABASE pxldb;
\c pxldb;

CREATE USER secadv WITH PASSWORD 'ilovesecurity';
GRANT ALL PRIVILEGES ON DATABASE pxldb TO secadv;

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    user_name TEXT NOT NULL UNIQUE,
    password_hash TEXT NOT NULL
);

GRANT ALL PRIVILEGES ON TABLE users TO secadv;

BEGIN;

INSERT INTO users (user_name, password_hash)
VALUES ('pxl-admin', crypt('insecureandlovinit', gen_salt('bf', 8))),
       ('george', crypt('iwishihadbetteradmins', gen_salt('bf', 8)));
COMMIT;
