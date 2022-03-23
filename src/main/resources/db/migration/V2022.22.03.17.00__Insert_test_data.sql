INSERT INTO product (id, name)
VALUES (1, 'AppleTV'),
       (2, 'XiaomiTV'),
       (3, 'SamsungTV'),
       (4, 'LgTV'),
       (5, 'SonyTV'),
       (6, 'PanasonicTV'),
       (7, 'PhilipsTV');


INSERT INTO warehouse (id, name, latitude, longitude)
VALUES (1, 'Westminster', 10.16, 140.90),
       (2, 'Greenwich', 56.78, 112.42),
       (3, 'Islington', 27.89, 63.33),
       (4, 'Camden', 44.94, 46.93),
       (5, 'Kensington and Chelsea', 89.42, 120.12),
       (6, 'Lewisham', 46.78, 20.56),
       (7, 'Southwark', 77.87, 177.23);


INSERT INTO warehouse_product (id, warehouse_id, product_id)
VALUES (1, 1, 1),
       (2, 1, 2),
       (3, 1, 3),
       (4, 1, 4),
       (5, 1, 5),
       (6, 6, 6),
       (7, 7, 7),
       (8, 2, 1),
       (9, 2, 2),
       (10, 2, 3),
       (11, 2, 4),
       (12, 5, 5),
       (13, 2, 6),
       (14, 2, 7),
       (15, 3, 1),
       (16, 3, 2),
       (17, 3, 3),
       (18, 3, 1),
       (19, 3, 2),
       (20, 7, 3),
       (21, 4, 4),
       (22, 3, 5),
       (23, 4, 6),
       (24, 3, 7);