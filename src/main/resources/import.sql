
INSERT INTO rol (nombre) VALUES ('RECTOR');
INSERT INTO rol (nombre) VALUES ('DOCENTE');
INSERT INTO rol (nombre) VALUES ('ESTUDIANTE');

-- Insertar usuarios (password: "1234" para todos)

-- RECTOR
INSERT INTO usuario (username, email, password, rol_id) VALUES ('rector1', 'rector1@colegio.com', '$2a$10$kReZUnYT0LU8fbSDwJjyQOYMfzipGL/CapXzldUVMkksQKaSVhEn6', 1);

-- DOCENTE
INSERT INTO usuario ( username, email, password, rol_id) VALUES ( 'docente1', 'docente1@colegio.com', '$2a$10$kReZUnYT0LU8fbSDwJjyQOYMfzipGL/CapXzldUVMkksQKaSVhEn6', 2);

-- ESTUDIANTE
INSERT INTO usuario (username, email, password, rol_id) VALUES ( 'estudiante1', 'estudiante1@colegio.com', '$2a$10$kReZUnYT0LU8fbSDwJjyQOYMfzipGL/CapXzldUVMkksQKaSVhEn6', 3);

INSERT INTO docente (usuario_id, nombre_docente, especialidad) VALUES (2, 'Docente Matemáticas', 'Matemáticas');

INSERT INTO estudiante (usuario_id, grado, nombre_estudiante) VALUES (3, 10, 'estudiante');