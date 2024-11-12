package com.zoho.stringtask;
import java.util.*;
import com.zoho.customstringexception.*;
import com.zoho.stringutility.*;
import java.util.regex.Pattern;
public class StringTask {
    public int getLength(String str) throws CustomStringException {
        StringTaskUtility.checkNullString(str);
        return str.length();
    }
    public char[] convertStringToCharArray(String str) throws CustomStringException {
        StringTaskUtility.checkNullString(str);
        return str.toCharArray();
    }
    public char getCharacterAt(String str,int index) throws CustomStringException {
        StringTaskUtility.checkOutOfRangeIndex(index,str);
        return str.charAt(index);
    }
    public int getNoOfOccurences(char character,String str) throws CustomStringException {
        StringTaskUtility.checkInvalidString(str);
        int noOfOcc=0;
        for(char stringCharacter : str.toCharArray()) {
            if(stringCharacter == character) {
                noOfOcc++;
            }
        }
        return noOfOcc;
    }
    public int getGreatestPosition(char character,String str) throws CustomStringException {
        StringTaskUtility.checkNullString(str);
        return  str.lastIndexOf(character);
    }
    public String getLastFewCharacters(int noOfChar,String str) throws CustomStringException {
        StringTaskUtility.exceedsMaxNoOfChar(noOfChar,str);
        return str.substring(str.length() - noOfChar);
    }
    public String getFirstFewCharacters(int noOfChar,String str) throws CustomStringException {
        StringTaskUtility.exceedsMaxNoOfChar(noOfChar,str);
        return str.substring(0, noOfChar);
    }
    public String replacePrefix(String originalString,String replacementString,int size) throws CustomStringException {
        StringTaskUtility.checkInvalidString(replacementString);
        StringTaskUtility.exceedsMaxNoOfChar(size,originalString);
        String result = replacementString + originalString.substring(size);
        return result;
    }
    public String replaceSuffix(String originalString,String replacementString,int size) throws CustomStringException {
        StringTaskUtility.checkInvalidString(replacementString);
        StringTaskUtility.exceedsMaxNoOfChar(size,originalString);
        String result = originalString.substring(0,originalString.length()-size)+replacementString;
        return result;
    }
    public String replaceFromIndex(String originalString,String replacementString,int size,int index) throws CustomStringException {
        StringTaskUtility.checkInvalidString(replacementString);
        StringTaskUtility.checkOutOfRangeIndex(index+size,originalString);
        String result = originalString.substring(0,index) + replacementString + originalString.substring(index+size);
        return result;
    }


    public boolean isEndsWith(String ends,String str) throws CustomStringException {
        StringTaskUtility.checkNullString(str,ends);
        return str.endsWith(ends);
    }
    public boolean isStartsWith(String starts,String str) throws CustomStringException {
        StringTaskUtility.checkNullString(str,starts);
        return str.startsWith(starts);
    }
    public String getUpperCaseString(String str) throws CustomStringException {
        StringTaskUtility.checkNullString(str);
        return str.toUpperCase();
    }
    public String getLowerCaseString(String str) throws CustomStringException {
        StringTaskUtility.checkNullString(str);
        return str.toLowerCase();
    }
    public String getReversedString(String str) throws CustomStringException {
        StringTaskUtility.checkInvalidString(str);
        char[] charArray = str.toCharArray();
        int left = 0;
        int right = charArray.length - 1;
        while (left < right) {
            charArray[left] = (char) (charArray[left] + charArray[right] - (charArray[right--] = charArray[left++]));
        }
        return new String(charArray);
    }
    public String removeSpaces(String str) throws CustomStringException {
        StringTaskUtility.checkNullString(str);
        return str.replace(" ", "");
    }
    public String[] convertToStringArray(String seperator,String str) throws CustomStringException {
        StringTaskUtility.checkNullString(str,seperator);
        String regexSeperator=Pattern.quote(seperator);
        return  str.split(regexSeperator);
    }
    public boolean areStringsEqualWithCase(String firstString,String secondString) throws CustomStringException {
        StringTaskUtility.checkNullString(firstString,secondString);
        return firstString.equals(secondString);
    }
    public boolean areStringsEqualWithoutCase(String firstString,String secondString) throws CustomStringException {
        StringTaskUtility.checkNullString(firstString,secondString);
        return firstString.equalsIgnoreCase(secondString);
    }
    public String trimSpacesAtBeginAndEnd(String str) throws CustomStringException {
        StringTaskUtility.checkNullString(str);
        return str.trim();
    }
    public String mergeStrings(List<String> stringList,String mergingChar) throws CustomStringException {
        StringTaskUtility.checkNullString(mergingChar);
        StringTaskUtility.validateStringList(stringList);
        return String.join(mergingChar, stringList);
    }


}
