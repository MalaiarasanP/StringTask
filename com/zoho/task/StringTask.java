package com.zoho.task;
import java.util.*;
import com.zoho.customtaskexception.*;
import com.zoho.stringtaskutility.*;
import java.util.regex.Pattern;
public class StringTask{
	public int getLength(String str) throws CustomTaskException{
		StringTaskUtility.isNullString(str);
		return str.length();
		}
	public char[] convertToArr(String str) throws CustomTaskException{
		StringTaskUtility.isNullString(str);
		return str.toCharArray();
		}
	public char getCharacterAt(String str,int index) throws CustomTaskException{
		StringTaskUtility.isInvalidString(str);
		StringTaskUtility.isNegativeNumber(index);
		StringTaskUtility.isOutOfRangeIndex(index,str);
		return str.charAt(index);
		}
	public int getNoOfOccurences(char character,String str) throws CustomTaskException{
		StringTaskUtility.isInvalidString(str);
		int noOfOcc=0;
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)==character)
				noOfOcc++;
				}
		return noOfOcc;
	}
	public int getGreatestPosition(char character,String str) throws CustomTaskException{
		StringTaskUtility.isNullString(str);
		return  str.lastIndexOf(character);
		}
	public String getLastFewCharacters(int noOfChar,String str) throws CustomTaskException{
		StringTaskUtility.isInvalidString(str);
		StringTaskUtility.isNegativeNumber(noOfChar);
		StringTaskUtility.exceedsMaxNoOfChar(noOfChar,str);
		return str.substring(str.length() - noOfChar);
	}
	public String getFirstFewCharacters(int noOfChar,String str) throws CustomTaskException{
		StringTaskUtility.isInvalidString(str);
		StringTaskUtility.isNegativeNumber(noOfChar);
		StringTaskUtility.exceedsMaxNoOfChar(noOfChar,str);
		return str.substring(0, noOfChar);
			}
   	public String toReplacePrefix(String originalString,String replacementString,int size) throws CustomTaskException{
   			StringTaskUtility.isInvalidString(originalString);
			StringTaskUtility.isInvalidString(replacementString);
			StringTaskUtility.isNegativeNumber(size);
			StringTaskUtility.exceedsMaxNoOfChar(size,originalString);
   			String result = replacementString + originalString.substring(size);
   			return result;
   		}
   	public String toReplaceSuffix(String originalString,String replacementString,int size) throws CustomTaskException{
   			StringTaskUtility.isInvalidString(originalString);
			StringTaskUtility.isInvalidString(replacementString);
			StringTaskUtility.isNegativeNumber(size);
			StringTaskUtility.exceedsMaxNoOfChar(size,originalString);
   			String result =originalString.substring(0,originalString.length()-size)+replacementString;
   			return result;
   		}
   	public String toReplaceFromSpecificIndex(String originalString,String replacementString,int size,int index) throws CustomTaskException{
   			StringTaskUtility.isInvalidString(originalString);
			StringTaskUtility.isInvalidString(replacementString);
			StringTaskUtility.isNegativeNumber(size);
			StringTaskUtility.isNegativeNumber(index);
			StringTaskUtility.isOutOfRangeIndex(index,originalString);
			StringTaskUtility.exceedsMaxNoOfChar(size,originalString);
   			StringTaskUtility.isOutOfRangeIndex(index+size,originalString);	
   			String result=originalString.substring(0,index) + replacementString + originalString.substring(index+size);
   			return result;
   		}
   		
   				
	public boolean endWith(String ends,String str) throws CustomTaskException{
		StringTaskUtility.isNullString(str);
		StringTaskUtility.isNullString(ends);
		return str.endsWith(ends)? true:false;
		}
	public boolean startWith(String starts,String str) throws CustomTaskException{
		StringTaskUtility.isNullString(str);
		StringTaskUtility.isNullString(starts);
		return str.startsWith(starts)? true:false;
		}
	public String convertToUpperCase(String str) throws CustomTaskException{
		StringTaskUtility.isNullString(str);
		return str.toUpperCase();
		}
	public String convertToLowerCase(String str) throws CustomTaskException{
		StringTaskUtility.isNullString(str);
		return str.toLowerCase();
		}
	public String toReverse(String str) throws CustomTaskException{
		StringTaskUtility.isInvalidString(str);
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
	public String toRemoveSpaces(String str) throws CustomTaskException{
		StringTaskUtility.isNullString(str);
		return str.replace(" ", "");
		}
	public String[] convertToStringArr(String seperator,String str) throws CustomTaskException{
		StringTaskUtility.isNullString(str);
		StringTaskUtility.isNullString(seperator);
		String regexSeperator=Pattern.quote(seperator);
		return  str.split(regexSeperator);
		}
	public boolean compareStringIncludeCase(String firstString,String secondString) throws CustomTaskException{
		StringTaskUtility.isNullString(firstString);
		StringTaskUtility.isNullString(secondString);
		return firstString.equals(secondString);
		}
	public boolean compareStringExcludeCase(String firstString,String secondString) throws CustomTaskException{
		StringTaskUtility.isNullString(firstString);
		StringTaskUtility.isNullString(secondString);
		return firstString.equalsIgnoreCase(secondString);
		}
	public String trimSpacesAtBeginAndEnd(String str) throws CustomTaskException{
		StringTaskUtility.isNullString(str);
		return str.trim();
		}
	public String toMergeStrings(List<String> stringList,String mergingChar) throws CustomTaskException{
		StringTaskUtility.isNullString(mergingChar);
		boolean invalidList=StringTaskUtility.isInvalidList(stringList);
		if(invalidList){
			throw new CustomTaskException("Invalid list");
			}
		return String.join(mergingChar, stringList);
	}
		

}
