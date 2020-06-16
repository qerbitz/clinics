--
-- PostgreSQL database dump
--

-- Dumped from database version 11.1
-- Dumped by pg_dump version 11.1

-- Started on 2020-06-16 03:31:20

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO postgres;

--
-- TOC entry 2954 (class 0 OID 0)
-- Dependencies: 3
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 203 (class 1259 OID 49368)
-- Name: adresy; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.adresy (
    id_adresu integer NOT NULL,
    miejscowosc character varying,
    wojewodztwo character varying,
    powiat character varying,
    ulica character varying,
    nr_domu character varying,
    kod_pocztowy character varying
);


ALTER TABLE public.adresy OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 49366)
-- Name: adresy_id_adresu_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.adresy_id_adresu_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.adresy_id_adresu_seq OWNER TO postgres;

--
-- TOC entry 2955 (class 0 OID 0)
-- Dependencies: 202
-- Name: adresy_id_adresu_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.adresy_id_adresu_seq OWNED BY public.adresy.id_adresu;


--
-- TOC entry 205 (class 1259 OID 49379)
-- Name: badania; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.badania (
    id_badania integer NOT NULL,
    nazwa character varying
);


ALTER TABLE public.badania OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 49377)
-- Name: badania_id_badania_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.badania_id_badania_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.badania_id_badania_seq OWNER TO postgres;

--
-- TOC entry 2956 (class 0 OID 0)
-- Dependencies: 204
-- Name: badania_id_badania_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.badania_id_badania_seq OWNED BY public.badania.id_badania;


--
-- TOC entry 207 (class 1259 OID 49390)
-- Name: diagnozy; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.diagnozy (
    id_diagnozy integer NOT NULL,
    nazwa character varying,
    opis character varying
);


ALTER TABLE public.diagnozy OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 49388)
-- Name: diagnozy_id_diagnozy_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.diagnozy_id_diagnozy_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.diagnozy_id_diagnozy_seq OWNER TO postgres;

--
-- TOC entry 2957 (class 0 OID 0)
-- Dependencies: 206
-- Name: diagnozy_id_diagnozy_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.diagnozy_id_diagnozy_seq OWNED BY public.diagnozy.id_diagnozy;


--
-- TOC entry 211 (class 1259 OID 49412)
-- Name: lekarze; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.lekarze (
    id_lekarza integer NOT NULL,
    imie character varying,
    nazwisko character varying,
    pesel character varying,
    nr_gabinetu character varying,
    id_adresu integer
);


ALTER TABLE public.lekarze OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 49410)
-- Name: lekarze_id_lekarza_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.lekarze_id_lekarza_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.lekarze_id_lekarza_seq OWNER TO postgres;

--
-- TOC entry 2958 (class 0 OID 0)
-- Dependencies: 210
-- Name: lekarze_id_lekarza_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.lekarze_id_lekarza_seq OWNED BY public.lekarze.id_lekarza;


--
-- TOC entry 199 (class 1259 OID 49349)
-- Name: leki; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.leki (
    id_leku integer NOT NULL,
    nazwa_leku character varying
);


ALTER TABLE public.leki OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 49347)
-- Name: leki_id_leku_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.leki_id_leku_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.leki_id_leku_seq OWNER TO postgres;

--
-- TOC entry 2959 (class 0 OID 0)
-- Dependencies: 198
-- Name: leki_id_leku_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.leki_id_leku_seq OWNED BY public.leki.id_leku;


--
-- TOC entry 209 (class 1259 OID 49401)
-- Name: pacjenci; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pacjenci (
    id_pacjenta integer NOT NULL,
    id_adresu integer NOT NULL,
    imie character varying,
    nazwisko character varying,
    pesel character varying,
    nr_telefonu character varying
);


ALTER TABLE public.pacjenci OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 49399)
-- Name: pacjenci_id_pacjenta_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.pacjenci_id_pacjenta_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.pacjenci_id_pacjenta_seq OWNER TO postgres;

--
-- TOC entry 2960 (class 0 OID 0)
-- Dependencies: 208
-- Name: pacjenci_id_pacjenta_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.pacjenci_id_pacjenta_seq OWNED BY public.pacjenci.id_pacjenta;


--
-- TOC entry 213 (class 1259 OID 49423)
-- Name: przychodnia; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.przychodnia (
    id_przychodni integer NOT NULL,
    id_adresu integer NOT NULL
);


ALTER TABLE public.przychodnia OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 49421)
-- Name: przychodnia_id_przychodni_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.przychodnia_id_przychodni_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.przychodnia_id_przychodni_seq OWNER TO postgres;

