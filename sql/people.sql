--this is the people table
CREATE TABLE IF NOT EXISTS people
(
    id integer NOT NULL DEFAULT nextval('people_id_seq'::regclass),
    name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    "createdAt" timestamp with time zone NOT NULL,
    "updatedAt" timestamp with time zone NOT NULL,
    country_id bigint,
    CONSTRAINT people_pkey PRIMARY KEY (id)
)
