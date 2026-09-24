
ALTER TABLE career
    ALTER COLUMN name TYPE varchar(255),
    ALTER COLUMN degree_awarded TYPE varchar(255);

ALTER TABLE university
    ALTER COLUMN name TYPE varchar(255),
    ALTER COLUMN email TYPE varchar(254);

ALTER TABLE course
    ALTER COLUMN name TYPE varchar(255);

ALTER TABLE section
    ALTER COLUMN classroom TYPE varchar(30),
    ALTER COLUMN period TYPE varchar(30),
    ALTER COLUMN schedule TYPE varchar(255);

ALTER TABLE student
    ALTER COLUMN name TYPE varchar(255),
    ALTER COLUMN email TYPE varchar(254),
    ALTER COLUMN phone_number TYPE varchar(30),
    ALTER COLUMN address TYPE varchar(300);

ALTER TABLE teacher
    ALTER COLUMN name TYPE varchar(255),
    ALTER COLUMN email TYPE varchar(254),
    ALTER COLUMN phone_number TYPE varchar(30);
