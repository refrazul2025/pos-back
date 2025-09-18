CREATE TABLE payment (
    id BIGSERIAL PRIMARY KEY,
    sale_id BIGINT NOT NULL,
    amount_paid NUMERIC(15,2),
    payment_date DATE,
    payment_type VARCHAR(50),
    CONSTRAINT fk_payment_sale FOREIGN KEY (sale_id) REFERENCES sale(id)
);