package com.nighthawk.spring_portfolio.mvc.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data 
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique=true)
    private String movie;

    private int haha;
    private int boohoo;

    public static String[] init() {
        final String[] movieArray = {
            "The Shawshank Redemption",
            "The Dark Night",
            "Forrest Gump",
            "Fight Club",
            "Inception",
            "Interstellar",
            "Saving Private Ryan",
            "The Green Mile",
            "The Lord of the Rings: The Fellowship of the Ring",
            "The Lord of the Rings: The Two Towers",
            "The Lord of the Rings: The Return of the King",
            "Back to the Future",
            "The Lion King",
            "Oppenheimer"
        };
        return movieArray;
    }
}
