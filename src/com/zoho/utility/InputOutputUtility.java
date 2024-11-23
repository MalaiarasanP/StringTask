package com.zoho.utility;
import com.zoho.customexception.*;
import java.util.*;
public class InputOutputUtility {
    public static int getValidIntegerInput(Scanner scanner, String prompt) throws UtilityValidationException {
        StringSequenceUtility.validateNonNull(prompt);
        validateNonNull(scanner);
        int input=0;
        boolean validInput = false;
        while (!validInput) {
            System.out.print(prompt);
            try {
                input = scanner.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            } finally {
                scanner.nextLine();
            }
        }
        return input;
    }
    public static String getValidInputString(Scanner scanner,String prompt) throws UtilityValidationException {
        validateNonNull(scanner);
        StringSequenceUtility.validateNonNull(prompt);
        System.out.print(prompt);
        String str = scanner.nextLine();
        return str;
    }
    public static void validateNonNull(Scanner scanner) throws UtilityValidationException {
        if (scanner == null) {
            throw new UtilityValidationException("Null scanner");
        }
    }
    public static List<String> getStringList(Scanner scanner) throws UtilityValidationException {
    	validateNonNull(scanner);
        ArrayList<String> strings = new ArrayList<>();
        boolean exit = false;
        int n=1;
        System.out.println("Enter the strings you want to append to the StringBuilder.");
        System.out.println("Press Enter on an empty line to finish.");
        while(!exit) {
            System.out.print("String "+n+ " : ");
            String toMerge= scanner.nextLine();
            if (toMerge.isEmpty()) {
                exit = true;
            } else {
                strings.add(toMerge);
                n++;
            }
        }
        return strings;
    }
}
