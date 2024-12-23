package com.zoho.stringbuilder.stringbuildertask;
import com.zoho.utility.*;
import java.util.*;
import com.zoho.customexception.*;
public class StringBuilderTask {
    public StringBuilder createStringBuilder() {
        return new StringBuilder();
    }
    public StringBuilder createStringBuilder(List<String> inputs,String seperator) throws CustomException {
        StringBuilder stringBuilder = new StringBuilder();
        return appendInput(stringBuilder,inputs,seperator);
    }
    public StringBuilder appendInput(StringBuilder stringBuilder,List<String> inputs,String seperator) throws CustomException {
        StringSequenceUtility.validateNonNull(stringBuilder,seperator);
        StringSequenceUtility.validateSequenceList(inputs);
        int listSize = inputs.size();
        for(int i=0; i<listSize; i++) {
            stringBuilder.append(inputs.get(i));
            if(!seperator.isEmpty() && i<listSize-1) {
                stringBuilder.append(seperator);
            }
        }
        return stringBuilder;
    }
    public StringBuilder insertStringAfterIndex(StringBuilder stringBuilder,List<String> inputs,String separator,CharSequence insertInput,int index) throws CustomException {
        StringSequenceUtility.validateNonNull(insertInput,stringBuilder,separator);
        StringSequenceUtility.checkOutOfRangeIndex(index,inputs);
        int position = calculateInsertionPosition(inputs, separator, index);
        return stringBuilder.insert(position,separator+insertInput);

    }
    public StringBuilder deleteStringAtIndex(StringBuilder stringBuilder,List<String> inputs,String separator,int index) throws CustomException {
        StringSequenceUtility.validateNonNull(stringBuilder,separator);
        StringSequenceUtility.checkOutOfRangeIndex(index,inputs);
        int start = calculateStartPosition(inputs, separator, index);
        int end = start + inputs.get(index).length();
        if (index < inputs.size() - 1) {
            end += separator.length();
        }
        return stringBuilder.delete(start, end);
    }
    public StringBuilder replaceSeperator(StringBuilder stringBuilder,String oldSeparator,String newSeparator) throws CustomException {
        StringSequenceUtility.validateNonNull(newSeparator,oldSeparator,stringBuilder);
        int index = stringBuilder.indexOf(oldSeparator);
        while (index != -1) {
            stringBuilder.replace(index, index + oldSeparator.length(), newSeparator);
            index = stringBuilder.indexOf(oldSeparator, index + newSeparator.length());
        }
        return stringBuilder;
    }
    public StringBuilder deleteStringInRange(StringBuilder stringBuilder,int startIndex,int endIndex) throws CustomException {
        StringSequenceUtility.validateIndexRange(startIndex,endIndex,stringBuilder);
        return stringBuilder.delete(startIndex,endIndex);
    }
    public StringBuilder getReversedStringBuilder(StringBuilder stringBuilder) throws CustomException {
        StringSequenceUtility.validateNonNull(stringBuilder);
        return stringBuilder.reverse();
    }
    public StringBuilder replaceStringInRange(StringBuilder stringBuilder,int startIndex,int endIndex,String replacement)throws CustomException {
        StringSequenceUtility.validateNonNull(stringBuilder,replacement);
        StringSequenceUtility.validateIndexRange(startIndex,endIndex,stringBuilder);
        return stringBuilder.replace(startIndex,endIndex,replacement);
    }
    public int findFirstSeperatorIndex(StringBuilder stringBuilder,String seperator) throws CustomException {
        StringSequenceUtility.validateNonNull(stringBuilder,seperator);
        return stringBuilder.indexOf(seperator);
    }
    public int findLastSeperatorIndex(StringBuilder stringBuilder,String seperator) throws CustomException {
        StringSequenceUtility.validateNonNull(stringBuilder,seperator);
        return stringBuilder.lastIndexOf(seperator);
    }
    // Helper method to calculate the insertion position
    private int calculateInsertionPosition(List<String> inputs, String separator, int index) {
        int position = 0;
        for (int i = 0; i <= index; i++) {
            position += inputs.get(i).length();
            if (i < index || index == 0) {
                position += separator.length();
            }
        }
        return position;
    }
    // Helper method to calculate the starting position for deletion
    private int calculateStartPosition(List<String> inputs, String separator, int index) {
        int start = 0;
        for (int i = 0; i < index; i++) {
            start += inputs.get(i).length() + separator.length();
        }
        return start;
    }



}
