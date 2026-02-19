CREATE TYPE user_role AS ENUM ('ADMIN', 'USER');

CREATE TYPE vehicle_fuel AS ENUM (
    'GASOLINA',
    'DIESEL',
    'HIBRIDO',
    'ELECTRICO'
);

CREATE TYPE inquiry_status AS ENUM (
    'PENDIENTE',
    'CONTACTADO',
    'RECHAZADO',
    'CERRADO'
);



CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,

    nombre VARCHAR(150) NOT NULL,
    apellido VARCHAR(150) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    password VARCHAR(250) NOT NULL,
    celular VARCHAR(30) NOT NULL,

    rol user_role NOT NULL DEFAULT 'USER'
);



CREATE TABLE vehicles (
    id BIGSERIAL PRIMARY KEY,
    marca VARCHAR(150) NOT NULL,
    modelo VARCHAR(150) NOT NULL,
    color VARCHAR(20) NOT NULL,
    year INT NOT NULL,
    precio NUMERIC(12, 2) NOT NULL,
    kilometraje NUMERIC (10, 2) NOT NULL,
    gasolina vehicle_fuel NOT NULL,
    descripcion TEXT,
    disponible BOOLEAN NOT NULL DEFAULT TRUE,

    image_url TEXT NOT NULL, --imagen principal del vehiculo,
    fecha_publicacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);



CREATE TABLE vehicle_images (
    id BIGSERIAL PRIMARY KEY,

    vehicle_id BIGINT NOT NULL,
    image_url TEXT NOT NULL,

    CONSTRAINT fk_vehicle_image
        FOREIGN KEY (vehicle_id)
        REFERENCES vehicles(id)
        ON DELETE CASCADE
);



CREATE TABLE inquiries (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    vehicle_id BIGINT NOT NULL,

    comentarios TEXT,
    estado inquiry_status NOT NULL DEFAULT 'PENDIENTE',
    fecha_creacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_inquiry_user
        FOREIGN KEY (user_id)
        REFERENCES users(id)
        ON DELETE CASCADE,

    CONSTRAINT fk_inquiry_vehicle
        FOREIGN KEY (vehicle_id)
        REFERENCES vehicles(id)
        ON DELETE CASCADE
);



--INDEXES

CREATE INDEX idx_inquiries_user ON inquiries(user_id);
CREATE INDEX idx_inquiries_vehicle ON inquiries(vehicle_id);
CREATE INDEX idx_vehicles_available ON vehicles(disponible)