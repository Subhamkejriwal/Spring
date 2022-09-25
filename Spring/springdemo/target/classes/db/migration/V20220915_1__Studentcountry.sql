CREATE TABLE IF NOT EXISTS public.student_country
(
    country_id integer NOT NULL,
    country character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT student_country_pkey PRIMARY KEY (country_id)
)