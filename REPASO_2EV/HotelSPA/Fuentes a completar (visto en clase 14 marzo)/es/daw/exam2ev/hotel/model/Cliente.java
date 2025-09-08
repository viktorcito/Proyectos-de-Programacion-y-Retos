package es.daw.exam2ev.hotel.model;

public class Cliente {
    
    private String referenciaCliente;
    private String nombreApellidos;
    private String email; 
    private String movil; 

    //COMPLETAR CÓDIGO

    public Cliente(String referenciaCliente, String nombreApellidos, String email, String movil) {
        this.referenciaCliente = referenciaCliente;
        this.nombreApellidos = nombreApellidos;
        this.email = email;
        this.movil = movil;
    }

    @Override
    public String toString() {
        return "Cliente{" + "referenciaCliente=" + referenciaCliente + ", nombreApellidos=" + nombreApellidos + ", email=" + email + ", movil=" + movil + '}';
    }

    
}
