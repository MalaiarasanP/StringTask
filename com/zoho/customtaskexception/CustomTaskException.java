package com.zoho.customtaskexception;
public class CustomTaskException extends Exception{
	public CustomTaskException(String errorMessage){
		super(errorMessage);
		} 
	public CustomTaskException(String errorMessage,Throwable cause){
		super(errorMessage, cause);
		}
}
