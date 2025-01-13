package wordleHelper;

// Imports
import java.util.*;
import java.io.File;
import java.io.IOException;

public class WordleHelper {

    public static void main(String[] args) {
        String fileName = "words_alpha.txt";
        ArrayList<String> words = new ArrayList<>();
        
        // Create a File object
        File file = new File(fileName);

        // Try and Catch of opening a new file
        try {
                Scanner scanner = new Scanner(file);

                // Add all the words into an ArrayList
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (line.length() == 5) {
                    words.add(line);
                    }
                }
                scanner.close();
                
                scanner = new Scanner(System.in);
                System.out.print("Please enter your green letters and their places and not sure with \"-\"(e.g., W--D-E if WDE are known. If no green then enter \"-----\"): ");
                String greenL = scanner.nextLine();
                System.out.print("Please Enter all eliminated letters as one word (e.g., LMNOPQRS): ");
                String blackL = scanner.nextLine();
                System.out.print("Please Enter all yellow letters: ");
                String yellowL = scanner.nextLine();
              
                // Eliminates all words that doesn't include greenL letters in the corresponding spots
                boolean possibleWordGreen = true;
                for (int i = 0; i < words.size(); i ++) {
	                for (int j = 0; j < greenL.length(); j ++) {
	                	if (Character.isLetter(greenL.charAt(j))) {
	                		if (words.get(i).charAt(j) != greenL.charAt(j)) {
	                			possibleWordGreen = false;
	                		}
	                	}
	                }
	                if (!possibleWordGreen) {
	                	words.remove(i);
		            	i -= 1;
	                }
	                possibleWordGreen = true;
                }
                
             
                // Eliminates all words that doesn't include yellowL letters
                boolean possibleWordYellow = true;
                for (int i = 0; i < words.size(); i ++) {
		            for (int j = 0; j < yellowL.length(); j++) {
		            	char letter = yellowL.charAt(j);
		            	if (words.get(i).indexOf(letter) == -1) {
		            		possibleWordYellow = false;
		            	}
		            }
		            if (!possibleWordYellow) {
		            	words.remove(i);
		            	i -= 1;
		            }
		            possibleWordYellow = true;
                }
                
                // Eliminates all words that includes blackL letters
                boolean possibleWordBlack = true;
                for (int i = 0; i < words.size(); i ++) {
		            for (int j = 0; j < blackL.length(); j++) {
		            	char letter = blackL.charAt(j);
		            	if (words.get(i).indexOf(letter) != -1) {
		            		possibleWordBlack = false;
		            	}
		            }
		            if (!possibleWordBlack) {
		            	words.remove(i);
		            	i -= 1;
		            }
		            possibleWordBlack = true;
                }
	            	
                
            } 
         catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
        for (int i = 0; i < words.size(); i ++) {
        	System.out.println(words.get(i));
        }
        System.out.println(words.size());
        
    }
}
