package fr.m1i.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.filrouge.dao.FormateurDAO;
import fr.filrouge.hibernate.Formateur;

/**
 * Servlet implementation class UpdateFormateur
 */
@WebServlet("/DeleteFormateur")
public class DeleteFormateur extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteFormateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Debut doget deleteFormateur");

		String delete = request.getParameter("delete");
		int id = Integer.parseInt(delete);

		FormateurDAO formateurDAO = new FormateurDAO();

		// delete
		Formateur formateur = null;
		try {
			formateur = formateurDAO.findById(id);
			formateurDAO.delete(formateur);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// redirection
		List<Formateur> formateurs = null;
		try {
			formateurs = formateurDAO.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// on lie les valeurs à la reponse
		request.setAttribute("formateurs", formateurs);

		// on dispatch vers la jsp adaptee
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/afficherFormateurs.jsp");
		rd.forward(request, response);

		formateurDAO.close();
		
		System.out.println("Fin doget deleteFormateur");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