--
-- TOC entry 2961 (class 0 OID 0)
-- Dependencies: 212
-- Name: przychodnia_id_przychodni_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.przychodnia_id_przychodni_seq OWNED BY public.przychodnia.id_przychodni;


--
-- TOC entry 219 (class 1259 OID 49463)
-- Name: specjalizacja_lekarz; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.specjalizacja_lekarz (
    id_lekarza integer NOT NULL,
    id_specjalizacji integer NOT NULL,
    ajdi integer NOT NULL
);


ALTER TABLE public.specjalizacja_lekarz OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 49338)
-- Name: specjalizacje; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.specjalizacje (
    id_specjalizacji integer NOT NULL,
    nazwa character varying
);


ALTER TABLE public.specjalizacje OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 49336)
-- Name: specjalizacje_id_specjalizacji_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.specjalizacje_id_specjalizacji_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.specjalizacje_id_specjalizacji_seq OWNER TO postgres;

--
-- TOC entry 2962 (class 0 OID 0)
-- Dependencies: 196
-- Name: specjalizacje_id_specjalizacji_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.specjalizacje_id_specjalizacji_seq OWNED BY public.specjalizacje.id_specjalizacji;


--
-- TOC entry 201 (class 1259 OID 49360)
-- Name: terminy; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.terminy (
    id_terminu integer NOT NULL,
    data_ date,
    czas_od time without time zone,
    czas_do time without time zone
);


ALTER TABLE public.terminy OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 49358)
-- Name: terminy_id_terminu_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.terminy_id_terminu_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.terminy_id_terminu_seq OWNER TO postgres;

--
-- TOC entry 2963 (class 0 OID 0)
-- Dependencies: 200
-- Name: terminy_id_terminu_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.terminy_id_terminu_seq OWNED BY public.terminy.id_terminu;


--
-- TOC entry 217 (class 1259 OID 49442)
-- Name: urlopy; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.urlopy (
    id_urlopu integer NOT NULL,
    id_lekarza integer NOT NULL,
    data_od date,
    data_do date
);


ALTER TABLE public.urlopy OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 49440)
-- Name: urlopy_id_urlopu_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.urlopy_id_urlopu_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.urlopy_id_urlopu_seq OWNER TO postgres;

--
-- TOC entry 2964 (class 0 OID 0)
-- Dependencies: 216
-- Name: urlopy_id_urlopu_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.urlopy_id_urlopu_seq OWNED BY public.urlopy.id_urlopu;


--
-- TOC entry 215 (class 1259 OID 49434)
-- Name: wizyty; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.wizyty (
    id_wizyty integer NOT NULL,
    id_diagnozy integer NOT NULL,
    id_terminu integer NOT NULL,
    id_przychodni integer NOT NULL,
    id_lekarza integer NOT NULL,
    id_pacjenta integer NOT NULL
);


ALTER TABLE public.wizyty OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 49432)
-- Name: wizyty_id_wizyty_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.wizyty_id_wizyty_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.wizyty_id_wizyty_seq OWNER TO postgres;

--
-- TOC entry 2965 (class 0 OID 0)
-- Dependencies: 214
-- Name: wizyty_id_wizyty_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.wizyty_id_wizyty_seq OWNED BY public.wizyty.id_wizyty;


--
-- TOC entry 218 (class 1259 OID 49448)
-- Name: wizyty_leki_badania; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.wizyty_leki_badania (
    id_wizyty integer NOT NULL,
    id_badania integer NOT NULL,
    id_leku integer NOT NULL,
    ajdi integer NOT NULL
);


ALTER TABLE public.wizyty_leki_badania OWNER TO postgres;

--
-- TOC entry 2763 (class 2604 OID 49371)
-- Name: adresy id_adresu; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.adresy ALTER COLUMN id_adresu SET DEFAULT nextval('public.adresy_id_adresu_seq'::regclass);


--
-- TOC entry 2764 (class 2604 OID 49382)
-- Name: badania id_badania; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.badania ALTER COLUMN id_badania SET DEFAULT nextval('public.badania_id_badania_seq'::regclass);


--
-- TOC entry 2765 (class 2604 OID 49393)
-- Name: diagnozy id_diagnozy; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.diagnozy ALTER COLUMN id_diagnozy SET DEFAULT nextval('public.diagnozy_id_diagnozy_seq'::regclass);


--
-- TOC entry 2767 (class 2604 OID 49415)
-- Name: lekarze id_lekarza; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.lekarze ALTER COLUMN id_lekarza SET DEFAULT nextval('public.lekarze_id_lekarza_seq'::regclass);


