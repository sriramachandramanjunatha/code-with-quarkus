package org.acme;

import java.util.List;

import org.acme.entity.Movie;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/movie")
public class MovieResource {

	MovieRepository movieRepository;
	
	public MovieResource(MovieRepository movieRepository){
		this.movieRepository=movieRepository;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Movie> movies(@QueryParam("year") String year){
		if(year!=null) {
			return movieRepository.findByYear(Integer.parseInt(year));
		}
		return Movie.listAll();
	}

	@Transactional
	@POST 
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addMovie(Movie movie) {
//		movie.id=null;
		movie.persist();
		return Response.status(Status.CREATED).entity(movie).build();
	}
}
