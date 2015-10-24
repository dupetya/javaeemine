SELECT 
    c.*, c.number_plate
FROM
    car c;
    

SELECT 
    c.*, LOWER(c.number_plate) 'KisRendszam'
FROM
    car c;


SELECT 
    *
FROM
    car c
        CROSS JOIN
    car_model m;
SELECT 
    *
FROM
    car c,
    car_model m;

SELECT 
    *
FROM
    car c
        JOIN
    car_model m ON c.car_model_id = m.id;
SELECT 
    *
FROM
    car c,
    car_model m
WHERE
    c.car_model_id = m.id;

SELECT 
    *
FROM
    car c
        RIGHT JOIN
    car_model m ON c.car_model_id = m.id;
    
alter table car add index color_idx(color);
    
select * from car c join car_model m on c.car_model_id = m.id where color = "black";
