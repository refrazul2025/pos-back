CREATE TABLE sale_balance (
    id SERIAL PRIMARY KEY,
    cargo NUMERIC(15,2) DEFAULT 0.00,
    abono NUMERIC(15,2) DEFAULT 0.00,
    saldo NUMERIC(15,2) DEFAULT 0.00,
    description TEXT,                        -- Detalle o nota opcional
    balance_date DATE NOT NULL
);

CREATE TABLE general_balance (
    id SERIAL PRIMARY KEY,
    reference_id BIGINT,                     -- ID del registro origen (sale, purchase, etc.)
    reference_type VARCHAR(50) NOT NULL,     -- Tipo de origen: 'SALE', 'PURCHASE', 'EXPENSE', etc.
    cargo NUMERIC(15,2) DEFAULT 0.00,       -- Cargo
    abono NUMERIC(15,2) DEFAULT 0.00,       -- Abono
    saldo NUMERIC(15,2) DEFAULT 0.00,       -- Saldo resultante
    balance_date DATE NOT NULL,             -- Fecha del movimiento
    description TEXT,                        -- Detalle o nota opcional
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);