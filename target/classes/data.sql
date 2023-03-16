insert into sample values ('gvfhjsbdjhsbc');

insert into restaurant (id, name, city, locality, address, is_recommended, cuisine_type, date_time_onboarded,
                        rating, cost_bracket) values ('1f562597-a1ca-41f4-82bd-8b9ea0271b20', 'My Restro Cafe', 'Bengaluru', 'Whitefield', 'Whitefield, Bluru',
                        true, 'NORTH_INDIAN', '2022-03-01 23:00:00', 4.5, 3);
insert into restaurant (id, name, city, locality, address, is_recommended, cuisine_type, date_time_onboarded,
                        rating, cost_bracket) values('2f562597-a1ca-41f4-82bd-8b9ea0271b21', 'Chinx', 'Bengaluru', 'Whitefield', 'Whitefield, Bluru',
                        false, 'CHINESE', '2023-01-01 23:00:00', 4.5, 3);
insert into restaurant (id, name, city, locality, address, is_recommended, cuisine_type, date_time_onboarded,
                        rating, cost_bracket) values ('3f562597-a1ca-41f4-82bd-8b9ea0271b22', 'Udupi', 'Bengaluru', 'Whitefield', 'Whitefield, Bluru',
                        true, 'SOUTH_INDIAN', '2022-12-01 23:00:00', 4.5, 3);
insert into restaurant (id, name, city, locality, address, is_recommended, cuisine_type, date_time_onboarded,
                        rating, cost_bracket) values ('4f562597-a1ca-41f4-82bd-8b9ea0271b23', 'Mumbai Tiffins', 'Bengaluru', 'Whitefield', 'Whitefield, Bluru',
                        false, 'NORTH_INDIAN', '2023-11-01 23:00:00',3.0, 5);
insert into restaurant (id, name, city, locality, address, is_recommended, cuisine_type, date_time_onboarded,
                        rating, cost_bracket) values ('5f562597-a1ca-41f4-82bd-8b9ea0271b24', 'Foodles', 'Bengaluru', 'Whitefield', 'Whitefield, Bluru',
                        true, 'CHINESE', '2023-03-01 02:00:00',3.5, 5);
insert into restaurant (id, name, city, locality, address, is_recommended, cuisine_type, date_time_onboarded,
                        rating, cost_bracket) values ('6f562597-a1ca-41f4-82bd-8b9ea0271b25', 'Rasaganga', 'Bengaluru', 'Whitefield', 'Whitefield, Bluru',
                        false, 'SOUTH_INDIAN', '2023-02-15 23:00:00',2.5, 5);
insert into restaurant (id, name, city, locality, address, is_recommended, cuisine_type, date_time_onboarded,
                        rating, cost_bracket) values ('7f562597-a1ca-41f4-82bd-8b9ea0271b26', 'Punjabi Cafe', 'Bengaluru', 'Whitefield', 'Whitefield, Bluru',
                        true, 'NORTH_INDIAN', '2023-03-01 23:15:00', 4.5, 4);
insert into restaurant (id, name, city, locality, address, is_recommended, cuisine_type, date_time_onboarded,
                        rating, cost_bracket) values ('8f562597-a1ca-41f4-82bd-8b9ea0271b27', 'Xhatkaaz', 'Bengaluru', 'Whitefield', 'Whitefield, Bluru',
                        false, 'CHINESE', '2023-03-01 23:00:00', 5.0, 4);
insert into restaurant (id, name, city, locality, address, is_recommended, cuisine_type, date_time_onboarded,
                        rating, cost_bracket) values ('9f562597-a1ca-41f4-82bd-8b9ea0271b28', 'Xosa Plaza', 'Bengaluru', 'Whitefield', 'Whitefield, Bluru',
                        true, 'SOUTH_INDIAN', '2023-03-05 23:00:00', 4.0, 4);
insert into restaurant (id, name, city, locality, address, is_recommended, cuisine_type, date_time_onboarded,
                        rating, cost_bracket) values ('7f562597-a1ca-41f4-82bd-8b9ea0271b66', 'Xunjabi Cafe', 'Bengaluru', 'Whitefield', 'Whitefield, Bluru',
                        true, 'NORTH_INDIAN', '2023-03-01 23:15:00', 2.5, 4);
insert into restaurant (id, name, city, locality, address, is_recommended, cuisine_type, date_time_onboarded,
                        rating, cost_bracket) values ('8f562597-a1ca-46f4-82bd-8b6ea0271b27', 'Chatkaaz', 'Bengaluru', 'Whitefield', 'Whitefield, Bluru',
                        false, 'CHINESE', '2023-03-01 23:00:00', 3.5, 4);
insert into restaurant (id, name, city, locality, address, is_recommended, cuisine_type, date_time_onboarded,
                        rating, cost_bracket) values ('9f562597-a6ca-41f4-82bd-8b9ea0276b28', 'Dosa Plaza', 'Bengaluru', 'Whitefield', 'Whitefield, Bluru',
                        true, 'SOUTH_INDIAN', '2023-03-05 23:00:00', 4.0, 4);


insert into user_orders (order_id, user_id, restaurant_id, cuisine_type, cost_bracket, order_date)
values ('0x129856-q9ii-41f4-82bd-8b9ea0271b28', '0x129856-a1ca-41f4-82bd-8b9ea0271b28', '9f562597-a1ca-41f4-82bd-8b9ea0271b28', 'SOUTH_INDIAN', 2, '2023-03-01 23:15:00');
insert into user_orders (order_id, user_id, restaurant_id, cuisine_type, cost_bracket, order_date)
values ('0x129856-p0bd-41f4-82bd-8b9ea0271b28', '0x129856-a1ca-41f4-82bd-8b9ea0271b28', '6f562597-a1ca-41f4-82bd-8b9ea0271b25', 'SOUTH_INDIAN', 5, '2023-03-01 23:15:00');
insert into user_orders (order_id, user_id, restaurant_id, cuisine_type, cost_bracket, order_date)
values ('0x129856-f8sd-41f4-82bd-8b9ea0271b28', '0x129856-a1ca-41f4-82bd-8b9ea0271b28', '3f562597-a1ca-41f4-82bd-8b9ea0271b22', 'SOUTH_INDIAN', 4, '2023-03-01 23:15:00');

insert into user_orders (order_id, user_id, restaurant_id, cuisine_type, cost_bracket, order_date)
values ('0x129856-k7sb-41f4-82bd-8b9ea0271b28', '1p129856-a1ca-41f4-82bd-8b9ea0271b28', '5f562597-a1ca-41f4-82bd-8b9ea0271b24', 'CHINESE', 4, '2023-03-01 23:15:00');
insert into user_orders (order_id, user_id, restaurant_id, cuisine_type, cost_bracket, order_date)
values ('0x129856-c9xb-41f4-82bd-8b9ea0271b28', '2o129856-a1ca-41f4-82bd-8b9ea0271b28', '5f562597-a1ca-41f4-82bd-8b9ea0271b24', 'CHINESE', 4, '2023-03-01 23:15:00');
insert into user_orders (order_id, user_id, restaurant_id, cuisine_type, cost_bracket, order_date)
values ('0x129856-m8sd-41f4-82bd-8b9ea0271b28', '3d129856-a1ca-41f4-82bd-8b9ea0271b28', '7f562597-a1ca-41f4-82bd-8b9ea0271b26', 'NORTH_INDIAN', 3, '2023-03-01 23:15:00');




