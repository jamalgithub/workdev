/*
create table person
(
   id integer not null,
   name varchar(255) not null,
   location varchar(255),
   birth_date timestamp,
   primary key(id)
);

*/
/*
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE )
VALUES(10001,'Jamal', 'Tetouan', sysdate());
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE )
VALUES(10002,'Adil', 'Tanger', sysdate());
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE )
VALUES(10003,'Nabil', 'Rabat', sysdate());
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE )
VALUES(10004,'Karim', 'Sale', sysdate());
*/

insert into course(id, name, created_date, last_updated_date) 
values(10001,'JPA in 50 Steps', sysdate(), sysdate());
insert into course(id, name, created_date, last_updated_date) 
values(10002,'Spring in 50 Steps', sysdate(), sysdate());
insert into course(id, name, created_date, last_updated_date) 
values(10003,'Spring Boot in 100 Steps', sysdate(), sysdate());