INSERT INTO s_bookshare.t_users (name, username, city, role, password)
VALUES ('Илья', 'guardianshield.cpp@gmail.com', 'Рязань', 'ROLE_ADMIN', '$2a$10$rdrnJWU12IspjSJcJCzik.J.BU3P0A7vP0aHwor9FLeLXBVkDd6ze'),
       ('Филип', 'philip@gmail.com', 'Москва', 'ROLE_USER', '$2a$10$PluaJy8j.NBpzFYCO0MzhuR18Hk6crGdAVVrz01w6wstYtwiBGs9.');

INSERT INTO s_bookshare.t_books (user_id, name, description, status)
VALUES (1, 'Приключения Тома Сойера', 'Классика от Марка Твена', 'AVAILABLE'),
       (1, 'Война и мир', 'Русская клаасика', 'AVAILABLE'),
       (2, 'Гарри Поттер и философский камень', 'Первая книга о Гарри Поттере', 'AVAILABLE'),
       (2, 'Записки о Шерлоке Холмсе', 'Английский детектив', 'AVAILABLE');
