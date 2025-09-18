CREATE TABLE sale_detail (
    id BIGSERIAL PRIMARY KEY,
    sale_id BIGINT NOT NULL,
    product_code VARCHAR(100),
    quantity INT,
    unit_price NUMERIC(15,2),
    subtotal NUMERIC(15,2),
    CONSTRAINT fk_sale_detail_sale FOREIGN KEY (sale_id) REFERENCES sale(id)
);
