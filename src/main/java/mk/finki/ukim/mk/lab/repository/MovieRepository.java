package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.model.Movie;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieRepository {
    public List<Movie> movieList;

    public MovieRepository(){
        movieList = new ArrayList<>();
        movieList.add(new Movie("Title 1","Summary 1",1.0));
        movieList.add(new Movie("Title 2","Summary 2",2.0));
        movieList.add(new Movie("Title 3","Summary 3",3.0));
        movieList.add(new Movie("Title 4","Summary 4",4.0));
        movieList.add(new Movie("Title 5","Summary 5",5.0));
        movieList.add(new Movie("Title 6","Summary 6",6.0));
        movieList.add(new Movie("Title 7","Summary 7",7.0));
        movieList.add(new Movie("Title 8","Summary 8",8.0));
        movieList.add(new Movie("Title 9","Summary 9",9.0));
        movieList.add(new Movie("Title 10","Summary 10",10.0));
    }

    public List<Movie> findAll(){
        return movieList;
    }

    public List<Movie> searchMovies(String text){
        List<Movie> searchResult = new ArrayList<>();

        for(Movie movie : movieList){
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
