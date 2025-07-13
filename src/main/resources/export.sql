
CREATE DATABASE libros;
--
-- TOC entry 220 (class 1259 OID 16393)
-- Name: autor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.autor (
    id integer NOT NULL,
    nombre character varying(250),
    anio_inicio integer,
    anio_fin integer
);


ALTER TABLE public.autor OWNER TO postgres;

--
-- TOC entry 4935 (class 0 OID 0)
-- Dependencies: 220
-- Name: TABLE autor; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.autor IS 'Tabla información del autor de el libro';


--
-- TOC entry 4936 (class 0 OID 0)
-- Dependencies: 220
-- Name: COLUMN autor.id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.autor.id IS 'Identificador de la tabla autor';


--
-- TOC entry 4937 (class 0 OID 0)
-- Dependencies: 220
-- Name: COLUMN autor.nombre; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.autor.nombre IS 'Nombre del autor de el libro';


--
-- TOC entry 219 (class 1259 OID 16392)
-- Name: autor_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.autor_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.autor_id_seq OWNER TO postgres;

--
-- TOC entry 4938 (class 0 OID 0)
-- Dependencies: 219
-- Name: autor_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.autor_id_seq OWNED BY public.autor.id;


--
-- TOC entry 222 (class 1259 OID 16400)
-- Name: lenguaje; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.lenguaje (
    id integer NOT NULL,
    codigo character varying(3),
    nombre character varying(250)
);


ALTER TABLE public.lenguaje OWNER TO postgres;

--
-- TOC entry 4939 (class 0 OID 0)
-- Dependencies: 222
-- Name: TABLE lenguaje; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.lenguaje IS 'Tabla información del lenguaje de el libro';


--
-- TOC entry 4940 (class 0 OID 0)
-- Dependencies: 222
-- Name: COLUMN lenguaje.id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.lenguaje.id IS 'Identificador de la tabla lenguaje';


--
-- TOC entry 4941 (class 0 OID 0)
-- Dependencies: 222
-- Name: COLUMN lenguaje.codigo; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.lenguaje.codigo IS 'Código de moneda correspondiente al país';


--
-- TOC entry 4942 (class 0 OID 0)
-- Dependencies: 222
-- Name: COLUMN lenguaje.nombre; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.lenguaje.nombre IS 'Nombre del país asociado al código de moneda';


--
-- TOC entry 221 (class 1259 OID 16399)
-- Name: lenguaje_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.lenguaje_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.lenguaje_id_seq OWNER TO postgres;

--
-- TOC entry 4943 (class 0 OID 0)
-- Dependencies: 221
-- Name: lenguaje_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.lenguaje_id_seq OWNED BY public.lenguaje.id;


--
-- TOC entry 218 (class 1259 OID 16386)
-- Name: libro; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.libro (
    id integer NOT NULL,
    titulo character varying(250),
    numero_descargas integer
);


ALTER TABLE public.libro OWNER TO postgres;

--
-- TOC entry 4944 (class 0 OID 0)
-- Dependencies: 218
-- Name: TABLE libro; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.libro IS 'Tabla información de el libro';


--
-- TOC entry 4945 (class 0 OID 0)
-- Dependencies: 218
-- Name: COLUMN libro.id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.libro.id IS 'Identificador de la tabla libro';


--
-- TOC entry 4946 (class 0 OID 0)
-- Dependencies: 218
-- Name: COLUMN libro.titulo; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.libro.titulo IS 'título del libro';


--
-- TOC entry 4947 (class 0 OID 0)
-- Dependencies: 218
-- Name: COLUMN libro.numero_descargas; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.libro.numero_descargas IS 'número de descargar del libro';


--
-- TOC entry 223 (class 1259 OID 16406)
-- Name: libro_autor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.libro_autor (
    id_libro integer NOT NULL,
    id_autor integer NOT NULL
);


ALTER TABLE public.libro_autor OWNER TO postgres;

--
-- TOC entry 4948 (class 0 OID 0)
-- Dependencies: 223
-- Name: TABLE libro_autor; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.libro_autor IS 'Relación para registrar los autores del libro';


--
-- TOC entry 217 (class 1259 OID 16385)
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
-- TOC entry 4949 (class 0 OID 0)
-- Dependencies: 217
-- Name: libro_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.libro_id_seq OWNED BY public.libro.id;


--
-- TOC entry 224 (class 1259 OID 16411)
-- Name: libro_lenguaje; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.libro_lenguaje (
    id_libro integer NOT NULL,
    id_lenguaje integer NOT NULL
);


ALTER TABLE public.libro_lenguaje OWNER TO postgres;

--
-- TOC entry 4950 (class 0 OID 0)
-- Dependencies: 224
-- Name: TABLE libro_lenguaje; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.libro_lenguaje IS 'Tabla relación para asociar los lenguajes de un libro';


--
-- TOC entry 4761 (class 2604 OID 16396)
-- Name: autor id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.autor ALTER COLUMN id SET DEFAULT nextval('public.autor_id_seq'::regclass);


