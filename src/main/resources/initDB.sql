drop table if exists users cascade;
create table users(
                      id serial primary key,
                      name varchar(20),
                      email varchar(240),
                      phone_number varchar(13),
                      password varchar(20)
);

drop table if exists restaurants cascade;
create table restaurants(
                            id serial primary key,
                            name varchar(255),
                            description text,
                            latitude numeric(9, 7),
                            longitude numeric(9, 7),
                            address varchar(240),
                            main_image_link varchar(140),
                            ratting numeric(5, 4),
                            avg_bill int
);


drop table if exists kitchen_types cascade;
create table kitchen_types(
                            id serial primary key,
                            name varchar(60)
);

drop table if exists kitchen_types_restaurants cascade;
create table kitchen_types_restaurants(
                                          id serial primary key,
                                          restaurant_id int,
                                          kitchen_type_id int
);

drop table if exists restaurants_images_link cascade;
create table restaurants_images_link(
                                          id serial primary key,
                                          restaurant_id int,
                                          image_link varchar(255)
);

drop table if exists bookings cascade;
create table bookings(
                         id serial primary key,
                         user_id int,
                         restaurant_id int,
                         booking_date timestamp,
                         user_name varchar(30),
                         people_amount int
);

