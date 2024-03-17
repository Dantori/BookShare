CREATE TABLE IF NOT EXISTS s_bookshare.t_users
(
    user_id  BIGSERIAL PRIMARY KEY,
    name     VARCHAR(255) NOT NULL,
    login    VARCHAR(255) NOT NULL UNIQUE,
    city     VARCHAR(255) NOT NULL,
    role     VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS s_bookshare.t_books
(
    book_id     BIGSERIAL PRIMARY KEY,
    user_id     BIGSERIAL,
    name        VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    status      VARCHAR(255) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES s_bookshare.t_users (user_id)
);
