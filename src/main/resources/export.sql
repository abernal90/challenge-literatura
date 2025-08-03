CREATE DATABASE libros;

CREATE EXTENSION unaccent;

CREATE TABLE public.libro (
    id integer NOT NULL,
    titulo character varying(255),
    numero_descargas integer,
    autor character varying(255),
    anio_inicio integer,
    anio_fin integer,
    codigo_lenguaje character varying(255),
    lenguaje character varying(255)
);


ALTER TABLE public.libro OWNER TO postgres;

--
-- TOC entry 4905 (class 0 OID 0)
-- Dependencies: 219
-- Name: TABLE libro; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.libro IS 'Tabla información de el libro';


--
-- TOC entry 4906 (class 0 OID 0)
-- Dependencies: 219
-- Name: COLUMN libro.id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.libro.id IS 'Identificador de la tabla libro';


--
-- TOC entry 4907 (class 0 OID 0)
-- Dependencies: 219
-- Name: COLUMN libro.titulo; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.libro.titulo IS 'título del libro';


--
-- TOC entry 4908 (class 0 OID 0)
-- Dependencies: 219
-- Name: COLUMN libro.numero_descargas; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.libro.numero_descargas IS 'número de descargar del libro';


--
-- TOC entry 218 (class 1259 OID 16385)
-- Name: libro_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.libro_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.libro_id_seq OWNER TO postgres;

--
-- TOC entry 4909 (class 0 OID 0)
-- Dependencies: 218
-- Name: libro_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.libro_id_seq OWNED BY public.libro.id;


--
-- TOC entry 4749 (class 2604 OID 16389)
-- Name: libro id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.libro ALTER COLUMN id SET DEFAULT nextval('public.libro_id_seq'::regclass);


--
-- TOC entry 4898 (class 0 OID 16386)
-- Dependencies: 219
-- Data for Name: libro; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.libro (id, titulo, numero_descargas, autor, anio_inicio, anio_fin, codigo_lenguaje, lenguaje) FROM stdin;
1	Moby Dick; Or, The Whale	115502	Melville, Herman	1819	1891	en	inglés
2	Letters of a Javanese Princess	794	Kartini, Raden Adjeng	1879	1904	en	inglés
\.


--
-- TOC entry 4910 (class 0 OID 0)
-- Dependencies: 218
-- Name: libro_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.libro_id_seq', 2, true);


--
-- TOC entry 4751 (class 2606 OID 16391)
-- Name: libro libro_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.libro
    ADD CONSTRAINT libro_pkey PRIMARY KEY (id);


-- Completed on 2025-08-03 04:55:31

--
-- PostgreSQL database dump complete
--

