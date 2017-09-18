package fr.filrouge.jersey;

import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.Hibernate;

import fr.filrouge.dao.FormateurDAO;
import fr.filrouge.hibernate.Formateur;

@Path("/users")
public class UserRestService {
	
	FormateurDAO formateurDAO = new FormateurDAO();
	
//	private static final FormateurDAO formateurDAO = new FormateurDAO();
	
	@GET
	public Response getUser(){
		return Response.status(200).entity("getuser est appelé").build();
	}
	
	@GET
	@Path("/vip")
	public Response getUserVIP(){
		return Response.status(200).entity("getuserVIP est appelé").build();
	}
	
	@GET
	@Path("/username/{username}:[a-zA-Z][a-zA-Z_0-9]")
	public Response getUserByUserName(@PathParam("username") String username){
		return Response.status(200).entity("getuser est appelé avec le nom : "+username).build();
	}
	
	@GET
	@Path("{id:\\d+}")
	public Response getUserById(@PathParam("id") String id){
		return Response.status(200).entity("getuser est appelé avec le id : "+id).build();
	}
	
	@GET
	@Path("/books/{id:\\d+}")
	public Response getBookByISBN(@PathParam("id") String ISBN){
		return Response.status(200).entity("getBook est appelé avec le ISBN : "+ISBN).build();
	}
	
	@GET
	@Path("{year}/{month}/{day}")
	public Response getUserHistory(@PathParam("year") int year,
									@PathParam("month") int month,
									@PathParam("day") int day){
		String date = year+"/"+month+"/"+day;
		return Response.status(200).entity("getHistot=y est appelé avec la date : "+date).build();
	}
	
	@GET
	@Path("/query")
	public Response getUsers(
			@DefaultValue("1000")@QueryParam("from") int from,
			@QueryParam("to") int to,
			@QueryParam("orderBy") List<String> orderBy){
		return Response.status(200).entity("getUsers from  "+from+" to "+to+" , orderBy "+orderBy.toString()).build();
	}
	
	@POST
	@Path("/add")
	public Response addUser(
			@FormParam("nom") String nom,
			@FormParam("age") int age) {
		return Response.status(200).entity("addUser nom  "+nom+" age "+age).build();
	}
	
	@GET
	@Path("/gfbn/{name}")
	public Response getFormateursByName(@PathParam("name") String name) throws Exception{
		
		FormateurDAO formateurDAO = new FormateurDAO();
		List<Formateur> formateurs = formateurDAO.findByName(name);
		
		return Response.status(200).entity("getFormateursByName avec  "+name+" | liste : "+formateurs).build();
	}
//	@GET
//	@Path("/gfbnq")
//	public Response getFormateursByNameQ(@QueryParam("name") String name) throws Exception{
//		System.out.println("appel web service getFormateurByNameQ");
//		FormateurDAO formateurDAO = new FormateurDAO();
//		List<Formateur> formateurs = formateurDAO.findByName(name);
//		
//		return Response.status(200).entity("getFormateursByNameQ avec  "+name+" | liste : "+formateurs).build();
//	}
	
//	@GET
//	@Path("/gfbnq")
//	public String getFormateursByNameQ(@QueryParam("name") String name) throws Exception{
//		System.out.println("appel web service getFormateurByNameQ");
//		List<Formateur> formateurs = formateurDAO.findByName(name);
//		System.out.println("reponse : "+formateurs.toString());
//		return formateurs.toString(); 
//	}
	
	@GET
	@Path("/gfbnq")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Formateur> getFormateursByNameQ(@QueryParam("name") String name) throws Exception{
		System.out.println("appel web service getFormateurByNameQ | name : "+name);
				
		List<Formateur> formateurs = formateurDAO.findByName(name);
		formateurDAO.close();
		Hibernate.initialize(formateurs);
		System.out.println("reponse : "+formateurs);
		return formateurs; 
	}
	
	
	
}
