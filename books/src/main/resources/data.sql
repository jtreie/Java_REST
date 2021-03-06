INSERT INTO books(isbn, title, author, year_of_publication, publisher, rating_id) VALUES ('0195153448','Classical Mythology','Mark P. O. Morford',2002,'Oxford University Press',1);
INSERT INTO books(isbn, title, author, year_of_publication, publisher, rating_id) VALUES ('0002005018','Clara Callan','Richard Bruce Wright',2001,'HarperFlamingo Canada',2);
INSERT INTO books(isbn, title, author, year_of_publication, publisher, rating_id) VALUES ('0375704027','Norwegian Woods','Haruki Murakami',2000,'Vintage',3);
INSERT INTO books(isbn, title, author, year_of_publication, publisher, rating_id) VALUES ('0307949486','The Girl with the Dragon tattoo','Stieg Larsson',2011,'Black Lizard',4);
INSERT INTO books(isbn, title, author, year_of_publication, publisher, rating_id) VALUES ('0486280616','Adventures of Huckleberry Finn','Mark Twain',1994,'Dover Publications',5);
INSERT INTO books(isbn, title, author, year_of_publication, publisher, rating_id) VALUES ('8498193486','Kevade','Oskar Luts',2006,'',6);
INSERT INTO books(isbn, title, author, year_of_publication, publisher, rating_id) VALUES ('9949571766','Rajamustrid','Fred Jüssi',2017,'Pilgrim',7);
INSERT INTO books(isbn, title, author, year_of_publication, publisher, rating_id) VALUES ('1554513723','Erebos','Ursula Poznanzki',2012,'Annick Press',8);
INSERT INTO books(isbn, title, author, year_of_publication, publisher, rating_id) VALUES ('054792822X','The Hobbit','J. R. R. Tolkien',2012,'Houghton Mifflin Harcourt',9);
INSERT INTO books(isbn, title, author, year_of_publication, publisher, rating_id) VALUES ('152479628X','Fire & Blood','George R. R. Martin',2018,'Bantam',10);
INSERT INTO books(isbn, title, author, year_of_publication, publisher, rating_id) VALUES ('0679753796','Dance dance dance','Haruki Murakami',1995,'Vintage',7);
INSERT INTO books(isbn, title, author, year_of_publication, publisher, rating_id) VALUES ('0375702245','The Idiot','Fyodor Dostojevsky',2003,'Vintage',5);
INSERT INTO books(isbn, title, author, year_of_publication, publisher, rating_id) VALUES ('1908251905','Vargamäe','A. H. Tammsaare',2019,'Vagabond Voices',6);
INSERT INTO books(isbn, title, author, year_of_publication, publisher, rating_id) VALUES ('0743412281','Pet Sematary','Stephen King',2002,'Gallery Books',2);
INSERT INTO books(isbn, title, author, year_of_publication, publisher, rating_id) VALUES ('1984819194','Brief Answers to the Big Questions','Stephen Hawking',2018,'Bantam',1);


INSERT INTO book_ratings VALUES (rating_seq.nextval, '0195153448',6);
INSERT INTO book_ratings VALUES (rating_seq.nextval, '0002005018',3);
INSERT INTO book_ratings VALUES (rating_seq.nextval, '0375704027',9);
INSERT INTO book_ratings VALUES (rating_seq.nextval, '0307949486',8);
INSERT INTO book_ratings VALUES (rating_seq.nextval, '8498193486',8);
INSERT INTO book_ratings VALUES (rating_seq.nextval, '9949571766',3);
INSERT INTO book_ratings VALUES (rating_seq.nextval, '1554513723',10);
INSERT INTO book_ratings VALUES (rating_seq.nextval, '054792822X',1);
INSERT INTO book_ratings VALUES (rating_seq.nextval, '0679753796',9);
INSERT INTO book_ratings VALUES (rating_seq.nextval, '1908251905',5);
INSERT INTO book_ratings VALUES (rating_seq.nextval, '0743412281',3);
INSERT INTO book_ratings VALUES (rating_seq.nextval, '1984819194',6);

INSERT INTO top_list (isbn, title, book_rating)
SELECT BOOKS.ISBN AS ISBN, BOOKS.TITLE AS Title, BOOK_RATINGS.BOOK_RATING AS Rating
FROM BOOKS, BOOK_RATINGS
WHERE BOOKS.ISBN = BOOK_RATINGS.ISBN
GROUP BY BOOK_RATINGS.BOOK_RATING, BOOKS.ISBN
ORDER BY BOOK_RATING DESC;

INSERT INTO book_list (title, book_rating)
SELECT BOOKS.TITLE AS Title, BOOK_RATINGS.BOOK_RATING AS Rating
FROM BOOKS
INNER JOIN BOOK_RATINGS ON BOOKS.ISBN=BOOK_RATINGS.ISBN