--
-- TOC entry 2761 (class 2604 OID 49352)
-- Name: leki id_leku; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.leki ALTER COLUMN id_leku SET DEFAULT nextval('public.leki_id_leku_seq'::regclass);


--
-- TOC entry 2766 (class 2604 OID 49404)
-- Name: pacjenci id_pacjenta; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pacjenci ALTER COLUMN id_pacjenta SET DEFAULT nextval('public.pacjenci_id_pacjenta_seq'::regclass);


--
-- TOC entry 2768 (class 2604 OID 49426)
-- Name: przychodnia id_przychodni; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.przychodnia ALTER COLUMN id_przychodni SET DEFAULT nextval('public.przychodnia_id_przychodni_seq'::regclass);


--
-- TOC entry 2760 (class 2604 OID 49341)
-- Name: specjalizacje id_specjalizacji; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.specjalizacje ALTER COLUMN id_specjalizacji SET DEFAULT nextval('public.specjalizacje_id_specjalizacji_seq'::regclass);


--
-- TOC entry 2762 (class 2604 OID 49363)
-- Name: terminy id_terminu; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.terminy ALTER COLUMN id_terminu SET DEFAULT nextval('public.terminy_id_terminu_seq'::regclass);


--
-- TOC entry 2770 (class 2604 OID 49445)
-- Name: urlopy id_urlopu; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.urlopy ALTER COLUMN id_urlopu SET DEFAULT nextval('public.urlopy_id_urlopu_seq'::regclass);


--
-- TOC entry 2769 (class 2604 OID 49437)
-- Name: wizyty id_wizyty; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.wizyty ALTER COLUMN id_wizyty SET DEFAULT nextval('public.wizyty_id_wizyty_seq'::regclass);


--
-- TOC entry 2932 (class 0 OID 49368)
-- Dependencies: 203
-- Data for Name: adresy; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.adresy (id_adresu, miejscowosc, wojewodztwo, powiat, ulica, nr_domu, kod_pocztowy) FROM stdin;
2	\N	\N	\N	\N	\N	\N
3	\N	\N	\N	\N	\N	\N
4	\N	\N	\N	\N	\N	\N
5	\N	\N	\N	\N	\N	\N
6	\N	\N	\N	\N	\N	\N
7	Rzeszow	Podkarpackie	rzeszowski	Jana Pawła	2	\N
8	Rzeszow	Podkarpackie	rzeszowski	Rejtana	34	\N
9	Krakow	Malopolskie	malopolski	Sobieskiego	12	\N
1	Warszawa	\N	\N	\N	\N	\N
\.


--
-- TOC entry 2934 (class 0 OID 49379)
-- Dependencies: 205
-- Data for Name: badania; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.badania (id_badania, nazwa) FROM stdin;
1	Profilaktyka
2	Morfologia
3	Glukoza
4	Badanie tarczycy
5	Proby watrobowe
\.


--
-- TOC entry 2936 (class 0 OID 49390)
-- Dependencies: 207
-- Data for Name: diagnozy; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.diagnozy (id_diagnozy, nazwa, opis) FROM stdin;
1	Cukrzyca	\N
2	Rak płuc	\N
3	Zdrowy	\N
\.


--
-- TOC entry 2940 (class 0 OID 49412)
-- Dependencies: 211
-- Data for Name: lekarze; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.lekarze (id_lekarza, imie, nazwisko, pesel, nr_gabinetu, id_adresu) FROM stdin;
2	Janusz	Maciejewski	\N	\N	\N
3	Maksymilian	Gorski	\N	\N	\N
4	Marek	Wojciechowski	\N	\N	\N
5	Przemek	Michalski	\N	\N	\N
6	Gabriel	Kucharski	\N	\N	\N
1	Zdzisław	Majewski	\N	\N	\N
\.


--
-- TOC entry 2928 (class 0 OID 49349)
-- Dependencies: 199
-- Data for Name: leki; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.leki (id_leku, nazwa_leku) FROM stdin;
1	Teflexo
2	Prevenar
3	Qlaira
4	Apap
\.


--
-- TOC entry 2938 (class 0 OID 49401)
-- Dependencies: 209
-- Data for Name: pacjenci; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pacjenci (id_pacjenta, id_adresu, imie, nazwisko, pesel, nr_telefonu) FROM stdin;
1	1	Mateusz	Nowak	\N	\N
2	2	Mateusz	Gaj	\N	\N
3	3	Jan	Giermek	\N	\N
4	4	Kamil	Sok	\N	\N
\.


--
-- TOC entry 2942 (class 0 OID 49423)
-- Dependencies: 213
-- Data for Name: przychodnia; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.przychodnia (id_przychodni, id_adresu) FROM stdin;
2	7
1	8
3	9
\.


