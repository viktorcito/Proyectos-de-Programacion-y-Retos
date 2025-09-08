package es.daw.web;

import es.daw.web.bd.DBConnection;
import es.daw.web.bd.DaoEmpleado;
import es.daw.web.bd.DaoOficina;
import es.daw.web.model.Empleado;
import es.daw.web.model.Oficina;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet encargado de la creación de pedidos
 *
 * @author daw1a
 */
@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    	
    	// ----------
    	request.setCharacterEncoding("UTF-8");
    	String empleadoCSV = request.getParameter("empleado");
    	
    	DaoEmpleado daoE;
    	 
    	String[] infoEmpleado = empleadoCSV.split(",");
    	
    	String cod_oficina = infoEmpleado[5];
    	
    	String message = "";
    	
    	// Antes de crear el obj empleado compruebo si existe el código de oficina
    	try {
			DaoOficina daoO = new DaoOficina();
			Oficina ofi = daoO.select(cod_oficina);
			
			// No existe la oficina
			if (ofi.getCodigo_oficina() == null) {
				request.setAttribute("message", "ERROR: El código de oficina "+cod_oficina+" no"
						+ " exiten en la BD");
				getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
			}
			else {
				// El código de oficina existe
				Empleado e = new Empleado();
				e.setApellido1(infoEmpleado[1]);
				e.setApellido2(infoEmpleado[2]);
				e.setCodigo_oficina(cod_oficina);
				e.setEmail(infoEmpleado[4]);
				e.setExtension(infoEmpleado[3]);
				e.setNombre(infoEmpleado[0]);
				e.setPuesto(infoEmpleado[6]);
				
				daoE = new DaoEmpleado();
				daoE.insert(e);
				
				message = "El empleado "+e.getNombre()+" "+e.getApellido1()+" se ha dado de alta correctamente";
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			message= e.getMessage();
			
			/*request.setAttribute("message", e.getMessage());
			getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);*/
			
			
		}
    	
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Inserta Empleado</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> "+message+"</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    	
    	// -----------
    	
    	
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }


    @Override
    public void destroy() {
        try {
            super.destroy();
            DBConnection.closeConnection();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}
