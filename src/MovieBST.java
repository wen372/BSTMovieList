/* The MovieBST implementation */

import java.util.ArrayList;
//Binary search tree for movie nodes
public class MovieBST {
    Movie root;

    //add a Movie node into the BST
    public void add(Movie add) {
        root = addRecursive(root, add);
    }

    //Uses recursion to find correct spot to add into
    private Movie addRecursive(Movie tree, Movie add) {
        if (tree == null) {
            tree = add;
        }
        else if (tree.compareTo(add) == 0) {
            return tree;
        }
        //if add > tree
        else if (tree.compareTo(add) < 0) {
            tree.right = addRecursive(tree.right, add);

        }
        //if add < tree
        else if (tree.compareTo(add) > 0) {
            tree.left = addRecursive(tree.left, add);
        }
        return tree;
    }

    //prints tree in order
    public Movie printInOrder(Movie root){
        if(root == null){
            return null;
        }
        printInOrder(root.left);
        System.out.println(root.getTitle());
        printInOrder(root.right);
        return null;
    }

    //returns arraylist of movies bounded between two songs
    public ArrayList<Movie> subSetList(ArrayList<Movie> array, Movie root, String start, String end) {
        // Selects movie titles that fall alphabetically between start and end.
        //case 1 root == null
        if(root == null){
            return array;
        }
        //root is between bounds
        if(root.getTitle().compareToIgnoreCase(start) >= 0 && root.getTitle().compareToIgnoreCase(end) <= 0){
            subSetList(array, root.left,start,end);
            array.add(root);
            subSetList(array, root.right,start,end);
        }
        //root is less than start
        if(root.getTitle().compareToIgnoreCase(start) <= -1){
            subSetList(array, root.right,start,end);
        }
        //root is greater than end
        if(root.getTitle().compareToIgnoreCase(end) >= 1){
            subSetList(array, root.left,start,end);
        }

        return array;
    }

    //prints tree in order bounded by two song names
    public void printSubSet(Movie root, String start, String end){

        //case 1 root == null
        if(root == null){
            return;
        }
        //root is between bounds
        if(root.getTitle().compareToIgnoreCase(start) >= 0 && root.getTitle().compareToIgnoreCase(end) <= 0){
            printSubSet(root.left,start,end);
            System.out.println(root.getTitle());
            printSubSet(root.right,start,end);
        }
        //root is less than start
        if(root.getTitle().compareToIgnoreCase(start) <= -1){
            printSubSet(root.right,start,end);
        }
        //root is greater than end
        if(root.getTitle().compareToIgnoreCase(end) >= 1){
            printSubSet(root.left,start,end);
        }

    }

}