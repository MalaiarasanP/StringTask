package com.zoho.stringtaskutility;
import java.util.*;
import com.zoho.customtaskexception.*;
public class StringTaskUtility{
	public static void isNullString(String input) throws CustomTaskException{
		try{
		if(input==null){
			throw new NullPointerException("Null string");
			}
			}
		catch(NullPointerException e){
			throw new CustomTaskException("Invalid string",e);
			}
		}
	public static void isInvalidString(String input) throws CustomTaskException{
		try{
		if(input==null){
			throw new NullPointerException("Null string");
			}
		if(input.isEmpty()){
			throw new IllegalArgumentException("Empty string");
			}
			}
		catch(Exception e){
			throw new CustomTaskException("Invalid string",e);
			}
			}
	public static void isNegativeNumber(int index) throws CustomTaskException{
		try{
		if(index<0){
			throw new IndexOutOfBoundsException("Negative Index");
			}
			}
		catch(IndexOutOfBoundsException e){
			throw new CustomTaskException("Invalid string",e);
			}
			}
	public static void isOutOfRangeIndex(int index,String input) throws CustomTaskException{
		try{
		isInvalidString(input);
		if(index>=input.length()){
			throw new IndexOutOfBoundsException("Index out of range");
			}
			}
		catch(IndexOutOfBoundsException e){
			throw new CustomTaskException("Invalid string",e);
			}
			}		
	public static void exceedsMaxNoOfChar(int size,String input) throws CustomTaskException{
		try{
		isInvalidString(input);
		if(size>input.length()){
			throw new IndexOutOfBoundsException("Exceed max character");
		}
		}
		catch(IndexOutOfBoundsException e){
			throw new CustomTaskException("invalid string",e);
			}
		}
	public static boolean isInvalidList(List<String> list){
		if (list == null||list.isEmpty()) {
            		return true;
       	 }
       	 for (String element : list){
            		if (element != null) {
               		 return false;
            		}
        	}
        	return true; 
		}
		}
