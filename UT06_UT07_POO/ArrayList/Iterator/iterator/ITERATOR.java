package iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author melola
 */
public class ITERATOR {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("****************** EJEMPLO 1 ****************");
        ArrayList<Integer> listInt2 = new ArrayList<>();
        listInt2.add(3);
        listInt2.add(4);
        listInt2.add(2);
        listInt2.add(6);
        listInt2.add(5);
        listInt2.add(1);
        listInt2.add(7);        
        
        // Este bucle lanza la expción java.util.ConcurrentModificationException
        // No se puede recorrer así un ArrayList y borrar a la vez
        /*for(Integer i:listInt2){
            if (i % 2 == 0)
                listInt2.remove(i);
        }*/

        System.out.println("Lista inicial: "+listInt2);
        Iterator<Integer> it = listInt2.iterator();

        while(it.hasNext()){
            int item = it.next();
            if (item % 2 == 0)
                it.remove();
        }
        System.out.println("Lista sin pares: "+listInt2);

        
        // ----------------
        System.out.println("\n****************** EJEMPLO 2 ****************");
        // UnsupportedOperationException
        //List<Integer> listInt = Arrays.asList(4,5,1,2,8,9,6);
        
        List<Integer> listInt = new ArrayList<>(Arrays.asList(4,5,1,2,8,9,6));

        System.out.println("Lista inicial: "+listInt);
        Iterator<Integer> it2 = listInt.iterator();

        while(it2.hasNext()){
            int item = it2.next();
            if (item % 2 == 0)
                it2.remove();
        }
        System.out.println("Lista sin pares: "+listInt);



        
    }

}
