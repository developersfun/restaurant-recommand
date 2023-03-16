create table sample (ID varchar(20) UNIQUE);

create table restaurant (id varchar(255) not null, address varchar(255), city varchar(255), rating float(4),
cost_bracket integer, cuisine_type varchar(255), date_time_onboarded timestamp(6),
is_recommended boolean, locality varchar(255), name varchar(255), primary key (id));

create table user_orders (order_id varchar(255) not null, user_id varchar(255) not null, restaurant_id varchar(255) not null,
cost_bracket integer, cuisine_type varchar(255),  order_date timestamp(6), primary key (order_id));
