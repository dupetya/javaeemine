drop table if exists car;

CREATE TABLE car (
    id BIGINT PRIMARY KEY UNIQUE AUTO_INCREMENT,
    number_of_wheel INT DEFAULT 4 NOT NULL,
    brand VARCHAR(20) NOT NULL,
    model VARCHAR(35) NOT NULL,
    number_plate VARCHAR(15) NOT NULL UNIQUE,
    color VARCHAR(25) NOT NULL,
    manufactoring_date DATE NOT NULL
);

insert into car (brand, model, number_plate, color, manufactoring_date) values
	("BMW", "318d", "ABC-123", "black", "2007-10-04"),
    ("BMW", "318d", "ABC-124", "blue", "2004-12-15"),
    ("BMW", "320d", "ABC-125", "black", "2012-02-25");


drop table if exists car_model;

CREATE TABLE car_model (
    id BIGINT PRIMARY KEY UNIQUE AUTO_INCREMENT,
    number_of_wheel INT DEFAULT 4 NOT NULL,
    brand VARCHAR(20) NOT NULL,
    model VARCHAR(35) NOT NULL
);

insert into car_model (brand, model, number_of_wheel) select distinct brand, model, number_of_wheel from car;

alter table car add column car_model_id bigint;

UPDATE car c 
SET 
    c.car_model_id = (SELECT 
            m.id
        FROM
            car_model m
        WHERE
            m.brand = c.brand AND m.model = c.model
                AND m.number_of_wheel = c.number_of_wheel);

alter table car change car_model_id car_model_id bigint not null,
	add foreign key (car_model_id) references car_model(id);

alter table car drop column model,
	drop column brand,
    drop column number_of_wheel;

insert into car_model (brand, model, number_of_wheel) values ("Trabant", "601", 4);