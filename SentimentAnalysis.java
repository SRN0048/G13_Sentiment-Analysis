/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sentimentanalysis;

/**
 *
 * @author Kris
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class SentimentAnalysis {

    /**
     * @param args the command line arguments
     */
public static void main(String[] args) throws FileNotFoundException 
	{
		File reviewFile = new File("movieReviews.txt");
		
		Scanner keyboard = new Scanner(System.in);

		int reviewScore;
		String reviewText;
		//String word;
                String review;
                int wordCount = 0;
                int count = 0;
                int sumScore = 0;
                double avgScore;
                double totalAvgScore = 0;
                double reviewAvg = 0;

		System.out.println("Enter a review:");
                review = keyboard.nextLine();
                String[] arr = review.split(" "); 
                
                for (String word : arr){
                    Scanner reviewScanner = new Scanner(reviewFile);
                    word = (" "+word+" ").toLowerCase();

                    while(reviewScanner.hasNext())
                    {
                            reviewScore = reviewScanner.nextInt();
                            reviewText = reviewScanner.nextLine().toLowerCase();

                            if(reviewText.contains(word))
                            {
                                count++;
                                sumScore += reviewScore;
				//System.out.println("Score: "+reviewScore);
				//System.out.println("Text: "+reviewText);
                            }
                    }
                    avgScore = (double)sumScore/count;
                    //System.out.println("Total sum score: "+ sumScore);
                    //System.out.println("count: "+ count);
                    //System.out.println("The average word score is: "+avgScore);
                    totalAvgScore += avgScore;
                    wordCount++;
                    count = 0;
                    sumScore = 0;
                }
                reviewAvg = (double)totalAvgScore/wordCount;
                System.out.println("The review has an average value of "+ reviewAvg);
                if (reviewAvg > 2){
                    System.out.println("Positive Sentiment");
                }
                else{
                    System.out.println("Negative Sentiment");
                }
                
	}

}

