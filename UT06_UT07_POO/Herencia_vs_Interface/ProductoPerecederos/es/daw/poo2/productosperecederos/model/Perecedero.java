
package es.daw.poo2.productosperecederos.model;

/**
 *
 * @author melol
 */
public class Perecedero extends Producto{
    private int diasCaducar;

    public Perecedero(int diasCaducar, String nombre, double precio) {
        super(nombre, precio);
        this.diasCaducar = diasCaducar;
    }

    public int getDiasCaducar() {
        return diasCaducar;
    }

    public void setDiasCaducar(int diasCaducar) {
        this.diasCaducar = diasCaducar;
    }
    
    
    @Override
    public double calcular(int cantidad){
        // A parte de lo que hace producto
        double precio = super.calcular(cantidad);
        // El precio se reducirá según los días a caducar
        switch (diasCaducar) {
            case 1:
                precio = precio - (precio*25)/100;
                break;
            case 2:
                precio = precio -(precio*33)/100;
                break;
            case 3:
                precio = precio -(precio*50)/100;
                break;
            default:
                break;
        }
        
        return precio;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Perecedero{" + "diasCaducar=" + diasCaducar + '}');
        return sb.toString();
    }
    
    /**
     * Implementar el método abstracto
     * @return 
     */
    public boolean permiteDevolucion(){
        if (diasCaducar > 5) return true;
        else return false;
    }
    
    
    @Override
    public String convert2XML() {
        return "<producto>Producto perecedero<producto>";
    } 
    
}
