/**
 * EJEMPLO DE UNA CLASE DE TIPO MODELO
 */
package es.daw.web.agendaWEB.model;

import java.time.LocalDate;
import java.util.Objects;

public class Persona implements Comparable<Persona>{
//public class Persona {

	private String dni;
	private String nombre;
	private String apellidos;
	private LocalDate fechaNacimiento;
	
	public Persona() { 
		super();
	}

	public Persona(String dni, String nombre, String apellidos, LocalDate fechaNacimiento) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
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

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	@Override
	public int hashCode() {
		return Objects.hash(apellidos, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(apellidos, other.apellidos) && Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Persona [dni=" + this.dni + ", nombre=" + this.nombre + ", apellidos=" + this.apellidos + ", fechaNacimiento="
				+ this.fechaNacimiento + "]";
	}
	
    
	@Override
        public int compareTo(Persona p){
            return dni.compareTo(p.getDni());
        }
	
	
}
