import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.*;
import java.io.PrintWriter;
import java.io.FileOutputStream;

//This program takes care of handling the output and input files Movies.txt 
public class Movies {

   private ArrayList unwatchedMovies = new ArrayList<String>();
   private Random randGen;
   
   //fetching the list of unwatched movies from "Movies.txt"; reading into an array list
   public void movieList(){
      //Declaration
      FileInputStream fileByteStream = null; //File input stream
      Scanner inFS = null; //Scanner object
      String movie = ""; //data from file
      
      //try opening file or catch exception
      try{
      fileByteStream = new FileInputStream("Movies.txt");
      }
      catch(FileNotFoundException exception){
       System.out.println("Movies.txt is missing.");
       System.exit(99);
      }
      inFS = new Scanner(fileByteStream);
      
      //saving contents into an ArrayList
      while (inFS.hasNext()){
        movie = inFS.nextLine();
        unwatchedMovies.add(movie);
      }
      try{
         fileByteStream.close();
      }
      catch (IOException exception){
         System.out.println("Error: File could not be closed");
      }
   }
    
      
   //adds the new movie to the movies.txt file
   public void newMovieList() { 
      System.out.println("What movie would you like to add to the list? ");
      Scanner scnr = new Scanner(System.in);
      String aNewMovie = scnr.nextLine();

      FileOutputStream fileStream = null;
      PrintWriter outFS = null;
      try{
      fileStream = new FileOutputStream("Movies.txt");//exception handling
      }
      catch (FileNotFoundException exception){
         System.out.println("Error: File not found");
         System.exit(99);
      }

      outFS = new PrintWriter(fileStream);
      for(int i = 0; i < unwatchedMovies.size(); i++){
         outFS.println(unwatchedMovies.get(i));
      }
      outFS.println(aNewMovie);
      outFS.flush();
      try{//exception handling
      fileStream.close();
      }
      catch (IOException exception){
         System.out.println("Error: File could not be closed");
      }
      System.out.println("adding movie to the list...");

   }

   //returns a random movie from the movie list
   public Object generateMovie(){
      randGen = new Random(); //New Random number Generator
      int randInt;
      int size;
      size = unwatchedMovies.size();
      randInt = randGen.nextInt(size);
      Object selectedMovie = "";
      selectedMovie = unwatchedMovies.get(randInt);
      return selectedMovie;
   }
}