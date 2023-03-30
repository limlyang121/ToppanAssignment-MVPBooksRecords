--this is the book renting history table
CREATE TABLE IF NOT EXISTS book_rents
(
    person_id bigint NOT NULL,
    book_id bigint NOT NULL,
    "createdAt" time with time zone NOT NULL,
    "updatedAt" time with time zone NOT NULL
)
