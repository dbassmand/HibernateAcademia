package Entidades;

import java.io.Serializable; // Importa la interfaz Serializable para permitir la serialización de la clase.
import jakarta.persistence.*; // Importa las anotaciones necesarias para la persistencia.

/**
 * Clase que representa la entidad "Alumno" mapeada a la tabla "alumno" en la base de datos.
 */
@Entity
@Table(name="alumno")
public class Alumno implements Serializable {
    // Identificador de versión para la serialización.
    private static final long serialVersionUID = 1L;

    /**
     * Identificador único del alumno, mapeado a la columna "ID" en la base de datos.
     * Generado automáticamente mediante la estrategia IDENTITY.
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * Nombre del alumno, mapeado automáticamente a una columna con el mismo nombre.
     */
    private String nombre;

    /**
     * Apellidos del alumno, mapeados automáticamente a una columna con el mismo nombre.
     */
    private String apellidos;

    /**
     * Edad del alumno, mapeada automáticamente a una columna con el mismo nombre.
     */
    private int edad;

    /**
     * Número de asignaturas inscritas por el alumno, mapeado automáticamente a una columna con el mismo nombre.
     */
    private int numeroAsignaturas;

    // Métodos getter y setter para acceder y modificar los atributos de la clase.

   
    public long getId() {
        return id;
    }

   
    public void setId(long id) {
        this.id = id;
    }

    
    public String getNombre() {
        return nombre;
    }

   
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

   
    public String getApellidos() {
        return apellidos;
    }

   
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

   
    public int getEdad() {
        return edad;
    }

   
    public void setEdad(int edad) {
        this.edad = edad;
    }

    
    public int getNumeroAsignaturas() {
        return numeroAsignaturas;
    }

    
    public void setNumeroAsignaturas(int numeroAsignaturas) {
        this.numeroAsignaturas = numeroAsignaturas;
    }
}
