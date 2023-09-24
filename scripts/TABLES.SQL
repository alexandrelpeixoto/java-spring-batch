-- Table: bill.tppl_invoice_detail

-- DROP TABLE IF EXISTS billing.tppl_call;
create schema invoice;

CREATE SEQUENCE IF NOT EXISTS invoice.tppl_invoice_detail_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE invoice.tppl_invoice_detail_seq
    OWNER TO postgres;


CREATE TABLE IF NOT EXISTS invoice.tppl_invoice_detail

(
    id_invoice_detail bigint NOT NULL DEFAULT nextval('invoice.tppl_invoice_detail_seq'::regclass),
    id_invoice bigint NOT NULL,
    id_client bigint NOT NULL,
    dt_expiry timestamp(3) without time zone NOT NULL,
    dt_issue timestamp(3) without time zone NOT NULL,
    dt_detail timestamp(3) without time zone ,
    hr_detail time(6) without time zone ,
    de_identifier character varying(50) COLLATE pg_catalog."default",
    de_cnl_local_area character varying(10) COLLATE pg_catalog."default",
    de_ddd character varying(10) COLLATE pg_catalog."default",
    de_phone_number character varying(20) COLLATE pg_catalog."default",
    de_cnl_destiny_phone character varying(50) COLLATE pg_catalog."default",
    de_locality_name character varying(50) COLLATE pg_catalog."default",
    de_uf_destiny_phone character varying(5) COLLATE pg_catalog."default",
    de_supplier_code character varying(10) COLLATE pg_catalog."default",
    de_supplier_description character varying(50) COLLATE pg_catalog."default",
    de_country_code character varying(10) COLLATE pg_catalog."default",
    nr_duration integer,
    de_category character varying(10) COLLATE pg_catalog."default",
    de_category_description character varying(255) COLLATE pg_catalog."default",
    de_cost_signal character varying(5) COLLATE pg_catalog."default",
  
    
    -- campos novos com humberto 
    vl_cost numeric(15,5),
    de_service character varying(255) COLLATE pg_catalog."default",
    de_data_unit character varying(5) COLLATE pg_catalog."default",
    nr_consumption bigint ,
    id_service_group_detail bigint ,
    id_user_created bigint ,
    id_user_updated bigint ,
    dt_created timestamp(3) with time zone,
    dt_updated timestamp(3) with time zone,
	de_line_type character varying(5) COLLATE pg_catalog."default", -- tipo da linha 3 , 4, 5, 7 
	
    
    
    -- campos somente do tipo call da fatura
    de_ddd_area character varying(10) COLLATE pg_catalog."default",
    de_dialed_number  character varying(20) COLLATE pg_catalog."default",
    de_call_type  character varying(10) COLLATE pg_catalog."default",
    de_billing_hour_descrption  character varying(25) COLLATE pg_catalog."default",
    nr_icms_aliquot numeric(15,5),
    -- campos do tipo de SERVICE
    de_service_unit character varying(50) COLLATE pg_catalog."default",
    de_category_group character varying(100) COLLATE pg_catalog."default",
    de_category_group_description character varying(255) COLLATE pg_catalog."default",
    de_national_internation_code character varying(50) COLLATE pg_catalog."default",
    de_service_description character varying(255) COLLATE pg_catalog."default",

    -- campos do tipo descontos
    de_unique_account_identifier character varying(50) COLLATE pg_catalog."default",
    dt_begin_fix timestamp(3) without time zone ,
    dt_end_fix timestamp(3) without time zone ,
    hr_begin_fix time(6) without time zone ,
    hr_end_fix time(6) without time zone ,
    nr_calc_base_discount numeric(15,5),
    nr_discount_percent numeric(15,5),

    CONSTRAINT tppl_incoive_detail_pkey PRIMARY KEY (id_invoice_detail)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE IF EXISTS invoice.tppl_invoice_detail
    OWNER to postgres;
-- Index: uq_tcyt_call_01
