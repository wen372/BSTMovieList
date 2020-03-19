/* The MovieBST implementation */

public class MovieBST {
    Movie root;

    public void subSet(String start, String end){
        // Selects movie titles that fall alphabetically between start and end.
    }

    // more methods


    public Movie sortedArrayToBST(Movie[] movies) {

        return helper(movies, 0, movies.length - 1);
    }

    public Movie helper(Movie[] movies, int low, int high) {
        if(low > high) {
            return null;
        }

        int mid = low + (high - low)/2;
        //center val of sorted array as the root of the bst
        Movie head = movies[mid];

        //left of the mid value should go to the left of this root node to satisfy bst
        head.left = helper(movies, low, mid - 1);
        //right of the mid value should go to the right of this root node to satisfy bst
        head.right = helper(movies, mid + 1, high);
        return head;

    }

    public void traverseInOrder(Movie node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.println(" " + node);
            traverseInOrder(node.right);
        }
    }


}