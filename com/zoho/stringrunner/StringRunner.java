package com.zoho.stringrunner;
import java.util.*;
import java.io.*;
import com.zoho.stringtask.*;
import com.zoho.customstringexception.*;

public class StringRunner {
    StringTask task = new StringTask();
    
    public static void main(String[] args) {
        System.out.println("=========== String Tasks =============");
        System.out.print("1.Length of the String entered in the command line argument\n2.Convert String into char array\n3.Displaying a character of a string\n4.No. of occurence of character\n5.Greatest position of a character\n6.Displaying last Few characters of a string\n7.Displaying first few characters of a string\n8.Replacing characters in a string\n9.check whether the string starts with the original string \n10.check whether the string ends with the original string\n11.UPPERCASE\n12.lowercase\n13.Reverse a string\n14.Multiple words in a single line\n15.Multiple String in a single line after removing spaces\n16.Convert a string into string array using a seperator\n17.Merging strings with a character in between\n18.Comparing Strings (case sensitive)\n19.Comparing Strings (case insensitive)\n20.Removing extra spaces in the beginning and the end\n21.Exit\n");
        System.out.println("======================================");
        boolean exit;
        StringRunner runner = new StringRunner();
        
        try(Scanner scanner = new Scanner(System.in)){
            do {
                exit = false;
                try {
                    int selectOperation=runner.getValidIntegerInput(scanner,"Select an operation : ");
                    switch(selectOperation) {
                    case 1: {
                        System.out.println("Length of the string in comment line argument : "+ runner.getLength(args));
                        break;
                    }
                    case 2: {
                        System.out.println("Converting String into char Array : "+ runner.convertStringToCharArray(scanner));
                        break;
                    }
                    case 3: {
                        System.out.println("Selected character of the String : "+ runner.getCharacterAt(scanner));
                        break;
                    }
                    case 4: {
                        System.out.println("No of occurence of the entered character :"+ runner.getNoOfOccurences(scanner));
                        break;
                    }
                    case 5: {
                        System.out.println("Greatest position of the entered character :"+ runner.getGreatestPositionOfCharacter(scanner));
                        break;
                    }
                    case 6: {
                        System.out.println("Last few characters of the given string : "+ runner.getLastFewCharacters(scanner));
                        break;
                    }
                    case 7: {
                        System.out.println("First few characters of the given string :"+runner.getFirstFewCharacters(scanner));
                        break;
                    }
                    case 8: {
                        System.out.println("ModifiedString : "+ runner.getReplacedString(scanner));
                        break;
                    }
                    case 9: {
                        System.out.println("Entered string starts with the original string - "+ runner.isStartsWith(scanner));
                        break;
                    }
                    case 10: {
                        System.out.println("Entered string ends with the original string"+ runner.isEndsWith(scanner));
                        break;
                    }
                    case 11: {
                        System.out.println("UPPERCASE : "+ runner.getUpperCaseString(scanner));
                        break;
                    }
                    case 12: {
                        System.out.println("lowercase : "+ runner.getLowerCaseString(scanner));
                        break;
                    }
                    case 13: {
                        System.out.println("Reversed String : "+ runner.getReversedString(scanner));
                        break;
                    }
                    case 14: {
                        System.out.println("Multiple Strings in a line : "+ runner.getMultipleStringsInSingleLine(scanner));
                        break;
                    }
                    case 15: {
                        System.out.println("Multiple Strings in a single line after removing spaces : "+ runner.removeSpaces(scanner));

                        break;
                    }
                    case 16: {
                        System.out.println("spaced strings to String arr : "+ runner.convertToStringArray(scanner));
                        break;
                    }
                    case 17: {
                        System.out.println("Merged Strings with a character inbetween : "+ runner.mergeStrings(scanner));
                        break;
                    }
                    case 18: {
                        System.out.println("String1 equal to String2 (case sensitive) - "+ runner.areStringsEqualWithCase(scanner));
                        break;

                    }
                    case 19: {
                        System.out.println("String1 equal to String2 (case insensitive) - "+ runner.areStringsEqualWithoutCase(scanner));
                        break;
                    }
                    case 20: {
                        System.out.println("String after removing extra spaces :" + runner.trimSpacesAtBeginAndEnd(scanner));
                        break;
                    }
                    case 21: {
                        exit = true;
                    }
                    default : {
                        System.out.println("Please enter a number between (1-21)");
                    }
                    }
                } catch(StringRunnerException exception) {
                    System.out.println("Error : "+ exception.getMessage());
                    System.out.println("Exception : "+ exception.getClass().getName());
                    Throwable cause = exception.getCause();
                    if(cause!=null) {
                        System.out.println("Root cause : "+ cause.getMessage());
                        System.out.println("Root cause Exception : "+ cause.getClass().getName());
                    }
                }
                
            } while(!exit);
            }
            
    }
    private String getLength(String[] args) throws StringRunnerException {
        try {
            System.out.println("=== String length ===");
            if(args.length>0) {
                int length = task.getLength(args[0]);
                return Integer.toString(length);

            } else {
                return "No input was provided";
            }
        } catch(Exception exception) {
            throw new StringRunnerException("Runner exception",exception);
        }
    }

