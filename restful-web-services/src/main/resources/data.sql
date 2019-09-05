insert into user(id, name, birth_date)
values(10001, 'Saroj', sysdate());
insert into user(id, name, birth_date)
values(10002, 'Manoj', sysdate());
insert into user(id, name, birth_date)
values(10003, 'Chhanda', sysdate());

insert into post(id, description, user_id)
values(10001, 'This is my first post', 10001);
insert into post(id, description, user_id)
values(10002, 'This is my second post', 10001);