--
-- TOC entry 2948 (class 0 OID 49463)
-- Dependencies: 219
-- Data for Name: specjalizacja_lekarz; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.specjalizacja_lekarz (id_lekarza, id_specjalizacji, ajdi) FROM stdin;
1	1	1
2	2	2
3	3	3
1	2	4
4	3	5
\.


--
-- TOC entry 2926 (class 0 OID 49338)
-- Dependencies: 197
-- Data for Name: specjalizacje; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.specjalizacje (id_specjalizacji, nazwa) FROM stdin;
2	Kardiolog
3	Dentysta
4	Ortopeda
5	Okulista
6	Psychiatra
7	Pediatra
8	Ginekolog
1	Urolog
\.


--
-- TOC entry 2930 (class 0 OID 49360)
-- Dependencies: 201
-- Data for Name: terminy; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.terminy (id_terminu, data_, czas_od, czas_do) FROM stdin;
1	2019-05-22	\N	\N
2	2019-06-22	\N	\N
3	2018-06-13	\N	\N
4	2019-12-12	\N	\N
\.


--
-- TOC entry 2946 (class 0 OID 49442)
-- Dependencies: 217
-- Data for Name: urlopy; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.urlopy (id_urlopu, id_lekarza, data_od, data_do) FROM stdin;
\.


--
-- TOC entry 2944 (class 0 OID 49434)
-- Dependencies: 215
-- Data for Name: wizyty; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.wizyty (id_wizyty, id_diagnozy, id_terminu, id_przychodni, id_lekarza, id_pacjenta) FROM stdin;
1	1	1	1	1	1
2	2	2	2	2	2
3	2	3	2	2	3
4	3	4	3	3	4
\.


--
-- TOC entry 2947 (class 0 OID 49448)
-- Dependencies: 218
-- Data for Name: wizyty_leki_badania; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.wizyty_leki_badania (id_wizyty, id_badania, id_leku, ajdi) FROM stdin;
1	1	1	1
2	2	3	2
1	2	2	4
3	2	3	5
3	4	4	6
1	3	4	3
4	4	3	7
2	5	4	8
\.


--
-- TOC entry 2966 (class 0 OID 0)
-- Dependencies: 202
-- Name: adresy_id_adresu_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.adresy_id_adresu_seq', 1, false);


--
-- TOC entry 2967 (class 0 OID 0)
-- Dependencies: 204
-- Name: badania_id_badania_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.badania_id_badania_seq', 1, false);


--
-- TOC entry 2968 (class 0 OID 0)
-- Dependencies: 206
-- Name: diagnozy_id_diagnozy_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.diagnozy_id_diagnozy_seq', 1, false);


--
-- TOC entry 2969 (class 0 OID 0)
-- Dependencies: 210
-- Name: lekarze_id_lekarza_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.lekarze_id_lekarza_seq', 1, false);


--
-- TOC entry 2970 (class 0 OID 0)
-- Dependencies: 198
-- Name: leki_id_leku_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.leki_id_leku_seq', 1, false);


--
-- TOC entry 2971 (class 0 OID 0)
-- Dependencies: 208
-- Name: pacjenci_id_pacjenta_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.pacjenci_id_pacjenta_seq', 1, false);


--
-- TOC entry 2972 (class 0 OID 0)
-- Dependencies: 212
-- Name: przychodnia_id_przychodni_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.przychodnia_id_przychodni_seq', 1, false);


--
-- TOC entry 2973 (class 0 OID 0)
-- Dependencies: 196
-- Name: specjalizacje_id_specjalizacji_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.specjalizacje_id_specjalizacji_seq', 1, true);


--
-- TOC entry 2974 (class 0 OID 0)
-- Dependencies: 200
-- Name: terminy_id_terminu_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.terminy_id_terminu_seq', 1, false);


--
-- TOC entry 2975 (class 0 OID 0)
-- Dependencies: 216
-- Name: urlopy_id_urlopu_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.urlopy_id_urlopu_seq', 1, false);


--
-- TOC entry 2976 (class 0 OID 0)
-- Dependencies: 214
-- Name: wizyty_id_wizyty_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.wizyty_id_wizyty_seq', 1, false);


--
-- TOC entry 2778 (class 2606 OID 49376)
-- Name: adresy adresy_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.adresy
    ADD CONSTRAINT adresy_pkey PRIMARY KEY (id_adresu);


--
-- TOC entry 2780 (class 2606 OID 49387)
-- Name: badania badania_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.badania
    ADD CONSTRAINT badania_pkey PRIMARY KEY (id_badania);


