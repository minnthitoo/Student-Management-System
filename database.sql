
create database school;

use school;

create table office(
    id int primary key auto_increment,
    email varchar(255) not null,
    password varchar(255) not null
    );

insert into office (email, password) values ('aa', '123');

create table teacher(
    id int auto_increment primary key,
    name varchar(50) not null,
    nrc varchar(20) not null,
    major varchar(20) not null,
    email varchar(50) not null UNIQUE key,
    phone varchar(15) not null,
    address varchar(255) not null,
    PASSWORD VARCHAR(100) not null
);

create table student(
    id int auto_increment primary key,
    name varchar(255) not null,
    nrc varchar(20) not null,
    s_class varchar(20) not null,
    phone varchar(15) not null UNIQUE key,
    email varchar(50) not null UNIQUE key,
    address varchar(255) not null,
    password VARCHAR(100) not null
);

create table classes(
    id int auto_increment primary key,
    class_name varchar(255) not null,
    duration varchar(255) not null,
    startdate varchar(255) not null
    );

CREATE TABLE timetable(

    id int PRIMARY KEY auto_increment,

    mon_fir_time varchar(50) not null,
    mon_sec_time varchar(50) not null,
    mon_tha_time varchar(50) not null,
    mon_for_time varchar(50) not null,

    tue_fir_time varchar(50) not null,
    tue_sec_time varchar(50) not null,
    tue_tha_time varchar(50) not null,
    tue_for_time varchar(50) not null,

    wed_fir_time varchar(50) not null,
    wed_sec_time varchar(50) not null,
    wed_tha_time varchar(50) not null,
    wed_for_time varchar(50) not null,

    thu_fir_time varchar(50) not null,
    thu_sec_time varchar(50) not null,
    thu_tha_time varchar(50) not null,
    thu_for_time varchar(50) not null,

    fri_fir_time varchar(50) not null,
    fri_sec_time varchar(50) not null,
    fri_tha_time varchar(50) not null,
    fri_for_time varchar(50) not null,
    
    major varchar(50) not null
);