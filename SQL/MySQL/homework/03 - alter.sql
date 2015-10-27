alter table customer
	add id bigint auto_increment unique first;
    
drop table if exists customer_address;

create table customer_address(
	id BIGINT PRIMARY KEY UNIQUE AUTO_INCREMENT,
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
	comm varchar(255)
);

insert into customer_address (city,street,house_number,floor_number,door_number,bell_name,company_name,tel_number1,tel_number2,tel_number3,comm)
	select city,street,house_number,floor_number,door_number,bell_name,company_name,tel_number1,tel_number2,tel_number3,comm from customer;
    
alter table customer
	add address_id bigint
    after customer_name;
    
update customer c 
	set c.address_id = (
		select a.id from customer_address a
        where c.city = a.city and c.street = a.street and c.house_number = a.house_number
			and c.floor_number = a.floor_number and c.door_number = a.door_number
            and c.bell_name = a.bell_name and c.company_name=a.company_name 
            and c.tel_number1 = a.tel_number1 and c.tel_number2 = a.tel_number2 and c.tel_number3 = a.tel_number3
            and c.comm = a.comm
    );

alter table customer change address_id address_id bigint not null,
	add foreign key (address_id) references customer_address(id);
    
alter table customer 
	drop column city,
    drop column street,
    drop column house_number,
    drop column floor_number,
    drop column door_number,
    drop column bell_name,
    drop column company_name,
    drop column tel_number1,
    drop column tel_number2,
    drop column tel_number3,
    drop column comm;