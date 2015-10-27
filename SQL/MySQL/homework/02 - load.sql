load data local infile 'd:\\JavaEETraining\\javaeemine\\SQL\\MySQL\\homework\\sample.csv'
	into table customer
    fields terminated by ',' enclosed by '"'
    lines terminated by '\r\n'
    ignore 1 lines;