package es.daw.poo2.electrodomesticos.enumerados;

/**
 *
 * @author melola
 */
public enum ConsumoEnergetico {

    A(100),
    B(80),
    C(60),
    D(50),
    E(30),
    F(10);
    
    private int extra;
    
    private ConsumoEnergetico(int extra){
        this.extra = extra;
    }

    public int getExtra() {
        return extra;
    }
}
