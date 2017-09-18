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
@WebServlet("/AjoutFormateur")
public class AjoutFormateur extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjoutFormateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Debutn doget ajoutFormateur");

		String ajout1 = "";
		String ajout2 = "";
		ajout1 = request.getParameter("ajout1");
		ajout2 = request.getParameter("ajout2");

		if (ajout1 != null) {

			// on dispatch vers la jsp adaptee
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/ajoutFormateur.jsp");
			rd.forward(request, response);
		}

		if (ajout2 != null) {
			
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");

			FormateurDAO formateurDAO = new FormateurDAO();
			Formateur formateur = new Formateur();
			try {
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
