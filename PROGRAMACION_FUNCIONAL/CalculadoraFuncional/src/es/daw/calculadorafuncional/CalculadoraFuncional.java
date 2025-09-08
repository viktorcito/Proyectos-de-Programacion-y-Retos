package es.daw.calculadorafuncional;

/**
 *
 * @author melola
 */
public class CalculadoraFuncional {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // FORMA IMPERATIVA
        Calculadora calc = new Calculadora();
        int rdoSuma = calc.sumar(2, 2);
        System.out.println("Suma: "+rdoSuma);
        
        int rdoResta = calc.restar(4, 2);
        System.out.println("Resta: "+rdoResta);
        
        // FORMA DECLARTIVA: FUNCIONAL
        // 1. Usando una lambda para llamar al método sumar de la clase Calculadora
        Operator suma = (a,b) -> calc.sumar(a, b);
        System.out.println("Suma lambda: "+suma.operar(2, 2));
        
        // 2. Usando una referencia a método para llamar al método restar de la clase Calculadora
        Operator resta = calc::restar;
        System.out.println("Resta: "+resta.operar(7, 3));
    }
    
    
}
