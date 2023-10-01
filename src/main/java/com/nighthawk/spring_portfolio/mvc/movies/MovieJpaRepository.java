package main.java.com.nighthawk.spring_portfolio.mvc.movies;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

// JPA is an object-relational mapping (ORM) to persistent data, originally relational databases (SQL). Today JPA implementations has been extended for NoSQL.
public interface MovieJpaRepository extends JpaRepository<Movie, Long> {
    /* JPA has many built in methods: https://www.tutorialspoint.com/spring_boot_jpa/spring_boot_jpa_repository_methods.htm
    The below custom methods are prototyped for this application
    */
    void save(String Movie);
    List<Movie> findAllByOrderByMovieAsc();
    List<Movie> findByMovieIgnoreCase(String movie);
}
