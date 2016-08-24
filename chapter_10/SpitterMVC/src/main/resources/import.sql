insert into user (id, username, password, fullname, email, role) values (1, 'habuma', 'password', 'Craig Walls', 'craig@habuma.com',0);
insert into user (id, username, password, fullname, email, role) values (2, 'artnames', 'password', 'Art Names', 'artnames@habuma.com',1);
insert into message (id, user_id, text, created_at) values (1, 1, 'Have', '2010-06-19');
insert into message (id, user_id, text, created_at) values (2, 1, 'Whos', '2010-06-19');
insert into message (id, user_id, text, created_at) values (3, 2, 'Trying', '2010-06-19');
