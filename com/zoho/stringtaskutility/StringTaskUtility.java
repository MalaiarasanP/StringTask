package com.zoho.stringtaskutility;
import java.util.*;
import com.zoho.customtaskexception.*;
public class StringTaskUtility{
	public static void isNullString(String input) throws CustomTaskException{
		if(input==null){
			throw new CustomTaskException("Invalid input : null string ");
			}
		}
	public static void isInvalidString(String input) throws CustomTaskException{
		if(input==null){
			throw new CustomTaskException("Invalid input : null string");
			}
		if(input.isEmpty()){
			throw new CustomTaskException("Invalid input : Empty string");
			}
			}
	public static void isNegativeNumber(int index) throws CustomTaskException{
		if(index<0){
			throw new CustomTaskException("Invalid input : negative Index");
			}
			}
	public static void isOutOfRangeIndex(int index,String input) throws CustomTaskException{
		isInvalidString(input);
		if(index>=input.length()){
			throw new CustomTaskException("Invalid input : index out of range");
			}
			}		
	public static void exceedsMaxNoOfChar(int size,String input) throws CustomTaskException{
		isInvalidString(input);
		if(size>input.length()){
			throw new CustomTaskException("Invalid No of char");
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
