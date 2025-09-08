package es.daw.consola;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<String> nombres = new ArrayList<>();
        
        DataAccess da;
        try{
            da = new DataAccess();
            da.openConnection();
            nombres = da.getData();
            da.closeConnection();
        }catch(SQLException e){
        	e.printStackTrace();
            System.err.println(e.getMessage());
        } catch (ClassNotFoundException ex) {
        	ex.printStackTrace();
        	System.err.println("Driver no cargado");
            System.err.println(ex.getMessage());
        }

        nombres.forEach(System.out::println);

	}

}