--
-- TOC entry 2782 (class 2606 OID 49398)
-- Name: diagnozy diagnozy_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.diagnozy
    ADD CONSTRAINT diagnozy_pkey PRIMARY KEY (id_diagnozy);


--
-- TOC entry 2786 (class 2606 OID 49420)
-- Name: lekarze lekarze_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.lekarze
    ADD CONSTRAINT lekarze_pkey PRIMARY KEY (id_lekarza);


--
-- TOC entry 2774 (class 2606 OID 49357)
-- Name: leki leki_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.leki
    ADD CONSTRAINT leki_pkey PRIMARY KEY (id_leku);


--
-- TOC entry 2784 (class 2606 OID 49409)
-- Name: pacjenci pacjenci_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pacjenci
    ADD CONSTRAINT pacjenci_pkey PRIMARY KEY (id_pacjenta);


--
-- TOC entry 2788 (class 2606 OID 49428)
-- Name: przychodnia przychodnia_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.przychodnia
    ADD CONSTRAINT przychodnia_pkey PRIMARY KEY (id_przychodni);


--
-- TOC entry 2796 (class 2606 OID 49467)
-- Name: specjalizacja_lekarz specjalizacja_lekarz_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.specjalizacja_lekarz
    ADD CONSTRAINT specjalizacja_lekarz_pkey PRIMARY KEY (ajdi);


--
-- TOC entry 2772 (class 2606 OID 49346)
-- Name: specjalizacje specjalizacje_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.specjalizacje
    ADD CONSTRAINT specjalizacje_pkey PRIMARY KEY (id_specjalizacji);


--
-- TOC entry 2776 (class 2606 OID 49365)
-- Name: terminy terminy_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.terminy
    ADD CONSTRAINT terminy_pkey PRIMARY KEY (id_terminu);


--
-- TOC entry 2792 (class 2606 OID 49447)
-- Name: urlopy urlopy_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.urlopy
    ADD CONSTRAINT urlopy_pkey PRIMARY KEY (id_urlopu);


--
-- TOC entry 2794 (class 2606 OID 49479)
-- Name: wizyty_leki_badania wizyty_leki_badania_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.wizyty_leki_badania
    ADD CONSTRAINT wizyty_leki_badania_pkey PRIMARY KEY (ajdi);


--
-- TOC entry 2790 (class 2606 OID 49439)
-- Name: wizyty wizyty_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.wizyty
    ADD CONSTRAINT wizyty_pkey PRIMARY KEY (id_wizyty);


--
-- TOC entry 2797 (class 2606 OID 49458)
-- Name: lekarze id_adresu; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.lekarze
    ADD CONSTRAINT id_adresu FOREIGN KEY (id_lekarza) REFERENCES public.adresy(id_adresu);


--
-- TOC entry 2798 (class 2606 OID 49480)
-- Name: przychodnia id_adresu; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.przychodnia
    ADD CONSTRAINT id_adresu FOREIGN KEY (id_przychodni) REFERENCES public.adresy(id_adresu);


--
-- TOC entry 2801 (class 2606 OID 57519)
-- Name: wizyty_leki_badania id_badania; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.wizyty_leki_badania
    ADD CONSTRAINT id_badania FOREIGN KEY (id_badania) REFERENCES public.badania(id_badania);


--
-- TOC entry 2802 (class 2606 OID 49468)
-- Name: specjalizacja_lekarz id_lekarza; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.specjalizacja_lekarz
    ADD CONSTRAINT id_lekarza FOREIGN KEY (id_lekarza) REFERENCES public.lekarze(id_lekarza);


--
-- TOC entry 2800 (class 2606 OID 57514)
-- Name: wizyty_leki_badania id_leku; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.wizyty_leki_badania
    ADD CONSTRAINT id_leku FOREIGN KEY (id_leku) REFERENCES public.leki(id_leku);


--
-- TOC entry 2803 (class 2606 OID 49473)
-- Name: specjalizacja_lekarz id_specjalizacji; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.specjalizacja_lekarz
    ADD CONSTRAINT id_specjalizacji FOREIGN KEY (id_specjalizacji) REFERENCES public.specjalizacje(id_specjalizacji);


--
-- TOC entry 2799 (class 2606 OID 57504)
-- Name: wizyty_leki_badania id_wizyty; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.wizyty_leki_badania
    ADD CONSTRAINT id_wizyty FOREIGN KEY (id_wizyty) REFERENCES public.wizyty(id_wizyty);


-- Completed on 2020-06-16 03:31:20

--
-- PostgreSQL database dump complete
--

