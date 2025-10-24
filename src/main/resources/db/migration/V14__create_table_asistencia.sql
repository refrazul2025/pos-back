CREATE TABLE asistencias (
    id BIGSERIAL PRIMARY KEY,
    usuario VARCHAR(255) NOT NULL,
    fecha DATE NOT NULL,
    hora INT NOT NULL
);
