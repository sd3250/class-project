

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12387)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2143 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: -
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

--
-- TOC entry 185 (class 1259 OID 16431)
-- Name: employee_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE employee_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 187 (class 1259 OID 16435)
-- Name: employee; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE employee (
    id numeric DEFAULT nextval('employee_id_seq'::regclass) NOT NULL,
    first_name character varying(20),
    last_name character varying(20),
    bith_date date,
    gender character varying(10),
    employment_date date,
    job_title character varying(20),
    salary numeric
);


--
-- TOC entry 186 (class 1259 OID 16433)
-- Name: leave_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE leave_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 188 (class 1259 OID 16444)
-- Name: leave; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE leave (
    id numeric DEFAULT nextval('leave_id_seq'::regclass) NOT NULL,
    employee_id numeric,
    start_date date,
    days numeric,
    leave_type character varying(20),
    approved boolean
);


--
-- TOC entry 2135 (class 0 OID 16435)
-- Dependencies: 187
-- Data for Name: employee; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- TOC entry 2136 (class 0 OID 16444)
-- Dependencies: 188
-- Data for Name: leave; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- TOC entry 2144 (class 0 OID 0)
-- Dependencies: 185
-- Name: employee_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('employee_id_seq', 1, false);


--
-- TOC entry 2145 (class 0 OID 0)
-- Dependencies: 186
-- Name: leave_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('leave_id_seq', 1, false);


--
-- TOC entry 2012 (class 2606 OID 16443)
-- Name: employee employee_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY employee
    ADD CONSTRAINT employee_pkey PRIMARY KEY (id);


--
-- TOC entry 2014 (class 2606 OID 16452)
-- Name: leave leave_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY leave
    ADD CONSTRAINT leave_pkey PRIMARY KEY (id);


--
-- TOC entry 2015 (class 2606 OID 16453)
-- Name: leave fk_employee_id; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY leave
    ADD CONSTRAINT fk_employee_id FOREIGN KEY (id) REFERENCES employee(id);


-- Completed on 2018-03-14 16:26:48


CREATE SEQUENCE user_id_seq
   START WITH 1
   INCREMENT BY 1
   NO MINVALUE
   NO MAXVALUE
   CACHE 1;



-- Note: If you get a syntax error for the below line, try changing -user- to -public."user"-
CREATE TABLE user (
    id numeric DEFAULT nextval('user_id_seq'::regclass) NOT NULL,
    username character varying(30) NOT NULL,
    password character varying(30),
    role character varying(15),
    employee_id numeric,
    PRIMARY KEY (username),
    CONSTRAINT employee_id FOREIGN KEY (employee_id)
        REFERENCES public.employee (id) MATCH SIMPLE
);
--
-- PostgreSQL database dump complete
--

