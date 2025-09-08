package es.daw.web.model;

/**
 *
 * @author daw1a
 */
public class Empleado {
    
    private int codigo_empleado;
    private String nombre, apellido1, apellido2, extension, email,puesto;
    private String codigo_oficina;

    public Empleado() {
    }

    
    public int getCodigo_empleado() {
        return codigo_empleado;
    }

    public void setCodigo_empleado(int codigo_empleado) {
        this.codigo_empleado = codigo_empleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getCodigo_oficina() {
        return codigo_oficina;
    }

    public void setCodigo_oficina(String codigo_oficina) {
        this.codigo_oficina = codigo_oficina;
    }

}
