package com.zoho.stringbuilder.stringbuildertask;
import com.zoho.utility.*;
import java.util.*;
import com.zoho.customexception.*;
public class StringBuilderTask {
    public StringBuilder createStringBuilder() {
        return new StringBuilder();
    }
    public StringBuilder createStringBuilder(List<? extends CharSequence> inputs) throws CustomException {
        StringBuilder stringBuilder = new StringBuilder();
        return appendInputToBuilder(stringBuilder,inputs);
    }
    public StringBuilder appendInputToBuilder(StringBuilder stringBuilder,List<? extends CharSequence> appendInputs) throws CustomException {
        StringSequenceUtility.validateNonNull(stringBuilder);
        StringSequenceUtility.validateSequenceList(appendInputs);
        for(CharSequence appendInput : appendInputs) {
            stringBuilder.append(appendInput);
        }
        return stringBuilder;
    }
    public StringBuilder appendInputWithSeperator(StringBuilder stringBuilder,List<? extends CharSequence> appendInputs,String seperator) throws CustomException {
        StringSequenceUtility.validateNonNull(stringBuilder,seperator);
        StringSequenceUtility.validateSequenceList(appendInputs);
        int listSize = appendInputs.size();
        for(int i=0; i<listSize; i++) {
            stringBuilder.append(appendInputs.get(i));
            if(i<listSize-1) {
                stringBuilder.append(seperator);
            }
        }
        return stringBuilder;
    }
    public StringBuilder insertStringAfterIndex(StringBuilder stringBuilder,List<? extends CharSequence> appendInputs,String seperator,CharSequence insertInput,int index) throws CustomException {
        StringSequenceUtility.validateNonNull(insertInput,stringBuilder,seperator);
        StringSequenceUtility.checkOutOfRangeIndex(index,appendInputs);
        int position = 0;
        for (int i = 0; i <= index; i++) {
            position += appendInputs.get(i).length();
            if (i < index || index == 0) {
                position += seperator.length(); // Include the seperator if it's not first or last element
            }
        }
        return stringBuilder.insert(position,seperator+insertInput);

    }
    public StringBuilder deleteStringAtIndex(StringBuilder stringBuilder,List<? extends CharSequence> appendInputs,String separator,int index) throws CustomException {
        StringSequenceUtility.validateNonNull(stringBuilder,separator);
        StringSequenceUtility.checkOutOfRangeIndex(index,appendInputs);
        int start = 0;
        for (int i = 0; i < index; i++) {
            start += appendInputs.get(i).length() + separator.length(); // Calculate start index of the string to delete
        }
        int end = start + appendInputs.get(index).length();
        if (index < appendInputs.size() - 1) {
            end += separator.length(); // Include the separator if it's not the last element
        }
        stringBuilder.delete(start, end); // Delete the substring
        return stringBuilder;
    }
    public StringBuilder replaceSeperator(StringBuilder stringBuilder,String oldSeparator,String newSeparator) throws CustomException {
        StringSequenceUtility.validateNonNull(newSeparator,oldSeparator,stringBuilder);
        int index = stringBuilder.indexOf(oldSeparator); // Find the first occurrence of oldSeparator
        while (index != -1) {
            stringBuilder.replace(index, index + oldSeparator.length(), newSeparator); // Replace oldSeparator with newSeparator
            index = stringBuilder.indexOf(oldSeparator, index + newSeparator.length()); // Find next occurrence
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




}
