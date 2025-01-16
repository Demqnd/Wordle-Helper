package wordleHelper;

// Imports
import java.util.*;
import java.io.File;
import java.io.IOException;

public class WordleHelper {

    public static void main(String[] args) {
	// Create a File object 
        String fileName = "words_alpha.txt";
	File file = new File(fileName);

	// Initializing an ArrayList
        ArrayList<String> words = new ArrayList<>();
        
        

        // Try and Catch of opening a new file
        try {
                Scanner scanner = new Scanner(file);

                // Add all the words into the ArrayList
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (line.length() == 5) {
                    words.add(line);
                    }
                }
                scanner.close();

		// Get the User Input for their current wordle progress
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
				// If the character the user entered is either a letter or "-"
	                	if (Character.isLetter(greenL.charAt(j))) {
					//If the green char the user entered does not match the same location as the current word in words ArrayList
	                		if (words.get(i).charAt(j) != greenL.charAt(j)) {
						// Set the word to be removed
	                			possibleWordGreen = false;
	                		}
	                	}
	                }
			// If the current word in words ArrayList does not fit the user description then remove it
	                if (!possibleWordGreen) {
	                	words.remove(i);
		            	i -= 1;
	                }

			// Reset the variable for the loop
	                possibleWordGreen = true;
                }
                
             
                // Eliminates all words that doesn't include yellowL letters
                boolean possibleWordYellow = true;
                for (int i = 0; i < words.size(); i ++) {
		            for (int j = 0; j < yellowL.length(); j++) {
		            	char letter = yellowL.charAt(j);
				// If the users yellow word is not contained in the current ArrayList Word
		            	if (words.get(i).indexOf(letter) == -1) {
					// Set the word to be removed
		            		possibleWordYellow = false;
		            	}
		            }
			    // If the current word in words ArrayList does not fit the user description then remove it
		            if (!possibleWordYellow) {
		            	words.remove(i);
		            	i -= 1;
		            }
			    // Reset the variable for the loop
		            possibleWordYellow = true;
                }
                
                // Eliminates all words that includes blackL letters
                boolean possibleWordBlack = true;
                for (int i = 0; i < words.size(); i ++) {
		            for (int j = 0; j < blackL.length(); j++) {
		            	char letter = blackL.charAt(j);
				// if the ArrayList word contains one of the black letters that it should not
		            	if (words.get(i).indexOf(letter) != -1) {
					// Set the word to be removed
		            		possibleWordBlack = false;
		            	}
		            }
			    // If the current word in words ArrayList does not fit the user description then remove it
		            if (!possibleWordBlack) {
		            	words.remove(i);
		            	i -= 1;
		            }
			    // Reset the variable for the loop
		            possibleWordBlack = true;
                }
	            	
                
            } 
	 // Catch Error
         catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        // Print out all possible words
        for (int i = 0; i < words.size(); i ++) {
        	System.out.println(words.get(i));
        }
        
    }
}
