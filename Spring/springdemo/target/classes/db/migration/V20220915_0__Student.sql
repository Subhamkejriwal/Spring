CREATE TABLE IF NOT EXISTS public.student
(
    user_id integer NOT NULL,
    city character varying(255) COLLATE pg_catalog."default",
    created_at date NOT NULL,
    is_deleted boolean NOT NULL,
    mobile character varying(255) COLLATE pg_catalog."default",
    name character varying(255) COLLATE pg_catalog."default",
    updated_at date,
    student_country_country_id integer,
    CONSTRAINT student_pkey PRIMARY KEY (user_id),
    CONSTRAINT ukqrdopstv7a04wrx6drgh2r1y9 UNIQUE (name, mobile),
    CONSTRAINT fkipa5bm2l7fots1gifbg6nly10 FOREIGN KEY (student_country_country_id)
        REFERENCES public.student_country (country_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)