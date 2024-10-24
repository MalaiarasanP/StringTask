package com.zoho.runner;
import java.util.*;
import java.io.*;
import com.zoho.task.*;
import com.zoho.customtaskexception.*;

public class StringRunner{
public static void main(String[] args){
	System.out.println("=========== String Tasks =============");
	System.out.print("1.Length of the String\n2.Convert String into char array\n3.Displaying a character of a string\n4.No. of occurence of character\n5.Greatest position of a character\n6.Displaying last Few characters of a string\n7.Displaying first few characters of a string\n8.Replacing characters in a string\n9.check whether the string starts with the original string \n10.check whether the string ends with the original string\n11.UPPERCASE\n12.lowercase\n13.Reverse a string\n14.Multiple words in a single line\n15.Convert a string into string array using a seperator\n16.Comparing strings\n17.Removing extra spaces in the beginning and the end\n18.Merging strings with a character in between\n19.Retrieve a String from command line arguments\n20.Exit\n");
	
	System.out.println("======================================");
	boolean exit;
	int selectOperation=0;
	String input="";
	Scanner scanner = new Scanner(System.in);
	StringTask word = new StringTask();
	try{
	do{
		
		exit = true;
		if(!(0<selectOperation&&selectOperation<21)){
			selectOperation=getValidIntegerInput(scanner,"Select an operation : ");
			if(!(0<selectOperation&&selectOperation<21)){
				System.out.println("Please enter a number between (1-19)");
				continue;
		}
		}
	try{
	switch(selectOperation){
	case 1:{
	System.out.println("=== String length ===");
	input = getValidInputString(scanner,"Enter a String : ");
	System.out.println("Length of the entered String : " + word.getLength(input));
	selectOperation=0;
	break;
	}
	case 2:{
	System.out.println("=== String -> Character Array ===");
	input = getValidInputString(scanner,"Enter a String : ");
	System.out.println("Converting String into char Array : "+ Arrays.toString(word.convertToArr(input)));
	selectOperation=0;
	break;
	}
	case 3:{
	System.out.println("=== Character of a string ===");
	input = getValidInputString(scanner,"Enter a String : ");
	int indexNo = getValidIntegerInput(scanner,"Enter index Number : ");
	System.out.println(indexNo + " Character of the String : "+ word.getCharacterAt(input,indexNo));
	selectOperation=0;
	break;
	}
	case 4:{
	System.out.println("=== No. of occurence ===");
	input = getValidInputString(scanner,"Enter a String : ");
	System.out.print("Enter a char to check its no. of occurrences : ");
	char character1 = scanner.next().charAt(0);
	System.out.println("No of occurence of the entered character :"+ word.getNoOfOccurences(character1,input));
	selectOperation=0;
	break;
	}
	case 5:{
	System.out.println("=== Greatest position of a Character ===");
	input = getValidInputString(scanner,"Enter a String : ");
	System.out.print("Enter a char to find its greatest position : ");
	char character2 = scanner.next().charAt(0);
	if(word.getGreatestPosition(character2,input)==-1){
		System.out.println("The entered character is not present in the string");
		}
	else{
		System.out.println("Greatest position of the entered character :"+ word.getGreatestPosition(character2,input));
	}
	selectOperation=0;
	break;
	}
	case 6:{
	System.out.println("=== Displaying last few characters ===");
	input = getValidInputString(scanner,"Enter a String : ");
	int noOfLastFewChar = getValidIntegerInput(scanner,"Enter the No. of characters to be displayed :");
	String lastFewChar = word.getLastFewCharacters(noOfLastFewChar,input);
	System.out.println("Last " + noOfLastFewChar+" characters of the given string : "+ lastFewChar);
	selectOperation=0;	
	break;
	}
	case 7:{
	System.out.println("=== Displaying first few characters ===");
	input = getValidInputString(scanner,"Enter a String : ");
	int noOfFirstFewChar= getValidIntegerInput(scanner,"Enter the No. of characters to be displayed :");
	String firstFewChar = word.getFirstFewCharacters(noOfFirstFewChar,input);	
	System.out.println("First "+noOfFirstFewChar+" characters of the given string :"+ firstFewChar);
	selectOperation=0;
	break;
	}
	case 8:{
	String modifiedString ="";
	System.out.println("=== Replacing Strings !! ===");
	input = getValidInputString(scanner,"Enter original String : ");
	String replacement = getValidInputString(scanner,"Enter replacement String : ");
	int size= getValidIntegerInput(scanner,"No. of characters to replace in the original string : ");
	System.out.println("Where to Replace\n1.Prefix\n2.Suffix\n3.From Specific Index");
	int type = getValidIntegerInput(scanner,"Select a number :");
	switch(type){
		case 1:{
			modifiedString = word.toReplacePrefix(input,replacement,size);
			break;
		}
		case 2:{
			modifiedString = word.toReplaceSuffix(input,replacement,size);
			break;
		}
		case 3:{
			int indexNo = getValidIntegerInput(scanner,"Enter index no. : ");
			modifiedString = word.toReplaceFromSpecificIndex(input,replacement,size,indexNo);
			break;
		}
		default:{
			throw new CustomTaskException("Select a proper option");
			}
		}
	System.out.println("ModifiedString : "+ modifiedString);
	selectOperation=0;
	break;
	}
	case 9:{
	System.out.println("===== Checking if the string starts with the original string =====");
	input = getValidInputString(scanner,"Enter a String : ");
	String enteredString = getValidInputString(scanner,"Enter a String to check : ");
	System.out.println("Entered string starts with the original string - "+ word.startWith(enteredString,input));
	selectOperation=0;
	break;
		}
	case 10:{
	System.out.println("===== Checking if the string ends with the original string =====");
	input = getValidInputString(scanner,"Enter original String : ");
	String enteredString = getValidInputString(scanner,"Enter a String to check : ");
	System.out.println("Entered string ends with the original string"+ word.endWith(enteredString,input));
	selectOperation=0;
	break;
	}
	case 11:{
	System.out.println("=== UPPERCASE ===");
	input = getValidInputString(scanner,"Enter a String : ");
	System.out.println("UPPERCASE : "+ word.convertToUpperCase(input));
	selectOperation=0;
	break;
	}
	case 12:{
	System.out.println("=== LOWERCASE ===");
	input = getValidInputString(scanner,"Enter a String : ");
	System.out.println("lowercase : "+ word.convertToLowerCase(input));
	selectOperation=0;
	break;
	}
	case 13:{
	System.out.println("=== Reversing a String ===");
	input = getValidInputString(scanner,"Enter a String : ");
	System.out.println("Reversed String : "+ word.toReverse(input));
	selectOperation=0;
	break;
	}
	case 14:{
	System.out.println("=== Removing Spaces ====");
	String spacedString = getValidInputString(scanner,"Enter a string with spaces : ");
	System.out.println("strings with spaces in a single line after removing spaces : "+ word.toRemoveSpaces(spacedString));
	selectOperation=0;
	break;
	}
	case 15:{
	System.out.println("=== Converting string into string array using a seperator ===");
	String multiString= getValidInputString(scanner,"Enter a String : ");
	String seperator = getValidInputString(scanner,"Enter seperator : ");
	System.out.println("spaced strings to String arr : "+ Arrays.toString(word.convertToStringArr(seperator,multiString)));
	selectOperation=0;
	break;
	}
	case 16:{
	System.out.println("Comparing two strings whether it is equal or not");
	String mainString = getValidInputString(scanner,"Enter String 1 : ");
	String compareString = getValidInputString(scanner,"Enter String 2 : ");
	System.out.println("String1 is equal to String2 (case sensitive) - "+ word.compareStringIncludeCase(mainString,compareString));
	System.out.println("String1 is equal to String2 (ignore case) - "+ word.compareStringExcludeCase(mainString,compareString));
	selectOperation=0;
	break;
	}
	case 17:{
	System.out.println("====== Removing extra spaces in the beginning and end ======");
	String stringWithSpace = getValidInputString(scanner,"Enter a string which has spaces in the beginning and ending :");
	System.out.println("String after removing extra spaces :" + word.trimSpacesAtBeginAndEnd(stringWithSpace));
	selectOperation=0;
	break;
	}
	case 18:{
	System.out.println("===Write multiple strings to merge them in a single line seperated by a character===");
	ArrayList<String> multipleStrings = new ArrayList<String>();
	int n=1;
	while(true){
	 	System.out.print("String "+n+ " : ");
	 	String toMerge= scanner.nextLine();
	 	n++;
	 	if (toMerge.isEmpty()){
	 		break;
	 		}
	 	multipleStrings.add(toMerge);
	 	}
	String mergingChar = getValidInputString(scanner,"Enter the character : ");
	System.out.println("Merged Strings with a character inbetween : "+ word.toMergeStrings(multipleStrings,mergingChar));
	selectOperation=0;
	break;
	}
	case 19:{
	System.out.println("=== Retrieve a string from command line arguments ===");
	if(args.length>0){
		System.out.println("You entered : "+ args[0]);
		}
	else{
		System.out.println("No input was provided\n");
		}
	selectOperation=0;
	break;
		}
	default:{
		exit = false;
		System.out.println("==== Exit ====");
	}
	}
	}
	catch(CustomTaskException error){
		System.out.println("Error : "+ error.getMessage());
		System.out.println("Exception : "+ error.getClass().getName());
		Throwable cause = error.getCause();
		if(cause!=null){
			System.out.println("Root cause : "+ cause.getMessage());
			System.out.println("Root cause Exception : "+ cause.getClass().getName());
			}
		
		}
	}while(exit);
	}
	finally{
		scanner.close();
		}
	
	
}
public static String getValidInputString(Scanner scanner,String prompt){
	String str;	
	System.out.print(prompt);
	str = scanner.nextLine();
	return str;
	}
public static int getValidIntegerInput(Scanner scanner, String prompt){
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
