import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

//creates BST using movieslends data as input and prints out subsets between two songs as examples of the tree
public class Main {
    public static void main(String[] args) throws Exception{
        Scanner file = new Scanner(new File("../data/movies.csv"));
        //ignores header of csv file
        file.nextLine();
        //creates empty list for movie nodes
        ArrayList<Movie> movies = new ArrayList<>();
        //reads in file and stores nodes into arraylist
        while(file.hasNextLine()){
            movies.add(Movie.readMovie(file));
        }
        //removes quotation marks from song title
        for(Movie movie : movies){
            if(movie.getTitle().charAt(0) == '"'){
                movie.setTitle(movie.getTitle().substring(1));
            }
        }
        //create Binary Search Tree
        MovieBST bst = new MovieBST();
        //adds each movie node in arraylist to BST
        int count = 0;
        for(Movie movieList : movies) {
            bst.add(movieList);
            count++;
        }






        System.out.println(count + " Movies added into BST\n");
        //bst.printInOrder(bst.root);

        //Uses subSetList in order to print subset between two songs
        System.out.println("The subset of movies between Bug's Life AND Harry Potter and the Sorcerer's Stone (a.k.a. Harry Potter and the Philosopher's Stone) is:");
        ArrayList<Movie> subset = new ArrayList<>();
        subset = bst.subSetList(subset, bst.root,"Bug's Life","Harry Potter and the Sorcerer's Stone (a.k.a. Harry Potter and the Philosopher's Stone)");
        for(Movie titles : subset){
            System.out.println(titles.getTitle());
        }
        System.out.println();

        System.out.println("The subset of movies between Back to the Future AND Hulk is: ");
        bst.printSubSet(bst.root,"Back to the Future","Hulk");

        System.out.println();

        System.out.println("The subset of movies between Toy Story AND WALL·E: ");
        bst.printSubSet(bst.root,"Toy Story","WALL·E");

        //print output to file
        printToFile(count,bst);

    }

    public static void printToFile(int count, MovieBST bst)throws Exception{

        //print to file
        PrintStream output = new PrintStream(new FileOutputStream(new File("../output/output.txt")));
        output.println(count + " Movies added into BST\n");

        //Uses subSetList in order to print subset between two songs
        output.println("The subset of movies between Bug's Life AND Harry Potter and the Sorcerer's Stone (a.k.a. Harry Potter and the Philosopher's Stone) is:");
        ArrayList<Movie> subset = new ArrayList<>();
        subset = bst.subSetList(subset, bst.root,"Bug's Life","Harry Potter and the Sorcerer's Stone (a.k.a. Harry Potter and the Philosopher's Stone)");
        for(Movie titles : subset){
            output.println(titles.getTitle());
        }
        output.println();

        subset.clear();
        output.println("The subset of movies between Back to the Future AND Hulk is: ");
        subset = bst.subSetList(subset, bst.root,"Back to the Future","Hulk");
        for(Movie titles : subset){
            output.println(titles.getTitle());
        }

        output.println();

        subset.clear();
        output.println("The subset of movies between Toy Story AND WALL·E: ");
        subset = bst.subSetList(subset, bst.root,"Toy Story","WALL·E");
        for(Movie titles : subset){
            output.println(titles.getTitle());
        }
    }



}
