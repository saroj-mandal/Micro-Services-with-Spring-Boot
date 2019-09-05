insert into course(id, name) values(100001, 'Spring boot jpa hibernate');
insert into course(id, name) values(100002, 'React');
insert into course(id, name) values(100003, 'Node');

insert into passport(id, number) values(400001, 'AJH38746');
insert into passport(id, number) values(400002, 'SHG38723');
insert into passport(id, number) values(400003, 'GDTY3287');

insert into student(id, name, passport_id) values(300001, 'Saroj', 400001);
insert into student(id, name, passport_id) values(300002, 'Manoj', 400002);
insert into student(id, name, passport_id) values(300003, 'Chhanda', 400003);

insert into student_course (student_id, course_id) values(300001,100001);
insert into student_course (student_id, course_id) values(300001,100002);
insert into student_course (student_id, course_id) values(300002,100001);
insert into student_course (student_id, course_id) values(300002,100002);
insert into student_course (student_id, course_id) values(300002,100003);
insert into student_course (student_id, course_id) values(300003,100003);
insert into student_course (student_id, course_id) values(300003,100001);

insert into review(id, rating, description, course_id) values(500001, 3, 'this course is shit',100001);
insert into review(id, rating, description, course_id) values(500002, 5, 'nice course',100002);
insert into review(id, rating, description, course_id) values(500003, 4, 'not bad',100003);