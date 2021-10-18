package es.iessoterohernandez.daw.dwes.nominas.server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import es.iessoterohernandez.daw.dwes.nominas.laboral.DatosNoCorrectosException;
import es.iessoterohernandez.daw.dwes.nominas.laboral.Empleado;
import es.iessoterohernandez.daw.dwes.nominas.laboral.EmpleadosDAO;

/**
 * Servlet implementation class selectServlet
 */
public class selectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public selectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter salida = response.getWriter();
		
		salida.print("<html>");
		salida.print("<body>");
		for(Empleado e : EmpleadosDAO.getEmpleados()) {
			salida.print("<br>" + e.imprime());
			}
		salida.print("</body>");
		salida.print("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
