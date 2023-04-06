create table users
(
    id       int auto_increment
        primary key,
    email    varchar(255) not null,
    username varchar(255) not null,
    password varchar(60)  not null,
    constraint email
        unique (email)
);

