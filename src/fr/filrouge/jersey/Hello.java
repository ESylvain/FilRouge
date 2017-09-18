package fr.filrouge.jersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class Hello {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String ditBonjourEnTexte(){
		return "Ouste ";
	}
	@GET
	@Produces(MediaType.TEXT_XML)
	public String ditBonjourEnXML(){
		return "<?xml version=\"1.0\"?>"+"<hello>Bien tenté</hello>";
	}
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String ditBonjourEnHTML(){
		return "<html><head><meta charset=\"UTF-8\"><title>Insert title here</title></head><body><h1>oh non je suis demasqué</h1></body></html>";
	}
}
