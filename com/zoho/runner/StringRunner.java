package com.zoho.runner;
import java.util.*;
import java.io.*;
import com.zoho.task.*;
import com.zoho.customexception.customstringexception.*;

public class StringRunner {
    public static void main(String[] args) {
        System.out.println("=========== String Tasks =============");
        System.out.print("1.Length of the String\n2.Convert String into char array\n3.Displaying a character of a string\n4.No. of occurence of character\n5.Greatest position of a character\n6.Displaying last Few characters of a string\n7.Displaying first few characters of a string\n8.Replacing characters in a string\n9.check whether the string starts with the original string \n10.check whether the string ends with the original string\n11.UPPERCASE\n12.lowercase\n13.Reverse a string\n14.Multiple words in a single line\n15.Convert a string into string array using a seperator\n16.Comparing strings\n17.Removing extra spaces in the beginning and the end\n18.Merging strings with a character in between\n19.Retrieve a String from command line arguments\n20.Exit\n");

        System.out.println("======================================");
        boolean exit;
        int selectOperation=0;
        String input="";
        Scanner scanner = new Scanner(System.in);
        try {
            do {
                exit = false;
                if(!(0<selectOperation&&selectOperation<21)) {
                    selectOperation=getValidIntegerInput(scanner,"Select an operation : ");
                    if(!(0<selectOperation&&selectOperation<21)) {
                        System.out.println("Please enter a number between (1-20)");
                        continue;
                    }
                }

                try {
                    switch(selectOperation) {
                    case 1: {
                        displayStringLength(scanner);
                        break;
                    }
                    case 2: {
                        displayStringToCharArrayConversion(scanner);
                        break;
                    }
                    case 3: {
                        displayCharacterOfString(scanner);
                        break;
                    }
                    case 4: {
                        displayNoOfOccurences(scanner);
                        break;
                    }
                    case 5: {
                        displayGreatestPositionOfCharacter(scanner);
                        break;
                    }
                    case 6: {
                        displayLastFewCharacters(scanner);
                        break;
                    }
                    case 7: {
                        displayFirstFewCharacters(scanner);
                        break;
                    }
                    case 8: {
                        displayReplacedString(scanner);
                        break;
                    }
                    case 9: {
                        performStartsWith(scanner);
                        break;
                    }
                    case 10: {
                        performEndsWith(scanner);
                        break;
                    }
                    case 11: {
                        performConvertToUpperCase(scanner);
                        break;
                    }
                    case 12: {
                        performConvertToLowerCase(scanner);
                        break;
                    }
                    case 13: {
                        displayReversedString(scanner);
                        break;
                    }
                    case 14: {
                        displayStringAfterRemovingSpaces(scanner);
                        break;
                    }
                    case 15: {
                        performConvertToStringArray(scanner);
                        break;
                    }
                    case 16: {
                        performComparingStrings(scanner);
                        break;
                    }
                    case 17: {
                        performRemovingExtraSpaces(scanner);
                        break;
                    }
                    case 18: {
                        displayMergedStrings(scanner);
                        break;
                    }
                    case 19: {
                        displayRetrievedString(args);
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
    private static void displayStringLength(Scanner scanner) throws CustomStringException {
        System.out.println("=== String length ===");
        String input = getValidInputString(scanner, "Enter a String : ");
        System.out.println("Length of the entered String : " + StringTask.getLength(input));
    }
    private static void displayStringToCharArrayConversion(Scanner scanner)throws CustomStringException {
        System.out.println("=== String -> Character Array ===");
        String input = getValidInputString(scanner,"Enter a String : ");
        System.out.println("Converting String into char Array : "+ Arrays.toString(StringTask.convertStringToCharArray(input)));
    }
    private static void displayCharacterOfString(Scanner scanner) throws CustomStringException {
        System.out.println("=== Character of a string ===");
        String input = getValidInputString(scanner,"Enter a String : ");
        int indexNo = getValidIntegerInput(scanner,"Enter index Number : ");
        System.out.println(indexNo + " Character of the String : "+ StringTask.getCharacterAt(input,indexNo));
    }
    private static void displayNoOfOccurences(Scanner scanner) throws CustomStringException {
        System.out.println("=== No. of occurence ===");
        String input = getValidInputString(scanner,"Enter a String : ");
        System.out.print("Enter a char to check its no. of occurrences : ");
        char character = scanner.next().charAt(0);
        System.out.println("No of occurence of the entered character :"+ StringTask.getNoOfOccurences(character,input));
    }
    private static void displayGreatestPositionOfCharacter(Scanner scanner)throws CustomStringException {
        System.out.println("=== Greatest position of a Character ===");
        String input = getValidInputString(scanner,"Enter a String : ");
        System.out.print("Enter a char to find its greatest position : ");
        char character = scanner.next().charAt(0);
        if(StringTask.getGreatestPosition(character,input)==-1) {
            System.out.println("The entered character is not present in the string");
        } else {
            System.out.println("Greatest position of the entered character :"+ StringTask.getGreatestPosition(character,input));
        }
    }
    private static void displayLastFewCharacters(Scanner scanner) throws CustomStringException {
        System.out.println("=== Displaying last few characters ===");
        String input = getValidInputString(scanner,"Enter a String : ");
        int noOfLastFewChar = getValidIntegerInput(scanner,"Enter the No. of characters to be displayed :");
        String lastFewChar = StringTask.getLastFewCharacters(noOfLastFewChar,input);
        System.out.println("Last " + noOfLastFewChar+" characters of the given string : "+ lastFewChar);
    }
    private static void displayFirstFewCharacters(Scanner scanner) throws CustomStringException {
        System.out.println("=== Displaying first few characters ===");
        String input = getValidInputString(scanner,"Enter a String : ");
        int noOfFirstFewChar= getValidIntegerInput(scanner,"Enter the No. of characters to be displayed :");
        String firstFewChar = StringTask.getFirstFewCharacters(noOfFirstFewChar,input);
        System.out.println("First "+noOfFirstFewChar+" characters of the given string :"+ firstFewChar);
    }
    private static void displayReplacedString(Scanner scanner) throws CustomStringException {
        String modifiedString ="";
        System.out.println("=== Replacing Strings !! ===");
        String input = getValidInputString(scanner,"Enter original String : ");
        String replacement = getValidInputString(scanner,"Enter replacement String : ");
        int size= getValidIntegerInput(scanner,"No. of characters to replace in the original string : ");
        System.out.println("Where to Replace\n1.Prefix\n2.Suffix\n3.From Specific Index");
        int type = getValidIntegerInput(scanner,"Select a number :");
        switch(type) {
        case 1: {
            modifiedString = StringTask.replacePrefix(input,replacement,size);
            break;
        }
        case 2: {
            modifiedString = StringTask.replaceSuffix(input,replacement,size);
            break;
        }
        case 3: {
            int indexNo = getValidIntegerInput(scanner,"Enter index no. : ");
            modifiedString = StringTask.replaceFromIndex(input,replacement,size,indexNo);
            break;
        }
        default: {
            throw new CustomStringException("Select a proper option");
        }
        }
        System.out.println("ModifiedString : "+ modifiedString);
    }
    private static void performStartsWith(Scanner scanner) throws CustomStringException {
        System.out.println("===== Checking if the string starts with the original string =====");
        String input = getValidInputString(scanner,"Enter a String : ");
        String enteredString = getValidInputString(scanner,"Enter a String to check : ");
        System.out.println("Entered string starts with the original string - "+ StringTask.isStartsWith(enteredString,input));
    }
    private static void performEndsWith(Scanner scanner) throws CustomStringException {
        System.out.println("===== Checking if the string ends with the original string =====");
        String input = getValidInputString(scanner,"Enter original String : ");
        String enteredString = getValidInputString(scanner,"Enter a String to check : ");
        System.out.println("Entered string ends with the original string"+ StringTask.isEndsWith(enteredString,input));
    }
    private static void performConvertToUpperCase(Scanner scanner) throws CustomStringException {
        System.out.println("=== UPPERCASE ===");
        String input = getValidInputString(scanner,"Enter a String : ");
        System.out.println("UPPERCASE : "+ StringTask.getUpperCaseString(input));
    }
    private static void performConvertToLowerCase(Scanner scanner) throws CustomStringException {
        System.out.println("=== LOWERCASE ===");
        String input = getValidInputString(scanner,"Enter a String : ");
        System.out.println("lowercase : "+ StringTask.getLowerCaseString(input));
    }
    private static void displayReversedString(Scanner scanner) throws CustomStringException {
        System.out.println("=== Reversing a String ===");
        String input = getValidInputString(scanner,"Enter a String : ");
        System.out.println("Reversed String : "+ StringTask.getReversedString(input));
    }
    private static void displayStringAfterRemovingSpaces(Scanner scanner) throws CustomStringException {
        System.out.println("=== Removing Spaces ====");
        String spacedString = getValidInputString(scanner,"Enter a string with spaces : ");
        System.out.println("strings with spaces in a single line after removing spaces : "+ StringTask.removeSpaces(spacedString));
    }
    private static void performConvertToStringArray(Scanner scanner) throws CustomStringException {
        System.out.println("=== Converting string into string array using a seperator ===");
        String multiString= getValidInputString(scanner,"Enter a String : ");
        String seperator = getValidInputString(scanner,"Enter seperator : ");
        System.out.println("spaced strings to String arr : "+ Arrays.toString(StringTask.convertToStringArray(seperator,multiString)));
    }
    private static void performComparingStrings(Scanner scanner) throws CustomStringException {
        System.out.println("Comparing two strings whether it is equal or not");
        String mainString = getValidInputString(scanner,"Enter String 1 : ");
        String compareString = getValidInputString(scanner,"Enter String 2 : ");
        System.out.println("String1 is equal to String2 (case sensitive) - "+ StringTask.areStringsEqualWithCase(mainString,compareString));
        System.out.println("String1 is equal to String2 (ignore case) - "+ StringTask.areStringsEqualWithoutCase(mainString,compareString));
    }
    private static void performRemovingExtraSpaces(Scanner scanner) throws CustomStringException {
        System.out.println("====== Removing extra spaces in the beginning and end ======");
        String stringWithSpace = getValidInputString(scanner,"Enter a string which has spaces in the beginning and ending :");
        System.out.println("String after removing extra spaces :" + StringTask.trimSpacesAtBeginAndEnd(stringWithSpace));
    }
    private static void displayMergedStrings(Scanner scanner) throws CustomStringException {
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
        System.out.println("Merged Strings with a character inbetween : "+ StringTask.mergeStrings(multipleStrings,mergingChar));
    }
    private static void displayRetrievedString(String[] args) throws CustomStringException {
        System.out.println("=== Retrieve a string from command line arguments ===");
        if(args.length>0) {
            System.out.println("You entered : "+ args[0]);
        } else {
            System.out.println("No input was provided\n");
        }
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
