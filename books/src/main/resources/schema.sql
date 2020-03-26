DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS book_ratings;
DROP TABLE IF EXISTS top_list;
DROP TABLE IF EXISTS book_list;

CREATE SEQUENCE rating_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS books (
    isbn                  varchar(13) not null,
    title                 varchar(255) not null,
    author                varchar(255) not null,
    year_of_publication   int(10) not null,
    publisher             text,
    rating_id 				  bigint,
    primary key (isbn)
);

CREATE TABLE IF NOT EXISTS book_ratings (
    id                  bigint        not null,
    isbn                varchar(13)   not null,
    book_rating         int(11)       not null,
    primary key  (id)
);
CREATE TABLE IF NOT EXISTS top_list (
isbn                  varchar(13) not null,
title                 varchar(255) not null,
book_rating         int(11),
primary key (isbn)
);

CREATE TABLE IF NOT EXISTS book_list (
title                 varchar(255) not null,
book_rating         int(11),
primary key (title)
);

ALTER TABLE book_ratings
    ADD CONSTRAINT isbn_fkey
        FOREIGN KEY (isbn)
            REFERENCES books;