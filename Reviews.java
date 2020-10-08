import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.io.FileNotFoundException;

/*Getting reviews from the user and calculating an average out of all the reviews left*/
public class Reviews{//declaring variables
   private double review;
   private ArrayList<Double> userReviews = new ArrayList<Double>();
   
   public void leaveReview() {//starting point of the system... all other methods are called here
      Scanner scnr = new Scanner(System.in);
      seeReviews();
      System.out.print("I hope you enjoyed our services. Please leave a review: (0.0 - 5.0 stars): ");
      review = scnr.nextDouble(); 
      saveReview();
      reviewAvg();
      
   }
   
   public void seeReviews() {//takes the past reviews from the file "Reviews.txt", saves them to userReviews array
      FileInputStream fileByteStream = null;
      Scanner inFS = null;
    
      try{//exception handling for opening file
         fileByteStream = new FileInputStream("Reviews.txt");
      }
      catch(FileNotFoundException exception){//exception handling
         System.out.println("Reviews.txt is missing.");
         System.exit(99);
      }

      inFS = new Scanner(fileByteStream);
      while (inFS.hasNextDouble()){
         double pastReview = inFS.nextDouble();
         userReviews.add(pastReview);
      }
       try{//exception handling for closing file
         fileByteStream.close();
      }
      catch (IOException exception){
         System.out.println("Error: File could not be closed");
      }

   }
   
   public void saveReview() {//takes the new review input by the user and saves it in the "Reviews.txt" file
      FileOutputStream fileStream = null;
      PrintWriter outFS = null;
      
      try{
         fileStream = new FileOutputStream("Reviews.txt");//exception handling for opening file
      }
      catch(FileNotFoundException exception){
         System.out.println("Reviews.txt is missing.");
         System.exit(99);
      }
         outFS = new PrintWriter(fileStream);//rewriting everything into the file plus the new number
         for (int i=0; i< userReviews.size(); i++){
            outFS.println(userReviews.get(i));
         }
         outFS.println(review);
         outFS.flush();
       
        try{//exception handling for closing file
         fileStream.close();
      }
      catch (IOException exception){
         System.out.println("Error: File could not be closed");
      }

   }
   public void reviewAvg() {//takes the average of all the reviews left in history
        double sum = 0.0;
        for (int i=0; i< userReviews.size(); i++){
         sum = sum + userReviews.get(i);
        }
        sum = sum + review;
        double average = sum/(userReviews.size() + 1);
        System.out.println("Thank you for your input. Our current average rating is " + average);
   }
}