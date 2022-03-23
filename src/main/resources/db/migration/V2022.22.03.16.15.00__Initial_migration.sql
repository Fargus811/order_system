CREATE TABLE customer
(
    id         BIGINT      NOT NULL PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(24) NOT NULL,
    last_name  VARCHAR(24) NOT NULL,
    latitude   DOUBLE      NOT NULL,
    longitude  DOUBLE      NOT NULL
);

CREATE TABLE warehouse
(
    id        BIGINT      NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name      VARCHAR(24) NOT NULL,
    latitude  DOUBLE      NOT NULL,
    longitude DOUBLE      NOT NULL
);

CREATE TABLE warehouse_product
(
    id           BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    warehouse_id BIGINT NOT NULL,
    product_id   BIGINT NOT NULL
);

CREATE TABLE product
(
    id   BIGINT      NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(24) NOT NULL
);

CREATE TABLE customer_order
(
    id                             BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    customer_id                    BIGINT NOT NULL,
    product_id                     BIGINT NOT NULL,
    warehouse_id                   BIGINT NOT NULL,
    distance                       DOUBLE NOT NULL
);

CREATE TABLE warehouse_distance_to_customer
(
    id           BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    customer_id  BIGINT NOT NULL,
    warehouse_id BIGINT NOT NULL,
    distance     DOUBLE NOT NULL
);