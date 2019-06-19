package com.mendix.test;

public class Sample {
   public static void main(String[] args){
	   String reqId="test test 1424541.";
	   String[] parts = reqId.split(" ");
		//String Id = parts[14];
		String Id = parts[parts.length-1];
		String IdNum = Id.replaceAll("\\.", "");
		System.out.println("RequestId is: " + Id + " "+ IdNum);
   }
	
}
