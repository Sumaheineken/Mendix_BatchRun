package com.mendix.test;

public class BaseScript {
	
	static String dependentTCName = "";
	static String dependentGlobalId;

	
	public boolean matchTestCaseAndSuiteName(String testCaseName,String suitName){
		boolean match = false;
		if(testCaseName.equalsIgnoreCase(suitName)){
			match = true;
		}
		return match;
	}

}