--
-- TOC entry 4762 (class 2604 OID 16403)
-- Name: lenguaje id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.lenguaje ALTER COLUMN id SET DEFAULT nextval('public.lenguaje_id_seq'::regclass);


--
-- TOC entry 4760 (class 2604 OID 16389)
-- Name: libro id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.libro ALTER COLUMN id SET DEFAULT nextval('public.libro_id_seq'::regclass);


--
-- TOC entry 4925 (class 0 OID 16393)
-- Dependencies: 220
-- Data for Name: autor; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.autor (id, nombre, anio_inicio, anio_fin) FROM stdin;
1	Melville, Herman	1819	1891
3	Dostoyevsky, Fyodor	1821	1881
4	Gage, Matilda Joslyn	1826	1898
5	Kartini, Raden Adjeng	1879	1904
\.


--
-- TOC entry 4927 (class 0 OID 16400)
-- Dependencies: 222
-- Data for Name: lenguaje; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.lenguaje (id, codigo, nombre) FROM stdin;
1	en	inglés
2	en	inglés
3	en	inglés
4	en	inglés
5	es	español
\.


--
-- TOC entry 4923 (class 0 OID 16386)
-- Dependencies: 218
-- Data for Name: libro; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.libro (id, titulo, numero_descargas) FROM stdin;
4	Moby Dick; Or, The Whale	104393
6	Crime and Punishment	36481
7	Woman, Church & State: The Original Exposé of Male Collaboration Against the Female Sex	987
8	Letters of a Javanese Princess	789
\.


--
-- TOC entry 4928 (class 0 OID 16406)
-- Dependencies: 223
-- Data for Name: libro_autor; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.libro_autor (id_libro, id_autor) FROM stdin;
4	1
6	3
7	4
8	5
\.


--
-- TOC entry 4929 (class 0 OID 16411)
-- Dependencies: 224
-- Data for Name: libro_lenguaje; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.libro_lenguaje (id_libro, id_lenguaje) FROM stdin;
4	1
6	2
7	3
8	4
8	5
\.


--
-- TOC entry 4951 (class 0 OID 0)
-- Dependencies: 219
-- Name: autor_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.autor_id_seq', 5, true);


--
-- TOC entry 4952 (class 0 OID 0)
-- Dependencies: 221
-- Name: lenguaje_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.lenguaje_id_seq', 5, true);


--
-- TOC entry 4953 (class 0 OID 0)
-- Dependencies: 217
-- Name: libro_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.libro_id_seq', 8, true);


--
-- TOC entry 4766 (class 2606 OID 16398)
-- Name: autor autor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.autor
    ADD CONSTRAINT autor_pkey PRIMARY KEY (id);


--
-- TOC entry 4768 (class 2606 OID 16405)
-- Name: lenguaje lenguaje_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.lenguaje
    ADD CONSTRAINT lenguaje_pkey PRIMARY KEY (id);


--
-- TOC entry 4770 (class 2606 OID 16410)
-- Name: libro_autor libro_autor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.libro_autor
    ADD CONSTRAINT libro_autor_pkey PRIMARY KEY (id_libro, id_autor);


--
-- TOC entry 4772 (class 2606 OID 16415)
-- Name: libro_lenguaje libro_lenguaje_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.libro_lenguaje
    ADD CONSTRAINT libro_lenguaje_pkey PRIMARY KEY (id_libro, id_lenguaje);


--
-- TOC entry 4764 (class 2606 OID 16391)
-- Name: libro libro_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.libro
    ADD CONSTRAINT libro_pkey PRIMARY KEY (id);


--
-- TOC entry 4773 (class 2606 OID 16426)
-- Name: libro_autor fk_id_autor_with_libro_autor; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.libro_autor
    ADD CONSTRAINT fk_id_autor_with_libro_autor FOREIGN KEY (id_autor) REFERENCES public.autor(id) NOT VALID;


--
-- TOC entry 4775 (class 2606 OID 16436)
-- Name: libro_lenguaje fk_id_lenguaje_with_libro_lenguaje; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.libro_lenguaje
    ADD CONSTRAINT fk_id_lenguaje_with_libro_lenguaje FOREIGN KEY (id_lenguaje) REFERENCES public.lenguaje(id) NOT VALID;


--
-- TOC entry 4774 (class 2606 OID 16421)
-- Name: libro_autor fk_id_libro_with_libro_autor; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.libro_autor
    ADD CONSTRAINT fk_id_libro_with_libro_autor FOREIGN KEY (id_libro) REFERENCES public.libro(id) NOT VALID;


--
-- TOC entry 4776 (class 2606 OID 16431)
-- Name: libro_lenguaje fk_id_libro_with_libro_lenguaje; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.libro_lenguaje
    ADD CONSTRAINT fk_id_libro_with_libro_lenguaje FOREIGN KEY (id_libro) REFERENCES public.libro(id) NOT VALID;


-- Completed on 2025-07-13 16:45:47

--
-- PostgreSQL database dump complete
--

