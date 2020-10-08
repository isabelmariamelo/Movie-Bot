import java.util.Scanner;
/*This class is made to define the output of the program "Homework2"

*/
public class movieEditor{

   //class variables
   private boolean userAns = false;
   private boolean secondUserAns = false;
   
   public static void whatToDo(){//If the user wants to add a mo
      System.out.println("Would you like to: \n(a) add a movie to the list first \n(b) skip to get a movie recommendation");
      Scanner scnr = new Scanner(System.in);
      String wtd = scnr.next();
      char toDo = wtd.charAt(0);
      switch (toDo) {
         case 'a':
            Movies movieObject = new Movies();
            movieObject.movieList();
            movieObject.newMovieList();
            break;
         case 'b':
            break;
         default:
            break;
      }
   }
   
   
   public static void moviePresentor(Object selectedMovie) {//show user the movie that was selected in format
      System.out.println("We have selected \"" + selectedMovie + "\" for you to watch.");
   }
   
   public void haveYouSeenIt(){ //returns true if user has seen the movie
      Scanner scnr = new Scanner(System.in);
      System.out.println("Have you seen this movie yet? (y/n)");
      String ans = scnr.next();
      char answer = ans.charAt(0);
      if (answer == 'y'){
         userAns = true;
      }
      else {
         userAns = false;
      }
    }
    
    public static Object movieGen() { // creates a movie object; returns the selected movie
       Movies anotherMovie = new Movies();
       anotherMovie.movieList();
       Object nextMovie = anotherMovie.generateMovie();
       return nextMovie;
    }
    
    public void seenIt() {//if the user has seen the movie, it shows a new movie
     while (userAns == true){
       System.out.println("Cool. Let us choose another movie for you.");
       Object nextMovie = movieGen();
       moviePresentor(nextMovie);
       haveYouSeenIt();
      }
    }
    
     public void wantToWatch(){// return true if user does not want to watch the movie
      Scanner scnr = new Scanner(System.in);
      System.out.println("Do you want to watch this movie? (y/n)");
      String ans = scnr.next();
      char answer = ans.charAt(0);
      if (answer == 'n'){
         secondUserAns = true;
      }
      else {
         secondUserAns = false;
      }
    }

    public void notSeenIt() {// if the user does not want to see the movie, it chooses a new movie
      while (secondUserAns == true){
       System.out.println("That's okay. Let us choose another movie for you.");
       Object nextMovie = movieGen();
       moviePresentor(nextMovie);
       wantToWatch();
      }
      
    }
      
   }
