package com.nighthawk.spring_portfolio.mvc.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // annotation to simplify the creation of RESTful web services
@RequestMapping("/api/movies")  // all requests in file begin with this URI
public class MovieApiController {

    @Autowired
    private MovieJpaRepository repository;

    @GetMapping("/")
    public ResponseEntity<List<Movie>> getMovie() {
        return new ResponseEntity<>( repository.findAll(), HttpStatus.OK);
    }

    /* Update Like
     * @PutMapping annotation is used for mapping HTTP PUT requests onto specific handler methods.
     * @PathVariable annotation extracts the templated part {id}, from the URI
     */
    @PostMapping("/like/{id}")
    public ResponseEntity<Movie> setLike(@PathVariable long id) {
        /* 
        * Optional (below) is a container object which helps determine if a result is present. 
        * If a value is present, isPresent() will return true
        * get() will return the value.
        */
        Optional<Movie> optional = repository.findById(id);
        if (optional.isPresent()) {  // Good ID
            Movie movie = optional.get();  // value from findByID
            movie.setHaha(movie.getHaha()+1); // increment value
            repository.save(movie);  // save entity
            return new ResponseEntity<>(movie, HttpStatus.OK);  // OK HTTP response: status code, headers, and body
        }
        // Bad ID
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);  // Failed HTTP response: status code, headers, and body
    }

    /* Update dislike
     */
    @PostMapping("/dislike/{id}")
    public ResponseEntity<Movie> setDislike(@PathVariable long id) {
        Optional<Movie> optional = repository.findById(id);
        if (optional.isPresent()) {  // Good ID
            Movie movie = optional.get();
            movie.setBoohoo(movie.getBoohoo()+1);
            repository.save(movie);
            return new ResponseEntity<>(movie, HttpStatus.OK);
        }
        // Bad ID
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
