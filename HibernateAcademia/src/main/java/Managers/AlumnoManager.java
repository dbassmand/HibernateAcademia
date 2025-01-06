package Managers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import Entidades.Alumno;

public class AlumnoManager {
	
	
	//CRUD
	public long create(String nombre, String apellidos, int edad, int numeroAsignaturas) {
	    Alumno alumno = new Alumno();  // Crear una nueva instancia de Alumno
	    
	    alumno.setNombre(nombre);  // Establecer el nombre del alumno
	    alumno.setApellidos(apellidos);  // Establecer los apellidos del alumno
	    alumno.setEdad(edad);  // Establecer la edad del alumno
	    alumno.setNumeroAsignaturas(numeroAsignaturas);  // Establecer el número de asignaturas

	    // Crear una sesión para interactuar con la base de datos
	    Session session = ManagerPrincipal.sessionFactory.openSession();
	    session.beginTransaction();  // Iniciar una nueva transacción

	    // Guardar el objeto "alumno" en la base de datos y obtener el ID generado
	    long id = (long)session.save(alumno);  // Guarda el nuevo alumno y obtiene el ID

	    session.getTransaction().commit();  // Confirmar (commit) la transacción
	    session.close();  // Cerrar la sesión

	    return id;  // Devuelve el ID del nuevo alumno guardado
	}

	
	
	public Alumno read(long id) {
	    Session session = ManagerPrincipal.sessionFactory.openSession();  // Abrir una sesión
	    Alumno alumno = session.get(Alumno.class, id);  // Obtener el alumno con el ID especificado
	    session.close();  // Cerrar la sesión
	    return alumno;  // Retornar el objeto Alumno
	}

	
	
	public void update(long id, String nombre, String apellidos, int edad, int numeroAsignaturas) {
	    Alumno alumno = read(id);  // Obtener el alumno con el ID

	    System.out.println("\nIntroduce los datos que quieras modificar");

	    // Si el nombre no es nulo, se actualiza
	    if(nombre != null) {
	        alumno.setNombre(nombre);  // Establecer nuevo nombre
	        System.out.println("\nNombre actualizado");
	    }
	    if(apellidos != null) {
	        alumno.setApellidos(apellidos);  // Establecer nuevos apellidos
	        System.out.println("Apellidos actualizados");
	    }
	    if(edad != 0) {
	        alumno.setEdad(edad);  // Establecer nueva edad
	        System.out.println("Edad actualizada");
	    }
	    if(numeroAsignaturas != 0) {
	        alumno.setNumeroAsignaturas(numeroAsignaturas);  // Establecer nuevo número de asignaturas
	        System.out.println("Numero de asignaturas actualizado");
	    }

	    // Guardar la entidad actualizada en la base de datos
	    Session session = ManagerPrincipal.sessionFactory.openSession();
	    session.beginTransaction();  // Iniciar transacción
	    session.update(alumno);  // Actualizar el registro del alumno en la base de datos
	    session.getTransaction().commit();  // Confirmar transacción
	    session.close();  // Cerrar la sesión
	}

	
	
	public void delete(long id) {
	    Alumno alumno = read(id);  // Obtener el alumno con el ID

	    // Abrir sesión y empezar transacción
	    Session session = ManagerPrincipal.sessionFactory.openSession();
	    session.beginTransaction();

	    // Eliminar el alumno de la base de datos
	    session.delete(alumno);  // Eliminar el alumno
	    session.getTransaction().commit();  // Confirmar transacción
	    session.close();  // Cerrar la sesión
	}


	
	public void info(long id) {
	    Alumno alumno = read(id);  // Obtener el alumno con el ID
	    // Mostrar la información del alumno
	    System.out.println("\nNombre del Alumno: " + alumno.getNombre());
	    System.out.println("Apellidos del Alumno: " + alumno.getApellidos());
	    System.out.println("Edad del Alumno: " + alumno.getEdad());
	    System.out.println("Numero de asignaturas del Alumno: " + alumno.getNumeroAsignaturas());
	}

	
	public long getmaxId() {
	    Session session = ManagerPrincipal.sessionFactory.openSession();  // Abrir sesión
	    // Realizar consulta para obtener el valor máximo de 'id' en la tabla 'Alumno'
	    Long maxId = (long) session.createQuery("select max(id) from Alumno").uniqueResult();
	    session.close();  // Cerrar sesión
	    
	    // Si la tabla está vacía, maxId será null, así que se retorna 0
	    return (maxId != null) ? maxId : 0;  // Operador ternario: si maxId es null, devuelve 0
	}

	
}
