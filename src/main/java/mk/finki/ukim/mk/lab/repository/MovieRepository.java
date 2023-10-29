package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Movie;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieRepository {
    public List<Movie> findAll(){
        return DataHolder.movies;
    }

    public List<Movie> searchMovies(String text){
        List<Movie> searchResult = new ArrayList<>();

        for(Movie movie : DataHolder.movies){
            String title = movie.getTitle().toLowerCase();
            String description = movie.getSummary().toLowerCase();
            text = text.toLowerCase();

            if(title.contains(text) || description.contains(text)){
                searchResult.add(movie);
            }
        }
        return searchResult;
    }

}
