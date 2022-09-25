ALTER TABLE IF EXISTS public.student
RENAME COLUMN city TO current_city;


ALTER TABLE IF EXISTS public.student
ADD  native_city character varying(255) COLLATE pg_catalog."default";