package es.iessoterohernandez.daw.dwes.controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.iessoterohernandez.daw.dwes.modelo.acciones.EmpleadosDAO;
import es.iessoterohernandez.daw.dwes.modelo.empleado.Empleado;

/**
 * Servlet implementation class ControladorNominas
 */
@WebServlet(description = "Controlador que administra el proyecto Nominas", urlPatterns = "/nominas")
public class ControladorNominas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControladorNominas() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String opcion = request.getParameter("opcion");

		switch (opcion) {
		case "mostrarEmpleado":
			List<Empleado> listaEmp = new ArrayList<>();
			listaEmp = EmpleadosDAO.getEmpleados();
			System.out.println("Elegida opción {Mostrar Empleados}");

			request.setAttribute("lista", listaEmp);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/vistas/MostrarEmpleado.jsp");
			requestDispatcher.forward(request, response);
			break;
			
		case "mostrarSalario":
				String dato = request.getParameter("txtBuscar");
				int sueldo = EmpleadosDAO.getSueldo(dato);
				request.setAttribute("sueldo", sueldo);
				request.getRequestDispatcher("/vistas/MostrarSalario.jsp").forward(request, response);
				break;			
			
		case "modificarEmpleado":
			requestDispatcher = request.getRequestDispatcher("/vistas/ModificarEmpleado.jsp");
			requestDispatcher.forward(request, response);
		}

		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
			
	}

}
