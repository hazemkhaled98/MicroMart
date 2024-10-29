CREATE TABLE IF NOT EXISTS orders
(
    id       BIGINT PRIMARY KEY AUTO_INCREMENT,
    sku_code VARCHAR(255)   NOT NULL,
    price    DECIMAL(15, 2) NOT NULL,
    quantity INT            NOT NULL
);