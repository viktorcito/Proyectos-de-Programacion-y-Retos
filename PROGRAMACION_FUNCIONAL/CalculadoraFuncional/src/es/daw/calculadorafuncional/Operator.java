package es.daw.calculadorafuncional;

/**
 * Las interfaces funcionales son interfaces que tienen un método a implementar, es decir, un método abstracto. 
 * Esto significa que cada interfaz creada que respeta esta premisa se convierte automáticamente en una interfaz funcional.
 * El compilador reconoce esas interfaces y permite que estén disponibles para que los desarrolladores trabajen, por ejemplo, con expresiones lambda.
 * @author melol
 */
@FunctionalInterface
public interface Operator {
    public int operar(int a, int b);
}
