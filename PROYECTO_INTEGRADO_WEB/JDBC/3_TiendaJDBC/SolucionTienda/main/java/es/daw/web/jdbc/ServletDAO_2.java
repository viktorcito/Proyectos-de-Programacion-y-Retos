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
import java.util.Comparator;
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
        String codigo = "";
        
        DaoProducto daoP = null;
        DaoFabricante daoF = null;
        List<Producto> productos = null;
        List<Fabricante> fabricantes = null;
        
        //2. Crear el producto
        //Producto p = new Producto();
        
        
        //3. Crear el DAO del producto para acceso a B.D
        try {
        	
        	daoP = new DaoProducto();
        	//productos = daoP.selectAll();
        	
        	daoF = new DaoFabricante();
        	fabricantes = daoF.selectAll();
        	
        	Producto p = new Producto();
        	
            switch (operacion){
                case "insert":
                    //p.setCodigo(Integer.parseInt(codigo));
                    p.setNombre(nombre);
                    p.setPrecio(Float.parseFloat(precio));
                    p.setCodigo_fabricante(Integer.parseInt(codigo_fabricante));
                	
                    daoP.insert(p);
                    System.out.println("[processRequest] Se ha dado de alta un nuevo producto");
                    break;
                case "update":
                	codigo = request.getParameter("codigo");
                	p.setCodigo(Integer.parseInt(codigo));
                	p.setNombre(nombre);
                	daoP.update(p);
                	System.out.println("[processRequest] Se ha actualizado el producto con código "+codigo);
                    break;
                case "delete":
                	codigo = request.getParameter("codigo");
                	daoP.delete(Integer.parseInt(codigo));
                	System.out.println("[processRequest] Se ha borrado el producto con código "+codigo);
                    break;
                    
                  
            }

        } catch (SQLException e) {
            System.err.println("[processRequest][ERROR REALIZAR CONSULTA]" + e.getMessage());
            request.setAttribute("message", "ERROR en la operación <"+operacion+"> contra la BD");
            getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
        } catch (NumberFormatException e) {
        	e.printStackTrace();
        	request.setAttribute("message", "El precio debe ser un valor numérico que permite decimales. Ejemplo 125.99");
        	// Pendiente poner un mensaje genérico para precio y código...
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
            out.println("<h1>Operación ["+operacion+"] realizada con éxito!</h1>");

            out.println("<h2>TABLA DE PRODUCTOS</h2>");
            out.println("<table border='1'>");

            out.println("<tr><th>CÓDIGO</th><th>NOMBRE</th><th>PRECIO</th><th>FABRICANTE</th></tr>");
            //if (productos != null) {
            	productos = daoP.selectAll(); // no aparecería el nuevo producto
            	productos.sort(Comparator.reverseOrder());
                for (Producto p : productos) {
                    out.println("<tr>");
                    out.println("<td>" + p.getCodigo() + "</td>");
                    out.println("<td>" + p.getNombre() + "</td>");
                    out.println("<td>" + p.getPrecio() + "</td>");

                    out.println("<td>" + Utils.obtenerNombreFabricante(fabricantes, p.getCodigo_fabricante()) + "</td>");
                    out.println("</tr>");
                }
            //}

            out.println("</table>");
            
            
            
            
            
            out.println("<a href='index.html'>Volver</a>");
            out.println("</body>");
            out.println("</html>");
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
