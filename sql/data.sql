-- Clear all previous data (for testing purposes only)
TRUNCATE authors, books, people, author_books, book_rents;

-- For performance testing purposes
INSERT INTO books (id, name, "createdAt", "updatedAt")
VALUES (generate_series(1,20), md5(random()::text), '20120618', NOW() + (random() * (NOW()+'90 days' - NOW())) + '30 days');

INSERT INTO authors (id, name, "createdAt", "updatedAt")
VALUES (generate_series(1,20), md5(random()::text), '20120618', NOW() + (random() * (NOW()+'90 days' - NOW())) + '30 days');

INSERT INTO people (id, name, "createdAt", "updatedAt", country_id)
VALUES (generate_series(1,100), md5(random()::text), '20120618', NOW() + (random() * (NOW()+'90 days' - NOW())) + '30 days', 4);

INSERT INTO author_books (author_id, book_id, "createdAt", "updatedAt")
VALUES (generate_series(1,20), generate_series(1,20), '2020-07-01 19:10:25', '2020-07-01 19:10:25');

do'
BEGIN
    for r in 1..100000 loop
            INSERT INTO book_rents (person_id, book_id, "createdAt", "updatedAt") VALUES (floor(random() * 100 + 1), floor(random() * 20 + 1)::int, ''2020-07-01 19:10:25'' , ''2020-07-01 19:10:25'');
        end loop;
END;
'

-- For edge cases testing purposes
-- INSERT INTO books (id, name, "createdAt", "updatedAt") VALUES (1, 'Book 1', '20120618', '20120618');
-- INSERT INTO books (id, name, "createdAt", "updatedAt") VALUES (2, 'Book 2', '20120618', '20120618');
-- INSERT INTO books (id, name, "createdAt", "updatedAt") VALUES (3, 'Book 3', '20120618', '20120618');
-- INSERT INTO books (id, name, "createdAt", "updatedAt") VALUES (4, 'Book 4', '20120618', '20120618');
-- INSERT INTO books (id, name, "createdAt", "updatedAt") VALUES (5, 'Book 5', '20120618', '20120618');
--
-- INSERT INTO people (id, name, "createdAt", "updatedAt", country_id) VALUES (1, 'Person 1', '20120618', '20120618', 360);
-- INSERT INTO people (id, name, "createdAt", "updatedAt", country_id) VALUES (2, 'Person 2', '20120618', '20120618', 360);
-- INSERT INTO people (id, name, "createdAt", "updatedAt", country_id) VALUES (3, 'Person 3', '20120618', '20120618', 360);
-- INSERT INTO people (id, name, "createdAt", "updatedAt", country_id) VALUES (4, 'Person 4', '20120618', '20120618', 360);
-- INSERT INTO people (id, name, "createdAt", "updatedAt", country_id) VALUES (5, 'Person 5', '20120618', '20120618', 702);
--
-- INSERT INTO authors (id, name, "createdAt", "updatedAt") VALUES (1, 'Famous Author 1', '20120618', '20120618');
-- INSERT INTO authors (id, name, "createdAt", "updatedAt") VALUES (2, 'Famous Author 2', '20120618', '20120618');
-- INSERT INTO authors (id, name, "createdAt", "updatedAt") VALUES (3, 'Famous Author 3', '20120618', '20120618');
-- INSERT INTO authors (id, name, "createdAt", "updatedAt") VALUES (4, 'Famous Author 4', '20120618', '20120618');
--
-- INSERT INTO author_books (author_id, book_id, "createdAt", "updatedAt") VALUES (1, 1, '2020-07-01 19:10:25', '2020-07-01 19:10:25');
-- INSERT INTO author_books (author_id, book_id, "createdAt", "updatedAt") VALUES (2, 2, '2020-07-01 19:10:25', '2020-07-01 19:10:25');
-- INSERT INTO author_books (author_id, book_id, "createdAt", "updatedAt") VALUES (3, 3, '2020-07-01 19:10:25', '2020-07-01 19:10:25');
-- INSERT INTO author_books (author_id, book_id, "createdAt", "updatedAt") VALUES (4, 4, '2020-07-01 19:10:25', '2020-07-01 19:10:25');
-- INSERT INTO author_books (author_id, book_id, "createdAt", "updatedAt") VALUES (4, 5, '2020-07-01 19:10:25', '2020-07-01 19:10:25');
--
-- INSERT INTO book_rents (person_id, book_id, "createdAt", "updatedAt") VALUES (1, 5, '2020-07-01 19:10:25', '2020-07-01 19:10:25');
-- INSERT INTO book_rents (person_id, book_id, "createdAt", "updatedAt") VALUES (2, 5, '2020-07-01 19:10:25', '2020-07-01 19:10:25');
-- INSERT INTO book_rents (person_id, book_id, "createdAt", "updatedAt") VALUES (2, 5, '2020-07-01 19:10:25', '2022-07-01 19:10:25');
-- INSERT INTO book_rents (person_id, book_id, "createdAt", "updatedAt") VALUES (2, 5, '2020-07-01 19:10:25', '2021-07-01 19:10:25');
-- INSERT INTO book_rents (person_id, book_id, "createdAt", "updatedAt") VALUES (3, 5, '2020-07-    01 19:10:25', '2020-07-01 19:10:25');
-- INSERT INTO book_rents (person_id, book_id, "createdAt", "updatedAt") VALUES (3, 5, '2020-07-01 19:10:25', '2021-07-01 19:10:25');
-- INSERT INTO book_rents (person_id, book_id, "createdAt", "updatedAt") VALUES (4, 5, '2020-07-01 19:10:25', '2020-07-01 19:10:25');
-- INSERT INTO book_rents (person_id, book_id, "createdAt", "updatedAt") VALUES (1, 2, '2020-07-01 19:10:25', '2020-07-01 19:10:25');
-- INSERT INTO book_rents (person_id, book_id, "createdAt", "updatedAt") VALUES (4, 2, '2020-07-01 19:10:25', '2020-07-01 19:10:25');
-- INSERT INTO book_rents (person_id, book_id, "createdAt", "updatedAt") VALUES (5, 4, '2020-07-01 19:10:25', '2020-07-01 19:10:25');
-- INSERT INTO book_rents (person_id, book_id, "createdAt", "updatedAt") VALUES (5, 4, '2020-07-01 19:10:25', '2020-07-01 19:10:25');
-- INSERT INTO book_rents (person_id, book_id, "createdAt", "updatedAt") VALUES (5, 4, '2020-07-01 19:10:25', '2020-07-01 19:10:25');
-- INSERT INTO book_rents (person_id, book_id, "createdAt", "updatedAt") VALUES (1, 4, '2020-07-01 19:10:25', '2020-07-01 19:10:25');

