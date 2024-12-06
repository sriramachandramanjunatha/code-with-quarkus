//package org.acme;
//
//import java.util.List;
//
//import org.acme.entity.Movie;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import jakarta.ws.rs.Produces;
//import jakarta.ws.rs.core.MediaType;
//
//@RequestMapping("/spring-movie")
//public class MovieController {
//
//	private SpringMovieRepository movieRepository;
//	
//	public MovieController(SpringMovieRepository movieRepository){
//		this.movieRepository=movieRepository;
//	}
//	
//	@GetMapping
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<Movie> movies(@RequestParam	("year") String year){
//		if(year!=null) {
//			return movieRepository.findByYear(year);
//		}
//		return movieRepository.findAll();
//	}
//}
