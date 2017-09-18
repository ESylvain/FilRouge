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
 * Servlet implementation class Control
 */
@WebServlet("/ListFormateurs")
public class ListFormateurs extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @throws ClassNotFoundException 
	 * @see HttpServlet#HttpServlet()
	 */
	public ListFormateurs() {
		super();
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("do post");

		//on regarde ce que veut la requete
		// a terme un switch
//		String categorie = request.getParameter("categorie");
		
		
		//on appelle la couche metier
		FormateurDAO formateurDAO = new FormateurDAO();
		List<Formateur> formateurs = null;
		try {
			formateurs = formateurDAO.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//on lie les valeurs à la reponse
		request.setAttribute("formateurs", formateurs);
//		for(Formateur f : formateurs){
//			System.out.println(f.getCourss());
//		}
//		
		//on dispatch vers la jsp adaptee
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/afficherFormateurs.jsp");
		rd.forward(request, response);
		
		formateurDAO.close();
		System.out.println("Fin do post");
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("dqls dlkdmj qsjld");
	}

}
