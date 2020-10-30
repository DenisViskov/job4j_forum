create table posts (
  id serial primary key,
  name varchar(2000),
  description text,
  created timestamp without time zone not null default now()
);

create table roles (
  id integer primary key,
  name varchar(255)
);