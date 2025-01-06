import java.util.Scanner;

import Managers.AlumnoManager;
import Managers.ManagerPrincipal;


public class Principal {

    public static void main(String[] args) {
        // Creación del objeto Scanner para leer entradas del usuario
        Scanner entrada = new Scanner(System.in);
        
        // Variables para almacenar los datos del alumno y el menú de opciones
        int opcion1 = 0;
        long idGenerado = 0;
        String nombre = null;
        String apellido = null;
        int edad = 0;
        int numeroasignaturas = 0;
        long maxId = 0;
        boolean bandera = false;
        String respuesta = "";

        // Mensaje de bienvenida
        System.out.println("***Bienvenido a mi primer CRUD con Hibernate!***");
        
        // Llamada para inicializar la configuración de Hibernate
        ManagerPrincipal.setup();
        
        // Instanciación de AlumnoManager para gestionar las operaciones CRUD
        AlumnoManager alumnomanager = new AlumnoManager();
        
        // Bucle principal que mantiene el programa activo hasta que se salga
        while (!bandera) {

            // Imprimir el menú de opciones
            System.out.println("\n************************************");
            System.out.println("*                                  *");
            System.out.println("*  Menu de selección de opciones:  *");
            System.out.println("*                                  *");
            System.out.println("*  Opcion 1 - Crear registro       *");
            System.out.println("*  Opcion 2 - Consultar registro   *");
            System.out.println("*  Opcion 3 - Actualizar registro  *");
            System.out.println("*  Opcion 4 - Borrar registro      *");
            System.out.println("*  Opcion 5 - Salir                *");
            System.out.println("*                                  *");
            System.out.println("************************************");
            System.out.print("\nSelección: ");

            // Lee la opción seleccionada por el usuario
            opcion1 = entrada.nextInt();

            // Validación de que la opción esté en el rango correcto
            if (opcion1 < 1 || opcion1 > 5) {
                System.out.println("Opcion inválida");
            } else {
                bandera = true;
            }

            // Reinicia la bandera para seguir dentro del bucle
            bandera = false;

            // Sección de opciones del menú según la selección del usuario
            switch (opcion1) {
                case 1:
                    // Opción para crear un nuevo registro
                    System.out.println("\n**Crear un nuevo registro**");
                    
                    // Limpiar el búfer de Scanner
                    entrada.nextLine();
                    
                    // Bucle para validar el nombre del alumno
                    while (!bandera) {
                        System.out.print("\nNombre del alumno: ");
                        nombre = entrada.nextLine().trim(); // Elimina espacios en blanco
                         
                        if (nombre.isEmpty()) {
                            System.out.println("El nombre no puede estar vacio, intentelo de nuevo");
                        } else {                    
                            bandera = true;
                        }
                    }
                    
                    // Bucle para validar el apellido del alumno
                    bandera = false;
                    while (!bandera) {
                        System.out.print("Apellido del alumno: ");
                        apellido = entrada.nextLine().trim();
                        
                        if (apellido.isEmpty()) {
                            System.out.println("El apellido no puede estar vacio, intentelo de nuevo");
                        } else {
                            bandera = true;
                        }
                    }

                    // Leer la edad del alumno
                    System.out.print("Edad del alumno:");
                    while (!entrada.hasNextInt()) {
                        System.out.println("Por favor introduzca un número válido");
                        entrada.next(); // Limpiar el scanner
                    }
                    edad = entrada.nextInt();
                    entrada.nextLine(); // Limpiar el scanner
                    
                    // Leer el número de asignaturas
                    System.out.print("Numero de asignaturas: ");
                    while (!entrada.hasNextInt()) {
                        System.out.println("Por favor introduzca un número válido");
                        entrada.next(); // Limpiar el scanner
                    }
                    numeroasignaturas = entrada.nextInt();
                    entrada.nextLine(); // Limpiar el scanner
                    
                    // Llamar al método create de AlumnoManager para crear el alumno en la base de datos
                    idGenerado = alumnomanager.create(nombre, apellido, edad, numeroasignaturas);
                    System.out.println("Registro creado con éxito. El ID del nuevo registro es: " + idGenerado);
                    
                    // Reiniciar bandera para volver al menú principal
                    bandera = false;
                    break;
                
                case 2:
                    // Opción para consultar un registro
                    System.out.println("\n**Consultar registro**");
                    
                    // Obtener el ID máximo de la base de datos
                    maxId = alumnomanager.getmaxId();
                    
                    if (maxId == 0) { //opcion muy improbable, pero comprueba que haya al menos 1 registro en la BBDD
                        System.out.println("No hay registros disponibles en la base de datos.");
                        break;
                    }
                    
                    // Mostrar el rango de IDs válidos
                    System.out.println("\nEl rango de Id´s válidos es desde 1 a " + maxId);
                    System.out.print("Introduzca el ID del registro que desea consultar: ");
                    
                    // Validación para asegurar que se ingrese un ID válido
                    while (!entrada.hasNextLong()) {
                        System.out.println("Por favor, introduzca un valor válido");
                        entrada.next();
                    }
                    
                    // Leer el ID del registro
                    idGenerado = entrada.nextLong();
                    entrada.nextLine(); // Limpiar el scanner
                    
                    // Validar que el ID esté dentro del rango permitido
                    if (idGenerado < 1 || idGenerado > maxId) {
                        System.out.println("El Id introducido no existe");
                    } else if(!alumnomanager.exists(idGenerado)) { //verifica que el si ID esta vacia por que fue borrado 
                        System.out.println("\nRegistro vacío: No existe un registro asociado con este ID.");
                    }else {
                        // Si el ID es válido, esta en rango y contiene datos, se leen los datos del alumno
                        alumnomanager.read(idGenerado);
                        alumnomanager.info(idGenerado);
                    }
                    
                    // Reiniciar bandera para volver al menú principal
                    bandera = false;
                    break;
                
                case 3:
                    // Opción para modificar un registro
                    System.out.println("\n**Modificar Registro**");
                    bandera = false; // Reiniciar bandera
                    
                    // Obtener el ID máximo de la base de datos
                    maxId = alumnomanager.getmaxId();
                    
                    // Mostrar el rango de IDs válidos
                    System.out.println("\nEl rango de Id´s válidos es desde 1 a " + maxId);
                    System.out.print("Introduzca el ID del registro que desea modificar: ");
                    
                    // Validación para asegurar que se ingrese un ID válido
                    while (!entrada.hasNextLong()) {
                        System.out.println("Por favor, introduzca un valor válido");
                        entrada.next();
                    }
                    
                    // Leer el ID del registro
                    idGenerado = entrada.nextLong();
                    entrada.nextLine(); // Limpiar el scanner
                    
                    // Validar que el ID esté dentro del rango permitido
                    if (idGenerado < 1 || idGenerado > maxId) {
                        System.out.println("El Id introducido no existe");
                    } else if (!alumnomanager.exists(idGenerado)) {  // Verifica si el registro existe
                        System.out.println("\n**ATENCION** Registro vacío: ese registro no puede ser utilizado, ya fue borrado!");
                        break;  // Esto hace que el flujo regrese al menú sin intentar modificar el registro
                    } else {
                        // Si el ID es válido y existe, procedemos con la modificación
                        // Bucle para validar el nombre del alumno
                        while (!bandera) {
                            System.out.print("\nNombre del alumno: ");
                            nombre = entrada.nextLine().trim(); // Elimina espacios en blanco
                             
                            if (nombre.isEmpty()) {
                                System.out.println("El nombre no puede estar vacío, intentelo de nuevo");
                            } else {                    
                                bandera = true;
                            }
                        }
                        
                        // Bucle para validar el apellido del alumno
                        bandera = false;
                        while (!bandera) {
                            System.out.print("Apellido del alumno: ");
                            apellido = entrada.nextLine().trim();
                            
                            if (apellido.isEmpty()) {
                                System.out.println("El apellido no puede estar vacío, intentelo de nuevo");
                            } else {
                                // Leer la edad del alumno
                                System.out.print("Edad del alumno:");
                                while (!entrada.hasNextInt()) {
                                    System.out.println("Por favor introduzca un número válido");
                                    entrada.next(); // Limpiar el scanner
                                }
                                edad = entrada.nextInt();
                                entrada.nextLine(); // Limpiar el scanner
                                
                                // Leer el número de asignaturas
                                System.out.print("Número de asignaturas: ");
                                while (!entrada.hasNextInt()) {
                                    System.out.println("Por favor introduzca un número válido");
                                    entrada.next(); // Limpiar el scanner
                                }
                                numeroasignaturas = entrada.nextInt();
                                entrada.nextLine(); // Limpiar el scanner
                                
                                // Llamar al método update de AlumnoManager para actualizar los datos del alumno
                                alumnomanager.update(idGenerado, nombre, apellido, edad, numeroasignaturas);
                                
                                // Mostrar los nuevos datos del alumno
                                System.out.println("\nLos datos del alumno modificado son");
                                alumnomanager.info(idGenerado);
                                
                                // Reiniciar bandera para volver al menú principal
                                bandera = false;
                            }
                        }
                    }
                    break;

                
                case 4:
                    // Opción para eliminar un registro
                    System.out.println("\n**Eliminar registro**");
                    
                    // Obtener el ID máximo de la base de datos
                    maxId = alumnomanager.getmaxId();
                    
                    // Mostrar el rango de IDs válidos
                    System.out.println("\nEl rango de Id´s válidos es desde 1 a " + maxId);
                    System.out.print("Introduzca el ID del registro que desea eliminar: ");
                    
                    // Validación para asegurar que se ingrese un ID válido
                    while (!entrada.hasNextLong()) {
                        System.out.println("Por favor, introduzca un valor válido");
                        entrada.next();
                    }
                    
                    // Leer el ID del registro
                    idGenerado = entrada.nextLong();
                    entrada.nextLine(); // Limpiar el scanner
                    
                    // Validar que el ID esté dentro del rango permitido
                    if (idGenerado < 1 || idGenerado > maxId) {
                        System.out.println("El Id introducido no existe");
                    } else {
                        // Mostrar los datos del alumno seleccionado
                        System.out.println("Los datos del registro seleccionado son: ");
                        alumnomanager.info(idGenerado);

                        bandera = false;

                        // Validación de la respuesta (sí o no)
                        while (!bandera) {
                            System.out.println("¿Desea continuar? S/N");
                            respuesta = entrada.nextLine().toLowerCase();  // Obtener la respuesta en minúsculas
                            
                            if (respuesta.equals("s")) {
                                // Eliminar el registro
                                alumnomanager.delete(idGenerado);  
                                System.out.println("Registro " + idGenerado + " eliminado correctamente!.");
                                bandera = true;
                            } else if (respuesta.equals("n")) {
                                System.out.println("Registro no eliminado");
                                bandera = true;
                            } else {
                                System.out.println("Respuesta inválida. Por favor ingrese 's' o 'n'.");
                            }
                        }
                    }
                    // Reiniciar bandera para volver al menú principal
                    bandera = false;
                    break;

                case 5:
                    // Opción para salir del programa
                    for (int i = 0; i < 80; i++) {
                        System.out.println();  // "Simula" limpiar la consola
                    }
                    
                    System.out.println("\nHasta pronto!...");  // Despedida
                    bandera = true;  // Salir del bucle principal
                    
                    break;

                default:
                    // Si la opción no es válida (aunque no debería ocurrir debido al control anterior)
            }
        }
    }
}




