package fr.m1i.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MaServlet
 */
@WebServlet(value = { "/MaServlet",
		"/maservlet" }, name = "zzz", displayName = "ioio", initParams = @WebInitParam(name = "location", value = "Suisse"))
public class MaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String location;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("methode do get");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.encodeURL(null);
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

	/* Methodes cycle de vie */
	@Override
	public void init() throws ServletException {
		System.out.println("init");
		this.location = this.getInitParameter("location");
		System.out.println("param : " + location);
	}

	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service");
		super.service(req, resp);
	}

	@Override
	public void destroy() {
		System.out.println("destroy");
		super.destroy();
	}

}
