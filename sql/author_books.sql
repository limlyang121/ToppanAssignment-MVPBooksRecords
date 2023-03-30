-- this is the author and book multi to multi relationship table
CREATE TABLE IF NOT EXISTS author_books
(
    "createdAt" timestamp with time zone NOT NULL,
    "updatedAt" timestamp with time zone NOT NULL,
    author_id integer NOT NULL,
    book_id integer NOT NULL,
    CONSTRAINT author_books_pkey PRIMARY KEY (author_id, book_id),
    CONSTRAINT author_books_author_id_fkey FOREIGN KEY (author_id)
        REFERENCES public.authors (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT author_books_book_id_fkey FOREIGN KEY (book_id)
        REFERENCES public.books (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)
