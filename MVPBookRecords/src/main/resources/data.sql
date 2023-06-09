-- Clear all previous data (for testing purposes only)
TRUNCATE authors, books, people, author_books, book_rents;

-- For performance testing purposes

INSERT INTO books (id, name, "createdAt", "updatedAt")
VALUES (generate_series(1,20),  'Book Number '|| generate_series(1,20) , '20120618', NOW() + (random() * (NOW()+'90 days' - NOW())) + '30 days');


INSERT INTO authors (id, name, "createdAt", "updatedAt")
VALUES (generate_series(1,20), 'Author Number '|| generate_series(1,20), '20120618', NOW() + (random() * (NOW()+'90 days' - NOW())) + '30 days');

INSERT INTO people (id, name, "createdAt", "updatedAt", country_id)
VALUES (generate_series(1,100), 'People Number '|| generate_series(1,100), '20120618', NOW() + (random() * (NOW()+'90 days' - NOW())) + '30 days', 702);

DO '
DECLARE
    author_ids INTEGER[] := array(SELECT id FROM authors ORDER BY random() LIMIT 20);
    book_ids INTEGER[] := array(SELECT id FROM books ORDER BY random() LIMIT 20);
BEGIN
    FOR i IN 1..20 LOOP
            INSERT INTO author_books (author_id, book_id, "createdAt", "updatedAt")
            VALUES (author_ids[i], book_ids[i], ''20120618'', NOW() + (random() * (NOW() + ''90 days'' - NOW())) + ''30 days'');
        END LOOP;
END;
';


-- INSERT INTO author_books (author_id, book_id, "createdAt", "updatedAt")
--     VALUES (generate_series(1,20), generate_series(1,20), '2020-07-01 19:10:25', '2020-07-01 19:10:25');

do'
BEGIN
    for i in 1..100000 loop
            INSERT INTO book_rents (person_id, book_id, "createdAt", "updatedAt") VALUES (floor(random() * 100 + 1), floor(random() * 20 + 1)::int, ''2020-07-01 19:10:25'' , ''2020-07-01 19:10:25'');
        end loop;
END;
'
