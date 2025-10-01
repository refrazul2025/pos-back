CREATE TABLE user_outlet (
    user_id INT NOT NULL,
    outlet_id BIGINT NOT NULL,
    role VARCHAR(50), -- opcional: para definir rol en la tienda (ej. admin, cashier, manager)
    assigned_at TIMESTAMP DEFAULT NOW(), -- opcional: fecha de asignación
    PRIMARY KEY (user_id, outlet_id),
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    CONSTRAINT fk_outlet FOREIGN KEY (outlet_id) REFERENCES outlet(id) ON DELETE CASCADE
);


CREATE INDEX idx_user_outlet_user ON user_outlet(user_id);
CREATE INDEX idx_user_outlet_outlet ON user_outlet(outlet_id);