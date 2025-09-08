package es.daw.web.jdbc.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.daw.web.jdbc.model.Fabricante;
import es.daw.web.jdbc.model.Producto;

public class DaoFabricante implements Dao<Fabricante> {

	private Connection con;
	
    public DaoFabricante() throws SQLException {
		super();
		con = DBConnection.getConnection();
	}
	
	
	@Override
	public Fabricante select(int id) throws SQLException {
		
		ResultSet rs = null;
		try(PreparedStatement ps = con.prepareStatement("SELECT nombre from tienda.fabricante where codigo = ? ")){
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			if (rs.next()) {
				Fabricante f = new Fabricante();
				f.setNombre(rs.getString("nombre"));
				return f;
			}
			
				
		}
		finally {
			rs.close();
		}
		
		return null;
	}

	@Override
	public List<Fabricante> selectAll() throws SQLException {
        try (PreparedStatement ps = con.prepareStatement("SELECT * FROM tienda.fabricante");
        ResultSet rs = ps.executeQuery()){

	        List<Fabricante> result = null;
	
	        while (rs.next()) {
	            if (result == null) {
	                result = new ArrayList<>();
	            }
	
	            Fabricante p = new Fabricante();
	            p.setCodigo(rs.getInt("codigo"));
	            p.setNombre(rs.getString("nombre"));
	            result.add(p);
	            
	        }
//	        rs.close();
//	        ps.close();
	        return result;
        }
		
	}

	@Override
	public void insert(Fabricante t) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Fabricante t) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Fabricante t) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
