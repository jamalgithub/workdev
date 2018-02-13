-- Initial data for the student table. 
-- Spring Boot would execute this script after the tables are created from the entities.

insert into student values(10001,'Ranga', 'E1234567');
insert into student values(10002,'Ravi', 'A1234568');

insert into user values(10001, sysdate(), 'AB');
insert into user values(10002, sysdate(), 'Jill');
insert into user values(10003, sysdate(), 'Jam');

insert into post values(11001, 'My First Post', 10001);
insert into post values(11002, 'My Second Post', 10001);