begin;

drop schema if exists customer_schema cascade;
create schema customer_schema;

drop table if exists customer_schema.customers;
create table customer_schema.customers (
  id            serial             not null,
  firstName   varchar(50)         not null,
  lastName    varchar(50)         not null,
  middleName  varchar(50)                 ,
  phone        bigint      unique  not null,
  email        varchar(50)                 ,

  primary key (id)
);

commit;