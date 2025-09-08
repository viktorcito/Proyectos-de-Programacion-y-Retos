
package es.daw.web.model;

import java.util.Objects;

/**
 *
 * @author daw1a
 */
public class Oficina {
    private String codigo_oficina;
    private String ciudad,pais,region,codigo_postal,telefono;
    private String linea_direccion1, linea_direccion2;

    public Oficina() {
    }

    public String getCodigo_oficina() {
        return codigo_oficina;
    }

    public void setCodigo_oficina(String codigo_oficina) {
        this.codigo_oficina = codigo_oficina;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getLinea_direccion1() {
        return linea_direccion1;
    }

    public void setLinea_direccion1(String linea_direccion1) {
        this.linea_direccion1 = linea_direccion1;
    }

    public String getLinea_direccion2() {
        return linea_direccion2;
    }

    public void setLinea_direccion2(String linea_direccion2) {
        this.linea_direccion2 = linea_direccion2;
    }

}
