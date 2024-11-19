package com.zoho.stringbuilder.stringbuilderrunner;
import com.zoho.stringbuilder.stringbuildertask.*;
import com.zoho.utility.*;
import com.zoho.customexception.*;
import java.util.*;
public class StringBuilderRunner {
    StringBuilderTask builderTask = new StringBuilderTask();
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
        try(Scanner scanner = new Scanner(System.in)) {
            boolean exit;
            StringBuilderRunner builderRunner = new StringBuilderRunner();
            do {
                exit = false;
                try {
                    int selectOperation = StringSequenceUtility.getValidIntegerInput(scanner,"Select an operation : ");
                    switch(selectOperation) {
                    case 1: {
                        builderRunner.buildAndAppendBuilder(scanner);
                        break;
                    }
                    case 2: {
                        builderRunner.buildAndAppendWithSeperator(scanner);
                        break;
                    }
                    case 3: {
                        builderRunner.buildAndInsertStringBuilder(scanner);
                        break;
                    }
                    case 4: {
                        builderRunner.buildAndDeleteStringBuilder(scanner);
                        break;
                    }
                    case 5: {
                        builderRunner.buildAndReplaceDelimiter(scanner);
                        break;
                    }
                    case 6: {
                        builderRunner.buildAndReverseStringBuilder(scanner);
                        break;
                    }
                    case 7: {
                        builderRunner.buildAndDeleteStringInRange(scanner);
                        break;
                    }
                    case 8: {
                        builderRunner.buildAndReplaceCharactersInStringBuilder(scanner);
                        break;
                    }
                    case 9: {
                        builderRunner.buildAndFindFirstIndexOfStringBuilder(scanner);
                        break;
                    }
                    case 10: {
                        builderRunner.buildAndFindLastIndexOfStringBuilder(scanner);
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
    public void buildAndAppendBuilder(Scanner scanner) throws CustomException {
        try {
            StringBuilder stringBuilder = builderTask.createStringBuilder();
            System.out.println("Empty StringBuilder is created successfully.");
            getLength(stringBuilder);
            System.out.println("Initial String : "+stringBuilder.toString());
            System.out.println("== Append strings to the StringBuilder ==");
            stringBuilder = createStringBuilder(scanner);
            getLength(stringBuilder);
            System.out.println("Final String : "+stringBuilder.toString());
        } catch(Exception exception) {
            throw new StringBuilderException("Exception occurs",exception);
        }
    }
    public void buildAndAppendWithSeperator(Scanner scanner) throws CustomException {
        try {
            StringBuilder stringBuilder = createStringBuilder(scanner);
            getLength(stringBuilder);
            System.out.println("Initial String : "+stringBuilder.toString());
            stringBuilder = appendInputWithSeperator(scanner,stringBuilder);
            getLength(stringBuilder);
            System.out.println("Final String : "+stringBuilder.toString());
        } catch(Exception exception) {
            throw new StringBuilderException("Exception occurs",exception);
        }
    }
    public void buildAndInsertStringBuilder(Scanner scanner) throws CustomException {
        try {
            System.out.println("=== Creating a stringBuilder with strings with a seperator inbetween ===");
            List<String> strings = getStringList(scanner);
            String seperator = StringSequenceUtility.getValidInputString(scanner,"Enter seperator :");
            StringBuilder stringBuilder = buildAndAppendInputWithSeperator(scanner,strings,seperator);
            getLength(stringBuilder);
            System.out.println("Initial String : "+stringBuilder.toString());
            int position = StringSequenceUtility.getValidIntegerInput(scanner,"Enter the index no. to insert :");
            String insertInput = StringSequenceUtility.getValidInputString(scanner,"Enter the string to insert :");
            stringBuilder = builderTask.insertStringAfterIndex(stringBuilder,strings,seperator,insertInput,position);
            getLength(stringBuilder);
            System.out.println("Final String : "+stringBuilder.toString());
        } catch(Exception exception) {
            throw new StringBuilderException("Exception occurs",exception);
        }
    }
    public void buildAndDeleteStringBuilder(Scanner scanner) throws CustomException {
        try {
            System.out.println("=== Creating a stringBuilder of strings with a seperator inbetween ===");
            List<String> strings = getStringList(scanner);
            String seperator = StringSequenceUtility.getValidInputString(scanner,"Enter seperator :");
            StringBuilder stringBuilder = buildAndAppendInputWithSeperator(scanner,strings,seperator);
            getLength(stringBuilder);
            System.out.println("Initial String : "+stringBuilder.toString());
            int position = StringSequenceUtility.getValidIntegerInput(scanner,"Enter the index no. to delete that string :");
            stringBuilder = builderTask.deleteStringAtIndex(stringBuilder,strings,seperator,position);
            getLength(stringBuilder);
            System.out.println("Final String : "+stringBuilder.toString());
        } catch(Exception exception) {
            throw new StringBuilderException("Exception occurs",exception);
        }
    }
    public void buildAndReplaceDelimiter(Scanner scanner) throws CustomException {
        try {
            System.out.println("=== Creating a stringBuilder of strings with a seperator inbetween ===");
            List<String> strings = getStringList(scanner);
            String oldSeperator = StringSequenceUtility.getValidInputString(scanner,"Enter seperator :");
            StringBuilder stringBuilder = buildAndAppendInputWithSeperator(scanner,strings,oldSeperator);
            getLength(stringBuilder);
            System.out.println("Initial String : "+stringBuilder.toString());
            String newSeperator = StringSequenceUtility.getValidInputString(scanner,"Enter new seperator to replace the old one :");
            stringBuilder = builderTask.replaceSeperator(stringBuilder,oldSeperator,newSeperator);
            getLength(stringBuilder);
            System.out.println("Final String : "+stringBuilder.toString());
        } catch(Exception exception) {
            throw new StringBuilderException("Exception occurs",exception);
        }
    }
    public void buildAndDeleteStringInRange(Scanner scanner) throws CustomException {
        try {
            StringBuilder stringBuilder = createStringBuilder(scanner);
            getLength(stringBuilder);
            System.out.println("Initial String : "+stringBuilder.toString());
            int startIndex = StringSequenceUtility.getValidIntegerInput(scanner,"Enter start index of the range to delete:");
            int endIndex = StringSequenceUtility.getValidIntegerInput(scanner,"Enter end index of the range to delete :");
            stringBuilder= builderTask.deleteStringInRange(stringBuilder,startIndex,endIndex);
            getLength(stringBuilder);
            System.out.println("Final String : "+stringBuilder.toString());
        } catch(Exception exception) {
            throw new StringBuilderException("Exception occurs",exception);
        }

    }
    public void buildAndReverseStringBuilder(Scanner scanner) throws CustomException {
        try {
            System.out.println("=== Creating a stringBuilder of strings with a seperator inbetween ===");
            List<String> strings = getStringList(scanner);
            String seperator = StringSequenceUtility.getValidInputString(scanner,"Enter seperator :");
            StringBuilder stringBuilder = buildAndAppendInputWithSeperator(scanner,strings,seperator);
            getLength(stringBuilder);
            System.out.println("Initial String : "+stringBuilder.toString());
            stringBuilder = builderTask.getReversedStringBuilder(stringBuilder);
            getLength(stringBuilder);
            System.out.println("Final String : "+stringBuilder.toString());
        } catch(Exception exception) {
            throw new StringBuilderException("Exception occurs",exception);
        }
    }
    public void buildAndReplaceCharactersInStringBuilder(Scanner scanner) throws CustomException {
        try {
            StringBuilder stringBuilder = createStringBuilder(scanner);
            getLength(stringBuilder);
            System.out.println("Initial String : "+stringBuilder.toString());
            String replacementInput = StringSequenceUtility.getValidInputString(scanner,"Enter replacement string :");
            int startIndex = StringSequenceUtility.getValidIntegerInput(scanner,"Enter start index of the range to delete:");
            int endIndex = StringSequenceUtility.getValidIntegerInput(scanner,"Enter end index of the range to delete :");
            stringBuilder = builderTask.replaceStringInRange(stringBuilder,startIndex,endIndex,replacementInput);
            getLength(stringBuilder);
            System.out.println("Final String : "+stringBuilder.toString());
        } catch(Exception exception) {
            throw new StringBuilderException("Exception occurs",exception);
        }
    }
    public void buildAndFindFirstIndexOfStringBuilder(Scanner scanner) throws CustomException {
        try {
            System.out.println("=== Creating a stringBuilder of strings with a seperator inbetween ===");
            List<String> strings = getStringList(scanner);
            String seperator = StringSequenceUtility.getValidInputString(scanner,"Enter seperator :");
            StringBuilder stringBuilder = buildAndAppendInputWithSeperator(scanner,strings,seperator);
            getLength(stringBuilder);
            System.out.println("Initial String : "+stringBuilder.toString());
            String instanceString = StringSequenceUtility.getValidInputString(scanner,"Enter the character to find it's first occurence :");
            System.out.println("Index of the first instance of the entered charcter : "+builderTask.findFirstSeperatorIndex(stringBuilder,instanceString));
        } catch(Exception exception) {
            throw new StringBuilderException("Exception occurs",exception);
        }
    }
    public void buildAndFindLastIndexOfStringBuilder(Scanner scanner) throws CustomException {
        try {
            System.out.println("=== Creating a stringBuilder of strings with a seperator inbetween ===");
            List<String> strings = getStringList(scanner);
            String seperator = StringSequenceUtility.getValidInputString(scanner,"Enter seperator :");
            StringBuilder stringBuilder = buildAndAppendInputWithSeperator(scanner,strings,seperator);
            getLength(stringBuilder);
            System.out.println("Initial String : "+stringBuilder.toString());
            String instanceString = StringSequenceUtility.getValidInputString(scanner,"Enter the character to find it's last occurence :");
            System.out.println("Index of the first instance of the seperator : "+builderTask.findLastSeperatorIndex(stringBuilder,instanceString));
        } catch(Exception exception) {
            throw new StringBuilderException("Exception occurs",exception);
        }
    }

    public StringBuilder appendInputWithSeperator(Scanner scanner,StringBuilder stringBuilder) throws CustomException {
        List<String> strings = getStringList(scanner);
        String seperator = StringSequenceUtility.getValidInputString(scanner,"Enter seperator :");
        return builderTask.appendInputWithSeperator(stringBuilder,strings,seperator);
    }
    public StringBuilder buildAndAppendInputWithSeperator(Scanner scanner,List<? extends CharSequence> input,String seperator) throws CustomException {
        StringBuilder stringBuilder = new StringBuilder();
        return builderTask.appendInputWithSeperator(stringBuilder,input,seperator);
    }
    public StringBuilder buildAndAppendInputWithSeperator(Scanner scanner) throws CustomException {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> strings = getStringList(scanner);
        String seperator = StringSequenceUtility.getValidInputString(scanner,"Enter seperator :");
        return builderTask.appendInputWithSeperator(stringBuilder,strings,seperator);
    }
    public StringBuilder createStringBuilder(Scanner scanner) throws CustomException {
        List<String> strings = getStringList(scanner);
        return builderTask.createStringBuilder(strings);
    }
    public void getLength(StringBuilder stringBuilder) throws CustomException {
        System.out.println("Length of the StringBuilder : "+StringSequenceUtility.getLength(stringBuilder));
    }
    public List<String> getStringList(Scanner scanner) {
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
