package Entidades;
import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name="alumno")
public class Alumno implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nombre;
	private String apellidos;
	private int edad;
	private int numeroAsignaturas;
	
	
	
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
		this.nombre=nombre;
	}
	
	public String getApellidos() {
		return apellidos;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos=apellidos;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) {
		this.edad=edad;
	}

	public int getNumeroAsignaturas() {
		return numeroAsignaturas;
	}
	
	public void setNumeroAsignaturas(int numeroAsignaturas) {
		this.numeroAsignaturas= numeroAsignaturas;
	}
}
