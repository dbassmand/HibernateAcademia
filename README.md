CRUD con Hibernate: Gestión de Registros de Alumnos
Este proyecto implementa una aplicación de consola en Java que utiliza Hibernate para gestionar un sistema de registros de alumnos. Permite realizar las operaciones básicas de un CRUD (Crear, Leer, Actualizar y Borrar) sobre los registros de alumnos, almacenados en una base de datos.

Funcionalidades
La aplicación ofrece un menú interactivo en la consola donde el usuario puede realizar las siguientes acciones:

Crear un registro: Permite añadir un nuevo alumno con su nombre, apellido, edad y número de asignaturas.
Consultar un registro: Permite consultar los datos de un alumno mediante su ID.
Modificar un registro: Permite modificar los datos de un alumno existente, como nombre, apellido, edad o número de asignaturas.
Borrar un registro: Permite eliminar un registro de alumno, de modo que los datos del alumno sean eliminados de la base de datos.
Salir: Permite salir de la aplicación.
Detalles Técnicos
Lenguaje de programación: Java
Framework: Hibernate
Base de datos: El proyecto se conecta a una base de datos que almacena la información de los alumnos.
Interfaz de usuario: Consola de texto interactiva donde el usuario selecciona las opciones que desea ejecutar.
Lógica de la aplicación
Gestión de Registros: Se realiza un seguimiento de los registros de los alumnos mediante su ID. La aplicación muestra el rango de IDs válidos que el usuario puede utilizar para interactuar con los registros.
Evitar IDs vacíos: Si un alumno es borrado, su ID no podrá ser utilizado para crear o modificar un nuevo registro, y se marca como "vacío". El sistema verifica que el ID proporcionado esté dentro del rango y que no haya sido eliminado previamente.
Validación de entradas: La aplicación valida las entradas del usuario para asegurarse de que los datos ingresados (como el nombre, apellido, edad y número de asignaturas) sean correctos y válidos.
Instrucciones para ejecutar
Clona el repositorio en tu máquina local.
Abre el proyecto en Eclipse o tu IDE de preferencia.
Configura la base de datos (puedes utilizar una base de datos H2 embebida o una base de datos externa).
Ejecuta la clase principal Principal.java para iniciar la aplicación.
Dependencias
Este proyecto utiliza las siguientes dependencias:

Hibernate ORM: Para la gestión de la base de datos.
JDBC: Para la conexión con la base de datos.
H2 Database (opcional): Base de datos en memoria para pruebas rápidas.
Contribución
Si deseas contribuir a este proyecto, por favor sigue estos pasos:

Forkea el repositorio.
Crea una nueva rama para tu feature (git checkout -b feature/mi-feature).
Realiza los cambios y haz commit (git commit -am 'Agregado mi feature').
Haz push a la rama (git push origin feature/mi-feature).
Crea un Pull Request.
