CREATE TABLE product (
    code VARCHAR(50) PRIMARY KEY,
    description VARCHAR(255),
    category1 VARCHAR(100),
    category2 VARCHAR(100),
    barcode VARCHAR(100),
    purchase_price NUMERIC(15,2),
    sale_price NUMERIC(15,2),
    current_stock INT,
    outlet_id BIGINT NOT NULL,
    create_at TIMESTAMP WITHOUT TIME ZONE,
    update_at TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT fk_product_outlet FOREIGN KEY (outlet_id) REFERENCES outlet(id)
);