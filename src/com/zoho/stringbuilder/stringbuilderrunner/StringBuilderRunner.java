package com.zoho.stringbuilder.stringbuilderrunner;
import com.zoho.stringbuilder.stringbuildertask.*;
import com.zoho.utility.*;
import com.zoho.customexception.*;
import java.util.*;
public class StringBuilderRunner {
    StringBuilderTask builderTask = new StringBuilderTask();
    private static Scanner scanner;
    private static String emptySeparator = "";
    public static void main(String[] args) {
        System.out.println("\n--- StringBuilder Operations Menu ---");
        System.out.println("1. Create an empty StringBuilder, add a string, and display the results.");
        System.out.println("2. Create a StringBuilder with an initial string and add multiple strings with a separator.");
        System.out.println("3. Insert a string into a StringBuilder between existing strings.");
        System.out.println("4. Delete part of the StringBuilder content.");
        System.out.println("5. Replace old serparator with a new seperator in a StringBuilder.");
        System.out.println("6. Reverse the content of a StringBuilder.");
        System.out.println("7. Delete a specific range of characters from a StringBuilder.");
        System.out.println("8. Replace a specific range of characters in a StringBuilder.");
        System.out.println("9. Find the index of the first occurrence of a specific character in a StringBuilder.");
        System.out.println("10. Find the index of the last occurrence of a specific character in a StringBuilder.");
        System.out.println("11. Exit the program.");
        try(Scanner inputScanner = new Scanner(System.in)) {
            boolean exit;
            scanner=inputScanner;
            StringBuilderRunner builderRunner = new StringBuilderRunner();
            do {
                exit = false;
                try {
                    int selectOperation = InputOutputUtility.getValidIntegerInput(scanner,"Select an operation : ");
                    switch(selectOperation) {
                    case 1: {
                        builderRunner.buildAndAppendBuilder();
                        break;
                    }
                    case 2: {
                        builderRunner.buildAndAppendWithSeperator();
                        break;
                    }
                    case 3: {
                        builderRunner.buildAndInsertStringBuilder();
                        break;
                    }
                    case 4: {
                        builderRunner.buildAndDeleteStringBuilder();
                        break;
                    }
                    case 5: {
                        builderRunner.buildAndReplaceDelimiter();
                        break;
                    }
                    case 6: {
                        builderRunner.buildAndReverseStringBuilder();
                        break;
                    }
                    case 7: {
                         builderRunner.buildAndDeleteStringInRange();
                        break;
                    }
                    case 8: {
                        builderRunner.buildAndReplaceCharactersInStringBuilder();
                        break;
                    }
                    case 9: {
                        builderRunner.buildAndFindFirstIndexOfStringBuilder();
                        break;
                    }
                    case 10: {
                        builderRunner.buildAndFindLastIndexOfStringBuilder();
                        break;
                    }
                    case 11: {
                        exit = true;
                        break;
                    }
                    default : {
                        System.out.println("Please enter a number between (1-10)");
                    }
                    }
                } catch(CustomException exception) {
                    exception.printStackTrace();
                }
            } while(!exit);
        }
    }
    public void buildAndAppendBuilder() throws CustomException {
        try {
            System.out.println("=== Task 1: Create an empty StringBuilder and add a string ===");
            StringBuilder stringBuilder = builderTask.createStringBuilder();
            System.out.println("Empty StringBuilder is created successfully.");
            displayLength(stringBuilder);
            System.out.println("Initial String : "+stringBuilder.toString());
            System.out.println("== Append strings to the StringBuilder ==");
            List<String> strings = InputOutputUtility.getStringList(scanner);
            builderTask.appendInput(stringBuilder,strings,emptySeparator);
            displayLength(stringBuilder);
            System.out.println("Final String : "+stringBuilder.toString());
        } catch(Exception exception) {
            throw new StringBuilderException("Exception occurs",exception);
        }
    }
    public void buildAndAppendWithSeperator() throws CustomException {
        try {
            System.out.println("=== Task 2: Create a StringBuilder, add strings with a separator ===");
            List<String> strings = InputOutputUtility.getStringList(scanner);
            StringBuilder stringBuilder = builderTask.createStringBuilder(strings,emptySeparator);
            displayLength(stringBuilder);
            System.out.println("Initial String : "+stringBuilder.toString());
            String seperator = InputOutputUtility.getValidInputString(scanner,"Enter seperator :");
            builderTask.appendInput(stringBuilder,strings,seperator);
            displayLength(stringBuilder);
            System.out.println("Final String : "+stringBuilder.toString());
        } catch(Exception exception) {
            throw new StringBuilderException("Exception occurs",exception);
        }
    }
    public void buildAndInsertStringBuilder() throws CustomException {
        try {
            System.out.println("=== Task 3: Create a StringBuilder with strings and insert another string in between === ");
            List<String> strings = InputOutputUtility.getStringList(scanner);
            String separator = InputOutputUtility.getValidInputString(scanner,"Enter seperator :");
            StringBuilder stringBuilder = builderTask.createStringBuilder(strings,separator);
            displayLength(stringBuilder);
            System.out.println("Initial String : "+stringBuilder.toString());
            int position = InputOutputUtility.getValidIntegerInput(scanner,"Enter the index no. to insert :");
            String insertInput = InputOutputUtility.getValidInputString(scanner,"Enter the string to insert :");
            builderTask.insertStringAfterIndex(stringBuilder,strings,separator,insertInput,position);
            displayLength(stringBuilder);
            System.out.println("Final String : "+stringBuilder.toString());
        } catch(Exception exception) {
            throw new StringBuilderException("Exception occurs",exception);
        }
    }
    public void buildAndDeleteStringBuilder() throws CustomException {
        try {
            System.out.println("=== Task 4: Create a StringBuilder with strings and delete a selected string ===");
            List<String> strings = InputOutputUtility.getStringList(scanner);
            String separator = InputOutputUtility.getValidInputString(scanner,"Enter seperator :");
            StringBuilder stringBuilder = builderTask.createStringBuilder(strings,separator);
            displayLength(stringBuilder);
            System.out.println("Initial String : "+stringBuilder.toString());
            int position = InputOutputUtility.getValidIntegerInput(scanner,"Enter the index no. to delete that string :");
            builderTask.deleteStringAtIndex(stringBuilder,strings,separator,position);
            displayLength(stringBuilder);
            System.out.println("Final String : "+stringBuilder.toString());
        } catch(Exception exception) {
            throw new StringBuilderException("Exception occurs",exception);
        }
    }
    public void buildAndReplaceDelimiter() throws CustomException {
        try {
            System.out.println("=== Task 5: Create a StringBuilder with strings separated by a separator and replace old seperator with 'new seperator === ");
            List<String> strings = InputOutputUtility.getStringList(scanner);
            String oldSeparator = InputOutputUtility.getValidInputString(scanner,"Enter seperator :");
            StringBuilder stringBuilder = builderTask.createStringBuilder(strings,oldSeparator);
            displayLength(stringBuilder);
            System.out.println("Initial String : "+stringBuilder.toString());
            String newSeparator = InputOutputUtility.getValidInputString(scanner,"Enter new seperator to replace the old one :");
            builderTask.replaceSeperator(stringBuilder,oldSeparator,newSeparator);
            displayLength(stringBuilder);
            System.out.println("Final String : "+stringBuilder.toString());
        } catch(Exception exception) {
            throw new StringBuilderException("Exception occurs",exception);
        }
    }
    public void buildAndDeleteStringInRange() throws CustomException {
        try {
            System.out.println("=== Task 7: Create a StringBuilder and delete characters from index range === ");
            List<String> strings = InputOutputUtility.getStringList(scanner);
            StringBuilder stringBuilder = builderTask.createStringBuilder(strings,emptySeparator);
            displayLength(stringBuilder);
            System.out.println("Initial String : "+stringBuilder.toString());
            int startIndex = InputOutputUtility.getValidIntegerInput(scanner,"Enter start index of the range to delete:");
            int endIndex = InputOutputUtility.getValidIntegerInput(scanner,"Enter end index of the range to delete :");
            builderTask.deleteStringInRange(stringBuilder,startIndex,endIndex);
            displayLength(stringBuilder);
            System.out.println("Final String : "+stringBuilder.toString());
        } catch(Exception exception) {
            throw new StringBuilderException("Exception occurs",exception);
        }

    }
    public void buildAndReverseStringBuilder() throws CustomException {
        try {
            System.out.println("=== Task 6: Create a StringBuilder and reverse the string ===  ");
            List<String> strings = InputOutputUtility.getStringList(scanner);
            String separator = InputOutputUtility.getValidInputString(scanner,"Enter seperator :");
            StringBuilder stringBuilder = builderTask.createStringBuilder(strings,separator);
            displayLength(stringBuilder);
            System.out.println("Initial String : "+stringBuilder.toString());
            builderTask.getReversedStringBuilder(stringBuilder);
            displayLength(stringBuilder);
            System.out.println("Final String : "+stringBuilder.toString());
        } catch(Exception exception) {
            throw new StringBuilderException("Exception occurs",exception);
        }
    }
    public void buildAndReplaceCharactersInStringBuilder() throws CustomException {
        try {
            System.out.println("=== Task 8: Create a StringBuilder and replace characters in index range with a string === ");
            List<String> strings = InputOutputUtility.getStringList(scanner);
            StringBuilder stringBuilder = builderTask.createStringBuilder(strings,emptySeparator);
            displayLength(stringBuilder);
            System.out.println("Initial String : "+stringBuilder.toString());
            String replacementInput = InputOutputUtility.getValidInputString(scanner,"Enter replacement string :");
            int startIndex = InputOutputUtility.getValidIntegerInput(scanner,"Enter start index of the range to delete:");
            int endIndex = InputOutputUtility.getValidIntegerInput(scanner,"Enter end index of the range to delete :");
            builderTask.replaceStringInRange(stringBuilder,startIndex,endIndex,replacementInput);
            displayLength(stringBuilder);
            System.out.println("Final String : "+stringBuilder.toString());
        } catch(Exception exception) {
            throw new StringBuilderException("Exception occurs",exception);
        }
    }
    public void buildAndFindFirstIndexOfStringBuilder() throws CustomException {
        try {
            System.out.println("9: Create a StringBuilder with strings separated by a separator and find the index of the first separator === ");
            List<String> strings = InputOutputUtility.getStringList(scanner);
            String separator = InputOutputUtility.getValidInputString(scanner,"Enter seperator :");
            StringBuilder stringBuilder = builderTask.createStringBuilder(strings,separator);
            displayLength(stringBuilder);
            System.out.println("Initial String : "+stringBuilder.toString());
            String instanceString = InputOutputUtility.getValidInputString(scanner,"Enter character :");
            int index = builderTask.findFirstSeperatorIndex(stringBuilder,instanceString);
            System.out.println("Index of the first instance of the entered charcter : "+ index);
        } catch(Exception exception) {
            throw new StringBuilderException("Exception occurs",exception);
        }
    }
    public void buildAndFindLastIndexOfStringBuilder() throws CustomException {
        try {
            System.out.println("=== Task 10: Create a StringBuilder with strings separated by a seperator and find the index of the last seperator ===  ");
            List<String> strings = InputOutputUtility.getStringList(scanner);
            String separator = InputOutputUtility.getValidInputString(scanner,"Enter seperator :");
            StringBuilder stringBuilder = builderTask.createStringBuilder(strings,separator);
            displayLength(stringBuilder);
            System.out.println("Initial String : "+stringBuilder.toString());
            String instanceString = InputOutputUtility.getValidInputString(scanner,"Enter character:");
            int index = builderTask.findLastSeperatorIndex(stringBuilder,instanceString);
            System.out.println("Index of the first instance of the seperator : "+ index);
        } catch(Exception exception) {
            throw new StringBuilderException("Exception occurs",exception);
        }
    }
    public void displayLength(StringBuilder stringBuilder) throws CustomException {
        System.out.println("Length of the StringBuilder : "+StringSequenceUtility.getLength(stringBuilder));
    }

}
