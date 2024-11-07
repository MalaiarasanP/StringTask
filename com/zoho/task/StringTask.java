package com.zoho.task;
import java.util.*;
import com.zoho.customexception.customstringexception.*;
import com.zoho.utility.*;
import java.util.regex.Pattern;
public abstract class StringTask {
    public static int getLength(String str) throws CustomStringException {
        StringTaskUtility.checkNullString(str);
        return str.length();
    }
    public static char[] convertStringToCharArray(String str) throws CustomStringException {
        StringTaskUtility.checkNullString(str);
        return str.toCharArray();
    }
    public static char getCharacterAt(String str,int index) throws CustomStringException {
        StringTaskUtility.checkOutOfRangeIndex(index,str);
        return str.charAt(index);
    }
    public static int getNoOfOccurences(char character,String str) throws CustomStringException {
        StringTaskUtility.checkInvalidString(str);
        int noOfOcc=0;
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i)==character)
                noOfOcc++;
        }
        return noOfOcc;
    }
    public static int getGreatestPosition(char character,String str) throws CustomStringException {
        StringTaskUtility.checkNullString(str);
        return  str.lastIndexOf(character);
    }
    public static String getLastFewCharacters(int noOfChar,String str) throws CustomStringException {
        StringTaskUtility.exceedsMaxNoOfChar(noOfChar,str);
        return str.substring(str.length() - noOfChar);
    }
    public static String getFirstFewCharacters(int noOfChar,String str) throws CustomStringException {
        StringTaskUtility.exceedsMaxNoOfChar(noOfChar,str);
        return str.substring(0, noOfChar);
    }
    public static String replacePrefix(String originalString,String replacementString,int size) throws CustomStringException {
        StringTaskUtility.checkInvalidString(replacementString);
        StringTaskUtility.exceedsMaxNoOfChar(size,originalString);
        String result = replacementString + originalString.substring(size);
        return result;
    }
    public static String replaceSuffix(String originalString,String replacementString,int size) throws CustomStringException {
        StringTaskUtility.checkInvalidString(replacementString);
        StringTaskUtility.exceedsMaxNoOfChar(size,originalString);
        String result = originalString.substring(0,originalString.length()-size)+replacementString;
        return result;
    }
    public static String replaceFromIndex(String originalString,String replacementString,int size,int index) throws CustomStringException {
        StringTaskUtility.checkInvalidString(replacementString);
        StringTaskUtility.checkOutOfRangeIndex(index+size,originalString);
        String result = originalString.substring(0,index) + replacementString + originalString.substring(index+size);
        return result;
    }


    public static boolean isEndsWith(String ends,String str) throws CustomStringException {
        StringTaskUtility.checkNullString(str,ends);
        return str.endsWith(ends);
    }
    public static boolean isStartsWith(String starts,String str) throws CustomStringException {
        StringTaskUtility.checkNullString(str,starts);
        return str.startsWith(starts);
    }
    public static String getUpperCaseString(String str) throws CustomStringException {
        StringTaskUtility.checkNullString(str);
        return str.toUpperCase();
    }
    public static String getLowerCaseString(String str) throws CustomStringException {
        StringTaskUtility.checkNullString(str);
        return str.toLowerCase();
    }
    public static String getReversedString(String str) throws CustomStringException {
        StringTaskUtility.checkInvalidString(str);
        char[] charArray = str.toCharArray();
        int left = 0;
        int right = charArray.length - 1;
        while (left < right) {
            charArray[left] = (char) (charArray[left] + charArray[right] - (charArray[right] = charArray[left]));
            left++;
            right--;
        }
        return new String(charArray);
    }
    public static String removeSpaces(String str) throws CustomStringException {
        StringTaskUtility.checkNullString(str);
        return str.replace(" ", "");
    }
    public static String[] convertToStringArray(String seperator,String str) throws CustomStringException {
        StringTaskUtility.checkNullString(str,seperator);
        String regexSeperator=Pattern.quote(seperator);
        return  str.split(regexSeperator);
    }
    public static boolean areStringsEqualWithCase(String firstString,String secondString) throws CustomStringException {
        StringTaskUtility.checkNullString(firstString,secondString);
        return firstString.equals(secondString);
    }
    public static boolean areStringsEqualWithoutCase(String firstString,String secondString) throws CustomStringException {
        StringTaskUtility.checkNullString(firstString,secondString);
        return firstString.equalsIgnoreCase(secondString);
    }
    public static String trimSpacesAtBeginAndEnd(String str) throws CustomStringException {
        StringTaskUtility.checkNullString(str);
        return str.trim();
    }
    public static String mergeStrings(List<String> stringList,String mergingChar) throws CustomStringException {
        StringTaskUtility.checkNullString(mergingChar);
        StringTaskUtility.	validateStringList(stringList);
        return String.join(mergingChar, stringList);
    }


}
