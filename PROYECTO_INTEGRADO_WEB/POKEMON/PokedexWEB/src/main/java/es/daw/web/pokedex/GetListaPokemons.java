package es.daw.web.pokedex;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import es.daw.web.pokedex.util.UtilJSON;

/**
 * Servlet implementation class GetListaPokemons
 */
@WebServlet("/GetListaPokemons")
public class GetListaPokemons extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetListaPokemons() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean error = false;
		List<String> nombres = new ArrayList<>();
		try {
			nombres = UtilJSON.getNombres(10);
			
		}catch(IOException ex) {
			error = true;
			System.out.println(ex.getMessage());
		}
		
		//response.getWriter().append(nombres.toString());
		// El response va a devolver una página html
        response.setContentType("text/html;charset=UTF-8");
        
        try ( PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Listado de Pokemons</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<main style='text-align:center'>");
            out.println("<h1>lISTADO DE POKEMONS</h1>");
            if (error) {
            	out.println("<h2>ERROR</h2>");
            	out.println("<p style='color:red'>Ha habido problemas a la hora de cargar los Pokemons!!!!</p>");
            }
            else {
        		out.println("<form><select name='nombre'>");
        		
        		for(String nombre: nombres)
        			out.println("<option>"+nombre+"</option>");
        		
        		out.println("</select></form>");
            		
            }
            out.println("</main>");
            out.println("</body>");
            out.println("</html>");
        }		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
