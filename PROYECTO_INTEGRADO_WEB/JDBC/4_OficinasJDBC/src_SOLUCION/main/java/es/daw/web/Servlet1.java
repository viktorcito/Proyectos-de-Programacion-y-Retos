package es.daw.web;

import es.daw.web.bd.DBConnection;
import es.daw.web.bd.DaoOficina;
import es.daw.web.model.Oficina;
import es.daw.web.util.Utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author daw1a
 */
@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {

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
        
    	StringBuilder sb = new StringBuilder();
    	
    	String cod_oficina = request.getParameter("cod_oficina");
    	
    	String[] campos = request.getParameterValues("campo");
    	
    	System.out.println("campos:"+campos);
    	
    	// -----------------------
    	List<Oficina> oficinas = new ArrayList<>();
    	
    	try {
			DaoOficina daoO = new DaoOficina();
			
			oficinas = daoO.selectAll();
			
			if (campos == null)
				response.sendRedirect("error.html");
			
			else {
			
				sb.append("<h2>Informe de la oficina con código "+cod_oficina+"</h2>");
				sb.append("<table border='1'>");
				
				Oficina oficina = Utils.getOficinaByCod(cod_oficina,oficinas);
				//System.out.println("*********** RECURSIVIDAD *************");
				//Oficina oficina = Utils.getOficinaByCodRecursiva(cod_oficina,0,oficinas);
				
				// cabecera
				sb.append("<tr>");
				for(String campo: campos)
					sb.append("<th>"+campo+"</th>");
				sb.append("</tr>");
				
				// cuerpo tabla
				sb.append("<tr>");
				String valor ="";
				
				for(String campo: campos) {
					switch(campo) {
						case "ciudad":
							valor = oficina.getCiudad();
							break;
						case "pais":
							valor = oficina.getPais();
							break;
						case "telefono":
							valor = oficina.getTelefono();
							break;
						case "direccion":
							valor = oficina.getLinea_direccion1()+" "+oficina.getLinea_direccion2();
							break;
					}
					
					sb.append("<td>"+valor+"</td>");
					
				}
				
				
				sb.append("</tr>");
				
				sb.append("</table>");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	
    	
    	// -----------------------
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Informe de pedidos</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Ejecutado Servlet1</h1>");
            out.println(sb.toString()); //StringBuilder
            out.println("</body>");
            out.println("</html>");
        }
    	
    	
    	
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
