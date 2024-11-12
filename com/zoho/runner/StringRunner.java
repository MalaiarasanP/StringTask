package com.zoho.runner;
import java.util.*;
import java.io.*;
import com.zoho.task.*;
import com.zoho.customexception.customstringexception.*;

public class StringRunner {
    public static void main(String[] args) {
        System.out.println("=========== String Tasks =============");
        System.out.print("1.Length of the String entered in the command line argument\n2.Convert String into char array\n3.Displaying a character of a string\n4.No. of occurence of character\n5.Greatest position of a character\n6.Displaying last Few characters of a string\n7.Displaying first few characters of a string\n8.Replacing characters in a string\n9.check whether the string starts with the original string \n10.check whether the string ends with the original string\n11.UPPERCASE\n12.lowercase\n13.Reverse a string\n14.Multiple words in a single line\n15.Multiple String in a single line after removing spaces\n16.Convert a string into string array using a seperator\n17.Merging strings with a character in between\n18.Comparing Strings (case sensitive)\n19.Comparing Strings (case insensitive)\n20.Removing extra spaces in the beginning and the end\n21.Exit\n");

        System.out.println("======================================");
        boolean exit;
        int selectOperation=0;
        String input="";
        Scanner scanner = new Scanner(System.in);
        StringTask task = new StringTask();
        StringRunner runner = new StringRunner();
        try {
            do {
                exit = false;
                if(!(0<selectOperation&&selectOperation<22)) {
                    selectOperation=runner.getValidIntegerInput(scanner,"Select an operation : ");
                    if(!(0<selectOperation&&selectOperation<22)) {
                        System.out.println("Please enter a number between (1-20)");
                        continue;
                    }
                }

                try {
                    switch(selectOperation) {
                    case 1: {
                        System.out.println("Length of the string in comment line argument : "+ runner.displayStringLength(args,task));
                        break;
                    }
                    case 2: {
                        System.out.println("Converting String into char Array : "+ runner.displayStringToCharArrayConversion(scanner,task));
                        break;
                    }
                    case 3: {
                        System.out.println("Selected character of the String : "+ runner.displayCharacterOfString(scanner,task));
                        break;
                    }
                    case 4: {
                        System.out.println("No of occurence of the entered character :"+ runner.displayNoOfOccurences(scanner,task));
                        break;
                    }
                    case 5: {
                        System.out.println("Greatest position of the entered character :"+ runner.displayGreatestPositionOfCharacter(scanner,task));
                        break;
                    }
                    case 6: {
                        System.out.println("Last few characters of the given string : "+ runner.displayLastFewCharacters(scanner,task));
                        break;
                    }
                    case 7: {
                        System.out.println("First few characters of the given string :"+runner.displayFirstFewCharacters(scanner,task));
                        break;
                    }
                    case 8: {
                        System.out.println("ModifiedString : "+ runner.displayReplacedString(scanner,task));
                        break;
                    }
                    case 9: {
                        System.out.println("Entered string starts with the original string - "+ runner.performStartsWith(scanner,task));
                        break;
                    }
                    case 10: {
                        System.out.println("Entered string ends with the original string"+ runner.performEndsWith(scanner,task));
                        break;
                    }
                    case 11: {
                        System.out.println("UPPERCASE : "+ runner.performConvertToUpperCase(scanner,task));
                        break;
                    }
                    case 12: {
                        System.out.println("lowercase : "+ runner.performConvertToLowerCase(scanner,task));
                        break;
                    }
                    case 13: {
                    	 System.out.println("Reversed String : "+ runner.displayReversedString(scanner,task));
                        break;
                    }
                    case 14: {
                    	 System.out.println("Multiple Strings in a line : "+ runner.displayLineWithMultipleStrings(scanner,task));
                        break;
                    }
                    case 15: {
                    	 System.out.println("Multiple Strings in a single line after removing spaces : "+ runner.displayStringAfterRemovingSpaces(scanner,task));
                        
                        break;
                    }
                    case 16: {
                    	  System.out.println("spaced strings to String arr : "+ runner.performConvertToStringArray(scanner,task));
                        break;
                    }
                    case 17: {
                    	 System.out.println("Merged Strings with a character inbetween : "+ runner.displayMergedStrings(scanner,task));
                        break;
                    }
                    case 18: {
                    	 System.out.println("String1 equal to String2 (case sensitive) - "+ runner.performCompareStringsWithCase(scanner,task));
                        break;
                    	 
                    }
                    case 19: {
                    	 System.out.println("String1 equal to String2 (case insensitive) - "+ runner.performCompareStringsWithoutCase(scanner,task));
                        break;
                    }
                    case 20:{
                    	 System.out.println("String after removing extra spaces :" + runner.performRemovingExtraSpaces(scanner,task));
                    	 break;
                    }
                    default: {
                        exit = true;
                    }
                    }
                    selectOperation =0;
                } catch(CustomStringException error) {
                    System.out.println("Error : "+ error.getMessage());
                    System.out.println("Exception : "+ error.getClass().getName());
                    Throwable cause = error.getCause();
                    if(cause!=null) {
                        System.out.println("Root cause : "+ cause.getMessage());
                        System.out.println("Root cause Exception : "+ cause.getClass().getName());
                    }
                    scanner.nextLine();
                }
            } while(!exit);
        } finally {
            scanner.close();
        }
    }
    private String displayStringLength(String[] args,StringTask task) throws CustomStringException {
        System.out.println("=== String length ===");
        if(args.length>0){
        	int length = task.getLength(args[0]);
		return Integer.toString(length);

        }
        else{	
        	return "No input was provided";
        }
    }
    private String displayStringToCharArrayConversion(Scanner scanner,StringTask task)throws CustomStringException {
        System.out.println("=== String -> Character Array ===");
        String input = getValidInputString(scanner,"Enter a String : ");
        return Arrays.toString(task.convertStringToCharArray(input));
    }
    private char displayCharacterOfString(Scanner scanner,StringTask task) throws CustomStringException {
        System.out.println("=== Character of a string ===");
        String input = getValidInputString(scanner,"Enter a String : ");
        int indexNo = getValidIntegerInput(scanner,"Enter index Number : ");
        return task.getCharacterAt(input,indexNo);
    }
    private int displayNoOfOccurences(Scanner scanner,StringTask task) throws CustomStringException {
        System.out.println("=== No. of occurence ===");
        String input = getValidInputString(scanner,"Enter a String : ");
        System.out.print("Enter a char to check its no. of occurrences : ");
        char character = scanner.next().charAt(0);
        return task.getNoOfOccurences(character,input);
    }
    private String displayGreatestPositionOfCharacter(Scanner scanner,StringTask task)throws CustomStringException {
        System.out.println("=== Greatest position of a Character ===");
        String input = getValidInputString(scanner,"Enter a String : ");
        System.out.print("Enter a char to find its greatest position : ");
        char character = scanner.next().charAt(0);
        if(task.getGreatestPosition(character,input)==-1) {
            return "The entered character is not present in the string";
        } else {
            return Integer.toString(task.getGreatestPosition(character,input));
        }
    }
    private String displayLastFewCharacters(Scanner scanner,StringTask task) throws CustomStringException {
        System.out.println("=== Displaying last few characters ===");
        String input = getValidInputString(scanner,"Enter a String : ");
        int noOfLastFewChar = getValidIntegerInput(scanner,"Enter the No. of characters to be displayed :");
        String lastFewChar = task.getLastFewCharacters(noOfLastFewChar,input);
        return lastFewChar;
    }
    private String displayFirstFewCharacters(Scanner scanner,StringTask task) throws CustomStringException {
        System.out.println("=== Displaying first few characters ===");
        String input = getValidInputString(scanner,"Enter a String : ");
        int noOfFirstFewChar= getValidIntegerInput(scanner,"Enter the No. of characters to be displayed :");
        String firstFewChar = task.getFirstFewCharacters(noOfFirstFewChar,input);
        return firstFewChar;
    }
    private String displayReplacedString(Scanner scanner,StringTask task) throws CustomStringException {
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
            throw new CustomStringException("Select a proper option");
        }
        }
        return modifiedString;
    }
    private boolean performStartsWith(Scanner scanner,StringTask task) throws CustomStringException {
        System.out.println("===== Checking if the string starts with the original string =====");
        String input = getValidInputString(scanner,"Enter a String : ");
        String enteredString = getValidInputString(scanner,"Enter a String to check : ");
        return task.isStartsWith(enteredString,input);
    }
    private boolean performEndsWith(Scanner scanner,StringTask task) throws CustomStringException {
        System.out.println("===== Checking if the string ends with the original string =====");
        String input = getValidInputString(scanner,"Enter original String : ");
        String enteredString = getValidInputString(scanner,"Enter a String to check : ");
        return task.isEndsWith(enteredString,input);
    }
    private String performConvertToUpperCase(Scanner scanner,StringTask task) throws CustomStringException {
        System.out.println("=== UPPERCASE ===");
        String input = getValidInputString(scanner,"Enter a String : ");
        return task.getUpperCaseString(input);
    }
    private String performConvertToLowerCase(Scanner scanner,StringTask task) throws CustomStringException {
        System.out.println("=== LOWERCASE ===");
        String input = getValidInputString(scanner,"Enter a String : ");
        return task.getLowerCaseString(input);
    }
    private String displayReversedString(Scanner scanner,StringTask task) throws CustomStringException {
        System.out.println("=== Reversing a String ===");
        String input = getValidInputString(scanner,"Enter a String : ");
        return task.getReversedString(input);
    }
    private String displayLineWithMultipleStrings(Scanner scanner,StringTask task){
    	String input = getValidInputString(scanner,"Enter multiple strings in a line : ");
    	return input;
    }  
    private String displayStringAfterRemovingSpaces(Scanner scanner,StringTask task) throws CustomStringException {
        System.out.println("=== Removing Spaces ====");
        String spacedString = getValidInputString(scanner,"Enter a string with spaces : ");
        return task.removeSpaces(spacedString);
    }
    private String performConvertToStringArray(Scanner scanner,StringTask task) throws CustomStringException {
        System.out.println("=== Converting string into string array using a seperator ===");
        String multiString= getValidInputString(scanner,"Enter a String : ");
        String seperator = getValidInputString(scanner,"Enter seperator : ");
        return Arrays.toString(task.convertToStringArray(seperator,multiString));
    }
    private boolean performCompareStringsWithCase(Scanner scanner,StringTask task) throws CustomStringException {
        System.out.println("Comparing two strings whether it is equal or not (With case)");
        String mainString = getValidInputString(scanner,"Enter String 1 : ");
        String compareString = getValidInputString(scanner,"Enter String 2 : ");
        return task.areStringsEqualWithCase(mainString,compareString);
     }   
    private boolean performCompareStringsWithoutCase(Scanner scanner,StringTask task) throws CustomStringException {
    	System.out.println("Comparing two strings whether it is equal or not (Without case)");
    	String mainString = getValidInputString(scanner,"Enter String 1 : ");
        String compareString = getValidInputString(scanner,"Enter String 2 : ");
        return task.areStringsEqualWithoutCase(mainString,compareString);
    }
    private String performRemovingExtraSpaces(Scanner scanner,StringTask task) throws CustomStringException {
        System.out.println("====== Removing extra spaces in the beginning and end ======");
        String stringWithSpace = getValidInputString(scanner,"Enter a string which has spaces in the beginning and ending :");
        return task.trimSpacesAtBeginAndEnd(stringWithSpace);
    }
    private String displayMergedStrings(Scanner scanner,StringTask task) throws CustomStringException {
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
    }
    public static String getValidInputString(Scanner scanner,String prompt) {
        String str;
        System.out.print(prompt);
        str = scanner.nextLine();
        return str;
    }
    public static int getValidIntegerInput(Scanner scanner, String prompt) {
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
