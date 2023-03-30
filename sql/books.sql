--this is the book table
CREATE TABLE IF NOT EXISTS books
(
    id integer NOT NULL DEFAULT nextval('books_id_seq'::regclass),
    name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    "createdAt" timestamp with time zone NOT NULL,
    "updatedAt" timestamp with time zone NOT NULL,
    CONSTRAINT books_pkey PRIMARY KEY (id)
)