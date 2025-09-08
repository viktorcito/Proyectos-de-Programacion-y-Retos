package es.daw.web.jdbc;

import es.daw.web.jdbc.bd.DBConnection;
import es.daw.web.jdbc.bd.DaoFabricante;
import es.daw.web.jdbc.bd.DaoProducto;
import es.daw.web.jdbc.model.Fabricante;
import es.daw.web.jdbc.model.Producto;
import es.daw.web.jdbc.util.Utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
@WebServlet("/ServletDAO_1")
//@WebServlet(urlPatterns = {"/ServletDAO_1"})
public class ServletDAO_1 extends HttpServlet {

    private static final long serialVersionUID = 1L;

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

        DaoProducto daoP = null;
        DaoFabricante daoF = null;
        
        List<Producto> productos = null;
        List<Fabricante> fabricantes = null;

        try {
        	daoP = new DaoProducto();
            productos = daoP.selectAll();
            
            daoF = new DaoFabricante();
            fabricantes = daoF.selectAll();
            
            System.out.println("**************** LISTADO DE FABRICANTES ************");
            fabricantes.forEach(System.out::println);
            
            System.out.println("[processRequest] Se han cargado los datos de los productos en la colección");

        } catch (SQLException e) {
            request.setAttribute("message", "ERROR al realizar la consulta");
            getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
        }

        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet- Práctica tercer trimestre</title>");
            out.println("</head>");
            out.println("<body>");

            out.println("<h1>TABLA DE PRODUCTOS</h1>");
            out.println("<table border='1'>");

            //out.println("<tr><th>CÓDIGO</th><th>NOMBRE</th><th>PRECIO</th><th>COD FABRICANTE</th></tr>");
            out.println("<tr><th>CÓDIGO</th><th>NOMBRE</th><th>PRECIO</th><th>FABRICANTE</th></tr>");
            if (productos != null) {
                for (Producto p : productos) {
                    out.println("<tr>");
                    out.println("<td>" + p.getCodigo() + "</td>");
                    out.println("<td>" + p.getNombre() + "</td>");
                    out.println("<td>" + p.getPrecio() + "</td>");

                    // Necesito un método que me devuelva el nombre del fabricante a través de su código
                    //out.println("<td>" + p.getCodigo_fabricante() + "</td>");
                    //out.println("<td>" + Utils.obtenerNombreFabricante(fabricantes, p.getCodigo_fabricante()) + "</td>");
                    try {
						out.println("<td>" + daoF.select(p.getCodigo_fabricante()).getNombre() + "</td>");
					} catch (SQLException e) {
						out.println("<td>FABRICANTE DESCONOCIDO</td>");
						e.printStackTrace();
					}

                    out.println("</tr>");
                }
            }

            out.println("</table>");
            out.println("<a href='index.html'>Volver</a>");
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
        super.destroy();
        
        try {
            DBConnection.closeConnection();
        } catch (SQLException ex) {
            System.err.println("[processRequest][ERROR AL CERRA LA CONEXIÓN]" + ex.getMessage());
        }
        
    }    
}
