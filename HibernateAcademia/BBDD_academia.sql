-- Caso practico 1 Unidad 3 Acceso a Datos 

CREATE database academia;
USE academia;
create table Alumno (
	ID INT NOT NULL AUTO_INCREMENT,
    Nombre VARCHAR(45) NOT NULL,
    Apellidos VARCHAR(45) NOT NULL,
    Edad INT NOT NULL,
    NumeroAsignaturas INT NOT NULL,
    primary key (ID)
);

INSERT INTO Alumno (Nombre, Apellidos, Edad, NumeroAsignaturas) VALUES
('Juan', 'Pérez López', 20, 5),
('María', 'García Fernández', 22, 4),
('Carlos', 'Hernández Martín', 19, 3),
('Lucía', 'Martínez Sánchez', 21, 6),
('David', 'Gómez Ruiz', 18, 2),
('Sofía', 'Díaz Torres', 23, 4),
('Alejandro', 'Romero Vázquez', 20, 5),
('Laura', 'Jiménez Castro', 24, 6),
('Javier', 'Ortega Morales', 19, 3),
('Isabella', 'Navarro Flores', 22, 4);

SELECT * from alumno;