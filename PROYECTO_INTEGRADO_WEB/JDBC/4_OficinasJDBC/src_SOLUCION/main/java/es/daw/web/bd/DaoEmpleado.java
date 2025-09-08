package es.daw.web.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import es.daw.web.model.Empleado;

public class DaoEmpleado implements Dao<Empleado>{

	private Connection con;
	
	public DaoEmpleado() throws SQLException {
		con = DBConnection.getConnection();
	}
	
	
	@Override
	public Empleado select(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Empleado> selectAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Empleado t) throws SQLException {
		
		try(PreparedStatement ps = con.prepareStatement("INSERT INTO oficinas.empleado "
				+ "(nombre,apellido1,apellido2,extension,email,codigo_oficina,puesto) "
				+ "VALUES(?,?,?,?,?,?,?)")){
			ps.setString(1, t.getNombre());
			ps.setString(2, t.getApellido1());
			ps.setString(3, t.getApellido2());
			ps.setString(4, t.getExtension());
			ps.setString(5, t.getEmail());
			ps.setString(6, t.getCodigo_oficina());
			ps.setString(7, t.getPuesto());
			
			ps.executeUpdate();
		}
		
		
	}

	@Override
	public void update(Empleado t) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Empleado t) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	

}
