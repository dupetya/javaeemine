drop table if exists customer;

create table customer (
customer_name varchar(80) not null,
city varchar(80) not null,
street varchar(255) not null,
house_number varchar(20),
floor_number varchar(10),
door_number varchar(10),
bell_name varchar(80),
company_name varchar(100),
tel_number1 varchar(30),
tel_number2 varchar(30),
tel_number3 varchar(30),
comm varchar(255),
discount_percent int,
banned char,
premium char,
number_of_orders bigint
);