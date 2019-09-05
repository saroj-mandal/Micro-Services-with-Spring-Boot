/*create table person (
	id integer not null,
	name varchar(255) not null,
	location varchar(255),
	birth_date timestamp,
	primary key(id)
);
*/
insert into PERSON (id, name, location, birth_date) 
	values (100001, 'Saroj Mandal', 'Bengaluru', sysdate());
insert into PERSON (id, name, location, birth_date) 
	values (100002, 'Sona Mandal', 'Bengaluru', sysdate());
insert into PERSON (id, name, location, birth_date) 
	values (100003, 'Vini Mandal', 'Bengaluru', sysdate());	