package com.zoho.stringutility;
import java.util.*;
import com.zoho.customstringexception.*;
public abstract class StringTaskUtility {
    public static void checkNullString(String... inputs) throws StringUtilityException {
        for(String input : inputs) {
            if(input==null) {
                throw new StringUtilityException("Null String");
            }
        }
    }
    public static void checkInvalidString(String... inputs) throws StringUtilityException {
        for(String input : inputs) {
            if(input==null) {
                throw new StringUtilityException("Null string");
            }
            if(input.isEmpty()) {
                throw new StringUtilityException("Empty string");
            }
        }
    }
    public static void checkNegativeNumber(int index) throws StringUtilityException {
        if(index<0) {
            throw new StringUtilityException("Negative Index");
        }
    }
    public static void checkOutOfRangeIndex(int index,String input) throws StringUtilityException {
        checkInvalidString(input);
        checkNegativeNumber(index);
        if(index>=input.length()) {
            throw new StringUtilityException("Index out of range");
        }
    }
    public static void exceedsMaxNoOfChar(int size,String input) throws StringUtilityException {
        checkInvalidString(input);
        checkNegativeNumber(size);
        if(size>input.length()) {
            throw new StringUtilityException("Exceed max character");
        }
    }
    private static boolean isInvalidStringList(List<String> list) {
        if (list == null||list.isEmpty()) {
            return true;
        }
        for (String element : list) {
            if (element != null) {
                return false;
            }
        }
        return true;
    }
    public static void validateStringList(List<String> list) throws StringUtilityException{
    	if(isInvalidStringList(list)){
    		throw new StringUtilityException("Invalid String list");
    	}
    }
}