-- Initialize data for all tables
INSERT INTO authors (name, created_at, updated_at) VALUES 
    ('N.K. Jemisin', NOW(), NOW()),
    ('William Peter Blatty', NOW(), NOW()),
    ('Brandon Sanderson', NOW(), NOW());

INSERT INTO books (name, created_at, updated_at) VALUES 
    ('The Stone Sky', NOW(), NOW()),
    ('The Exorcist', NOW(), NOW()),
    ('The Final Empire', NOW(), NOW());

INSERT INTO people (name, country_id, created_at, updated_at) VALUES 
    ('Peggy Olsen', 702, NOW(), NOW()),
    ('Joan Harris', 702, NOW(), NOW()),
    ('Trudy Campbell', 702, NOW(), NOW()),
    ('Roger Sterling', 702, NOW(), NOW()),
    ('Don Draper', 458, NOW(), NOW()),
    ('E.B. Farnum', 458, NOW(), NOW()),
    ('Jim Halpert', 458, NOW(), NOW()),
    ('Kevin Malone', 458, NOW(), NOW()),
    ('Rachel Menken', 840, NOW(), NOW()),
    ('Betty Draper', 840, NOW(), NOW()),
    ('Michael Scott', 840, NOW(), NOW()),
    ('Darryl Philbin', 840, NOW(), NOW());

INSERT INTO author_books (author_id, book_id, created_at, updated_at) VALUES 
    (1, 1, NOW(), NOW()),
    (2, 2, NOW(), NOW()),
    (3, 3, NOW(), NOW());

