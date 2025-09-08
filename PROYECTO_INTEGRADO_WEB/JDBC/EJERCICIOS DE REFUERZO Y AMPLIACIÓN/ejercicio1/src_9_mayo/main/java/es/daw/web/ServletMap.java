package es.daw.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

import es.daw.web.util.Utils;

/**
 * Servlet implementation class ServletMap
 */

@WebServlet("/ServletMap")
public class ServletMap extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletMap() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Map<String,String[]> propiedades = request.getParameterMap();
		
		Utils.printRequestParameters(propiedades);
		
		Utils.printMap(propiedades);
		
		try {
			Utils.createPropertiesFile(propiedades,"parametrosWeb.properties");
		}catch(IOException ex) {
			response.getWriter().append("ERROR AL CREAR EL FICHERO DE PROPIEDADES");
		}
		
		response.getWriter().append("PINTANDO EN CONSOLA LAS PROPIEDADES...");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
