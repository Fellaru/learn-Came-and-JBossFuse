begin;

drop schema if exists customer_schema cascade;
create schema customer_schema;

drop table if exists customer_schema.customers;
create table customer_schema.customers (
  id            serial             not null,
  first_name   varchar(50)         not null,
  last_name    varchar(50)         not null,
  middle_name  varchar(50)                 ,
  phone        integer     unique  not null,
  email        varchar(50)                 ,

  primary key (id)
);

commit;