    private String convertStringToCharArray(Scanner scanner)throws StringRunnerException {
        try {
            System.out.println("=== String -> Character Array ===");
            String input = getValidInputString(scanner,"Enter a String : ");
            return Arrays.toString(task.convertStringToCharArray(input));
        } catch(Exception exception) {
            throw new StringRunnerException("Runner exception",exception);
        }
    }
    private char getCharacterAt(Scanner scanner) throws StringRunnerException {
        try {
            System.out.println("=== Character of a string ===");
            String input = getValidInputString(scanner,"Enter a String : ");
            int indexNo = getValidIntegerInput(scanner,"Enter index Number : ");
            return task.getCharacterAt(input,indexNo);
        } catch(Exception exception) {
            throw new StringRunnerException("Runner exception",exception);
        }
    }
    private int getNoOfOccurences(Scanner scanner) throws StringRunnerException {
        try {
            System.out.println("=== No. of occurence ===");
            String input = getValidInputString(scanner,"Enter a String : ");
            System.out.print("Enter a char to check its no. of occurrences : ");
            char character = scanner.next().charAt(0);
            return task.getNoOfOccurences(character,input);
        } catch(Exception exception) {
            throw new StringRunnerException("Runner exception",exception);
        }
    }
    private String getGreatestPositionOfCharacter(Scanner scanner)throws StringRunnerException {
        try {
            System.out.println("=== Greatest position of a Character ===");
            String input = getValidInputString(scanner,"Enter a String : ");
            System.out.print("Enter a char to find its greatest position : ");
            char character = scanner.next().charAt(0);
            if(task.getGreatestPosition(character,input)==-1) {
                return "The entered character is not present in the string";
            } else {
                return Integer.toString(task.getGreatestPosition(character,input));
            }
        } catch(Exception exception) {
            throw new StringRunnerException("Runner exception",exception);
        }
    }
    private String getLastFewCharacters(Scanner scanner) throws StringRunnerException {
        try {
            System.out.println("=== Displaying last few characters ===");
            String input = getValidInputString(scanner,"Enter a String : ");
            int noOfLastFewChar = getValidIntegerInput(scanner,"Enter the No. of characters to be displayed :");
            String lastFewChar = task.getLastFewCharacters(noOfLastFewChar,input);
            return lastFewChar;
        } catch(Exception exception) {
            throw new StringRunnerException("Runner exception",exception);
        }
    }
    private String getFirstFewCharacters(Scanner scanner) throws StringRunnerException {
        try {
            System.out.println("=== Displaying first few characters ===");
            String input = getValidInputString(scanner,"Enter a String : ");
            int noOfFirstFewChar= getValidIntegerInput(scanner,"Enter the No. of characters to be displayed :");
            String firstFewChar = task.getFirstFewCharacters(noOfFirstFewChar,input);
            return firstFewChar;
        } catch(Exception exception) {
            throw new StringRunnerException("Runner exception",exception);
        }
    }
    private String getReplacedString(Scanner scanner) throws StringRunnerException {
        try {
            String modifiedString ="";
            System.out.println("=== Replacing Strings !! ===");
            String input = getValidInputString(scanner,"Enter original String : ");
            String replacement = getValidInputString(scanner,"Enter replacement String : ");
            int size= getValidIntegerInput(scanner,"No. of characters to replace in the original string : ");
            System.out.println("Where to Replace\n1.Prefix\n2.Suffix\n3.From Specific Index");
            int type = getValidIntegerInput(scanner,"Select a number :");
            switch(type) {
            case 1: {
                modifiedString = task.replacePrefix(input,replacement,size);
                break;
            }
            case 2: {
                modifiedString = task.replaceSuffix(input,replacement,size);
                break;
            }
            case 3: {
                int indexNo = getValidIntegerInput(scanner,"Enter index no. : ");
                modifiedString = task.replaceFromIndex(input,replacement,size,indexNo);
                break;
            }
            default: {
                throw new StringRunnerException("Select a proper option");
            }
            }
            return modifiedString;
        } catch(Exception exception) {
            throw new StringRunnerException("Runner exception",exception);
        }
    }
    private boolean isStartsWith(Scanner scanner) throws StringRunnerException {
        try {
            System.out.println("===== Checking if the string starts with the original string =====");
            String input = getValidInputString(scanner,"Enter a String : ");
            String enteredString = getValidInputString(scanner,"Enter a String to check : ");
            return task.isStartsWith(enteredString,input);
        } catch(Exception exception) {
            throw new StringRunnerException("Runner exception",exception);
        }
    }
    private boolean isEndsWith(Scanner scanner) throws StringRunnerException {
        try {
            System.out.println("===== Checking if the string ends with the original string =====");
            String input = getValidInputString(scanner,"Enter original String : ");
            String enteredString = getValidInputString(scanner,"Enter a String to check : ");
            return task.isEndsWith(enteredString,input);
        } catch(Exception exception) {
            throw new StringRunnerException("Runner exception",exception);
        }
    }
    private String getUpperCaseString(Scanner scanner) throws StringRunnerException {
        try {
            System.out.println("=== UPPERCASE ===");
            String input = getValidInputString(scanner,"Enter a String : ");
            return task.getUpperCaseString(input);
        } catch(Exception exception) {
            throw new StringRunnerException("Runner exception",exception);
        }
    }
    private String getLowerCaseString(Scanner scanner) throws StringRunnerException {
        try {
            System.out.println("=== LOWERCASE ===");
            String input = getValidInputString(scanner,"Enter a String : ");
            return task.getLowerCaseString(input);
        } catch(Exception exception) {
            throw new StringRunnerException("Runner exception",exception);
        }
    }
    private String getReversedString(Scanner scanner) throws StringRunnerException {
        try {
            System.out.println("=== Reversing a String ===");
            String input = getValidInputString(scanner,"Enter a String : ");
            return task.getReversedString(input);
        } catch(Exception exception) {
            throw new StringRunnerException("Runner exception",exception);
        }
    }
    private String getMultipleStringsInSingleLine(Scanner scanner) throws StringRunnerException {
        try {
            String input = getValidInputString(scanner,"Enter multiple strings in a line : ");
            return input;
        } catch(Exception exception) {
            throw new StringRunnerException("Runner exception",exception);
        }
    }
    private String removeSpaces(Scanner scanner) throws StringRunnerException {
        try {
            System.out.println("=== Removing Spaces ====");
            String spacedString = getValidInputString(scanner,"Enter a string with spaces : ");
            return task.removeSpaces(spacedString);
        } catch(Exception exception) {
            throw new StringRunnerException("Runner exception",exception);
        }
    }
    private String convertToStringArray(Scanner scanner) throws StringRunnerException {
        try {
            System.out.println("=== Converting string into string array using a seperator ===");
            String multiString= getValidInputString(scanner,"Enter a String : ");
            String seperator = getValidInputString(scanner,"Enter seperator : ");
            return Arrays.toString(task.convertToStringArray(seperator,multiString));
        } catch(Exception exception) {
            throw new StringRunnerException("Runner exception",exception);
        }
    }
    private boolean areStringsEqualWithCase(Scanner scanner) throws StringRunnerException {
        try {
            System.out.println("Comparing two strings whether it is equal or not (With case)");
            String mainString = getValidInputString(scanner,"Enter String 1 : ");
            String compareString = getValidInputString(scanner,"Enter String 2 : ");
            return task.areStringsEqualWithCase(mainString,compareString);
        } catch(Exception exception) {
            throw new StringRunnerException("Runner exception",exception);
        }
    }
    private boolean areStringsEqualWithoutCase(Scanner scanner) throws StringRunnerException {
        try {
            System.out.println("Comparing two strings whether it is equal or not (Without case)");
            String mainString = getValidInputString(scanner,"Enter String 1 : ");
            String compareString = getValidInputString(scanner,"Enter String 2 : ");
            return task.areStringsEqualWithoutCase(mainString,compareString);
        } catch(Exception exception) {
            throw new StringRunnerException("Runner exception",exception);
        }
    }
    private String trimSpacesAtBeginAndEnd(Scanner scanner) throws StringRunnerException {
        try {
            System.out.println("====== Removing extra spaces in the beginning and end ======");
            String stringWithSpace = getValidInputString(scanner,"Enter a string which has spaces in the beginning and ending :");
            return task.trimSpacesAtBeginAndEnd(stringWithSpace);
        } catch(Exception exception) {
            throw new StringRunnerException("Runner exception",exception);
        }
    }
    private String mergeStrings(Scanner scanner) throws StringRunnerException {
        try {
            System.out.println("===Write multiple strings to merge them in a single line seperated by a character===");
            ArrayList<String> multipleStrings = new ArrayList<String>();
            int n=1;
            while(true) {
                System.out.print("String "+n+ " : ");
                String toMerge= scanner.nextLine();
                n++;
                if (toMerge.isEmpty()) {
                    break;
                }
                multipleStrings.add(toMerge);
            }
            String mergingChar = getValidInputString(scanner,"Enter the character : ");
            return task.mergeStrings(multipleStrings,mergingChar);
        } catch(Exception exception) {
            throw new StringRunnerException("Runner exception",exception);
        }
    }
    public String getValidInputString(Scanner scanner,String prompt) {
        System.out.print(prompt);
        String str = scanner.nextLine();
        return str;
    }
    public int getValidIntegerInput(Scanner scanner, String prompt) {
        int input=0;
        boolean validInput = false;
        while (!validInput) {
            System.out.print(prompt);
            try {
                input = scanner.nextInt();
                scanner.nextLine();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine();
            }
        }
        return input;
    }
}
