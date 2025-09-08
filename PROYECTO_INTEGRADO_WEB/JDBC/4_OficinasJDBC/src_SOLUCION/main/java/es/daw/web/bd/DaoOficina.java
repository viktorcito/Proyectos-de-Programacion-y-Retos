package es.daw.web.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.daw.web.model.Oficina;

public class DaoOficina implements Dao<Oficina>{

	
	private Connection con;
	
	public DaoOficina() throws SQLException {
		con = DBConnection.getConnection();
	}
	
	@Override
	public Oficina select(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public Oficina select(String codigo) throws SQLException {
		
		Oficina o = new Oficina();
		ResultSet rs = null;
		
		try(PreparedStatement ps = con.prepareStatement("SELECT * FROM oficinas.oficina "
				+ "where codigo_oficina = ?") ){
			
			ps.setString(1, codigo);
			
			rs = ps.executeQuery();
			
			if (rs.next()) {
				o.setCiudad(rs.getString("ciudad"));
				o.setCodigo_oficina(rs.getString("codigo_oficina"));
				o.setCodigo_postal(rs.getString("codigo_postal"));
				o.setLinea_direccion1(rs.getString("linea_direccion1"));
				o.setLinea_direccion2(rs.getString("linea_direccion2"));
				o.setPais(rs.getString("pais"));
				o.setRegion(rs.getString("region"));
				o.setTelefono(rs.getString("telefono"));
			}
		}
		finally {
			if (rs != null)
				rs.close();
		}
		return o;
	}

	@Override
	public List<Oficina> selectAll() throws SQLException {
		List<Oficina> oficinas = new ArrayList<>();
		ResultSet rs = null;
		
		try(PreparedStatement ps = con.prepareStatement("SELECT * FROM oficinas.oficina") ){
			rs = ps.executeQuery();
			while(rs.next()) {
				Oficina o = new Oficina();
				
				o.setCiudad(rs.getString("ciudad"));
				o.setCodigo_oficina(rs.getString("codigo_oficina"));
				o.setCodigo_postal(rs.getString("codigo_postal"));
				o.setLinea_direccion1(rs.getString("linea_direccion1"));
				o.setLinea_direccion2(rs.getString("linea_direccion2"));
				o.setPais(rs.getString("pais"));
				o.setRegion(rs.getString("region"));
				o.setTelefono(rs.getString("telefono"));
				
				oficinas.add(o);
			}
		}
		finally {
			if (rs != null)
				rs.close();
		}
		return oficinas;
	}

	@Override
	public void insert(Oficina t) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Oficina t) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Oficina t) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
