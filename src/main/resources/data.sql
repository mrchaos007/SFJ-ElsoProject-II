insert into Blogger(id, age, name) VALUES (1, 21, 'Gyula');
insert into Blogger(id, age, name) VALUES (2, 26, 'Krisz');
insert into STORY (id, title, content, posted, blogger_id) values (1, 'Teszt cím', 'Teszt tartalom', '2017-07-08', (select id FROM BLOGGER where name = 'Gyula') );
