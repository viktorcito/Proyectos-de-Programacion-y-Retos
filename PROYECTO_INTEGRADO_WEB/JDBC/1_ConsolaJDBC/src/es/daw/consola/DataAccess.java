package es.daw.consola;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author daw1a
 */
public class DataAccess {
    Connection con;
    Statement st;
    ResultSet rs;
    
    public void openConnection() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        //String userName = "root";
        //String pwd = "mysql";
        String url = "jdbc:mysql://localhost:3306/tienda";
        
        Properties props = new Properties();
        props.put("user","root");
        props.put("password","mysql");
        
        con = DriverManager.getConnection(url,props);
        //con = DriverManager.getConnection(url,userName,pwd);
        
    }
    
    public void closeConnection() throws SQLException{
    	con.close();
    }
    
    public ArrayList<String> getData() throws SQLException{
    	
        ArrayList<String> nombreProductos = new ArrayList<>();
        
        st = con.createStatement();
        
        rs = st.executeQuery("SELECT * FROM tienda.producto");
        
        while(rs.next()){
            String name = rs.getString("nombre");
            nombreProductos.add(name);
        }
        
        return nombreProductos;
    }

}