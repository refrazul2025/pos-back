CREATE TABLE sale (
    id BIGSERIAL PRIMARY KEY,
    sale_date DATE NOT NULL,
    sale_type VARCHAR(50),
    total NUMERIC(15,2),
    sale_closed BOOLEAN DEFAULT FALSE,
    customer VARCHAR(255),
    outlet_id BIGINT NOT NULL,
    CONSTRAINT fk_sale_branch FOREIGN KEY (outlet_id) REFERENCES outlet(id)
);