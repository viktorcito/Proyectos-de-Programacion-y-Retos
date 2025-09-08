package es.daw.web.jdbc;

import es.daw.web.jdbc.bd.DBConnection;
import es.daw.web.jdbc.bd.DaoProducto;
import es.daw.web.jdbc.model.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author daw1a
 */
@WebServlet(name = "ServletDAO_2", urlPatterns = {"/ServletDAO_2"})
public class ServletDAO_2 extends HttpServlet {

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
    	
        //1. Recoger datos enviados desde el formulario
        String nombre = request.getParameter("nombre");
        String precio = request.getParameter("precio");
        String codigo_fabricante = request.getParameter("codigo_fabricante");
        String operacion = request.getParameter("operacion");
        
        
        //2. Crear el producto
        Producto p = new Producto();
        //p.setCodigo(Integer.parseInt(codigo));
        p.setNombre(nombre);
        p.setPrecio(Float.parseFloat(precio));
        p.setCodigo_fabricante(Integer.parseInt(codigo_fabricante));
        
        //3. Crear el DAO del producto para acceso a B.D
        try {
        	
        	DaoProducto daoP = new DaoProducto();
        	
            switch (operacion){
                case "insert":
                    daoP.insert(p);
                    System.out.println("[processRequest] Se han cargado los datos de los productos en la colección");
                    break;
                case "update":
                    break;
                case "delete":
                    break;
                    
                  
            }

        } catch (SQLException e) {
            System.err.println("[processRequest][ERROR REALIZAR CONSULTA]" + e.getMessage());
            request.setAttribute("message", "ERROR en la operación <"+operacion+"> contra la BD");
            getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
        }
        
        
        //4. Respuesta del Servlet
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletDAO_2</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Operación realizada con éxito!</h1>");
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
