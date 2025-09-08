package es.daw.web.pokedex;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.io.PrintWriter;

import es.daw.web.pokedex.model.Pokemon;
import es.daw.web.pokedex.util.PokeAPIConnection;
import es.daw.web.pokedex.util.UtilJSON;

/**
 * Servlet implementation class GetPokemon
 */
@WebServlet("/GetPokemon")
public class GetPokemon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPokemon() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// -----------------------------------
		// 1. LEER DATOS DEL REQUEST 
		// Leo el  nombre del pokemon del formulario
		// Parámetro de tipo input text
		String nombre = request.getParameter("nombrePokemon");
		System.out.println("[GetPokemon] nombre:"+nombre);
		
		// Parámetro de tipo input radioButton
		String tipo = request.getParameter("tipo");
		
		// -----------------------------------		
		// 2. Creo la ruta donde se va a guardar el json del pokemon
		String pathJson = getServletContext().getRealPath("/")+"pokemon.json";
		System.out.println("[GetPokemon] pathJson:"+pathJson);

		boolean error = false;
		String urlImg = "";
		Pokemon pokemon = null;
		
		try {
			// 3. Creamos el JSON
			if (nombre != null  && !nombre.equals("")) {
				
				PokeAPIConnection.connect(nombre.toLowerCase(), pathJson);
				
				// 4. Convertimos el JSON del pokemon en un objeto (serializar)
				pokemon = UtilJSON.leer(pathJson);
				
				if(tipo.equalsIgnoreCase("front"))
					urlImg = pokemon.getSprites().getFront_default();
				else if (tipo.equalsIgnoreCase("back"))
					urlImg = pokemon.getSprites().getBack_default();
				else
					urlImg = pokemon.getSprites().getFront_default();
				
				
			}
		}catch(IOException ex) {
			System.out.println("********** PEDAZO DE ERROR ***************");
			System.err.println(ex.getMessage());
			error = true;

		}
		
		// 5. RESPUESTA (response)
		
		// El response devuelve texto
		//response.getWriter().append("FUNCIONANDO!!!! EL JSON SE HA CREADO EN "+pathJson);
		
		// El response va a devolver una página html
        response.setContentType("text/html;charset=UTF-8");
        
        try ( PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CON ARGUMENTO </title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<main style='text-align:center'>");
            out.println("<h1>INFORMACIÓN DEL POKEMON</h1>");
            if (error) {
            	out.println("<h2>ERROR</h2>");
            	out.println("<p style='color:red'>Ha habido problemas a la hora de cargar el Pokemon!!!!</p>");
            }else if (nombre == null) {
            	out.println("<h2>ERROR</h2>");
            	out.println("<p style='color:red'>Verifica el campo del HTML donde se escribe el nombre del Pokemon</p>");
            }else if (nombre.equals("")) {
            	out.println("<h2>ERROR</h2>");
            	out.println("<p style='color:red'>No has escrito nada torpedo!!!</p>");
            }
            else {
            	if (tipo.equals("info")) {
            		out.println("<h2>Información del pokemon "+nombre+"</h2>");
            		out.println("<table style='margin: 0 auto' border='1'>"
            				+ "<tr><th>Imagen</th><th>Nombre</th><th>Id</th><th>Altura</th></tr>"
            				+ "<tr><th><img src='"+urlImg+"'/></th><th>"+pokemon.getName()+"</th><th>"+pokemon.getId()+"</th><th>"+pokemon.getHeight()+"</th></tr>"
            				+ "</table>");
            		
            	}else {
		            out.println("<h2>Imagen "+tipo+" del pokemon "+nombre+"</h2>");
		            out.println("<img src='"+urlImg+"'/>");
            	}
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
