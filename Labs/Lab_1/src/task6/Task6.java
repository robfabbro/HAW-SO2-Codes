package task6;
import java.util.Scanner;

public class Task6 {

  public static void main(String[] args) {
    // initialize the scanner for user input
    Scanner scanner = new Scanner(System.in);

    // Ask the user to enter a sentence or paragraph, and read their input
    System.out.print("Enter a sentence or paragraph to analyze: ");
    String inputText = scanner.nextLine();

    // Set up the variables to count the letter statistics for the report
    int totalCharsWithSpaces = inputText.length(); // total characters including spaces
    int totalCharsWithoutSpaces = inputText.replace(" ", "").length(); // total characters excluding spaces using the replace method
    int vowelCount = countVowels(inputText); // count the number of vowels using the countVowels method
    int consonantCount = countConsonants(inputText); // count the number of consonants using the countConsonants method

    // Set up the variables to count the word statistics for the report
    String[] words = inputText.split("\\s+"); // creates an array of words using the split method with a regular expression that matches whitespace
    int totalWords = words.length; // count the total number of words using the length of the array
    String longestWord = findLongestWord(words); // find the longest word using the findLongestWord method

    // Set up the variable to count the sentence statistics for the report
    int totalSentences = countSentences(inputText);

    // Prints out the text analysis report to the console, as per the requirements of the task
    System.out.println("\n=== TEXT ANALYSIS REPORT ===");
    System.out.println("Original text: \"" + inputText + "\"\n");

    System.out.println("Character Statistics:");
    System.out.println("- Total characters (with spaces): " + totalCharsWithSpaces);
    System.out.println("- Total characters (without spaces): " + totalCharsWithoutSpaces);
    System.out.println("- Number of vowels: " + vowelCount);
    System.out.println("- Number of consonants: " + consonantCount + "\n");

    System.out.println("Word Statistics:");
    System.out.println("- Total number of words: " + totalWords);
    System.out.println("- Longest word: \"" + longestWord + "\"\n");

    System.out.println("Sentence Statistics:");
    System.out.println("- Total number of sentences: " + totalSentences);

    
    System.out.print("\033[0;33m"); // set the text color to yellow with ASCI codes
    System.out.println("\nThank you for using the Text Analysis Program!\n");
    System.out.print("\033[0;0m");  // reset the text color to default with ASCI codes

    scanner.close();
  }

  // Helper Method 1: countVowels - This method counts the number of vowels in the input text.
  // uses the for-each loop to iterate through each character in the text, 
  // converting it to lowercase and checking if it is a vowel
  // using the indexOf method to check if the character is in the string "aeiou"
  private static int countVowels(String text) {
    int count = 0;
    for (char c : text.toLowerCase().toCharArray()) {
      if ("aeiou".indexOf(c) != -1) {
        count++;
      }
    }
    return count;
  }

  // Helper Method 2: countConsonants - This method counts the number of consonants in the input text.
  // uses the for-each loop to iterate through each character in the text, 
  // converting it to lowercase and checking if it is a consonant
  // using the Character.isLetter method to check if the character is a letter and the indexOf method to check if it is not a vowel
  private static int countConsonants(String text) {
    int count = 0;
    for (char c : text.toLowerCase().toCharArray()) {
      if (Character.isLetter(c) && "aeiou".indexOf(c) == -1) {
        count++;
      }
    }
    return count;
  }

  // Helper Method 3: findLongestWord - This method finds the longest word in an array of strings.
  // uses the for-each loop to iterate through each word in the array, 
  // checking if the length of the current word is greater than the length of the longest word found so far
  // if it is, it updates the longest word variable to the current word
  // and at the end of the loop, it returns the longest word found in the array
  private static String findLongestWord(String[] words) {
    String longest = "";
    for (String word : words) {
      if (word.length() > longest.length()) {
        longest = word;
      }
    }
    return longest;
  }

  // Helper Method 4: countSentences - This method counts the number of sentences in the input text.
  // uses the split method to split the text into an array of strings based on the sentence-ending punctuation marks
  // and returns the length of the resulting array
  private static int countSentences(String text) {
    String[] sentences = text.split("[.!?]+");
    return sentences.length;
  }



}
