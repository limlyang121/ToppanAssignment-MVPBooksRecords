-- Clear all previous data (for testing purposes only)
TRUNCATE authors, books, people, author_books, book_rents;

-- For performance testing purposes

INSERT INTO books (id, name, "createdAt", "updatedAt")
VALUES (generate_series(1,20),   substring(md5(random()::text) from 1 for 15) , '20120618', NOW() + (random() * (NOW()+'90 days' - NOW())) + '30 days');


INSERT INTO authors (id, name, "createdAt", "updatedAt")
VALUES (generate_series(1,20), substring(md5(random()::text) from 1 for 15), '20120618', NOW() + (random() * (NOW()+'90 days' - NOW())) + '30 days');

INSERT INTO people (id, name, "createdAt", "updatedAt", country_id)
VALUES (generate_series(1,100), substring(md5(random()::text) from 1 for 15), '20120618', NOW() + (random() * (NOW()+'90 days' - NOW())) + '30 days', 702);


INSERT INTO author_books (author_id, book_id, "createdAt", "updatedAt")
VALUES (generate_series(1,20), generate_series(1,20), '2020-07-01 19:10:25', '2020-07-01 19:10:25');

do'
BEGIN
    for i in 1..100000 loop
            INSERT INTO book_rents (person_id, book_id, "createdAt", "updatedAt") VALUES (floor(random() * 100 + 1), floor(random() * 20 + 1)::int, ''2020-07-01 19:10:25'' , ''2020-07-01 19:10:25'');
        end loop;
END;
'