INSERT INTO book_rents (person_id, book_id, created_at, updated_at) VALUES 
    (1, 1, NOW(), NOW()),
    (1, 2, NOW(), NOW()),
    (1, 3, NOW(), NOW()),
    (1, 1, NOW(), NOW()),
    (1, 2, NOW(), NOW()),
    (1, 3, NOW(), NOW()),
    (2, 1, NOW(), NOW()),
    (2, 2, NOW(), NOW()),
    (2, 3, NOW(), NOW()),
    (2, 1, NOW(), NOW()),
    (2, 2, NOW(), NOW()),
    (2, 3, NOW(), NOW()),
    (2, 1, NOW(), NOW()),
    (3, 3, NOW(), NOW()),
    (3, 2, NOW(), NOW()),
    (3, 1, NOW(), NOW()),
    (3, 3, NOW(), NOW()),
    (3, 2, NOW(), NOW()),
    (3, 2, NOW(), NOW()),
    (3, 3, NOW(), NOW()),
    (3, 1, NOW(), NOW()),
    (3, 1, NOW(), NOW()),
    (4, 1, NOW(), NOW()),
    (4, 2, NOW(), NOW()),
    (4, 3, NOW(), NOW()),
    (4, 1, NOW(), NOW()),
    (4, 3, NOW(), NOW()),
    (4, 2, NOW(), NOW()),
    (4, 3, NOW(), NOW()),
    (4, 3, NOW(), NOW()),
    (5, 1, NOW(), NOW()),
    (5, 2, NOW(), NOW()),
    (5, 3, NOW(), NOW()),
    (6, 1, NOW(), NOW()),
    (6, 2, NOW(), NOW()),
    (6, 3, NOW(), NOW()),
    (7, 1, NOW(), NOW()),
    (7, 2, NOW(), NOW()),
    (7, 3, NOW(), NOW()),
    (8, 1, NOW(), NOW()),
    (8, 2, NOW(), NOW()),
    (8, 3, NOW(), NOW()),
    (9, 1, NOW(), NOW()),
    (9, 2, NOW(), NOW()),
    (10, 2, NOW(), NOW()),
    (11, 2, NOW(), NOW()),
    (12, 2, NOW(), NOW()),
    (10, 2, NOW(), NOW()),
    (10, 2, NOW(), NOW()),
    (10, 2, NOW(), NOW()),
    (10, 2, NOW(), NOW()),
    (10, 2, NOW(), NOW()),
    (10, 2, NOW(), NOW()),
    (10, 2, NOW(), NOW()),
    (10, 2, NOW(), NOW()),
    (10, 2, NOW(), NOW()),
    (10, 2, NOW(), NOW()),
    (10, 2, NOW(), NOW()),
    (10, 2, NOW(), NOW()),
    (10, 2, NOW(), NOW()),
    (10, 2, NOW(), NOW()),
    (10, 2, NOW(), NOW()),
    (10, 2, NOW(), NOW()),
    (10, 2, NOW(), NOW()),
    (10, 2, NOW(), NOW()),
    (10, 2, NOW(), NOW()),
    (10, 2, NOW(), NOW()),
    (10, 2, NOW(), NOW()),
    (10, 2, NOW(), NOW()),
    (10, 2, NOW(), NOW()),
    (10, 2, NOW(), NOW()),
    (10, 2, NOW(), NOW()),
    (10, 2, NOW(), NOW()),
    (10, 2, NOW(), NOW()),
    (10, 2, NOW(), NOW()),
    (10, 2, NOW(), NOW()),
    (10, 2, NOW(), NOW()),
    (10, 2, NOW(), NOW()),
    (10, 2, NOW(), NOW()),
    (10, 2, NOW(), NOW()),
    (10, 2, NOW(), NOW()),
    (10, 2, NOW(), NOW()),
    (10, 2, NOW(), NOW()),
    (10, 2, NOW(), NOW()),
    (10, 2, NOW(), NOW()),
    (11, 2, NOW(), NOW()),
    (12, 2, NOW(), NOW()),
    (10, 3, NOW(), NOW()),
    (11, 3, NOW(), NOW()),
    (12, 3, NOW(), NOW()),
    (10, 3, NOW(), NOW()),
    (11, 3, NOW(), NOW()),
    (11, 3, NOW(), NOW()),
    (11, 1, NOW(), NOW()),
    (11, 1, NOW(), NOW()),
    (11, 1, NOW(), NOW()),
    (11, 1, NOW(), NOW()),
    (11, 1, NOW(), NOW()),
    (11, 1, NOW(), NOW()),
    (11, 1, NOW(), NOW()),
    (11, 1, NOW(), NOW()),
    (11, 1, NOW(), NOW()),
    (11, 1, NOW(), NOW()),
    (11, 1, NOW(), NOW()),
    (11, 1, NOW(), NOW()),
    (11, 1, NOW(), NOW()),
    (11, 1, NOW(), NOW()),
    (11, 1, NOW(), NOW()),
    (11, 1, NOW(), NOW()),
    (11, 1, NOW(), NOW()),
    (11, 1, NOW(), NOW()),
    (11, 1, NOW(), NOW()),
    (11, 1, NOW(), NOW()),
    (11, 1, NOW(), NOW()),
    (11, 1, NOW(), NOW()),
    (11, 1, NOW(), NOW()),
    (12, 1, NOW(), NOW()),
    (12, 1, NOW(), NOW()),
    (12, 1, NOW(), NOW()),
    (12, 1, NOW(), NOW()),
    (10, 1, NOW(), NOW()),
    (10, 1, NOW(), NOW()),
    (10, 1, NOW(), NOW()),
    (10, 1, NOW(), NOW()),
    (11, 1, NOW(), NOW()),
    (11, 1, NOW(), NOW()),
    (9, 3, NOW(), NOW());