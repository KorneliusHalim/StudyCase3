PGDMP     "    	                x            atm_simulation    11.6    12.0                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    1386386    atm_simulation    DATABASE     �   CREATE DATABASE atm_simulation WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'English_Indonesia.1252' LC_CTYPE = 'English_Indonesia.1252';
    DROP DATABASE atm_simulation;
                postgres    false            �            1259    1386413    account    TABLE     �   CREATE TABLE public.account (
    account_number character varying(6) NOT NULL,
    name character varying(255),
    pin character varying(6),
    balance numeric(12,0)
);
    DROP TABLE public.account;
       public            postgres    false            �            1259    1386420    transaction_record    TABLE     �   CREATE TABLE public.transaction_record (
    id integer NOT NULL,
    account_number character varying(6),
    transaction_type_id integer,
    transaction numeric(12,0)
);
 &   DROP TABLE public.transaction_record;
       public            postgres    false            �            1259    1386418    transaction_record_id_seq    SEQUENCE     �   CREATE SEQUENCE public.transaction_record_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.transaction_record_id_seq;
       public          postgres    false    198                       0    0    transaction_record_id_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public.transaction_record_id_seq OWNED BY public.transaction_record.id;
          public          postgres    false    197            �            1259    1386428    transaction_type    TABLE     c   CREATE TABLE public.transaction_type (
    id integer NOT NULL,
    name character varying(255)
);
 $   DROP TABLE public.transaction_type;
       public            postgres    false            �            1259    1386426    transaction_type_id_seq    SEQUENCE     �   CREATE SEQUENCE public.transaction_type_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.transaction_type_id_seq;
       public          postgres    false    200                       0    0    transaction_type_id_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.transaction_type_id_seq OWNED BY public.transaction_type.id;
          public          postgres    false    199            �
           2604    1386423    transaction_record id    DEFAULT     ~   ALTER TABLE ONLY public.transaction_record ALTER COLUMN id SET DEFAULT nextval('public.transaction_record_id_seq'::regclass);
 D   ALTER TABLE public.transaction_record ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    197    198    198            �
           2604    1386431    transaction_type id    DEFAULT     z   ALTER TABLE ONLY public.transaction_type ALTER COLUMN id SET DEFAULT nextval('public.transaction_type_id_seq'::regclass);
 B   ALTER TABLE public.transaction_type ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    199    200    200                      0    1386413    account 
   TABLE DATA           E   COPY public.account (account_number, name, pin, balance) FROM stdin;
    public          postgres    false    196          
          0    1386420    transaction_record 
   TABLE DATA           b   COPY public.transaction_record (id, account_number, transaction_type_id, transaction) FROM stdin;
    public          postgres    false    198   K                 0    1386428    transaction_type 
   TABLE DATA           4   COPY public.transaction_type (id, name) FROM stdin;
    public          postgres    false    200   h                  0    0    transaction_record_id_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.transaction_record_id_seq', 1, false);
          public          postgres    false    197                       0    0    transaction_type_id_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.transaction_type_id_seq', 1, false);
          public          postgres    false    199            �
           2606    1386417    account account_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.account
    ADD CONSTRAINT account_pkey PRIMARY KEY (account_number);
 >   ALTER TABLE ONLY public.account DROP CONSTRAINT account_pkey;
       public            postgres    false    196            �
           2606    1386425 *   transaction_record transaction_record_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public.transaction_record
    ADD CONSTRAINT transaction_record_pkey PRIMARY KEY (id);
 T   ALTER TABLE ONLY public.transaction_record DROP CONSTRAINT transaction_record_pkey;
       public            postgres    false    198            �
           2606    1386433 &   transaction_type transaction_type_pkey 
   CONSTRAINT     d   ALTER TABLE ONLY public.transaction_type
    ADD CONSTRAINT transaction_type_pkey PRIMARY KEY (id);
 P   ALTER TABLE ONLY public.transaction_type DROP CONSTRAINT transaction_type_pkey;
       public            postgres    false    200               6   x�342615���/�K��,-�4��������!�GbNf.'������� �V      
      x������ � �         (   x�3��,�H)J,�2�t+�KQ)J�+NK-����� ��	n     