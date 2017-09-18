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
@WebServlet("/UpdateFormateur")
public class UpdateFormateur extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateFormateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Debutn doget updateFormateur");

		String update1 = "";
		String update2 = "";
		update1 = request.getParameter("update1");
		update2 = request.getParameter("update2");

		int id;

		if (update1 != null) {
			id = Integer.parseInt(update1);

			FormateurDAO formateurDAO = new FormateurDAO();
			Formateur formateur = null;
			try {
				formateur = formateurDAO.findById(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// on lie les valeurs à la reponse
			request.setAttribute("formateur", formateur);

			// on dispatch vers la jsp adaptee
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/updateFormateur.jsp");
			rd.forward(request, response);
			
			formateurDAO.close();
		}

		if (update2 != null) {
			id = Integer.parseInt(update2);
			
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");

			FormateurDAO formateurDAO = new FormateurDAO();
			Formateur formateur = null;
			try {
				formateur = formateurDAO.findById(id);
				formateur.setNom(nom);
				formateur.setPrenom(prenom);
				formateurDAO.save(formateur);
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
		}

		System.out.println("Fin doget updateFormateur");

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
