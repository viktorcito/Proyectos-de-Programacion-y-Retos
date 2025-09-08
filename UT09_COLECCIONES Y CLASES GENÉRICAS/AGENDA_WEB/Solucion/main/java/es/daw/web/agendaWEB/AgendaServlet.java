package es.daw.web.agendaWEB;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import es.daw.web.agendaWEB.model.Persona;
import es.daw.web.agendaWEB.util.UtilAgenda;
import es.daw.web.agendaWEB.util.UtilCSV;
import es.daw.web.agendaWEB.util.UtilMap;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * Servlet implementation class AgendaServlet
 */
@WebServlet("/AgendaServlet")
public class AgendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final String PATH_CSV = "recursos"+File.separator+"agenda"+File.separator+"agenda.csv";
	
	private static Map<String, Persona> agenda = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgendaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String opcion = request.getParameter("opcion");
		
		//Map<String, Persona> agenda = new HashMap<>();
		if (agenda == null)
			agenda = new HashMap<>();
		
		String messageError = "";
		String message = "";
		
		/*
		 1. Buscar los datos de una persona a través del teléfono.
		 2. Buscar el teléfono de una persona.
		 3. Modificar el teléfono de una persona en concreto.
		 4. Dar de alta una nueva Persona con su teléfono en la agenda
		 5. Borrar una persona concreta de la agenda.
		 6. Devolver la lista de personas con su teléfono ordenados por DNI 
		 */
		
		switch (opcion) {
			case "cargarCSV":
				// Comprobar si la opción es la de cargar los datos de la agenda a través del CSV
				// Leer el fichero CSV (linea a linea), coger los datos correspondiente y crear los
				// distintos objetos Persona
				// Con el primer campo del CSV creo la clave y con el resto creo el objeto persona
				try {
					UtilCSV.loadCSV(PATH_CSV, agenda);
					//UtilMap.printMap(agenda); //pintar el Map con genéricos
					UtilAgenda.pintaAgenda(agenda);
					message="Datos de la agenda cargados correctamente";
					
				}catch(IOException e) {
					messageError = "Pedazo de error al cargar la agenda a partir del CSV!!!!";
					System.out.println(messageError);
					e.printStackTrace();
				}
				break;
			case "BuscarPorTelef":{
				String telefono = request.getParameter("telefono");
				//UtilMap.searchValueByKey(agenda,telefono); //con genéricos
				Persona p;
				try {
					p = UtilAgenda.buscaPersonaPorTelefono(agenda, telefono);
					message = p.toString();
				} catch (Exception e) {
					e.printStackTrace();
					messageError = "No se ha encontrado la persona asociada a dicho teléfono";
				}
				break;
			}
			case "BuscarPorPersona":{
				String nombre = request.getParameter("nombre");
				String apellido = request.getParameter("apellido");
				String telefono = "";
				try {
					Persona p = new Persona();
					p.setNombre(nombre);
					p.setApellidos(apellido);
					telefono = UtilAgenda.buscaTelefonoPorPersona(agenda, p);
					message = String.format("El teléfono de %s es %s.",telefono,p.toString());
							
				} catch (Exception e) {
					e.printStackTrace();
					messageError = "No se ha encontrado la persona asociada a dicho teléfono";
				}
				break;
			}
			case "ModificarTelefonoPorPersona":{
				String nombreNuevo = request.getParameter("nombreNuevo");
				String apellidoNuevo = request.getParameter("apellidoNuevo");
				String telefonoNuevo = request.getParameter("telefonoNuevo");
				Persona p = new Persona();
				p.setNombre(nombreNuevo);
				p.setApellidos(apellidoNuevo);
				
				try {
					UtilAgenda.actualizaTelefPorPersona(agenda, p, telefonoNuevo);
					message = String.format("El teléfono nuevo de %s es %s.",p.toString(),telefonoNuevo);
				} catch (Exception e) {
					e.printStackTrace();
					messageError = "[MODIFICAR] No se ha encontrado la persona asociada a dicho teléfono";
				}
				break;
			}
			case "darAlta":{
				String nombreNuevo = request.getParameter("nombreNuevo");
				String apellidoNuevo = request.getParameter("apellidoNuevo");
				String telefonoNuevo = request.getParameter("telefonoNuevo");
				Persona p = new Persona();
				p.setNombre(nombreNuevo);
				p.setApellidos(apellidoNuevo);
				System.out.println("********** ALTA *************");
				System.out.println(p.toString());
				System.out.println("***********************");
				
				UtilAgenda.darAltaPersona(agenda, p, telefonoNuevo);
				message = String.format("Se ha dado de alta a la persona "+p);				
				break;
			}
			case "borrarPersona":{
				String nombreNuevo = request.getParameter("nombreNuevo");
				String apellidoNuevo = request.getParameter("apellidoNuevo");
				
				Persona p = new Persona();
				p.setNombre(nombreNuevo);
				p.setApellidos(apellidoNuevo);
				
				try {
					UtilAgenda.borrarPersona(agenda, p);
					message = String.format("Se ha borrado de la agenda a la persona "+p);
				} catch (Exception e) {
					messageError = "[BORRAR] No se ha encontrado la persona asociada a dicho teléfono";
					e.printStackTrace();
				}
				break;
				
			}
			case "listar":{
				TreeMap<String,Persona> agendaOrdenada=UtilAgenda.obtenerAgendaOrdenadaNatural(agenda);
				message = agendaOrdenada.toString();
				break;
			}
			default:
				break;
		}
		
		response.setContentType("text/html;charset=UTF-8");
		if (!messageError.equals(""))
			response.getWriter().append(messageError);
		else
			response.getWriter().append(message);
			
		//response.setCharacterEncoding("UTF-8");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
