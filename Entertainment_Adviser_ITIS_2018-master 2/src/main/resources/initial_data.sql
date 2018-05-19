DELETE FROM users;

INSERT INTO users (username, password, firstname, secondname, role)
VALUES ('user1', 'user1', 'Александр', 'Пушкин', 'USER');

INSERT INTO users (username, password, firstname, secondname, role)
VALUES ('user2', 'user2', 'Александр', 'Герцен', 'USER');

INSERT INTO users (username, password, firstname, secondname, role)
VALUES ('user3', 'user3', 'Михаил', 'Булагаков', 'USER');

INSERT INTO users (username, password, firstname, secondname, role)
VALUES ('user4', 'user4', 'Федор', 'Достоевский', 'USER');

INSERT INTO user_friend (user_id, friend_id) VALUES (1, 3), (1, 5);

insert into tag (tag_name) values ('кино');
insert into tag (tag_name) values ('театр');
insert into tag (tag_name) values ('выставка');

insert into user_tag (user_id, tags_id) VALUES (1, 1), (1, 2);
insert into user_tag (user_id, tags_id) VALUES (2, 2), (2, 3);

insert into event (name, description, start_date, end_date, address, image_url, status)
    VALUES ('Защита проекта', '19 мая состоится презентация проекта Entertainment Adviser',
            '2018-05-19 17:00:00'::timestamp, '2018-05-19 18:00:00'::timestamp,
    'Кремлевская 35, ауд. 1308', 'https://kpfu.ru/portal/docs/F1897406703/_ITIS_7.jpg',
    'Предстоит');

insert into event (name, description, start_date, end_date, address, image_url, status)
VALUES ('День Победы', '9 мая состоится презентация парад Победы',
        '2018-05-19 13:00:00'::timestamp, '2018-05-19 17:00:00'::timestamp,
        'Цирк/Площадь Тысячелетия', 'http://krasnosel.caoinform.ru/wp-content/uploads/sites/5/2018/04/feyerverk-300x200.jpg',
        'Окончено');
select *from user_event;