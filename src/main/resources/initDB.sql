drop table if exists users cascade;
create table users(
                      id serial primary key,
                      name varchar(40),
                      email varchar(240),
                      phone_number varchar(10),
                      password varchar(40)
);