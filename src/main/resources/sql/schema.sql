create table if not exists customer (id BIGSERIAL not null, fist_name varchar(255), last_name varchar(255), primary key (id));
create table if not exists customer_copy (id BIGSERIAL not null, fist_name varchar(255), last_name varchar(255), primary key (id));