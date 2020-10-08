/*Author: Isabel Melo
September 20th 2020
Homework 2 -- CSE 389
Program description: This is a random movie generator. 
It randomly chooses a movie from a list of movies. 
You can add movies from the list.
You can leave a review to our program.
*/

public class Homework2 {

//main (start execution)
   public static void main(String args[]){
      System.out.println("Welcome to random movie generator!");
      Movies movie = new Movies();//Creating mvie object
      movieEditor edits = new movieEditor();//Creating movieEditor Object
      edits.whatToDo();//decides whether to add a new movie to the list before getting a random movie
      movie.movieList();//reads the list of movies into a private array
      Object theSelectedMovie = movie.generateMovie();//chooses a random movie to watch
      edits.moviePresentor(theSelectedMovie);//Presents the random movie in a pretty format
      edits.haveYouSeenIt();//asks whether you have seen the chosen movie. Returns true if answer is yes.
      edits.seenIt();// If haveYouSeenIt() returns true, this will generate a new movie suggestion
      edits.wantToWatch();// asks whether they want to watch the current selected movie. Returns true if answer is no.
      edits.notSeenIt();// if wantToWatch is true, it will generate a new random movie to watch
      Reviews userReview = new Reviews();// After the movie is chosen, program asks for a review. Declaring review object
      userReview.leaveReview();//IO of review object + file handling
   }

}