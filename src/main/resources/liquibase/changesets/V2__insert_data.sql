INSERT INTO s_bookshare.t_users (name, username, city, role, password)
VALUES ('Илья', 'ilya@mail.ru', 'Рязань', 'ADMIN', '$2a$10$A5mRxGf9ihCnVI8JXx5qYOeZkZ4c013t1MQRYjmR73oR68y8o/.ge'),
       ('Филип', 'philip@mail.ru', 'Москва', 'USER', '$2a$10$V5H3mh3pI8c0QP0UhvY4/.5gs613OFlf2U.Izl4KdRKxmTfWxgdmG');

INSERT INTO s_bookshare.t_books (user_id, name, description, status, is_requested)
VALUES (1, 'Приключения Тома Сойера', 'Классика от Марка Твена', 'IN_EXCHANGE', FALSE),
       (1, 'Война и мир', 'Русская клаасика', 'AVAILABLE', FALSE),
       (2, 'Гарри Поттер и философский камень', 'Первая книга о Гарри Поттере', 'IN_EXCHANGE', FALSE),
       (2, 'Записки о Шерлоке Холмсе', 'Английский детектив', 'AVAILABLE', FALSE);
