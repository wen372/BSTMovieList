import java.util.*;
import java.io.File;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner file = new Scanner(new File("../data/movies.csv"));
        //ignores header of csv file
        file.nextLine();


        ArrayList<Movie> movies = new ArrayList<>();
        while(file.hasNextLine()){
            movies.add(Movie.readMovie(file));
        }
        for(Movie movie : movies){
            if(movie.getTitle().charAt(0) == '"'){
                movie.setTitle(movie.getTitle().substring(1));
            }
        }
        movies.sort(Movie::compareTo);

        //print all in arraylist
        /*
        for(Movie movie : movies){
            System.out.println(movie);
        }
         */
        Movie[] movieList = new Movie[movies.size()];
        int counter = 0;
        for(Movie movie : movies){
            movieList[counter] = movie;
            counter++;
        }
        MovieBST test = new MovieBST();
        test.root = test.sortedArrayToBST(movieList);
        //System.out.println(test.root);

        test.traverseInOrder(test.root);



        /*
        arr[0] = Movie.readMovie(file);
        System.out.println(Arrays.toString(arr[0].getGenres()));
        */
    }


}
