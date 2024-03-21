CREATE TABLE IF NOT EXISTS s_bookshare.t_users
(
    id       BIGSERIAL PRIMARY KEY,
    name     VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL UNIQUE,
    city     VARCHAR(255) NOT NULL,
    role     VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS s_bookshare.t_books
(
    id          BIGSERIAL PRIMARY KEY,
    user_id     BIGSERIAL,
    name        VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    status      VARCHAR(255) NOT NULL,

    FOREIGN KEY (user_id) REFERENCES s_bookshare.t_users (id)
);

CREATE TABLE IF NOT EXISTS s_bookshare.t_swap
(
    id          BIGSERIAL PRIMARY KEY,
    req_id      BIGSERIAL,
    req_book_id BIGSERIAL,
    res_id      BIGSERIAL,
    res_book_id BIGSERIAL
);